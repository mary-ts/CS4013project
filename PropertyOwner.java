import java.time.LocalDate;
import java.util.ArrayList;

public class PropertyOwner{
    ArrayList<Property> properties;
    private String owner;
    private int currentYear;


    public PropertyOwner(String owner){
        this.owner = owner;
        properties = new ArrayList<>();
        currentYear = (LocalDate.now()).getYear();
    }

    public String getOwner() {
        return owner;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void registerProperty(String address, String eircode, String location, double marketValue, boolean privateResidence){
        properties.add(new Property(this.owner, address, eircode, location, marketValue, privateResidence));
    }

    public String viewProperties(){
        String temp = "";
        for(Property n: properties){
            n.save(new Payment(currentYear, n.getTax(),false, n.getOverdue(), n.getOwner(), n.getEircode()));
            n.fillFullPaymentRecord();
            temp += n.toString() + n.taxToString();
        }
        return temp;
    }

    public void makePayment(String eircode, int year) {
        for (Property n : properties) {
            if (n.getEircode().equalsIgnoreCase(eircode)) {
                n.fillFullPaymentRecord();
                n.check(year);
                n.fillFullPaymentRecord();
                break;
            }
        }
    }

    public String specificQuery(int year){
        String list = "";
        for(Property n: properties){
            ArrayList<Payment> temp =  n.getFullPaymentRecord();
            for(Payment m: temp){
                if(m.getYear() == year){
                    list += n.toString() + m.toString();
                }
            }
        }
        return list;
    }

    public String specificQuery(String eircode){
        String list = "";
        for(Property n: properties){
            if (n.getEircode().equalsIgnoreCase(eircode)) {
                list = n.toString();
                ArrayList<Payment> temp =  n.getFullPaymentRecord();
                for(Payment m: temp){
                    list += m.toString();
                }
            }
        }
        return list;
    }

}
