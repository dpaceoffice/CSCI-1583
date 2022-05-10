import java.util.Scanner;

public class ChairScavenging {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = Integer.parseInt(input.nextLine());
		for(int i = 0; i < length; i++) {
			Scanner readline = new Scanner(input.nextLine());
			int amountOfStudents = readline.nextInt();
			int totalChairs = readline.nextInt();
			int chairsNeeded = (amountOfStudents <= totalChairs) ? 0 : (amountOfStudents - totalChairs);
			System.out.println(chairsNeeded);
			readline.close();
		}
		input.close();
	}
}
