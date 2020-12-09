
public class TaxCalculator {

	public double totalTax, marketTax, locationTax;
	private double fixedCost = 100;
	private double[] value;
	private double[] rate;
	
	private String[] locations; 
	private int[] locationVals;
	
	public TaxCalculator() {
		value = new double[]{150000, 400000, 650000};
		rate = new double[]{.01, .02, .04};
		locations = new String[]{"City","Large Town", "Small Town", "Village", "Countryside"};
		locationVals = new int[]{100, 80, 60, 50, 25};
	}
	
	public TaxCalculator(double[] value, double[] rate, String[] locations, int[] locationVals) {
		this.value = value;
	    this.rate = rate;
	    this.locations = locations;
	    this.locationVals = locationVals;
	}
   
	public double getMarketTax(Property p) {
		p.getMarketValue();
		for(int i=0; i < value.length; i++) {
			if(p.getMarketValue() < value[i]) {
				marketTax = rate[i];
			}
		}
		return marketTax;
	}
	
	public double getLocationTax(Property p) {
		p.getLocation();
		for(int i=0; i < locations.length; i++) {
			if(p.equals(locations[i])) {
				locationTax = locationVals[i];
			}
		} return locationTax;
	}

	public double getTotalTax(Property p) {
		if(p.isPrivateResidence() == true) {
			fixedCost += 100;
		}
		totalTax = ((p.getMarketValue()/100)*marketTax) +
			locationTax + fixedCost;		
		return totalTax;
	}
}
