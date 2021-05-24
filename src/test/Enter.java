package test;

//输入
public class Enter {
    public OBU obu;
    public Webcam webcam;
    public Semaphore semaphore;
    public Detector detector;
    public Enter(){}
    public Enter(OBU obu,Webcam webcam,Semaphore semaphore,Detector detector){
        this.obu=obu;
        this.webcam=webcam;
        this.semaphore=semaphore;
        this.detector=detector;
    }

    public OBU getObu() {
        return obu;
    }

    public Webcam getWebcam() {
        return webcam;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public Detector getDetector() {
        return detector;
    }
}
//OBU
class OBU{
    public double V;//T0时车速
    public double D;//T0时车辆距停止线距离
    public double As;//T0时车辆自身减速度
    public OBU(){};
    public OBU(int V,int D,int As) {
        this.V = V;
        this.D = D;
        this.As = As;
    }

    public double getV() {
        return V;
    }
    public double getD() {
        return D;
    }
    public double getAs() {
        return As;
    }
}
//摄像头
class Webcam{
    public int N;//T0时进口道排队车辆数
    public Webcam(){}
    public Webcam(int N){
        this.N=N;
    }

    public int getN() {
        return N;
    }
}
//信号灯
class Semaphore{
    public double Tgreen;//T0时绿灯剩余时间
    public double Tyellow;//交叉口黄灯时间
    public double Xi;//交叉口信号灯绿信比

    public Semaphore() {}
    public Semaphore(double Tgreen,double Tyellow,double Xi){
        this.Tgreen= Tgreen;
        this.Tyellow=Tyellow;
        this.Xi=Xi;
    }

    public double getTgreen() {
        return Tgreen;
    }
    public double getTyellow() {
        return Tyellow;
    }
    public double getXi() {
        return Xi;
    }
}
//检测器
class Detector{
    public int Q;//交叉口上游流量
    public Detector(){}
    public Detector(int Q){
        this.Q=Q;
    }

    public int getQ() {
        return Q;
    }
}
