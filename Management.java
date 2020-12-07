import java.util.ArrayList;

public class Management {
	//Get payments for property (array list in property)
	private Payment payments;
	public ArrayList<Integer> getProperty() {
		payments = new Payment();
		ArrayList<Integer> property = payments.getPayments();
		return property;
	}
	//get payments for property owner
}
