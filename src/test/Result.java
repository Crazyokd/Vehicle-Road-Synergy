package test;

public class Result {
    public int i;
    public double T2;
    public double t;
    public int flag;
    Result(){}
    Result(int i, double T2, double t, int flag){
        this.i=i;
        this.T2=T2;
        this.t=t;
        this.flag=flag;
    }
    @Override
    public String toString() {
        return "Result{" +
                "i=" + i +
                ", T2=" + T2 +
                ", t=" + t +
                ", flag=" + flag +
                '}';
    }
}
