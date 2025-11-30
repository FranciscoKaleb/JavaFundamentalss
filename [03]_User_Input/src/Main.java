import java.util.Scanner;  // Import the Scanner class
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		sc.nextLine(); // clear the scanner when using nextInt()
		
		System.out.println("Enter your nationality: ");
		String nationality = sc.nextLine();
		
		System.out.println("Your name is " + name);
		System.out.println("You are " + age + " years old");
		System.out.println("You are a " + nationality + " citizen");
		sc.close();
	}
}
