import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Rank	Method	         Return Type	                                     Parameters	               Description
//		1	     Math.abs(x)	    Same as input type (int, long, float, double)	   number	        Returns absolute value
//		2	     Math.max(a, b)	    Same as input type	                             two numbers	    Returns larger of two values
//		3	     Math.min(a, b)	    Same as input type	                             two numbers	    Returns smaller of two values
//		4	     Math.sqrt(x)	    double	                                         double x	               Square root
//		5	     Math.pow(a, b)	    double	                                         double a, double b	       Returns a^b
//		6	     Math.random()	    double	                                          none	              Returns random value from 0.0 to <1.0
//		7	     Math.round(x)	    long (for double) or int (for float)	          number	          Rounds to nearest integer
//		8	     Math.floor(x)	    double	                                          double x         	   Largest integer ≤ x
//		9	     Math.ceil(x)	    double	
		
		
		// [1] absolute values using abs()
		
//		int num1 = -1;
//		System.out.println(Math.abs(num1));
		
		
		
		
		// [2] Math.round()
		
//		System.out.println(Math.round(5.51));
		
		
		
		// [3] Math.random() - random value between 0 and 0.9999
		
//		System.out.println(Math.random());
		
		
		
		// [4]  Math.random() - increase range from 0 to 99.9999
		
//		System.out.println(Math.random() * 100);
		
		
		
		// [5] Math.random() convert to integer from 0 to 99; still up to 99 because 99.7 converted to int is 99
		
//		int num = (int)(Math.random() * 100);
//		System.out.println(num);
		
		
		
		
		// [6] Math.random() using math.round()     0 - 100
		
//		while(true) {
//			int num = (int)Math.round((Math.random() * 100));
//			
//			System.out.println(num);
//			
//			if(num == 100) {
//				break;
//			}
//		}
		
		
		
		
		
		// [7] random numbers from 18 - 21
		
//		int min = 18;
//		int num2 =  (int)Math.round(min + Math.random() * 3);
//		System.out.println(num2);
		
		
		
		
		
		// [8] choosing a random array element using Math.random()
		
//		int[] num_arr = {11,22,33,44,55};
//		
//		int min = 0; // first array index
//		
//		int rand_index = (int)Math.round(min + Math.random() * 4);
//		
//		System.out.println(num_arr[rand_index]);
		
		
		
		
		
		// [9] choosing random element from arrayList
		
		
//		ArrayList<Integer> num_arr = new ArrayList<Integer>();
//		num_arr.add(11);
//		num_arr.add(22);
//		num_arr.add(33);
//		num_arr.add(44);
//		num_arr.add(55);
//		
//		int min = 0;
//		
//		
//		
//		while(num_arr.size() != 0) {
//			
//			int rand_index = (int)Math.round(min + Math.random() * (num_arr.size() - 1) );
//			System.out.println(num_arr.get(rand_index));
//			num_arr.remove(rand_index);
//			
//		}
		
		
		
		


		
		
		
	}

}
