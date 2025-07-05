package part3;



import java.util.List;
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

    public static Country countryWithHighestCH4InYear(List<Country> countries, int year) {
        Country temp = null;
        double highestCH4 = 0.0;
        for (Country current : countries) {
            Emission currentE = current.getEmissions().get(year);
            if (currentE.getCH4() > highestCH4) {
                temp = current;
                highestCH4 = currentE.getCH4();
            }
        }
        return temp;
    }
    public static double highCH4(List<Country> countries, int year) {
        Country temp = null;
        double highestCH4 = 0.0;
        for (Country current : countries) {
            Emission currentE = current.getEmissions().get(year);
            if (currentE.getCH4() > highestCH4) {
                temp = current;
                highestCH4 = currentE.getCH4();
            }
        }
        return highestCH4;
    }

    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int startYear, int endYear) {
        Country temp = null;
        double highestDifference = 0.0;
        for (Country current : countries) {
            Emission E1 = current.getEmissions().get(startYear);
            Emission E2 = current.getEmissions().get(endYear);
            double E1Total = E1.getCH4() + E1.getCO2() + E1.getN2O();
            double E2Total = E2.getCH4() + E2.getCO2() + E2.getN2O();
            double increase = E2Total - E1Total;
            if (increase > highestDifference) {
                temp = current;
                highestDifference = increase;
            }
        }
        return temp;
    }
    public static double ReturnNum(List<Country> countries, int startYear, int endYear) {
        Country temp = null;
        double highestDifference = 0.0;
        for (Country current : countries) {
            Emission E1 = current.getEmissions().get(startYear);
            Emission E2 = current.getEmissions().get(endYear);
            double E1Total = E1.getCH4() + E1.getCO2() + E1.getN2O();
            double E2Total = E2.getCH4() + E2.getCO2() + E2.getN2O();
            double increase = E2Total - E1Total;
            if (increase > highestDifference) {
                temp = current;
                highestDifference = increase;
            }
        }
        return highestDifference;
    }
}


