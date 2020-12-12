import java.time.LocalDate;
import java.util.ArrayList;

public class Property {
    private TaxCalculator taxCalc;
    private String owner, address, eircode, location;
    private double marketValue;
    private boolean privateResidence;
    private ArrayList<Payment> paymentRecord;
    private ArrayList<Payment> fullPaymentRecord;
    private int yearCreated;
    private double tax;
    private double overdue;


    public Property(String owner, String address, String eircode, String location, double marketValue, boolean privateResidence) {
        this.owner = owner;
        this.address = address;
        this.eircode = eircode;
        this.location = location;
        this.marketValue = marketValue;
        this.privateResidence = privateResidence;
        yearCreated = (LocalDate.now()).getYear();
        paymentRecord = new ArrayList<>();
        fullPaymentRecord = new ArrayList<>();
        tax = taxCalc.getTotalTax(this);
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

    public int getYearCreated() {
        return yearCreated;
    }

    public double getTax() {
        return tax;
    }

    public ArrayList<Payment> getFullPaymentRecord() {
        return fullPaymentRecord;
    }

    public void fillFullPaymentRecord(){
        int mostRecentPay = paymentRecord.get(paymentRecord.size()).getYear();
        int yearsElapsed = mostRecentPay - yearCreated;
        int count = 1;
        for(int i = yearCreated; i <= yearsElapsed; i++){
            if(paymentRecord.get(count).getYear() == i){
                fullPaymentRecord.add(paymentRecord.get(count));
            }else {
                fullPaymentRecord.add(new Payment(i, false));
            }
        }
    }

    public void yearlyOverdue(){
        for(Payment n: fullPaymentRecord){
            if(n.isTaxPaid == false){
                overdue = 0;
            }
            if(n.isTaxPaid == false){
                if(overdue == 0) {
                    overdue = tax;
                }
                overdue = taxCalc.unpaidPenalty(overdue);
            }
        }
    }
    public void save(Payment payed){
        paymentRecord.add(payed);
    }


    public String toString() {
        return "Property:\n" + "Owner: " + owner + ", Address: " + address + ", Eircode: "
                + eircode + ", Location: " + location + ", MarketValue: " + marketValue +
                ", PrivateResidence: " + privateResidence + "\n" + year + "  Tax due: € "+
                tax + ", Overdue: €"; //+ overdueTax() + "\n";
    }
}
