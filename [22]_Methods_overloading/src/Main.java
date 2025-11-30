
public class Main {

	public static void main(String[] args) {
		
		int[] num_arr = {5,4,3,2,1};
		int[] sorted = sort(num_arr);
		for(int num: sorted) {
			System.out.print(num + " ");
		}
	}

	static int[] sort(int[] num_arr) {
		
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
		
		return num_arr;
	}
	
	
	
	

}
