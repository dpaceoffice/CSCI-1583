/**
* A class that models a Nation object with properties 
* such as its name, its national dish, its awesome-food-level (0 - 100) 
* based on that national dish, and its adjacent nations.
* 
* @author	David Pace
* @version	10/8/19
*/
import java.util.ArrayList;

//Our class IS-A Comparable, otherwise we cannot override the compareTo() method.
public class Nation implements Comparable {
	
	private String name;
	private String nationalDish;
	private int awesomeFoodLevel;
	private ArrayList<Nation> adjacentNations;
	
	public Nation(String name) {
		this.name = name;
		this.nationalDish = null;
		this.awesomeFoodLevel = 0;
		this.adjacentNations = new ArrayList<Nation>();
	}
	
	public void setNationalDish(String dish) {
		this.nationalDish = dish;
	}
	
	public void setAwesomeFoodLevel(int level) {
		this.awesomeFoodLevel = level;
	}
	
	public void addAdjacentNations(ArrayList<Nation> nations) {
		this.adjacentNations = nations;
	}
	
	public void addAdjacentNation(Nation nation) {
		this.adjacentNations.add(nation);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getNationalDish() {
		return this.nationalDish;
	}
	
	public int getAwesomeFoodLevel() {
		return this.awesomeFoodLevel;
	}
	
	public ArrayList<Nation> getAdjacentNations() {
		return this.adjacentNations;
	}
	
	//Override equals()
    //If the name, national dish, and awesome-food-level of this nation are equal to the name,
    //national dish, and awesome-food-level of some other nation (the nation we are comparing 
	//this nation to), return true--i.e., the nations are logically equal.
    //Otherwise, return false.
	@Override
	public boolean equals(Object object) {
		Nation nation = (Nation)object;
		return nation.getName().equals(name) && nationalDish.equals(nation.getNationalDish()) && (awesomeFoodLevel == nation.getAwesomeFoodLevel());
		//Provide implementation.
	}
	
	//Override hashCode() to return a constant, such as 0.
    //In certain conditions, if we call the .equals() method to compare two objects and
    //they do not return the same hashcode, then Java will not consider them equal, even
    //if the values of all their instance variables are the same.
	@Override
	public int hashCode() {
		return 0;
	}
	
	//Override compareTo() such that:
    //If the other nation (the Nation we are comparing this Nation to) has the same name,
    //compareTo() returns 0. If this nation's name comes before the other nation's name
    //alphabetically, return -1. If otherCountry's name comes first alphabetically,
    //return 1.
    //
    //Note that to compare Strings alphabetically, simply call compareTo() on a String.
    //The String class's compareTo() method is already implemented in such a way that
    //it will test for alphabetical ordering between two Strings when it is called.
    //For example, given string1 and string2, calling:
    //string1.compareTo(string2)
    //will compare string1 to string2. If the strings are the same, it will return 0.
    //If string1 comes before string2 alphabetically, it will return some negative number.
    //If string1 comes after string2 alphabetically, it will return some positive number.
	@Override
	public int compareTo(Object arg) {
		String otherNationName = ((Nation)arg).getName();
		return name.compareTo(otherNationName);
		//Provide implementation.
	}
	
	@Override
	public String toString() {
		String string = null;
		
		string = "" + this.name + "  " + this.nationalDish + "  " + this.awesomeFoodLevel
				+ System.lineSeparator() + "Nations adjacent to " + this.name + " are ";
				
		if (this.getAdjacentNations() != null) {
			for (int i = 0; i < this.getAdjacentNations().size(); i++) {
				string = string + this.getAdjacentNations().get(i).getName() + " ";
			}
		} else {
			string = string + "none";
		}
		return string + System.lineSeparator();
	}
}