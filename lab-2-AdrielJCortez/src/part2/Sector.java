package part2;

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

    public int getYearWithHighestEmissions() {
        int highestYear = 0;
        double highestAmount = 0.0;
        for (Map.Entry<Integer, Double> T_Emission : this.getEmissions().entrySet()) {
            Double current = T_Emission.getValue();
            if (current > highestAmount) {
                highestYear = T_Emission.getKey();
                highestAmount = current;
            }
        }
        return highestYear;
    }
}
