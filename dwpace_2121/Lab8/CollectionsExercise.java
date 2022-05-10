/** 
* @author	YOUR NAME HERE
* @version	THE DATE HERE
*/
import java.util.*;

public class CollectionsExercise {
	
	private static HashMap<String, Nation> map = new HashMap<>();
	private static LinkedList<Nation> list = new LinkedList<Nation>();
	private static HashSet<Nation> set = new HashSet<>();
	//Nations that we are storing in our data structures.
	private static Nation nation1;
	private static Nation nation2;
	private static Nation nation3;
	private static Nation nation4;
	private static Nation nation5;
	private static Nation nation6;
	private static Nation nation7;
	
	public static void main(String[] args) {
		
		createNations();
		
		//Begin by implementing these three methods below.
		addNationsToList();
		addNationsToMap();
		addNationsToSet();
		
		//Now finish implementing the relevant portions of these methods.
		areNationsEqual();
		getContentsOfList();
		getContentsOfMap();
		getContentsOfSet();
		sortList();
	}
	
	public static void createNations() {
		//Initialize nations 1 - 6.
		nation1 = new Nation("United Kingdom");
		nation1.setAwesomeFoodLevel(75);
		nation1.setNationalDish("Blood Pudding");
		
		nation2 = new Nation("Canada");
		nation2.setAwesomeFoodLevel(52);
		nation2.setNationalDish("Poutine");
		
		nation3 = new Nation("Japan");
		nation3.setAwesomeFoodLevel(98);
		nation3.setNationalDish("Sushi");
		
		nation4 = new Nation("Ireland");
		nation4.setAwesomeFoodLevel(32);
		nation4.setNationalDish("Irish Stew");
		
		nation5 = new Nation("United States");
		nation5.setAwesomeFoodLevel(66);
		nation5.setNationalDish("Hamburger");
		
		nation6 = new Nation("China");
		nation6.setAwesomeFoodLevel(84);
		nation6.setNationalDish("Peking Duck");
		
		nation1.addAdjacentNation(nation2);
		nation1.addAdjacentNation(nation3);
		nation1.addAdjacentNation(nation4);
		nation1.addAdjacentNation(nation5);
		nation1.addAdjacentNation(nation6);
		nation2.addAdjacentNation(nation1);
		nation2.addAdjacentNation(nation3);
		nation2.addAdjacentNation(nation4);
		nation2.addAdjacentNation(nation5);
		nation2.addAdjacentNation(nation6);
		nation3.addAdjacentNation(nation1);
		nation3.addAdjacentNation(nation2);
		nation3.addAdjacentNation(nation4);
		nation3.addAdjacentNation(nation5);
		nation3.addAdjacentNation(nation6);
		nation4.addAdjacentNation(nation1);
		nation4.addAdjacentNation(nation2);
		nation4.addAdjacentNation(nation3);
		nation4.addAdjacentNation(nation5);
		nation4.addAdjacentNation(nation6);
		nation5.addAdjacentNation(nation1);
		nation5.addAdjacentNation(nation2);
		nation5.addAdjacentNation(nation3);
		nation5.addAdjacentNation(nation4);
		nation5.addAdjacentNation(nation6);
		nation6.addAdjacentNation(nation1);
		nation6.addAdjacentNation(nation2);
		nation6.addAdjacentNation(nation3);
		nation6.addAdjacentNation(nation4);
		nation6.addAdjacentNation(nation5);
		
		//Initialize nation7, which is logically equivalent to nation2.
		nation7 = new Nation("Canada");
		nation7.setAwesomeFoodLevel(52);
		nation7.setNationalDish("Poutine");
		nation7.addAdjacentNation(nation1);
		nation7.addAdjacentNation(nation3);
		nation7.addAdjacentNation(nation4);
		nation7.addAdjacentNation(nation5);
		nation7.addAdjacentNation(nation6);
	}
	
	public static void addNationsToList() {
		list.add(nation1);
		list.add(nation2);
		list.add(nation3);
		list.add(nation4);
		list.add(nation5);
		list.add(nation6);
		list.add(nation7);
		//Add nations 1-7 to our LinkedList named list.
		
	}
	
	public static void addNationsToMap() {
		map.put(nation1.getName(), nation1);
		map.put(nation2.getName(), nation2);
		map.put(nation3.getName(), nation3);
		map.put(nation4.getName(), nation4);
		map.put(nation5.getName(), nation5);
		map.put(nation6.getName(), nation6);
		map.put("Canada2", nation7);
		//Store nations 1-7 in our HashMap named map, using each nation's name
		//as the Key.
		//For nation7, use the String "Canada2" as the Key.

	}
	
	public static void addNationsToSet() {
		set.add(nation1);
		set.add(nation2);
		set.add(nation3);
		set.add(nation4);
		set.add(nation5);
		set.add(nation6);
		set.add(nation7);
		//Add nations 1-7 to our HashSet named set.
		
	}
	
	//Fill in the part of the statement labeled #TODO with "Canada2".
	//Our goal is to compare nation2 to nation7 by retrieving them from the map
	//and testing them for logical equivalence.
	//If we retrieve the correct entry from the map and our .equals() and .hashcode()
	//methods have been overriden correctly, "The nations are equal." should print out.
	public static void areNationsEqual() {
		System.out.println("\nAre nations 2 and 7 in our map equal?\n");
		
		if (map.get(nation2.getName()).equals(map.get(nation7.getName()))) {
			System.out.println("The nations are equal." + System.lineSeparator());
		} else {
			System.out.println("The nations are not equal." + System.lineSeparator());
		}
	}
	
	//Return an object of type ListIterator<Nation> and store it in a variable
	//named "iterator" by calling the appropriate method on our LinkedList.
	//Call the appropriate method on our ListIterator named iterator to check if our iterator
	//has a next item that it can iterate through. In the while loop, assign each next element 
	//in the list to the variable "nation".
	public static void getContentsOfList() {
		ListIterator<Nation> iterator = list.listIterator();
		
		System.out.println("Contents of List: \n");
		while (iterator.hasNext()) {
			Nation nation = iterator.next();
			System.out.println(nation);
		}
	}
	
	public static void getContentsOfMap() {
		
		System.out.println("Contents of Map: \n" + map);
		System.out.println();
	}
	
	public static void getContentsOfSet() {
		System.out.println("\nContents of Set: \n");
		//If hashcode() is not overwritten, then this should print out 7 entries instead of 6.
		for (Nation nation : set) {
			System.out.println(nation);
		}
	}
	
	//The Collections.sort() method sorts the items in a data structure according
	//to the order specified in the compareTo() method.
	//If our compareTo() method was implemented properly, the list should sort the
	//countries by alphabetical order of each nation's name.
	//Note, unlike Sets, Lists DO contain duplicates.
	public static void sortList() {
		Collections.sort(list);
		
		System.out.println("Contents of sorted List: \n");
		
		for (Nation nation : list) {
			System.out.println(nation);
		}
	}
	
}