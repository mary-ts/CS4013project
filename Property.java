import java.time.LocalDate;
import java.util.ArrayList;

public class Property {
    private String owner, address, eircode, location;
    private double marketValue;
    private boolean privateResidence;
    public ArrayList<Payment> paymentRecord;

    public double overdue;
    public double currentTax;
    public int currentYear = 0;

    /*
    //these method names are nonsense, brain go nahh

    public void vdn(){
        for(Payment n: paymentRecord){
            if(n.getYear() == currentYear - 1 && n.getBalance() > 0){
                overdue += n.getBalance();
            }
        }
    }

    public void dga(){
        for(Payment n: paymentRecord){
            if(n.getYear() == currentYear){

            }
        }
    }

     */


    public Property(String owner, String address, String eircode, String location, double marketValue, boolean privateResidence) {
        this.owner = owner;
        this.address = address;
        this.eircode = eircode;
        this.location = location;
        this.marketValue = marketValue;
        this.privateResidence = privateResidence;
        paymentRecord = new ArrayList<>();
        TaxCalculator taxCalc = new TaxCalculator();
        currentTax = taxCalc.getTotalTax(this);
        String[] data = {owner, address, eircode, location, String.valueOf(marketValue), String.valueOf(privateResidence)};
        CSV.writeCSVFile("PropertyDetails.csv", data);
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

    public void save(Payment payed){
        paymentRecord.add(payed);
    }
    
    
    public void save(Payment payed){
        paymentRecord.add(payed);
    }

    public ArrayList<Payment> getPaymentRecord() {
        return paymentRecord;
    }

    public void setPaymentRecord(ArrayList<Payment> paymentRecord) {
        this.paymentRecord = paymentRecord;
    }

    public double getOverdue() {
        return overdue;
    }

    public void setOverdue(double overdue) {
        this.overdue = overdue;
    }

    public double getCurrentTax() {
        return currentTax;
    }

    public void setCurrentTax(double currentTax) {
        this.currentTax = currentTax;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }


    public String propertyToString() {
        return "Property:\n" +
                "owner=" + owner +
                ", address=" + address +
                ", eircode=" + eircode +
                ", location=" + location +
                ", marketValue=" + marketValue +
                ", privateResidence=" + privateResidence;
    }
}
