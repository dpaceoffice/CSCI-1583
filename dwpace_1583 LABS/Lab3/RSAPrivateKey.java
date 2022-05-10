import java.util.Scanner;

public class RSAPrivateKey {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = Integer.parseInt(input.nextLine());
		for (int i = 0; i < length; i++) {
			String variables = input.nextLine();
			Scanner scanner = new Scanner(variables);
			long a = scanner.nextLong();
			long m = scanner.nextLong();
			int x = 1;
			while((a * x) % m != 1) {
			   x++;
			}
			System.out.println(x);
			scanner.close();
		}
		input.close();
	}

}
