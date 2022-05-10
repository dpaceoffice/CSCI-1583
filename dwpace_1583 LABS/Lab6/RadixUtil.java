import java.lang.Integer;

public class RadixUtil {
	public static int base2(String binary) {
		char[] binaryArray = binary.toCharArray();
		int output = 0;
		for(int decimal = 0; decimal < binaryArray.length; decimal++) {
			if(binaryArray[decimal] == '1') {
				output += Math.pow(2, binaryArray.length -(decimal +1));
			}
		}
		return output;
	}
	public static String base2(int decimal) {
		return Integer.toBinaryString(decimal);
	}
	public static int base8(String octal) {
		return Integer.valueOf(octal, 8);
	}
	public static String base8(int decimal) {
		return Integer.toOctalString(decimal);
	}
	public static int base16(String hexadecimal) {
		return Integer.valueOf(hexadecimal, 16);
	}
	public static String base16(int decimal) {
		return Integer.toHexString(decimal);
	}

}