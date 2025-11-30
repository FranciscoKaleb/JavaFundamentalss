
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int age = -3;
		
		if(age > 0 && age <= 3) {
			System.out.println("baby");
		}
		else if(age > 3 && age <= 12) {
			System.out.println("young kid");
		}
		else if(age > 12 && age <= 19) {
			System.out.println("teenager");
		}
		else if(age > 19 && age <= 30) {
			System.out.println("young adult");
		}
		else if(age > 30 && age <= 59) {
			System.out.println("adult");
		}
		else if(age >= 60){
			System.out.println("senior");
		}
		else {
			System.out.println("age out of range");
		}
		
		

	}

}
