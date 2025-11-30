
public class Main {

	public static void main(String[] args) {
		
		
		
		// [1] for loop basic counter
		
//		for(int i = 100000;  i > 0;  i--) {
//			
//				System.out.println(i + " ");
//				
//		}
		
		
		
		
		
		
		// [2] for loop with if statement inside
//		
//		for(int i = 0;  i < 10;  i++) {
//		
//			if(i%2 != 0) {
//				System.out.print(i);
//			}
//		
//		}
		
		
		
		
		
		// [3] break keyword
		
//		for(int i = 0;  i < 10;  i++) {
//		
//			if(i == 5) {
//				break;
//			}
//			else {
//				System.out.print(i + " ");
//			}
//		
//		}
		
		
		
		
		
		// [4] print array elements using for loop
//		int[] grades = {75, 70, 80, 85, 91, 92, 93, 94, 999};
//		
//		for(int i = 0; i < grades.length; i++) {
//			
//			if(grades[i] < 75) {
//				System.out.println("grade: " + grades[i] + ", failed");
//			}
//			else if() {
//				// good
//			}
//			else if() {
//				// satisfactory
//			}
//			else if() {
//				// very satisfactory 
//			}
//			else if() {
//				// excellent
//			}
//			else {
//				// out of range
//			}
//			
//		}
		
		
		
		
		
		// [5] nested for loop
		
//		for(int i = 0; i <= 10; i++) {
//			
//			for(int j = 0; j <= i; j++) {
//				System.out.print(j);
//			}
//			
//			System.out.println(); // next line
//			
//		}
		
		
		
		
		
		
		
		// [6] for loop application - bubble sort 
		
		int[] num_arr = {11,1,3,4,-3,89,-44, -66, -99};
		int temp = 0;
		for(int j = 1; j < num_arr.length; j++) { // 1, 2, 3, 4
			for(int i = 0; i < num_arr.length-j; i++) {
				if(num_arr[i] > num_arr[i + 1]) { 
					//if true, swap values
					temp = num_arr[i+1]; 		// let temp hold value
					num_arr[i+1] = num_arr[i];	// reassign value
					num_arr[i] = temp;			// reassign value
				}
				else {
					// do nothing
				}
			}
		}
		
		
		// print array values
		for(int i = 0; i < num_arr.length; i++) {
			
			if(i <= num_arr.length - 2) {
				System.out.print (num_arr[i] + ", ");
			}
			else {
				System.out.print (num_arr[i] + " ");
			}
			
		}
		
		
		
		
		
		
	}

}
