package HW5;


/**
 * @author David Pace
 * @Since 10/26/19
 * @Version 1
 */
import java.util.ArrayList;
import java.util.List;
import java.lang.Comparable;
public class Sorters2120 {

	/**
	 * 
	 * @param theList
	 */
    public static <T extends Comparable<T> > void bubbleSort(List<T> theList) {
        int lastToConsider = theList.size();
        boolean calledSwap = false;
        while (lastToConsider > 1) {
            for (int j=0; j<lastToConsider-1; j++) {
                if (theList.get(j).compareTo(theList.get(j+1))  >  0 ) {
                    swap(theList,j,j+1);
                    calledSwap = true;
                }
            }
            if(calledSwap == false)
            	break;
            lastToConsider--;
        }
    }

    /**
     * 
     * @param theList
     * @param firstIndex  
     * @param SecondIndex 
     */
    private static <T extends Comparable<T> > void swap(List<T> theList, int i1, int i2) {

        T temp = theList.get(i1);
        theList.set(i1,theList.get(i2));
        theList.set(i2,temp);
    }

    
    /**
     * A selection sort's job is to organize a list of data from minimum to a maximum value.. 
     * Because we are comparing dogs, the weight is what indicates the position the dog should be in the list
     * This is pretty simple.. We need to just keep track of the lowest value.
     * @param List<T> with comparable objects
     * @return sorts the list passed in using comparable of contained generic object
     */
    public static <T extends Comparable<T> > void selectionSort(List<T> list) {//since we are using generics the comparable is a required interface for objects in this list 
    	for(int i = 0; i < list.size() -1; i++) {//linear loop
    		T firstGeneric = list.get(i);//grabs the first index, or whatever dog/generic we are currently working with
    		int lowestValueIndex = -1;//this has to be tracked for each dog we are currently working with
    		for(int i2 = i+1; i2 <= list.size() -1; i2++) {//so we have our first dog, lets compare it to the rest of the dogs in the list
    		    T comparedGeneric = list.get(i2);//lets save the next object avaliable then
    		    if(firstGeneric.compareTo(comparedGeneric) > 0) {//this means the second dog is smaller than the first if its bigger we will just try the next object
    		    	if(lowestValueIndex == -1) //we have to make sure this is set..
    		    		lowestValueIndex = i2;//since the second dog is smaller, set this
    		    	else
    		    		if(comparedGeneric.compareTo(list.get(lowestValueIndex)) < 0)//if the lowest already exists, compare it to the current compared
    		    			lowestValueIndex = i2;//if the compared is lower than the lowest in the index set it to new lowest
    		    	
    		    }
    		}
    		if(lowestValueIndex != -1)//if our lowest index got set, which is possible to stay -1 if the object being compared to the rest of the list is the lowest
    		   swap(list, i, lowestValueIndex);//lets swap our working object with the lowest object.. rinse and repeat
    	}

    }

    public static <T extends Comparable<T> > void mergeSort(List<T> theList) {
        recursiveMergeSortHelper(theList, 0, theList.size() - 1);
    }

    /**
     * The merge sort is a more efficient way to sort list instead of a linear strategy
     * It splits a list into two seperate lists until the lists are at their base elements
     * It then merges each list from the bottom of the hierarchy upward from minimum to greatest. 
     * Once it pops all the methods from the stack the initial param List<T> theList is merged and sorted
     * 
     * @param theList
     * @param first
     * @param last
     */
    private static <T extends Comparable<T> > void recursiveMergeSortHelper(List<T> theList, int first, int last) {
    	if(first < last) {
    		
    		int middleIndex = (first+last)/2;
    		recursiveMergeSortHelper(theList, first, middleIndex);
    		recursiveMergeSortHelper(theList, middleIndex +1, last);
    		merge(theList, first, middleIndex, last);
    	}

    }

    /**
     * 
     * @param theList
     * @param l - left index
     * @param m - middle index
     * @param r - right index
     */
    private static <T extends Comparable<T> > void merge(List<T> arr, int l, int m, int r) {	
    	List<T> L =  new ArrayList<>();
    	List<T> R = new ArrayList<>();
    	
    	int n1 = m - l +1;//size of first array to be merged
    	int n2 = r - m;//size of second array to be merged
    	
    	/*Puts data in temp lists*/
        for (int i = 0; i < n1; ++i) 
            L.add(i, arr.get(l + i));
        for (int i2 = 0; i2 < n2; ++i2) 
            R.add(i2, arr.get(m + 1+ i2));
        
        /*Merge temp arrays*/
        
        //inital index of first and second subarrays
        int initialIndex = 0;
        int secInitIndex = 0;
        
        //inital index of merged subarry array
        int merInitIndex = l;
        
        while(initialIndex < n1 && secInitIndex < n2) {//Checks if there are values in either corresponding index
        	if(L.get(initialIndex).compareTo(R.get(secInitIndex)) <= 0) {//If L <= R
        		arr.set(merInitIndex, L.get(initialIndex));//set the merged list's working index to the left's value
        		initialIndex ++;
        	} else {
        		arr.set(merInitIndex, R.get(secInitIndex));//otherwise set the merged list's working index to the right's value
        		secInitIndex ++;
        	}
        	merInitIndex ++;
        }
        while(initialIndex < n1) {//If we got here we may have more objects in L
        	arr.set(merInitIndex, L.get(initialIndex));//lets fill our array with the leftovers
        	initialIndex ++;
        	merInitIndex ++;
        }
        while(secInitIndex < n2) {//If the latter is true then we need to do the same for R
        	arr.set(merInitIndex, R.get(secInitIndex));//lets fill the array with the leftovers
        	secInitIndex ++;
        	merInitIndex ++;
        }
	}

	public static <T extends Comparable<T> > int indexOf(T searchItem, List<T> theList) {

        return recursiveBinarySearcher(searchItem, theList, 0, theList.size()-1);

    }

    /**
     * Binary search splits the data in the middle, essentially efficiently performing a linear search. Uses Big O, or a sorted list.
     * If the list isnt sorted this method promises nothing.
     * @param searchItem
     * @param List<T> theList
     * @param first
     * @param last
     * @return index of searchItem in theList
     * @requires a sorted List
     */
    private static <T extends Comparable<T> > int recursiveBinarySearcher(T searchItem, List<T> theList, int first, int last) {
    	int middle;
    	boolean foundIndex = false;
    	while(!foundIndex) {
    		middle = (first + last) /2;
    		if(searchItem.compareTo(theList.get(middle)) == 0)//if the object is the middle index
    			return middle;
    		else if(searchItem.compareTo(theList.get(middle)) < 0) //if the object we are looking for is less than our middle
    			last = middle -1;//we set the highest index to our middle -1
    		else//if the object we are looking for is larger than our middle
    			first = middle +1;//we focus on the larger half of the dataset
    		if(first > last)//if at some point we overlap, the search ends
    			foundIndex = true;//if we get here the object does not exist
    	}
        return -1;

    }
}
