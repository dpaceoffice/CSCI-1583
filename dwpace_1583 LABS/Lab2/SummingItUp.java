import java.util.Scanner;

public class SummingItUp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = Integer.parseInt(input.nextLine());// no clue why this is needed.
		String scanLine;
		
		for (int i = 0; i < length; i++)  {
			scanLine = input.nextLine();
			
			Scanner numberGraber = new Scanner(scanLine);
			int output = 0;
			int from = numberGraber.nextInt();
			int to = numberGraber.nextInt();
			if (from >= to) {
				while (from >= to) {
					output += from;
					from--;
					// System.out.println(from + " " + output);
				}
			} else
				while (from <= to) {
					output += from;
					from++;
				}
			System.out.println(output);
			numberGraber.close();
		}
		input.close();
	}

}
