package test;

public class TestData {
    double N;
    double Xi;
    double Q;
    double D;
    double V;
    double h;
    double m;
    double As;
    double Tgreen;
    double Tyellow;
    public TestData(){}

    public TestData(double n, double xi, double q, double d,
                    double v, double h, double m, double as, double tgreen, double tyellow) {
        N = n;
        Xi = xi;
        Q = q;
        D = d;
        V = v;
        this.h = h;
        this.m = m;
        As = as;
        Tgreen = tgreen;
        Tyellow = tyellow;
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
                ", As=" + As +
                ", Tgreen=" + Tgreen +
                ", Tyellow=" + Tyellow +
                '}';
    }
}
