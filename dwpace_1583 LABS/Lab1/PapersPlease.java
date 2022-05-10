import java.util.Scanner;

public class PapersPlease {
	private static boolean passPort, license, bc, allow;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		passPort = input.nextBoolean();
		license = input.nextBoolean();
		bc = input.nextBoolean();
		input.close();
		if(passPort)  
			allow = true;
		 else if(license && bc) 
			allow = true;
		 else
			allow = false;
		System.out.println(allow);
	}
}
