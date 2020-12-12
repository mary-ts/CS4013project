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

    public void registerProperty(String address, String eircode, String location, double marketValue, boolean privateResidence){
        properties.add(new Property(this.owner, address, eircode, location, marketValue, privateResidence));
    }

    //kinda working
    public String viewProperties(){
        String temp = "";
        for(Property n: properties){
            temp += n.toString();
        }
        return temp;
    }

    //not working yet
    public void makePayment(Property prop) {
        Payment payment = new Payment(currentYear, true);
        prop.save(payment);
        System.out.print(payment.toString());
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

    public String specificQuery(Property p){
        String list = "";
        for(Property n: properties){
            if(n == p){
                ArrayList<Payment> temp =  n.getFullPaymentRecord();
                for(Payment m: temp){
                        list += n.toString() + m.toString();
                }
            }
        }
        return list;
    }

}
