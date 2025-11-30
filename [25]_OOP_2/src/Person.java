
public class Person {

	// [1] Constants and defaults
	String default_name = "Juan";
	int default_age = 18;

	// [2] fields
	private String name;
	private int age;

	// [3] getters and setters - Encapsulation
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {

		if(age < 0) {
			throw new IllegalArgumentException("Age cannot be negative.");
		}
		else {
			this.age = age;
		}

	}

	// [4] constructors
	public Person() {
		this.name = default_name;
	}
	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}

	// [5] methods
	public void introduce() {
		System.out.println("Hi my name is " + name + " I am " + age + " years old");
	}



}
