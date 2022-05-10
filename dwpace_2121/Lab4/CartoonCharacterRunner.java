/**
* A class that runs CartoonCharacterSerializer by creating an
* ArrayList of cartoon characters, serializes it & sends it to
* an serialized file, deserializes the file & receives the 
* ArrayList back in its original structured form.
*
* @author	Christian Roos
* @version	September 9th, 2019
*/
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CartoonCharacterRunner {

	public static void main(String[] args) throws FileNotFoundException {
		//Declare and initialize at least three CartoonCharacter objects.
		CartoonCharacter char1 = new CartoonCharacter("Bob", 20, "Trump is great");
		CartoonCharacter char2 = new CartoonCharacter("Joe", 90, "Trump sucks");
		CartoonCharacter char3 = new CartoonCharacter("Trump", 6, "BUILD THE WALL");
		//Create an ArrayList of CartoonCharacter objects called "cartoons" & set it to null.
		ArrayList<CartoonCharacter> list = new ArrayList<CartoonCharacter>();

		//Declare and initialize an ArrayList of type <CartoonCharacter> named "characters".
		//Add your cartoon characters to your ArrayList.
		list.add(char1);
		list.add(char2);
		list.add(char3);
		
		//Call static method serializeCharacter() and pass in your ArrayList as the argument.
		System.out.println("\nCharacters have been serialized.");

		CartoonCharacterSerializer.serializeCharacter(list);
		
		//Reset your ArrayList to "null" after you serialize the ArrayList in the preceding step.
		list = null;

		//Call static method deserializeCharacter() and assign its result to your ArrayList.
		list = CartoonCharacterSerializer.deserializeCharacter();
		System.out.println("\nArrayList of characters has been deserialized.");
		System.out.println(list);
		
		String taglines = "";
		
		for (int i = 0; i < list.size(); i++) {
			taglines = taglines + list.get(i).getTagline() + "\n\n";
		}
		CartoonCharacterSerializer.printToFile(taglines);
		//Call static method printToFile() and pass in "taglines" as the argument.
	}
}