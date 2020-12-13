
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
            System.out.println("1) Property tax 2) Overdue tax 3) Payment stats 4) Other 5) Quit");
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
                    String owner = in.nextLine();
                    p.getPropertyTaxFromOwner(new PropertyOwner(owner));
                }
            } else if(command.equals("2")) {
                System.out.println("Please enter year:");
                int option = in.nextInt();
                System.out.println("Do you want data from 1) All property in that year or 2) eircode");
                option = in.nextInt();
                if (option == 1) {

                }
                //p.getOverdueTax(option, code);
            } else if(command.equals("3")) {
                System.out.println("Enter eircode: ");
                String code = in.nextLine().toUpperCase();
                p.getTaxStatistics(code);
            } else if(command.equals("4")) {

            } else if(command.equals("5")) {
                break;
            }
        }
    }
}
