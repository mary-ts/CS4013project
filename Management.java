import java.util.ArrayList;
import java.util.Arrays;

public class Management {
    //Get payments for property (array list in property)
    //specify property
    private Payment payments;
    private PropertyOwner property;

    //Get property tax payments from property owner
    public void getPropertyTaxFromOwner(PropertyOwner p) {
        ArrayList data = CSV.readCSVFile("Payments.csv");
        String[] headings = (String[]) data.get(0);

        int index = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Owner")){
                index = i;
                break;
            }
        }

        for (int i=0; i<data.size(); i++) {
            String[] tmp = (String[]) data.get(i);
            if (tmp[index].trim().equalsIgnoreCase(p.getOwner())) {
                System.out.println(Arrays.toString(tmp));
            }
        }

        return ;
    }

    public void getPropertyTaxFromProperty(String eircode) {
        ArrayList data = CSV.readCSVFile("Payments.csv");
        String[] headings = (String[]) data.get(0);

        int index = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Eircode")) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < data.size(); i++) {
            String[] tmp = (String[]) data.get(i);
            if (tmp[index].trim().equals(eircode))
                System.out.println(Arrays.toString(tmp));
        }
        //get payments for property owner
        //specify owner
/*
	public ArrayList<PropertyOwner> getOwnerProperty(PropertyOwner p) {
		ArrayList<PropertyOwner> property = p.viewProperties();
		return property;
	}
*/

//    public String getOwnerProperty(PropertyOwner p) {
//        //String property =
//        return p.viewProperties();
//        //return property;
//    }
    }
}
