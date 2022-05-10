import static org.junit.Assert.*;
import org.junit.*;
/**
 * 
 * @author David Pace
 * @since 10/7/2019
 * @version 1
 */
public class JunitTester {

	@Test
	public void testComparableStrings() {
		String first = "abc";
		String second = "abcd";
		assertEquals(-1, HW4.compareTo(first, second));
		first = "abdd";
		second ="abk";
		assertEquals(1, HW4.compareTo(second, first));
		first = "abcdefghi";
		second = "abcdefghi";
		assertEquals(0, HW4.compareTo(second, first));
		first = "efsd";
		second = "aefsd";
		assertEquals(1, HW4.compareTo(first, second));
	}
	
	@Test
	public void testfindFirstString() {
		String[] string = {"abc", "abcd", "efg", "arfil", "makde"};
		assertEquals("abc", HW4.findMinimum(string));
		String[] string2 = {"makde", "arfil", "abcd", "abd", "abc"};
		assertEquals("abc", HW4.findMinimum(string2));
		String[] string3 = {"makde", "arfil", "abc", "abcd", "abd", "abcde", "makde"};
		assertEquals("abc", HW4.findMinimum(string3));
		String[] string4 = {"rtf", "rtf", "abc", "rtf", "rtf"};
		assertEquals("abc", HW4.findMinimum(string4));
	}

}
