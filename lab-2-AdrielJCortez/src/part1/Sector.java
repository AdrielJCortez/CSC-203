package part1;

import java.util.Date;
import java.util.Map;

public class Sector {
    private String Name;
    private Map<Integer, Double> T_Emissions;

    public Sector(String Name, Map<Integer, Double> T_Emission) {
        this.Name = Name;
        this.T_Emissions = T_Emission;
    }

    public String getName() {
        return this.Name;
    }

    public Map<Integer, Double> getEmissions() {
        return this.T_Emissions;
    }
}
