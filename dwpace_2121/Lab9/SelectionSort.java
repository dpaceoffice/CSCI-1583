/**
* @author	David Pace
* @version	10/15/19
*/
import java.util.*;

public class SelectionSort {
	
	ArrayList<Integer> list;
	
	public SelectionSort(ArrayList<Integer> list) {
		this.list = list;
	}
	
	/*Implement a Selection Sort. You may use the swap() method below in your implementation
	 * if it makes the task easier for you. An iterative implementation of selection sort makes
	 * use of a for-loop that contains an inner for-loop. Selection sort begins by comparing
	 * every element in the array with the first element in the array. After one pass through
	 * the entire array, it will swap the lowest element in the array with the first element
	 * in the array. This means that after the first pass through the array, the first element
	 * in the array is now in its correct position.
	 * 
	 * In the second pass through the array, the same process will take place. However, instead
	 * of starting at the first element in the array (which has already been sorted), the second
	 * pass will start at the second element in the array. Every element remaining in the array
	 * will be compared to the second element in the array and the lowest element amongst the
	 * remaining items (which will be the 2nd-lowest element overall) will be swapped with the
	 * second element in the array.
	 * 
	 * This process will continue until the entire array is sorted.
	 * */
	public void sort() {
		for(int i = 0; i < list.size() -1; i++) {
			int firstValue = list.get(i);
			int lowestValueIndex = -1;
			for(int i2 = i+1; i2 <= list.size() -1; i2++) {
				int comparedValue = list.get(i2);
				if(firstValue > comparedValue) {
					if(lowestValueIndex == -1)
					lowestValueIndex = i2;
				else
					if(comparedValue < list.get(lowestValueIndex))
						lowestValueIndex = i2;
				}
			}
			if(lowestValueIndex != -1)
			swap(i, lowestValueIndex);
			System.out.println(list);
		}
	}

			
			//System.out.println() should be the final call made from our outer for loop
			//System.out.println(list);
	
	//Swaps two items in the list
	public void swap(int firstIndex, int secondIndex) {
		int temp = this.list.get(firstIndex);
		this.list.set(firstIndex, this.list.get(secondIndex));
		this.list.set(secondIndex, temp);
	}
	
	public static class SortRunner {
		public static void main(String[] args) {
			Integer[] numbers = {1,2,7,2,9,18,29,30,6,3};
			ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(numbers));
			SelectionSort sort = new SelectionSort(data);
			sort.sort();
			System.out.println(sort.list);
		}
	}
}