import java.util.ArrayList;
import java.util.Arrays;

public class Management {
    private Payment payments;
    private PropertyOwner property;

    public void getPropertyTaxFromOwner(PropertyOwner p) {
        ArrayList data = CSV.readCSVFile("Payments.csv");
        String[] headings = (String[]) data.get(0);

        int index = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Owner")){
                index = i;
                break;
            }
        }

        for (int i=0; i<data.size(); i++) {
            String[] tmp = (String[]) data.get(i);
            if (tmp[index].trim().equalsIgnoreCase(p.getOwner())) {
                System.out.println(Arrays.toString(tmp));
            }
        }
    }

    public void getPropertyTaxFromProperty(String eircode) {
        ArrayList data = CSV.readCSVFile("Payments.csv");
        String[] headings = (String[]) data.get(0);

        int index = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Eircode")) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < data.size(); i++) {
            String[] tmp = (String[]) data.get(i);
            if (tmp[index].trim().equals(eircode))
                System.out.println(Arrays.toString(tmp));
        }
    }

    private double getTotalTax(String eircode){
        String[] split = eircode.split(" ");
        String routingKey = split[0];
        double totalTax = 0;

        ArrayList data = CSV.readCSVFile("Payments.csv");
        String[] headings = (String[]) data.get(0);

        int index = 0;
        int taxIndex = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Eircode")) {
                index = i;
            }
            if (headings[i].trim().equalsIgnoreCase("Tax")) {
                taxIndex = i;
                break;
            }
        }

        for (int i = 0; i < data.size(); i++) {
            String[] tmp = (String[]) data.get(i);
            if (tmp[index].trim().contains(routingKey)) {
                totalTax = totalTax + Double.parseDouble(tmp[taxIndex]);
            }
        }
        return totalTax;
    }

    private double getAverageTax(String eircode){
        String[] split = eircode.split(" ");
        String routingKey = split[0];
        double averageTax = 0;

        ArrayList data = CSV.readCSVFile("Payments.csv");
        String[] headings = (String[]) data.get(0);

        int index = 0;
        int taxIndex = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Eircode")) {
                index = i;
            }
            if (headings[i].trim().equalsIgnoreCase("Tax")) {
                taxIndex = i;
            }
        }

        int numProps = 0;
        for (int i = 0; i < data.size(); i++) {
            String[] tmp = (String[]) data.get(i);
            if (tmp[index].trim().contains(routingKey)) {
                averageTax = averageTax + Double.parseDouble(tmp[taxIndex]);
                numProps ++;
            }
        }
        averageTax = averageTax/numProps;
        return averageTax;
    }

    private double getNumberPaid(String eircode){
        String[] split = eircode.split(" ");
        String routingKey = split[0];

        ArrayList data = CSV.readCSVFile("Payments.csv");
        String[] headings = (String[]) data.get(0);

        int index = 0;
        int paidIndex = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Eircode")) {
                index = i;
            }
            if (headings[i].trim().equalsIgnoreCase("Paid")) {
                paidIndex = i;
            }
        }

        int numProps = 0;
        for (int i = 0; i < data.size(); i++) {
            String[] tmp = (String[]) data.get(i);
            if (tmp[index].trim().contains(routingKey) && tmp[paidIndex].trim().equalsIgnoreCase("true")) {
                numProps ++;
            }
        }
        return numProps;
    }

    private double getPercentPaid(String eircode){
        String[] split = eircode.split(" ");
        String routingKey = split[0];
        double propNumber = getNumberPaid(eircode);

        ArrayList data = CSV.readCSVFile("Payments.csv");
        String[] headings = (String[]) data.get(0);

        int index = 0;
        for (int i = 0; i < headings.length; i++) {
            if (headings[i].trim().equalsIgnoreCase("Eircode")) {
                index = i;
            }
        }

        int numProps = 0;
        for (int i = 0; i < data.size(); i++) {
            String[] tmp = (String[]) data.get(i);
            if (tmp[index].trim().contains(routingKey)) {
                numProps ++;
            }
        }
        return (propNumber/numProps)*100;
    }

    public void getTaxStatistics(String eircode){
        String s = "Tax Statistics(based on routing key):\n";
        double totalTax = getTotalTax(eircode);
        double avgTax = getAverageTax(eircode);
        double numPaid = getNumberPaid(eircode);
        double percent = getPercentPaid(eircode);
        s = s + "Total tax: " + totalTax +
                "\nAverage tax: " + avgTax +
                "\nNumber of Paid Taxes: " + numPaid +
                "\nPercent of Paid Taxes: " + percent + "%";
        System.out.println(s);
    }
}
