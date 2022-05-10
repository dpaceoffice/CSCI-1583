
/**
* Lab 1: A class that tests Fraction.java
*
* @author	Christian Roos
* @version 	August 26th, 2019
* @motifiedBy David Pace
*
*/
import org.junit.*;

public class PartialFractionTest {
	
	//Declare any variables?
	Fraction f1,f2,f3,f4,f5;



	@Before
	public void setUp() {
		f1 = new Fraction(1,2);
		f2 = new Fraction(6,3);
		f3 = new Fraction(10,5);
		f4 = new Fraction(0,5);
	}
	
	@Test
	public void constructorExceptionTest() {
		try {
	          f5 = new Fraction(0,0);
	          Assert.fail();
	     } catch(ArithmeticException e) {
	          System.out.println(e);
	     }
	}
	
	@Test
	public void testGetNumerator() {
		Assert.assertEquals(f1.getNumerator(), 1, 0);
		Assert.assertEquals(f2.getNumerator(), 6, 0);
		Assert.assertEquals(f3.getNumerator(), 10, 0);
	}
	
	@Test
	public void testGetDenominator() {
		Assert.assertEquals(f1.getDenominator(), 2, 0);
		Assert.assertEquals(f2.getDenominator(), 3, 0);
		Assert.assertEquals(f3.getDenominator(), 5, 0);
	}
	
	@Test
	public void testAdd() {
		String result1 = f1.add(f1).toString();
		Assert.assertEquals("(1/1)", result1);	
	}
	
	@Test
	public void testSubtract() {
		String result1 = f1.subtract(f2).toString();
		Assert.assertEquals("(-3/2)", result1);	
		
	}
	
	@Test
	public void testMultiply() {
		String result1 = f3.subtract(f2).toString();
		Assert.assertEquals("(0/15)", result1);	
		
	}
	
	@Test
	public void testDivisionByZero() {
	     try {
	          f1.divide(f4);
	          Assert.fail();
	     } catch(ArithmeticException e) {
	          System.out.println(e);
	     }
	}
	
	@Test
	public void testDivide() {
		String result1 = f1.divide(f1).toString();
		Assert.assertEquals("(1/1)", result1);	
		
	}
	
	@Test
	public void testToString() {
		String result1 = f1.toString();
		Assert.assertEquals("(1/2)", result1);	
	}
	
	@Test
	public void testSimplify() {
		String result1 = f3.simplify().toString();
		Assert.assertEquals("(2/1)", result1);	
		
	}
	
	@Test
	public void testGCF() {
		int result1 = f3.gCF(2, 4);
		Assert.assertEquals(2, result1);	
		
	}
}//End class FractionTest.
