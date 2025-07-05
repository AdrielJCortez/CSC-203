package part1;

import java.util.Map;

public class Country {
    private String Name;
    private Map<Integer, Emission> Emissions;

    public Country(String Name, Map<Integer, Emission> Emission) {
        this.Name = Name;
        this.Emissions = Emission;
    }

    public String getName() {
        return this.Name;
    }

    public Map<Integer, Emission> getEmissions() {
        return this.Emissions;
    }
}
