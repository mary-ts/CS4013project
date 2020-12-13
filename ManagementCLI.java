import java.util.Scanner;
import java.io.IOException;

public class ManagementCLI {
    private Scanner in;
    private String command;
    private String command2;
    
    /*
        @Author: Rachel O'Donoghue, 19274505
        */
    
    public ManagementCLI(){
        in = new Scanner(System.in);
    }

    public void run(Management p) throws IOException {
        boolean more = true;
        while(more) {
            System.out.println("1)Property Tax 2) Overdue Tax 3) Payment Statistics 4) Change Tax 5) Quit");
            command = in.nextLine().toUpperCase();
            if(command.equals("1")) {
                System.out.println("Specify P)roperty eircode or O)wner");
                command2 = in.nextLine().toUpperCase();
                if(command2.equals("P")) {
                    System.out.println("Please enter Eircode:");
                    String code = in.nextLine().toUpperCase();
                    p.getPropertyTaxFromProperty(code);
                } else if (command2.equals("O")) {
                    System.out.println("Please specify owner:");
                    command2 = in.nextLine();
                    p.getPropertyTaxFromOwner(new PropertyOwner(command2));
                }
            } else if(command.equals("2")) {
                System.out.println("Please enter year:");
                String year = in.nextLine();
                System.out.println("Do you want data from A)ll or S)pecific area?");
                String choice = in.nextLine().toUpperCase();
                if (choice.equals("A")) {
                    p.getOverdue(Integer.parseInt(year));
                } else if(choice.equals("S")) {
                    System.out.println("Enter Eircode:");
                    String eircode2 = in.nextLine().toUpperCase();
                    p.getOverdue(Integer.parseInt(year), eircode2);
                }
            } else if(command.equals("3")) {
                System.out.println("Enter eircode: ");
                String eircode = in.nextLine().toUpperCase();
                p.getTaxStatistics(eircode);
            } else if(command.equals("4")) {
                p.testRates();
            } else if(command.equals("5")) {
                break;
            }
        }
    }
}
