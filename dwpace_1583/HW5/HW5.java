import java.util.Scanner;

public class HW5 {
	private static String roomDescriptions[] = { "You are in the guest bedroom. It smells musty. Exits are north and east.",
			"You are in South Hall, you see a room to your north, east, and west",
			"You are in the Dining Room, exits are north and west.",
			"You are in the Master Bedroom, exits are east and south",
			"You are in the North Hall exits are north, east, west, and south",
			"You are in the kitchen, exits are west and south", "You are on the Balcony, Exits are south." };
	private static int exits[][] = { { 3, 1, -1, -1 }, { 4, 2, 0, -1 }, { 5, -1, 1, -1 }, { -1, 4, -1, 0 }, { 6, 5, 3, 1 },
			{ -1, -1, 4, 2 }, { -1, -1, -1, 4 } };

	private static int currentRoom = 0;
	private static int NUMBER_OF_ROOMS = 7;
	private static int NORTH = 0;
	private static int EAST = 1;
	private static int WEST = 2;
	private static int SOUTH = 3;
	
	public static void main(String[] args) {
		sendDescription();
		sendPrompt();
	}

	private static void sendPrompt() {
		
		System.out.println(
				"Select a direction to go:\n N : go to the north \n S : to go south \n W : to go west \n E : to go east \n Q : to quit the game");
		handleInput();
	}

	private static void handleInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.toLowerCase().contains("n")) {
			moveSelection(NORTH);
		} else if (input.toLowerCase().contains("s")) {
			moveSelection(SOUTH);
		} else if (input.toLowerCase().contains("w")) {
			moveSelection(WEST);
		} else if (input.toLowerCase().contains("e")) {
			moveSelection(EAST);
		} else if (input.toLowerCase().contains("q")) {
			System.exit(0);
		} else {
			System.out.println("Invalid input, try again! Use : N, E, W, S, Q");
			handleInput();
		}
		scanner.close();

	}

	private static void sendDescription() {
		System.out.println(roomDescriptions[currentRoom]);
	}

	private static void moveSelection(int direction) {
		if (exits[currentRoom][direction] == -1) {
			System.out.println("There is not a room in that direction, try again.");
			handleInput();
			return;
		}
		currentRoom = exits[currentRoom][direction];
		sendDescription();
		sendPrompt();
	}

}
