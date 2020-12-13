import java.util.Arrays;

public class TaxCalculator {

    public double totalTax, marketTax, locationTax;
    private double fixedCost;
    private double[] value;
    private double[] rate;

    private String[] locations;
    private int[] locationVals;

    public TaxCalculator() {
        fixedCost = 100;
        value = new double[]{0, 150000, 400000, 650000};
        rate = new double[]{0, .01, .02, .04};
        locations = new String[]{"City","Large Town", "Small Town", "Village", "Countryside"};
        locationVals = new int[]{100, 80, 60, 50, 25};
    }

    public TaxCalculator(double fixedCost, double[] value, double[] rate, String[] locations, int[] locationVals) {
        this.fixedCost = fixedCost;
        this.value = value;
        this.rate = rate;
        this.locations = locations;
        this.locationVals = locationVals;
    }


    private double getMarketTax(Property p) {
        double v = p.getMarketValue();
        for(int i = value.length-1; i > 0; i--) {
            if(v >= value[i]) {
                marketTax = rate[i];
                break;
            }
        }
        return marketTax;
    }


    private double getLocationTax(Property p) {
        String location = p.getLocation();
        for(int i=0; i < locations.length; i++) {
            if(location.equalsIgnoreCase(locations[i])) {
                locationTax = locationVals[i];
            }
        } return locationTax;
    }

    public double getTotalTax(Property p) {
        if(p.isPrivateResidence()) {
            fixedCost += 100;
        }
        totalTax = ((p.getMarketValue()/100)*getMarketTax(p)) +
                getLocationTax(p) + fixedCost;
        return totalTax;
    }

    public double unpaidPenalty(double x) {
        x = x + ((x/100)*7);
        return x;
    }
}
