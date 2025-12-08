public class Main{
	public static void main(String[] args) {

        // generate 100,000 random numbers from 1-1000000
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000000);
        }

        
        Benchmark bench2 = new Benchmark("QuickSort");
        bench2.timeStart();
        SortingAlgo.insertionSort(arr);
        bench2.timeEnd();
        
    }
	
	public static void primeNumberCounter() {
		int prime_count = 0;
		int org_num = 10000; // edit this value to count how many prime num is under this number
		int num_outer = org_num;
		
		int num_inner = num_outer;
		int num_copy = num_inner;
		int factors_count = 0;
		while(num_outer >= 2) {
			while(num_inner != 0) {
				if(num_inner <= 1) {
					break;
				}
				if(num_copy%num_inner == 0) {
					factors_count++;
					if(factors_count == 2 && num_inner != 1) {
						break;
					}
				}
				num_inner--;
			}	
			if(factors_count == 2 && num_inner != 1) {
				System.out.println(num_copy + " is not prime, its divisible by " + num_inner);	
			}else {
				System.out.println(num_copy + " is prime");
				prime_count++;
			}
			num_outer--;
			num_inner = num_outer;
			num_copy = num_inner;
			factors_count = 0;
		}
		
		System.out.println("prime numbers under " + org_num + " is " + prime_count);
	}
	
	
}