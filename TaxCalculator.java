public class TaxCalculator {

	public double totalTax, fixedCost, locationTax;
	private static double[] value = {150000, 400000, 650000};
	
	private static String[] locations = {"City","Large Town", "Small Town", "Village", "Countryside"}; 
	private static int[] locationVals = {100, 80, 60, 50, 25};
	
	//Will probably have 2 constructors- 1 default and 1 custom //
	public TaxCalculator() {
		
			}
   
	public double getMarketTax(Property p) {
		
	}
	
	public double getLocationTax(Property p) {
		p.getLocation();
		for(int i=0; i < locations.length; i++) {
			if(p.equals(locations[i])) {
				locationTax = locationVals[i];
			}
		} return locationTax;
	}

	
	public double calculateTotalTax() {
		return totalTax;
	}
	
}
