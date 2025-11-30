import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		

		
		// 01 -  prints hello non stop

//		while(true) {
//			System.out.println("hello ");
//		}
		
		
		

		
		// 02 while loop with counter prints 0 - 10

//		int num = 0;
//		
//		while(num <= 10) {
//			System.out.print(num + " ");
//			num ++;
//		}
		
		
		
		
		// break keyword
		// 02.1 while loop with counter prints 0 - 10
		// stop loop at 5

//		int num = 0;
//		
//		while(num <= 100) {
//			
//			if(num%5 == 0) {
//				System.out.println(num);
//			}
//			num ++;
//			
//		}
		
		
		
		
		
		
		
		// 03 sum of numbers 1 - 5
//		int num = 0;
//		int sum = 0;
//		
//		while (num < 5) {
//			num ++;
//			sum = sum + num; 
//		}
//		
//		System.out.println(sum);
		
		
		
		
		
		
		// 04 reverse count
		
//		int num = 5;
//		
//		while(num > 0) {
//			System.out.println(num);
//			num--;
//		}
		
		
		
		
		// 05 simple scanner sample. user needs to type "exit" to end program
//
		
//		String name = "kaleb";
//		
//		System.out.println(name.length());
//		
//		
//		
//		int[] num_arr = {44, 77, 99};
//		
//		System.out.println(num_arr.length);
		
		
		
		
		
		
		
		// 06 reverse a number

//		int num = 4568903;
//		int reverse = 0;
//		
//		while(num != 0) {
//			int digit = num%10; // get the last digit
//			reverse = reverse*10 + digit;
//			num = num/10; // remove the last digit
//		}
//		
//		System.out.println(reverse);
		
		
		
		
		
		
		
		// 07  multiplication table
//		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Enter an integer");
//		
//		int num = sc.nextInt();
//		int i = 1;
//		while(i <= 10) {
//			System.out.println(num + " x " + i + " = " + (num*i));
//			i++;
//		}
		
		
		
		
		
		
		// 08 guess the number
		
		Random rand = new Random();
		int secret = rand.nextInt(10);
		Scanner sc = new Scanner(System.in);
		
		
		int guess = 0;
		
		while (guess != secret) {
		    System.out.print("Guess (1-10): ");
		    guess = sc.nextInt();
		    if (guess < secret) System.out.println("Too low!");
		    else if (guess > secret) System.out.println("Too high!");
		}
		System.out.println("Correct! The number was " + secret);
		
		
		
		
		
		
		
		// 09 factorial
		
//		int n = 5;
//		int fact = 1;
//
//		while (n > 0) {
//		    fact *= n;
//		    n--;
//		}
//		System.out.println("Factorial = " + fact);
		
		
		
		
		
		
		
		
		
		
		// 10 palindrome check
		
//		int num_orig = 1221;
//		int num_copy = 1221; // to be converted to zero
//		int reverse = 0;
//		
//		while(num_copy != 0) {
//			
//			int digit = num_copy%10; // get the last digit
//			reverse = reverse*10 + digit;
//			num_copy = num_copy/10; 		// remove the last digit
//			
//		}
//		
//		System.out.println(num_orig + " " + reverse);
//		
//		if (num_orig == reverse) {
//			System.out.println("palindrome");
//		}
//		else {
//			System.out.println("not palindrome");
//		}
		
		
		
		
		
		
		
		
		
		// 11 prime number checker
		
//		int num = 18;
//		int num_copy = 18;
//		int factors_count = 0;
//		
//		while(num != 0) {
//			
//			if(num <= 0) {
//				break;
//			}
//			
//			if(num_copy%num == 0) {
//				factors_count++;
//				if(factors_count > 2) {
//					break;
//				}
//			}
//			num = num -1;
//		}
//		
//		System.out.println("Factor count: " + factors_count);
//		
//		if(factors_count == 2) {
//			System.out.println("prime");
//		}else {
//			System.out.println("not prime");
//		}
		
		
		
		
		
		
		
		
		
		
		// 12 prime numbers up to n

		
//		int prime_count = 0;
//		int org_num = 2000000000;
//		int num_outer = org_num;
//		
//		int num_inner = num_outer;
//		int num_copy = num_inner;
//		int factors_count = 0;
//		
//		while(num_outer >= 2) {
//			
//			
//			
//			while(num_inner != 0) {
//				
//				if(num_inner <= 1) {
//					break;
//				}
//				
//				if(num_copy%num_inner == 0) {
//					factors_count++;
//					if(factors_count == 2 && num_inner != 1) {
//						break;
//					}
//				}
//				num_inner--;
//			}
//				
//			if(factors_count == 2 && num_inner != 1) {
//				System.out.println(num_copy + " is not prime, its divisible by " + num_inner);
//				
//			}else {
//				System.out.println(num_copy + " is prime");
//				prime_count++;
//			}
//			
//			num_outer--;
//			num_inner = num_outer;
//			num_copy = num_inner;
//			factors_count = 0;
//			
//		}
//		
//		System.out.println("prime numbers under " + org_num + " is " + prime_count);
		
		
		
		
		
		
		
	} // end of main method

} // end of Main class

























