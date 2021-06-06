package test;

public class TestData {
    double N;
    double Xi;
    double Q;
    double D;
    double V;
    double h;
    double m;
    double Tgreen;
    public TestData(){}

    public TestData(double n, double xi, double q, double d,
                    double v, double h, double m, double tgreen) {
        N = n;
        Xi = xi;
        Q = q;
        D = d;
        V = v;
        this.h = h;
        this.m = m;
        Tgreen = tgreen;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "N=" + N +
                ", Xi=" + Xi +
                ", Q=" + Q +
                ", D=" + D +
                ", V=" + V +
                ", h=" + h +
                ", m=" + m +
                ", Tgreen=" + Tgreen +
                '}';
    }
}
