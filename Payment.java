import java.time.LocalDate;
import java.util.ArrayList;

public class Payment {
    TaxCalculator taxCalc;
    private double payment;
    private double tax;
    private double balance;
    
    private int year;

    public Payment(Property property, double amount){
        taxCalc = new TaxCalculator();
        this.year = (LocalDate.now()).getYear();
        payment = amount;
        setTax();
        setPayment(amount);
        makePayment();
    }

    public void setPayment(double amount){
        payment = amount;
    }

    public double getPayment(){
        return payment;
    }

    public void setTax(){
        tax = taxCalc.getTotalTax();
    }

    public double getTax(){
        return tax;
    }

    public void makePayment(){
        balance = tax - payment;
    }

    public double getBalance() {
        return balance;
    }

    public int getYear() {
        return year;
    }

    public String toString(){
        return year + " Tax due: €" + tax + "   Amount paid: €" + payment + "   Left to pay: €"
                + balance + "\n";
    }

}
