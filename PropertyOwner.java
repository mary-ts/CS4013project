import java.util.ArrayList;

public class PropertyOwner{
    ArrayList<Property> properties = new ArrayList<>();
    private String owner;

    public PropertyOwner(String owner){
        this.owner = owner;
    }

    //fixed Double and Boolean issue here
    public void registerProperty(String address, String eircode, String location, double marketValue, boolean privateResidence){
        properties.add(new Property(this.owner, address, eircode, location, marketValue, privateResidence));
    }

    public String viewProperties(){
        String propertyTotal = "";
        for(Property n : properties){
            propertyTotal += n.toString();
        }
        return propertyTotal;
    }
}
