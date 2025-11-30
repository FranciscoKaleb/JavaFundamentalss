
public class Main {
	
	public static void main(String[] args) {
		
		// no return type, no parameters
		//printHello();
		
		// with return type, with parameters
		int sum = add(5, 4);
		int product = multiply(5, 4);
		double quotient = divide(5.5, 0.5);
		
		System.out.println(sum);
		System.out.println(product);
		System.out.println(quotient);
		
		// without return type, with parameters
		int[] num_arr = {11,22,33,44,55};
		printArray(num_arr);
		
		int sum6 = add(1,3);
		
	}
	
	public static void add() {
		int a = 1;
		int b = 2;
		int sum = a + b;
	}
	
	public static int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public static int subtract(int a, int b) {
		
		return a - b;
		
	}
	
	public static int multiply(int a , int b) {
		return a * b;
	}
	
	public static double divide(double a, double b) {
		return a/b;
	}
	
	public static void printArray(int[] arr) {
		for(int num: arr) {
			System.out.print(num + " ");
		}
	}
	
}
