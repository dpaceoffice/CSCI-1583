import java.util.Scanner;

public class LogIt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i = 0; i < cases; i++) {
			int max_numbers = input.nextInt();
			System.out.println(calculateLog2(max_numbers));
		}
	}

	public static int calculateLog2(int max) {
		double log2 = Math.log(max) / Math.log(2);
		int max_tries = (int) Math.ceil(log2);
		return max_tries;
	}

}
