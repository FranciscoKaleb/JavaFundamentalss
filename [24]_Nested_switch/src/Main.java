import java.util.Scanner;
import java.util.ArrayList; // Import the ArrayList class

public class Main {
	
	
	
	// -------------global variables-------------//
	static Scanner myScanner = new Scanner(System.in); // use only one scanner object
	
		// global volume variables
	static int volume = 35;
	static boolean muted = false;
	
		// global display variables
	static int brightness = 20;
	static boolean reading_mode = false;
	
		// global language variables
	static String[] languages = {"Filipino", "English", "Chinese", "Japanese", "Arab", "Indian"};
	static String chosen_language = languages[2];
	
		// global user variables
	static ArrayList<String> users = new ArrayList<String>();
	static String active_user;
	static {
	    users.add("Default User");
	    active_user = users.get(0);
	}
	// -------------global variables-------------//
	
	
	// main function
	public static void main(String[] args) {
		
		printMainMenu(); 
		myScanner.close(); // close scanner after program ends

	}
	
	// print main menu
	public static void printMainMenu() {
		
		System.out.println("Main Menu");
		System.out.println("Select the number to enter the settings");
		System.out.println("[1] Sound Settings");
		System.out.println("[2] Display Settings");
		System.out.println("[3] Show system values");
		System.out.println("[4] Program End");
		int option = myScanner.nextInt();
		
		switch(option) {
		
			case 1:
				printSoundSettings();
				break;
				
			case 2:
				break;
				
			case 3:
				printValues();
				printMainMenu();
				break;
			
			case 4:
				System.out.println("Program End");
				break;
				
			default:
				System.out.println("error, out of range, please select again.");
				printMainMenu();
				break;
		}
		
	}
	
	// print system values
	public static void printValues() {
		System.out.println();
		System.out.println("--------------System values-------------");
		System.out.println();
		System.out.println("volume: " + volume);
		System.out.println("muted: " + muted);
		System.out.println("brightness: " + brightness);
		System.out.println("reading_mode: " + reading_mode);
		System.out.println();
		System.out.println("--------------System values-------------");
		System.out.println();
	}
	
	// ----------------- SOUND RELATED FUNCTIONS START -----------------------//
	public static void printSoundSettings() {
		
		System.out.println("Sound Settings");
		System.out.println("[1] Volume");
		System.out.println("[2] Mute");
		System.out.println("[3] Go back");
		int option = myScanner.nextInt();
		
		switch(option) {
		
			case 1:
				alterVolume();
				printSoundSettings();
				break;
				
			case 2:
				mute();
				printSoundSettings();
				break;
				
			case 3:
				System.out.println("go back to main menu");
				printMainMenu();
				break;
				
			default:
				System.out.println("error, out of range");
				printSoundSettings();
				break;
				
		}
	}
	
	public static void alterVolume() {
		
		System.out.println("Enter values from 0 - 100 to set volume");
		volume = myScanner.nextInt();
		System.out.println("System volume set to " + volume);
		
	}
	
	public static void mute() {
		
		System.out.println("Mute system volume? [y/n]");
		System.out.println("[y] yes");
		System.out.println("[n] no");
		myScanner.nextLine(); // clear the scanner, its kind of like a bug when using nextLine() right after a nextInt()
		String choice = myScanner.nextLine();
		if(choice.equals("y")) {
			muted = true;
			System.out.println("muted: true");
		}
		else {
			muted = false;
			System.out.println("muted: false");
		}
		
		
	}
	// ----------------- SOUND RELATED FUNCTIONS END -------------------------//
	
	
	
	
	
	
	
	
	
	
	// ----------------- DISPLAY RELATED FUNCTIONS START -----------------------//
	public static void printDisplaySettings() {
		
		System.out.println("Sound Settings");
		System.out.println("[1] Volume");
		System.out.println("[2] Mute");
		System.out.println("[3] Go back");
		int option = myScanner.nextInt();
		
		switch(option) {
		
			case 1:
				alterVolume();
				printSoundSettings();
				break;
				
			case 2:
				mute();
				printSoundSettings();
				break;
				
			case 3:
				System.out.println("go back to main menu");
				printMainMenu();
				break;
				
			default:
				System.out.println("error, out of range");
				printSoundSettings();
				break;
				
		}
	}
	
	public static void alterBrightness() {
		
		System.out.println("Enter values from 0 - 100 to set volume");
		volume = myScanner.nextInt();
		System.out.println("System volume set to " + volume);
		
	}
	
	public static void readingMode() {
		
		System.out.println("Mute system volume? [y/n]");
		System.out.println("[y] yes");
		System.out.println("[n] no");
		myScanner.nextLine(); // clear the scanner, its kind of like a bug when using nextLine() right after a nextInt()
		String choice = myScanner.nextLine();
		if(choice.equals("y")) {
			muted = true;
			System.out.println("muted: true");
		}
		else {
			muted = false;
			System.out.println("muted: false");
		}
		
		
	}

	//  ----------------- DISPLAY RELATED FUNCTIONS END -------------------------//
	
	
	
	
	
	
	
	// ----------------- LANGUAGE RELATED FUNCTIONS START -----------------------//
	
	
	// ----------------- LANGUAGE RELATED FUNCTIONS END -------------------------//
	
	
	
	
	// ----------------- USER RELATED FUNCTIONS START -----------------------//
	static void user_list() {
		
	}
	static void add_user() {
		
	}
	static void replace_active_user() { //switch account . . .
		
	}
	
		// ----------------- USER RELATED FUNCTIONS END -------------------------//
	
	
	
}
