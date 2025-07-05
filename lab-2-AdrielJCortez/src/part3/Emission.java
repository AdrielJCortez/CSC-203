package part3;

public class Emission {
    private double CO2;
    private double N2O;
    private double CH4;

    public Emission(double CO2, double N2O, double CH4) {
        this.CO2 = CO2;
        this.N2O = N2O;
        this.CH4 = CH4;
    }

    public double getCO2() {
        return this.CO2;
    }

    public double getN2O() {
        return this.N2O;
    }

    public double getCH4() {
        return this.CH4;
    }

}
