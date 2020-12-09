public class TaxCalculator {

	public double totalTax, fixedCost, locationTax;
	private static double[] value = {150000, 400000, 650000};
	private static double[] rate = {.01, .02, .04};

	
	private static String[] locations = {"City","Large Town", "Small Town", "Village", "Countryside"}; 
	private static int[] locationVals = {100, 80, 60, 50, 25};
	
	//Will probably have 2 constructors- 1 default and 1 custom //
	public TaxCalculator() {
		
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

public double calculateTotalTax(Property p) {
	if(p.isPrivateResidence() == true) {
		fixedCost += 100;
	}
	totalTax = ((p.getMarketValue()/100)*marketTax) +
		locationTax + fixedCost;		
		return totalTax;
	}
	
}
