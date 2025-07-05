import java.util.List;
import java.util.Map;

public class Sector implements GreenhouseGasEmitter {
    private String name;
    private Map<Integer, Double> emissions;

    public Sector(String name, Map<Integer, Double> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Double> getEmissions() {
        return emissions;
    }

    public double getEmissionsInYear(int year) {
        return this.emissions.get(year);
    }

    public int getYearWithHighestEmissions() {
        double maxEmissions = Double.MIN_VALUE;
        int maxYear = -1;
        for (Map.Entry<Integer, Double> entry : this.getEmissions().entrySet()) {
            if (entry.getValue() > maxEmissions) {
                maxEmissions = entry.getValue();
                maxYear = entry.getKey();
            }
        }

        return maxYear;
    }

    public static Sector sectorWithBiggestChangeInEmissions(List<Sector> sectors, int startYear, int endYear) {
        Sector maxSector = null;
        double maxAvg = -1;

        for (Sector sector : sectors) {
            double sum = 0;
            for (int year = startYear; year <= endYear; year++) {
                sum = sum + sector.getEmissions().get(year);
            }
            double avg = sum / (endYear - startYear + 1);
            if (avg > maxAvg) {
                maxAvg = avg;
                maxSector = sector;
            }
        }

        System.out.println(maxSector.getName() + ", " + maxAvg);
        return maxSector;
    }
}
