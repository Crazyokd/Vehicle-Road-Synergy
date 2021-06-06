package test;

import java.io.*;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        readTestData();
        //启动程序
        System.out.println("已成功读入"+VehicleRoadSynergy.atd.size()+"组数据，请输入想要运行的索引：");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        VehicleRoadSynergy vehicleRoadSynergy=new VehicleRoadSynergy();
        vehicleRoadSynergy.start(index);

    }
    public static void readTestData(){
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(new File("testdata.txt")));
            String str = new String();
            int i=0;
            double[] a=new double[8];
            int index=0;
            while(i<17){
                int v=br.read();
                if(v==32||v==10){
                    a[index]=Double.parseDouble(str);
                    str=new String();
                    if(index==7){
                        VehicleRoadSynergy.atd.add(new TestData(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7]));
                        i++;
                    }
                    System.out.println(i);
                    index=(index+1)%8;
                }else if(v!=13){
                    str+=(char)v;
                }
            }
            for(TestData td:VehicleRoadSynergy.atd){
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




