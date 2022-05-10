import java.util.Scanner;

public class RSAPublicKey {
	private static long p;// must be prime
	private static long q;// must be prime
	private static long n;// p*q only if two seed numbers and e are valid
	private static long e;// e is a coprime number not a divisor of n

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = Integer.parseInt(input.nextLine());
		for (int i = 0; i < length; i++) {
			String variables = input.nextLine();
			Scanner scanner = new Scanner(variables);
			p = scanner.nextInt();
			q = scanner.nextInt();
			e = scanner.nextInt();
			handleCheck();
			scanner.close();
		}

		input.close();

	}

	private static void handleCheck() {
		if (primeNumber(p) && primeNumber(q)) {
			n = p * q;
			long totient = (p-1) * (q-1);
			if (e % n != 0 && e > 1 && e < totient)
				System.out.println("RSA Public Key: n=" + n + " e=" + e);
			else
				System.out.println("Invalid e for RSA Key!");
		} else
			System.out.println("Invalid n for RSA Key!");
	}
	

	private static boolean primeNumber(long number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
