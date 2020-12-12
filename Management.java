import java.util.ArrayList;

public class Management {
	//Get payments for property (array list in property)
	//specify property
	private Payment payments;
	private PropertyOwner property;
	public ArrayList<Payment> getProperty(Property p) {
		payments = new Payment();
		ArrayList<Payment> payments = p.getPaymentRecord();
		return payments;
	}
	//get payments for property owner
	//specify owner
/*	
	public ArrayList<PropertyOwner> getOwnerProperty(PropertyOwner p) {
		ArrayList<PropertyOwner> property = p.viewProperties();
		return property;
	}
*/
	
	public String getOwnerProperty(PropertyOwner p) {
		//String property = 
				return p.viewProperties();
		//return property;
	}	
