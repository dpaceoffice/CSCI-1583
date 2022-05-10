import java.util.Scanner;

public class StudentGrader {
	static float testA, labA, hw;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		testA = input.nextFloat();
		hw = input.nextFloat();
		labA = input.nextFloat();
		input.close();
		System.out.println(calculateTotal());
		
	}
	public static float calculateTotal() {
		testA *= 0.4f;//36
		hw *= 0.5f;//40
		labA *= 0.1f;//7
		return  testA + labA + hw;
	}
}
