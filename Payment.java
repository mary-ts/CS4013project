public class Payment {
    private int year;
    private boolean isTaxPaid;
    private double tax;
    private double overdue;

    public Payment(int year, double tax, boolean isTaxPaid, double overdue){
        this.year = year;
        this.isTaxPaid = isTaxPaid;
        this.tax = tax;
        this.overdue = overdue;
        String[] data = {Property.getOwner(), Property.getEircode(), String.valueOf(year), String.valueOf(tax), String.valueOf(isTaxPaid), String.valueOf(overdue)};
        //CSV.writeCSVFile("TaxDetails.csv", data);
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean getIsTaxPaid() {
        return isTaxPaid;
    }

    public void setIsTaxPaid(boolean isTaxPaid) {
        this.isTaxPaid = isTaxPaid;
    }

    public double getOverdue() {
        return overdue;
    }

    public void setOverdue(double overdue) {
        this.overdue = overdue;
    }

    public String toString(){
        return year + " Tax due: €" + tax + "   Is tax paid: " + isTaxPaid + "   Overdue: €"
                + overdue + "\n";
    }

}
