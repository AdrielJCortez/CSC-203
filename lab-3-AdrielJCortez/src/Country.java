import java.util.List;
import java.util.Map;

public class Country implements GreenhouseGasEmitter{
    private String name;
    private Map<Integer, Emission> emissions;

    public Country(String name, Map<Integer, Emission> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Emission> getEmissions() {
        return emissions;
    }

    public int getYearWithHighestEmissions() {
        double maxEmissions = Double.MIN_VALUE;
        int maxYear = -1;
        for (Map.Entry<Integer, Emission> entry : this.getEmissions().entrySet()) {
            Emission emission = entry.getValue();
            double totalEmissions = emission.getCO2() + emission.getCH4() + emission.getN2O();
            if (totalEmissions > maxEmissions) {
                maxEmissions = totalEmissions;
                maxYear = entry.getKey();
            }
        }

        return maxYear;
    }

    public static Country countryWithHighestCH4InYear(List<Country> countries, int year) {
        double maxCH4 = -1;
        Country maxCountry = null;

        for (Country country : countries) {
            double ch4InYear = country.getEmissions().get(year).getCH4();
            if (ch4InYear > maxCH4) {
                maxCH4 = ch4InYear;
                maxCountry = country;
            }
        }

        System.out.println(maxCountry.getName() + ", " + maxCH4);
        return maxCountry;
    }

    public static Country countryWithBiggestChangeInEmissions(List<Country> countries, int startYear, int endYear) {
        double maxChange = Double.MIN_VALUE;
        Country maxCountry = null;

        for (Country country : countries) {
            double startEmissions = country.getEmissions().get(startYear).getTotalEmissions();
            double endEmissions = country.getEmissions().get(endYear).getTotalEmissions();
            double change = endEmissions - startEmissions;

            if (change > maxChange) {
                maxChange = change;
                maxCountry = country;
            }
        }

        System.out.println(maxCountry.getName() + ", " + maxChange);
        return maxCountry;
    }

    public double getEmissionsInYear(int year) {
        Emission emissionsInYear =  this.emissions.get(year);
        return emissionsInYear.getCH4() + emissionsInYear.getCO2() + emissionsInYear.getN2O();
    }
}
