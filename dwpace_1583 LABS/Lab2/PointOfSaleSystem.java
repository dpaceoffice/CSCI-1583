import java.text.DecimalFormat;
import java.util.Scanner;

public class PointOfSaleSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int length = Integer.parseInt(input.nextLine());
		int itemNumber[] = new int[length];
		float prices[] = { 1.50f, 1.75f, 2.50f, 2.75f, 0.99f, 1.25f };
		float total = 0.0f;

		String readLine = input.nextLine();
		Scanner menuItems = new Scanner(readLine);

		for (int i = 0; i < length; i++) {
			int menuItem = menuItems.nextInt();
			itemNumber[i] = menuItem;
		}
		menuItems.close();
		for (int i = 0; i < length; i++) {
			total += prices[itemNumber[i] - 1];
		}
		input.close();

		total += (total * .065f);
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("Please pay $" + df.format(total));
		System.out.println("Thank you for eating at McDowell's!");
	}
}