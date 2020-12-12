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


    public String toString(){
        return year + " Tax due: €" + tax + "   Tax paid: €" + isTaxPaid + "   Overdue: €"
                + overdue + "\n";
    }

}
