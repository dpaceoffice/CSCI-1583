import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CartoonCharacterSerializer {
	
	//Create an ObjectOutputStream called "outputCartoon".
	public static ObjectOutputStream output;
	//Create an ObjectInputStream called "inputCartoon".
	public static ObjectInputStream input;
	//Create a PrintWriter called "writer".
	public static PrintWriter writer;
	
	public static void serializeCharacter(ArrayList<CartoonCharacter> characters) {
		try {
			output = new ObjectOutputStream(new FileOutputStream("characters.ser"));
			output.writeObject(characters);
			output.close();
			//Initialize a new ObjectOutputStream containing a FileOutputStream that sends your data to "cartoon.ser".
			//Call writeObject() on your ObjectOutputStream passing in your ArrayList of "characters".
			//Call close() on your ObjectOutputStream.
		} catch (IOException e) {
			System.out.println("An IOException was caught: " + e.getMessage());
		}
	}
	
	public static ArrayList<CartoonCharacter> deserializeCharacter() {
		ArrayList<CartoonCharacter> cartoons = null;
		//Create an ArrayList of CartoonCharacter objects called "cartoons" & set it to null.
		try {
			//Initialize your ObjectInputStream with a new FileInputStream that receives data from "cartoon.ser".
			input = new ObjectInputStream(new FileInputStream("characters.ser"));
			cartoons = (ArrayList<CartoonCharacter>) input.readObject();
			//Call readObject() on your ObjectInputStream, cast what it returns to an ArrayList 
			//of CartoonCharacter, and assign what it returns to your "cartoons" ArrayList.
		} catch (IOException e) {
			System.out.println("An IOException was caught: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("A ClassNotFoundException was caught: " + e.getMessage());
		}
		return cartoons;
	}
	
	public static void printToFile(String stringToFile) throws FileNotFoundException {
		//Initialize a new PrintWriter and pass in the file, "cartoon.txt", in which to send data.
		writer = new PrintWriter("cartoon.txt");
		//Call print() on your PrintWriter object and pass in the "stringToFile".
		writer.print(stringToFile);
		//Call close() on your PrintWriter.
		writer.close();
	}
}