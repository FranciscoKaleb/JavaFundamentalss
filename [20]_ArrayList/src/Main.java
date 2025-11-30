import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		// [1] declaring array list
		ArrayList<Integer> num_arr = new ArrayList<Integer>();
		
		// [2] .add() adding value to array list
		num_arr.add(11);
		num_arr.add(22);
		num_arr.add(33);
		num_arr.add(-33);
		num_arr.add(-44);
		
		// [3] .get() getting value from array list
		System.out.println(num_arr.get(0));
		
		// [4] .size() getting array list length
		System.out.println(num_arr.size());
		
		// [5] looping through arraylist
		for(int num : num_arr) {
			System.out.print(num + " ");
		}
		System.out.print("\n");
		
		// [6] .remove() removing value from arraylist
		num_arr.remove(0); // removes 11
		for(int num : num_arr) {
			System.out.print(num + " ");
		}
		System.out.print("\n");
		
		// [7] .sort() 
		Collections.sort(num_arr);
		for(int num : num_arr) {
			System.out.print(num + " ");
		}
		System.out.print("\n");
		
	}
}