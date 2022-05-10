/**
* A class that models a cartoon character.
*
* @author 	Christian Roos
* @version	September 9th, 2019
*/
import java.io.Serializable;

public class CartoonCharacter implements Serializable {

	private String name;
	private int age;
	private String tagline;

	public CartoonCharacter(String name, int age, String tagline) {
		this.name = name;
		this.age = age;
		this.tagline = tagline;
	}
	
	/**
	* Gets the cartoon character's name.
	*
	* @return	String		The name of the character.
	*/
	public String getName() {
		return this.name;
	}

	/**
	* Sets the cartoon character's name.
	*
	* @param	String		The name of the character.
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Gets the cartoon character's age.
	*
	* @return	int		The age of the character.
	*/
	public int getAge() {
		return this.age;
	}

	/**
	* Sets the cartoon character's age.
	*
	* @param	int		The age of the character.
	*/
	public void setAge(int age) {
		this.age = age;
	}

	/**
	* Gets the cartoon character's tagline.
	*
	* @return	String		The character's tagline.
	*/
	public String getTagline() {
		return this.tagline;
	}

	/**
	* Sets the cartoon character's age.
	*
	* @param	String		The character's tagline.
	*/
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	
	/**
	* Returns a String representation of a character.
	*
	* @return	String		A String rep. of the character.
	*/
	@Override
	public String toString() {
		return "\nName: " + this.name + "\nAge: " + this.age + "\nTagline: " + this.tagline;
	}
}