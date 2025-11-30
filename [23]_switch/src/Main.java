import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		

		// Example 1 switch statement 
		
//		int option = 1;
//		
//		switch(option){
//			
//			case 1:
//				System.out.println("Option 1 selected");
//				break;
//				
//			case 2: 
//				System.out.println("Option 2 selected");
//				break;
//			
//			default:
//				System.out.println("error, out of range");
//				break;
//				
//		}
		
		
		
		
		
		
		// Example 2 using Scanner
//		Scanner myScanner = new Scanner(System.in);
//		
//		int option = myScanner.nextInt();
//		
//		switch(option) {
//		
//			case 1:
//				System.out.println("Sound settings");
//				break;
//				
//			case 2:
//				System.out.println("Screen settings");
//				break;
//				
//			default:
//				System.out.println("error, out of range");
//				break;
//				
//		}
//		myScanner.close();
		
		
		
		
		
		
		
		// Example 3 with label
//				Scanner myScanner = new Scanner(System.in);
//				System.out.println("Settings menu: Select the number to enter the settings");
//				System.out.println("[1] Sound Settings");
//				System.out.println("[2] Screen Settings");
//				
//				int option = myScanner.nextInt();
//				
//				switch(option) {
//				
//					case 1:
//						System.out.println("Sound settings");
//						break;
//						
//					case 2:
//						System.out.println("Screen settings");
//						break;
//						
//					default:
//						System.out.println("error, out of range");
//						break;
//						
//				}
//				myScanner.close();
				
				
				
				
		        Scanner myScanner = new Scanner(System.in);
		        System.out.println("Settings menu: Select the number to enter the settings");
		        System.out.println("[1] Sound Settings");
		        System.out.println("[2] Screen Settings");

		        int option = myScanner.nextInt();

		        if (option == 1) {
		            System.out.println("Sound settings");
		        } else if (option == 2) {
		            System.out.println("Screen settings");
		        } else {
		            System.out.println("error, out of range");
		        }

		        myScanner.close();
				    
				

		
	}

}
