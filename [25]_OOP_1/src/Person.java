
public class Person {
	//defaults
	private String DEFAULT_NAME = "unnamed";
	private int DEFAULT_AGE = 18;
	
	// fields - private
	protected String name;
	protected int age;
	
	// properties
	public String getName() {
		return this.name;
	}
	public void setName(String n) {
		if(n.length() > 10) {
			System.out.println("max of 10 char");
		}
		else {
			this.name = n;
		}
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int a) {
		if(a < 0) {
			System.out.println("age cant be negative");
		}
		else {
			this.age = a;
		}
	}
	
	
	//constructors
	public Person() { //default constructor
		setName(DEFAULT_NAME);
		setAge(DEFAULT_AGE);
	}
	
	public Person(String n, int a) {
		
		setName(n);
		setAge(a);
		
	}
	
	//methods
	static void printsomething() {
		System.out.println("sdfsdf");
	}
	
}
