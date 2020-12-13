import java.time.LocalDate;
import java.util.ArrayList;

public class Property {
    private TaxCalculator taxCalc;
    private String owner, eircode, address, location;
    private double marketValue;
    private boolean privateResidence;
    private ArrayList<Payment> paymentRecord;
    private ArrayList<Payment> fullPaymentRecord;
    private int yearCreated;
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
        yearCreated = (LocalDate.now()).getYear();
        paymentRecord = new ArrayList<>();
        taxCalc = new TaxCalculator();
        permanentTax = taxCalc.getTotalTax(this);
        tax = permanentTax;
        String[] data = {owner, address, eircode, location, String.valueOf(marketValue), String.valueOf(privateResidence)};
        if (isPropertyinCSV()) {
            CSV.writeCSVFile("PropertyDetails.csv", data);
            save(new Payment(yearCreated, this.getTax(), false, this.getOverdue(), owner, eircode));
            fillFullPaymentRecord();
        }
        save(new Payment(yearCreated, this.getTax(), false, this.getOverdue(), owner, eircode));
        fillFullPaymentRecord();
    }

    public String getOwner() {
        return owner;
    }

    public String getAddress() {
        return address;
    }

    public String getEircode() {
        return eircode;
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

    public void fillFullPaymentRecord() {
        fullPaymentRecord = new ArrayList<>();
        int mostRecentPay = paymentRecord.get(paymentRecord.size() - 1).getYear();
        int count = 0;
        for (int i = yearCreated; i <= mostRecentPay; i++) {
            if (paymentRecord.get(count).getYear() == i) {
                fullPaymentRecord.add(paymentRecord.get(count));
                count++;
            } else {
                fullPaymentRecord.add(new Payment(i, tax, false, overdue, owner, eircode));
            }
            yearlyOverdue();
        }

    }

    public void yearlyOverdue() {
        double totalOverdue = 0;
        for (int i = 0; i < fullPaymentRecord.size() - 1; i++) {
            double tempTax = 0;
            if (fullPaymentRecord.get(i).getIsTaxPaid()) {
                fullPaymentRecord.get(i + 1).setOverdue(0);
                fullPaymentRecord.get(i + 1).setTax(permanentTax);
                totalOverdue = 0;
            }
            if (!fullPaymentRecord.get(i).getIsTaxPaid()) {
                if (fullPaymentRecord.get(i).getOverdue() == 0) {
                    overdue = permanentTax;
                }
                totalOverdue += overdue;
                fullPaymentRecord.get(i + 1).setOverdue(totalOverdue);
                overdue = taxCalc.unpaidPenalty(overdue);
                fullPaymentRecord.get(i + 1).setTax(overdue);
            }
        }
        overdue = 0;
    }

    public void save(Payment payed) {
        paymentRecord.add(payed);
    }

    public void check(int year) {
        for (Payment n : fullPaymentRecord) {
            if (n.getYear() == year) {
                n.setIsTaxPaid(true);
                return;
            }
        }
        save(new Payment(year, getTax(), true, getOverdue(), owner, eircode));
    }
    
     public boolean isPropertyinCSV(){
        ArrayList properties = CSV.readCSVFile("PropertyDetails.csv");
        String[] headings = (String[]) properties.get(0);
        boolean added = false;

        int index = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Eircode")) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < properties.size(); i++) {
            String[] tmp = (String[]) properties.get(i);
            if (tmp[index].trim().equals(eircode))
                added = true;
        }
        return added;
    }
    
    public String toString() {
        return "Property:\n" + "Owner: " + owner + ", Address: " + address + ", Eircode: "
                + eircode + ", Location: " + location + ", MarketValue: " + marketValue +
                ", PrivateResidence: " + privateResidence + "\n";
    }

    public String taxToString() {
        return fullPaymentRecord.get(fullPaymentRecord.size() - 1).toString();
    }
}
