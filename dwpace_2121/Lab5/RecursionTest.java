import org.junit.*;

public class RecursionTest {

	@Test
	public void testFibonacci() {
		int expected = 1;
		int actual = Recursion.fibonacci(1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFactorial() {
		int expected = 120;
		int actual = Recursion.factorial(5);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testStringIterator() {
		char expected = 'b';
		Assert.assertEquals(expected, Recursion.stringIterator("bite me", 'b'));
	}
}