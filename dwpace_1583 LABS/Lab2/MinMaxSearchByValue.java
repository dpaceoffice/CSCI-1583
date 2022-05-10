import java.util.Scanner;

public class MinMaxSearchByValue {


public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int length = Integer.parseInt(input.nextLine());
	for(int i = 0; i < length; i++) {
		String seq = input.nextLine();
		Scanner reader = new Scanner(seq);
		int min = reader.nextInt();
		int max = min;
		//System.out.println(""+Integer.parseInt(seq));
		while(reader.hasNextInt()) {
			int nextNumber = reader.nextInt();
			if(nextNumber > max)
				max = nextNumber;
			if(nextNumber < min)
				min = nextNumber;
		}
		System.out.printf("%s\n%d\n%d\n\n", seq, min, max);

	}

}

}