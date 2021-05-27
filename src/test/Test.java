package test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Test {
    public static ArrayList<TestData> atd = new ArrayList<>();
    public static void main(String[] args) {
        readTestData();
        //启动程序
        VehicleRoadSynergy vehicleRoadSynergy=new VehicleRoadSynergy();
        vehicleRoadSynergy.start();

    }
    public static void readTestData(){
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(new File("testdata.txt")));
            String str = new String();
            int i=0;
            double[] a=new double[10];
            int index=0;
            while(i<17){
                int v=br.read();
                if(v==32||v==10){
                    a[index]=Double.parseDouble(str);
                    str=new String();
                    if(index==9){
                        atd.add(new TestData(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7],a[8],a[9]));
                        i++;
                    }
                    index=(index+1)%10;
                }else if(v!=13){
                    str+=(char)v;
                }
            }
            for(TestData td:atd){
                System.out.println(td);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if(br!=null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}




