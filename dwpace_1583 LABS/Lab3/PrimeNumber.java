import java.util.Scanner;

public class PrimeNumber {


	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		int length = Integer.parseInt(input.nextLine());
		int number;
		for (int cases = 0; cases < length; cases++) {
			number = Integer.parseInt(input.nextLine());
			System.out.println(primeNumber(number));
		}
		input.close();
	}
	
	private static boolean primeNumber(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
