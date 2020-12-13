import java.util.Scanner;
import java.io.IOException;

public class ManagementCLI {
    private Scanner in;
    private String command;
    private String command2;

    public ManagementCLI(){
        in = new Scanner(System.in);
    }

    public void run(Management p) throws IOException {
        boolean more = true;
        while(more) {
            System.out.println("1) Property Tax 2) Overdue Tax 3) Payment Statistics 4) Change Tax 5) Quit");
            command = in.nextLine().toUpperCase();
            if(command.equals("1")) {
                System.out.println("Specify P)roperty or O)wner");
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
                int year = in.nextInt();
                System.out.println("Do you want data from A)ll or S)pecific area?");
                year = in.nextInt();
                if (command2.equals("A")) {
                	p.getOverdue(year);
                } else if(command2.equals("S")) {
                	System.out.println("Enter Eircode:");
                	command2 = in.nextLine();
                	p.getOverdue(year, command2);
                }
            } else if(command.equals("3")) {
                System.out.println("Enter eircode: ");
                command2 = in.nextLine().toUpperCase();
                p.getTaxStatistics(command2);
            } else if(command.equals("4")) {
            	p.testRates();
            } else if(command.equals("5")) {
                break;
            }
        }
    }
}
