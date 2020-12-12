import java.util.ArrayList;

public class Property {
    private TaxCalculator taxCalc;
    private String owner, address, eircode, location;
    private double marketValue;
    private boolean privateResidence;
    private ArrayList<Payment> paymentRecord;
    private ArrayList<Payment> fullPaymentRecord;
    private int yearCreated = 2010;
    private final double permanentTax;
    private double tax;
    private double overdue;


    public Property(String owner, String address, String eircode, String location, double marketValue, boolean privateResidence) {
        this.owner = owner;
        this.address = address;
        this.eircode = eircode;
        this.location = location;
        this.marketValue = marketValue;
        this.privateResidence = privateResidence;
        //yearCreated = (LocalDate.now()).getYear();
        paymentRecord = new ArrayList<>();
        taxCalc = new TaxCalculator();
        permanentTax = taxCalc.getTotalTax(this);
        tax = permanentTax;
        String[] data = {owner, address, eircode, location, String.valueOf(marketValue), String.valueOf(privateResidence)};
        //CSV.writeCSVFile("PropertyDetails.csv", data);
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

    public double getOverdue() {
        return overdue;
    }

    public ArrayList<Payment> getFullPaymentRecord() {
        return fullPaymentRecord;
    }

    public void fillFullPaymentRecord(){
        fullPaymentRecord = new ArrayList<>();
        //System.out.println(paymentRecord.size());
        int mostRecentPay = paymentRecord.get(paymentRecord.size() - 1).getYear();
        //int yearsElapsed = mostRecentPay - yearCreated;
        int count = 0;
        System.out.println("noice");
        for(int i = yearCreated; i <= mostRecentPay; i++){
            //System.out.println(i);
            if (paymentRecord.get(count).getYear() == i) {
                fullPaymentRecord.add(paymentRecord.get(count));
                count++;
            } else {
                fullPaymentRecord.add(new Payment(i, tax, false, overdue));
            }
            yearlyOverdue();
        }

    }

    public void yearlyOverdue(){
        double totalOverdue = 0;
        for(int i = 0; i < fullPaymentRecord.size() - 1; i++){
            double tempTax = 0;
            if(fullPaymentRecord.get(i).getIsTaxPaid()){
                fullPaymentRecord.get(i + 1).setOverdue(0);
                fullPaymentRecord.get(i + 1).setTax(permanentTax);
                totalOverdue = 0;
            }
            if(!fullPaymentRecord.get(i).getIsTaxPaid()){
                if(fullPaymentRecord.get(i).getOverdue() == 0) {
                    overdue = permanentTax;
                }
                //tempTax = overdue;
                totalOverdue += overdue;
                fullPaymentRecord.get(i + 1).setOverdue(totalOverdue);
                overdue = taxCalc.unpaidPenalty(overdue);
                fullPaymentRecord.get(i + 1).setTax(overdue);
            }
        }
        overdue = 0;
    }

    public void save(Payment payed){
        paymentRecord.add(payed);
    }


    public String toString() {
        String temp  = "";
        for(Payment m: paymentRecord){
            temp += m.toString();
        }
        return "Property:\n" + "Owner: " + owner + ", Address: " + address + ", Eircode: "
                + eircode + ", Location: " + location + ", MarketValue: " + marketValue +
                ", PrivateResidence: " + privateResidence + "\n" + temp;
    }
}
