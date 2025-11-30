import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Person> people = new ArrayList<>();

	public static void main(String[] args) {

		printMainMenu();
	}

	static void printMainMenu() {
		System.out.println("Choose an option");
		System.out.println("[1] add a person");
		System.out.println("[2] see people list");
		System.out.println("[3] End Program");
		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 1:
				addPerson();
				printMainMenu();
				break;
			case 2:
				listPerson();
				printMainMenu();
				break;
			case 3:
				System.out.println("End Program");
				break;
			default:
				System.out.println("out of range");
				printMainMenu();
				break;
		}

	}
	static void addPerson() {
		String name;
		int age;

		System.out.println("Enter name:");
		name = sc.nextLine();

		System.out.println("Enter age:");
		age = sc.nextInt();
		sc.nextLine();

		if(people.add(new Person(name,age))) {
			System.out.println("Added successfully!");
		}

	}
	static void listPerson() {
		for(Person p : people) {
			System.out.println(p.getName() + " " + p.getAge());
		}
	}

}

