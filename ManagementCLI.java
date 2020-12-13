import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class ManagementCLI {	
	Scanner scan = new Scanner(System.in);
	
	public void run(Management p) throws IOException {
		boolean more = true;
		while(more) {
			System.out.println("1) Property tax 2) Overdue tax 3) Payment stats 4) Other 5) Quit");
			int option = scan.nextInt();
			if(option == 1) {
				System.out.println("Specify 1) Property or 2) Property Owner");
				option = scan.nextInt();
				if(option == 1) {
					System.out.println("Please enter Eircode:");
					String code = scan.nextLine();
					p.getPropertyTaxFromProperty(code);
				} else if (option == 2) {
					System.out.println("Please specify owner:");
					String owner = scan.nextLine();
					//p.getPropertyTaxFromOwner(owner);
				}
			} else if(option == 2) {
				System.out.println("Please enter year:");
				option = scan.nextInt();
				System.out.println("Do you want data from 1) All property in that year or 2) eircode");
				option = scan.nextInt();
				if (option == 1) {
					
				}
				//p.getOverdueTax(option, code);
			} else if(option == 3) {
				System.out.println("Enter eircode");
				String code = scan.nextLine();
			//	p.getStats(code);
			} else if(option == 4) {
			
			} else if(option == 5) {
				break;
			}
		}
	}
}
