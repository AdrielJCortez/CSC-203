package part2;

import java.util.Map;

public class Country {
    private String Name;
    private Map<Integer, Emission> Emissions;

    public Country(String Name, Map<Integer, Emission> Emission) {
        this.Name = Name;
        this.Emissions = Emission;
    }

    public String getName()
    {
        return this.Name;
    }
    public Map<Integer, Emission> getEmissions() {
        return this.Emissions;
    }

    public int getYearWithHighestEmissions() {
        int highestYear = 0;
        double highestAmount = 0.0;
        for (Map.Entry<Integer, Emission> Emission : this.getEmissions().entrySet()) {
            Emission currentEmission = Emission.getValue(); // Grab current Emission
            double total = currentEmission.getCO2() + currentEmission.getN2O() + currentEmission.getCH4();
            if (total > highestAmount) {
                highestYear = Emission.getKey();
                highestAmount = total;
            }
        }
        return highestYear;
    }
}
