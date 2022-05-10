
/**
* Lab 1: A class that models a Fraction where a 
* Fraction object can perform basic arithmetic
* operations.
*
* @author 	Christian Roos
* @version  August 24th, 2019
*/
import java.lang.ArithmeticException;


public class Fraction
{
	private int numerator;
	private int denominator;
	
	/**
	* Contructor for Fraction
	* 
	* 
	*/
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		if(denominator == 0) {
		   throw new ArithmeticException("Undefined");
		} else {
		   this.denominator = denominator;
		}	
	}
	
	/**
	* Gets the numerator of this Fraction.
	* 
	* @return 	int 	numerator
	*/
	public int getNumerator() {
		return this.numerator;
	}
	
	/**
	* Gets the denominator of this Fraction.
	* 
	* @return 	int 	denominator
	*/
	public int getDenominator() {
		return this.denominator;
	}
	
	/**
	* Adds two fractions together
	* @return Fraction type of added fractions
	* @param Fraction the other fraction
	* 
	*/
	public Fraction add(Fraction otherFraction) {
		int productNum = this.numerator * otherFraction.getDenominator() + (otherFraction.getNumerator() * this.denominator);
		int productDenom = this.denominator * otherFraction.getDenominator();
		return new Fraction(productNum, productDenom).simplify();
	}
	
	/**
	* Adds two fractions together
	* @return Fraction type of subtracted fractions
	* @param Fraction the other fraction
	* 
	*/
	public Fraction subtract(Fraction otherFraction) {
		int productNum = this.numerator * otherFraction.getDenominator() - (otherFraction.getNumerator() * this.denominator);
		int productDenom = this.denominator * otherFraction.getDenominator();
		return new Fraction(productNum, productDenom).simplify();
		
	}
	
	/**
	* Adds two fractions together
	* @return Fraction type of multiplied fractions
	* @param Fraction the other fraction
	* 
	*/
	public Fraction multiply(Fraction otherFraction) {
		int productNum = this.numerator * otherFraction.numerator;
		int productDenom = this.denominator * otherFraction.denominator;
		Fraction product = new Fraction(productNum, productDenom);
		return product.simplify();
		
	}
	
	/**
	* Provide Javadoc.
	* <p>Divides this fraction by other fraction</p>
	* @param Fraction provide the other fraction to divide by
	* @return Fraction
	* @throws ArithmeticException "Divide by 0"
	* @custom.require The divisor fraction cannot have zero
	*
	*/
	public Fraction divide(Fraction otherFraction) {
		if(otherFraction.numerator == 0) {
			throw new ArithmeticException("Numerator is 0");
		} else {
			Fraction inverse = new Fraction(otherFraction.denominator, otherFraction.numerator);
			Fraction quotient = this.multiply(inverse).simplify();
			return quotient;
		}
		//Provide implementation.
		
	}
	
	/**
	* 
	* @return String that has the denominator in this format (num/denom)
	* 
	* 
	*/
	@Override
	public String toString() {
	return "("+this.numerator+"/"+this.denominator+")";
		
	}
	
	/**
	* Simplifies the passed in Fraction
	* by calling the gCF helper method.
	*  
	* @custom.require	The numerator not be zero.
	* @return	int		gCF
	*/
	public Fraction simplify() {
		int factor = Math.abs(gCF(this.numerator, this.denominator));
		
		if (this.numerator == 0) {
			Fraction alreadySimplified = new Fraction(this.numerator, this.denominator);
			return alreadySimplified;
		} else {
			Fraction simplified = new Fraction(this.numerator / factor, this.denominator / factor);
			System.out.println("Simplified Fraction: " + simplified);
			return simplified;
		}
	}
	
	/**
	* Determines the greatest common factor  
	* between two numbers.
	*
	* @param	int		a 
	* @param	int 	b 
	* @return	int		gCF
	*/
	public int gCF(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gCF(b, a % b);
		}
	}
}//End class Fraction.
