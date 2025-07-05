package part1;

import java.util.Map;

public class Util {
    public static int getYearWithHighestEmissions(Country country) {
        int highestYear = 0;
        double highestAmount = 0.0;
        for (Map.Entry<Integer, Emission> Emission : country.getEmissions().entrySet()) {
            Emission currentEmission = Emission.getValue(); // Grab current Emission
            double total = currentEmission.getCO2() + currentEmission.getN2O() + currentEmission.getCH4();
            if (total > highestAmount) {
                highestYear = Emission.getKey();
                highestAmount = total;
            }
        }
        return highestYear;
    }
    public static int getYearWithHighestEmissions(Sector sector) {
        int highestYear = 0;
        double highestAmount = 0.0;
        for (Map.Entry<Integer, Double> T_Emission : sector.getEmissions().entrySet()) {
            Double current = T_Emission.getValue();
            if (current > highestAmount) {
                highestYear = T_Emission.getKey();
                highestAmount = current;
            }
        }
        return highestYear;
    }
}
