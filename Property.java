import java.util.ArrayList;

public class Property {
    private String owner, address, eircode, location;
    private double marketValue;
    private boolean privateResidence;

    public Property(String owner, String address, String eircode, String location, Double marketValue, Boolean privateResidence) {
        this.owner = owner;
        this.address = address;
        this.eircode = eircode;
        this.location = location;
        this.marketValue = marketValue;
        this.privateResidence = privateResidence;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public String getLocation() {
        return location;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    public boolean isPrivateResidence() {
        return privateResidence;
    }

    public void setPrivateResidence(Boolean privateResidence) {
        this.privateResidence = privateResidence;
    }

    @Override
    public String toString() {
        return "Property:\n" +
                "owner=" + owner +
                ", address=" + address +
                ", eircode=" + eircode +
                ", location=" + location +
                ", marketValue=" + marketValue +
                ", privateResidence=" + privateResidence;
    }
}
