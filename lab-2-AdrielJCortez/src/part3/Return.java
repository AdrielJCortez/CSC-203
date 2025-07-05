package part3;

public class Return {
    private Country country;
    private double highest;

    public Return(Country country, double highest) {
        this.country = country;
        this.highest = highest;
    }

    public Country getCountri() {
        return this.country;
    }
    public double getHighest() {
        return this.highest;
    }
}
