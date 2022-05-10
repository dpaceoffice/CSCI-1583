

/**
 * 
 * @author David Pace
 * @since 10/7/19
 * @version 1
 */
public class HW4 {

	/**
	 * Overloaded compareTo method
	 * 
	 * @param s1 string one
	 * @param s2 string two
	 * @return int -1 if first string comes first alphabetically, 0 if the strings
	 *         are the same, 1 if the second string comes first alphabetically
	 * 
	 */
	public static int compareTo(String s1, String s2) {
		return compareTo(s1, s2, 0);
	}

	/**
	 * 
	 * @param s1       string one
	 * @param s2       string two
	 * @param compared index
	 * @return int -1 if first string comes first alphabetically, 0 if the strings
	 *         are the same, 1 if the second string comes first alphabetically
	 * 
	 */
	public static int compareTo(String s1, String s2, int index) {
		boolean sameLength = s1.length() == s2.length();
		if (s1.length() - 1 >= index && s2.length() - 1 >= index) {
			if (s1.charAt(index) == s2.charAt(index))
				return compareTo(s1, s2, index + 1);
			else
				return s1.charAt(index) < s2.charAt(index) ? -1 : 1;
		} else
			return sameLength ? 0 : s1.length() < s2.length() ? -1 : 1;
	}

	/**
	 * Overloaded findMinimum function, starts at first index
	 * 
	 * @param stringArray
	 * @return String - first string in alphabetical order.
	 */
	public static String findMinimum(String[] stringArray) {
		String min = findMinimum(stringArray, stringArray[0], 0);
		return min;

	}

	/**
	 * @param strings
	 * @param currentMin the starting minimum string
	 * @param index the current working index
	 * @return String - first string in alphabetical order
	 */
	public static String findMinimum(String[] strings, String currentMin, int index) {
		String min = currentMin;
		if ((strings.length - 1) >= index + 1) {
			if (compareTo(min, strings[index + 1]) > 0) {
				min = strings[index + 1];
				return findMinimum(strings, min, index + 1);
			} else if (compareTo(min, strings[index + 1]) <= 0)
				return findMinimum(strings, min, index + 1);
		}
		return min;
	}

}
