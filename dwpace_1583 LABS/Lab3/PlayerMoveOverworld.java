import java.util.Scanner;

public class PlayerMoveOverworld {
	private static int x, y;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = Integer.parseInt(input.nextLine());
		for (int i = 0; i < length; i++) {
			String coords = input.nextLine();
			Scanner scanner = new Scanner(coords);
			x = scanner.nextInt();
			y = scanner.nextInt();
			scanner.close();
			if (input.hasNextLine()) {
				scanner = new Scanner(input.nextLine());
				while (scanner.hasNext())
					handleMovement(scanner.next());
				scanner.close();
			}
			System.out.println("" + x + " " + y);
		}
		input.close();
	}

	private static void handleMovement(String entry) {
		switch (entry) {
		case "w":
			y--;
			break;
		case "a":
			x--;
			break;
		case "s":
			y++;
			break;
		case "d":
			x++;
			break;
		}
	}
}
