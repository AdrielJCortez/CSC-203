package part3;

import java.util.List;
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

    public static Sector sectorWithHighestAverageEmissions(List<Sector> sectors, int startYear, int endYear) {
        Sector temp = null;
        double highestAvg = 0.0;
        for (Sector current : sectors) {
            double total = 0.0;
            for (int year = startYear; year <= endYear; year++) {
                double currYear = current.getEmissions().get(year);
                total = total + currYear;
            }
            double avg = total/(endYear-startYear + 1);
            if (avg > highestAvg) {
                temp = current;
                highestAvg = avg;
            }
        }
        return temp;
    }
    public static double highAvgEm(List<Sector> sectors, int startYear, int endYear) {
        Sector temp = null;
        double highestAvg = 0.0;
        for (Sector current : sectors) {
            double total = 0.0;
            for (int year = startYear; year <= endYear; year++) {
                double currYear = current.getEmissions().get(year);
                total = total + currYear;
            }
            double avg = total/(endYear-startYear + 1);
            if (avg > highestAvg) {
                temp = current;
                highestAvg = avg;
            }
        }
        return highestAvg;
    }
}
