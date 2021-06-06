package test;

import java.util.ArrayList;
import java.util.Date;

public class VehicleRoadSynergy {
    public static final double len=3;//标准小汽车长度(m)
    public static final double Vlim=60;//交叉口最高限速(km/h)
    public static final double Tr=1.2;//驾驶员平均反应时间(s)
    public static final double d=5;//引导灯间的距离(m)
    public static final int f=1000;//打印频率
    public static final double h=2.4;//饱和车头时距(PCU/h)
    public static final int m=3;//交叉口进口道车道数
    public static final double Tyellow=3.0;//交叉口黄灯时间(s)
    public static final double As=1.5;//T0时车辆减速度

    public static ArrayList<TestData> atd = new ArrayList<>();//测试数据数组

    private long beginTime=initTime();//程序开始执行的时间

    private Answer ans=new Answer();

    public long initTime(){
        return new Date().getTime();
    }

    public void start(int index){
        new Thread(){
            @Override
            public void run(){
                String str=new String();
                for(int i=ans.getLength()-1;i>=0;i--)
                    str+=String.format("%5s","i:"+(i+1));
                System.out.println(str);

                int rate=1;
                while(true){
                    Date currentDate=new Date();
                    long currentTime=currentDate.getTime();
                    if(currentTime-beginTime>=f*rate){
                        System.out.println(ans);
                        rate++;
                    }
                }
            }
        }.start();
        run(new Enter(new OBU((int)atd.get(index).V,(int)atd.get(index).D),
                new Webcam((int)atd.get(index).N),new Semaphore(atd.get(index).Tgreen,atd.get(index).Xi),
                new Detector((int)atd.get(index).Q)));
    }

    public void run(Enter enter){
        Result result;
        double D1=0.0;
        double T1=3.6*enter.obu.D/enter.obu.V;
        double N1=(T1*enter.detector.Q)/3600+enter.webcam.N;
        double Nc=3600/h*enter.semaphore.Xi*T1;
        if(N1-Nc>0){
            double n=(N1-Nc)/m;
            D1=n*len;
            result=figureDistance(D1,enter.obu);
        }
        else{
            double Dy=enter.obu.D-enter.obu.V/3.6*enter.semaphore.Tgreen;
            double Lp=enter.obu.V/3.6*VehicleRoadSynergy.Tyellow;
            if(Dy-Lp>0){
                result=figureDistance(D1,enter.obu);
            }
            else{
                result=new Result(10,0.0,d/enter.obu.V*3.6,1);
            }
        }
        //输出一次结果
        System.out.println(result);

        int rate=1;
        boolean f=true;
        while(true){
            Date currentDate=new Date();
            long currentTime=currentDate.getTime();
            if(result.i<=1&&currentTime-beginTime>=(result.T2+result.t*rate)*1000){
                ans.getAns()[0]=2;
                break;
            }
            if(f&&currentTime-beginTime>=result.T2*1000){
                ans.getAns()[result.i-1]=result.flag;
                f=false;
            }
            if(!f&&currentTime-beginTime>=(result.T2+result.t*rate)*1000){
                ans.getAns()[result.i-1]=2;
                ans.getAns()[--result.i-1]=result.flag;
                rate++;
            }
        }
    }
    public Result figureDistance(double D1,OBU obu){
        double Ls=Vlim*Tr+Vlim*Vlim/(2*As);//Vlim具有不确定性
        int i=getLightI(Ls,D1);
        double T2=(obu.D-D1)*3.6/obu.V;

        double t=d/obu.V*3.6;

        return new Result(i,T2,t,0);
    }
    public int getLightI(double Ls,double D1){
        int i;
        for(i=1;i<10;i++){
            if(i*d-(Ls+D1)>=0)break;
        }
        return i-1;
    }
}
