import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VirtualPet {

	public static enum Stages {
		NEWBORN, GAMEOPTIONS, DIRESITUATIONS, ATEWALLET
	};

	private static int MULTIPLIER = 4;
	private static final int MAX_VALUE = 10;
	private static final int WARNING_VALUE = 4;
	private static final double NEED_STARTING_CONSTANT = 1.0;
	private static final int RACOONDOGIMG = 0, DEBTCOLLECTOR = 1, BATH = 2, RUN = 3;
	private static int age;
	private static String name;
	private static double hunger;
	private static double boredom;
	private static double dirtiness;
	private static ArrayList<String[]> highScores = new ArrayList<String[]>();
	private static StageHandler stageHandler;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		handleDialogue(0);
	}

	private static void sendArt(int image) {
		if (image == RACOONDOGIMG) {
			String[] dialogue = { " ...\r\n" + "  .\":.   .:\"\"   \"\".\r\n" + " :    :.:    .     \"'.<\"\"\"\">\r\n"
					+ "       :   ..:   .:..<(=)(=)>\r\n" + "       :..')) ; .').  )/~\\(\r\n"
					+ "       ')))   )))      \\U/ " };
			appendMessages(dialogue);
		} else if (image == DEBTCOLLECTOR) {
			String[] dialogue = { "                                                  _____\r\n"
					+ "                                            ,.-'''     '-.\r\n"
					+ "                                          ,'     _        '-\r\n"
					+ "                                        ,'     -'           \\\r\n"
					+ "                                       /                     \\\r\n"
					+ "                                       '                      |\r\n"
					+ "             _                        |              ..       \\\r\n"
					+ "           _(C)                       /                        |\r\n"
					+ "         ,'_   `.                     |       -''-.__        _'\r\n"
					+ "        '(o `    `.                   /            __',,--:,-'\r\n"
					+ "      ,'      .    `._.--....._      |      __.--''  '\r\n"
					+ "     @<<       ;               '-.   |     /'\r\n"
					+ "      |/------'     .              `\\|    ,'\r\n"
					+ "___________ ,`; ,'   ;                    | ____________________\r\n"
					+ "           /'  ;   ,'        ,-         _,'\r\n" + "         ,'  ,'  ,'        .'          |\r\n"
					+ "  _.(._,' _,'  ,' `._    .'            /\r\n" + " ((_O)))''_, -'      `-..'           ,'\r\n"
					+ "  |   |//'              M         ,''\r\n" + "   `-'                   J.     ,'\r\n"
					+ "                  ,------'P     /\r\n" + "                 ((.__________.'" };
			appendMessages(dialogue);
		} else if (image == BATH) {
			String[] dialogue = { "	__   _\r\n" + "		      _(  )_( )_\r\n" + "		     (_   _    _)\r\n"
					+ "		    / /(_) (__)\r\n" + "		   / / / / / /\r\n" + "		  / / / / / /" };
			appendMessages(dialogue);

		} else if (image == RUN) {
			String[] dialogue = { "            _\r\n" + "          _( }\r\n" + "-=   _  <<  \\\r\n"
					+ "    `.\\__/`/\\\\\r\n" + "-=      '--'\\\\  `\r\n" + "   -=     //\r\n" + "           \\)" };
			appendMessages(dialogue);
		}
	}

	private static void init() {
		stageHandler = new StageHandler(Stages.NEWBORN);
		hunger = NEED_STARTING_CONSTANT;
		boredom = NEED_STARTING_CONSTANT;
		dirtiness = NEED_STARTING_CONSTANT;
		MULTIPLIER = 1;
		age = 1;
	}

	private static void appendMessages(String[] dialogue) {
		appendMessages(dialogue, true);
	}

	private static void appendMessages(String[] dialogue, boolean showStars) {
		if (showStars)
			System.out.println("*****************************************");
		for (String text : dialogue) {
			System.out.println(text);
		}
	}

	private static void handleDialogue(int delay) {
		if (hunger > MAX_VALUE || boredom > MAX_VALUE || dirtiness > MAX_VALUE) {
			runAway();
			return;
		}
		handleDialogue(delay, stageHandler.getStep());
	}

	private static void handleDialogue(int delay, int step) {
		while (delay != 0) {
			delay--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			continue;
		}
		if (stageHandler.getStage() == Stages.NEWBORN) {
			String[] dialogue = { "You stumble upon a rabid raccoon dog.", "1. Pet it", "2. Bring it home",
					"3. Kick him to the curb" };
			appendMessages(dialogue);
		} else if (stageHandler.getStage() == Stages.GAMEOPTIONS) {
			String[] dialogue = { "Your pet is " + age + " day old!", "1. Check stats", "2. Feed Pet",
					"3. Play with Pet", "4. Give a bath" };
			appendMessages(dialogue);
		} else if (stageHandler.getStage() == Stages.DIRESITUATIONS) {
			String[] dialogue = { "1. Pay his Debt", "2. Tell him to beat it", "3. Show him where " + name + " is." };
			appendMessages(dialogue, false);

		} else if (stageHandler.getStage() == Stages.ATEWALLET) {
			if (step == 0) {
				String[] dialogue = {
						"While you look around for " + name
								+ " you notice your wallet has a huge bite taken out of it,",
						" and all the cash that was inside is now gone.", "1. Throw a rampage and find " + name + "",
						"2. Go to the bank and get more money." };
				appendMessages(dialogue, false);
			} else if (step == 2) {
				String[] dialogue = { "After stomping your feet and throwing a hissy fit, you find " + name + ".",
						"He's sleeping on a pile of your cash.", "1. Grab cash", "2. Lecture " + name + "",
						"3. Walk away, he looks peaceful" };
				appendMessages(dialogue, false);
			}
		}
		stageHandler.grabInput();
	}

	private static boolean checkPet() {
		String status[] = { "" + name + "'s, stomach is growling!", "" + name + " looks bored to death.",
				"" + name + " is starting to stink!", "He ran away... *RESTART*",
				"" + name + " looks like he's in great shape!" };
		System.out.println("Hunger:" + (int) (hunger * 10) + "%");
		System.out.println("Boredom:" + (int) (boredom * 10) + "%");
		System.out.println("Dirtiness:" + (int) (dirtiness * 10) + "%");
		if (hunger > MAX_VALUE || boredom > MAX_VALUE || dirtiness > MAX_VALUE) {
			System.out.println(status[3]);
			return false;
		}
		if (hunger >= WARNING_VALUE) {
			System.out.println(status[0]);
		}
		if (boredom >= WARNING_VALUE) {
			System.out.println(status[1]);
		}
		if (dirtiness >= WARNING_VALUE) {
			System.out.println(status[2]);
		}
		if (hunger <= WARNING_VALUE && boredom <= WARNING_VALUE && dirtiness <= WARNING_VALUE) {
			System.out.println(status[4]);
		}
		handleDialogue(3);
		return true;
	}

	public static void feedPet() {
		if (!process())
			return;
		Random rand = new Random();
		int n = rand.nextInt(2);// max 0-1
		if (n == 0) {
			String[] dialogue = { "When run into your kitchen to find something for " + name + ", but ",
					"The entire kitchen is ran through by some mutt.", "Oh wait! " + name + " get out of here!" };
			appendMessages(dialogue);
			hunger -= 0.2 * MULTIPLIER;
			dirtiness += 0.2 * MULTIPLIER;
			handleDialogue(3);
		} else {
			String[] dialogue = {
					"You walk around for a bit, and find some nice old socks out the hamper for " + name + "" };
			appendMessages(dialogue);
			hunger -= 0.3 * MULTIPLIER;
			handleDialogue(3);
		}
	}

	public static void playWithPet() {
		if (!process())
			return;
		Random rand = new Random();
		int n = rand.nextInt(2);
		if (n == 0) {
			String[] dialogue = { "*Throws couch at " + name + "*", "Looks like that wore him out." };
			appendMessages(dialogue);
			boredom -= 0.2 * MULTIPLIER;
			hunger += 0.5 * MULTIPLIER;
			handleDialogue(3);
		} else {
			String[] dialogue = { "You play tug of war over your iphone headphones with " + name + "." };
			appendMessages(dialogue);
			boredom -= 0.2 * MULTIPLIER;
			handleDialogue(3);
		}
	}

	public static void bathePet() {
		if (!process())
			return;
		Random rand = new Random();
		int n = rand.nextInt(2);
		if (n == 0) {
			sendArt(BATH);
			String[] dialogue = { "You give " + name + " a bath. He rather Enjoys it." };
			appendMessages(dialogue);
			dirtiness -= 0.3 * MULTIPLIER;
			boredom += 0.3 * MULTIPLIER;
			handleDialogue(3);
		} else {
			sendArt(DEBTCOLLECTOR);
			stageHandler.changeStage(Stages.DIRESITUATIONS);
			String[] dialogue = {
					"Things go horribly.. horribly wrong. As you run the water to bathe " + name
							+ ", another weirder looking raccoon dog",
					"climbs through a window; He is trying to collect debt from " + name + "" };
			appendMessages(dialogue);
			handleDialogue(0);
		}
	}

	public static void randomEvent() {
		stageHandler.changeStage(Stages.ATEWALLET);
		stageHandler.setStep(0);
		handleDialogue(0);
	}

	public static void runAway() {
		sendArt(RUN);
		String[] dialogue = { "Hey! " + name + "! Why are you running!",
				"Dang.. I guess that means this one's gone too.", "Oh well. Time to add another to the list." };
		appendMessages(dialogue);
		handleScores(true);
		init();
		handleDialogue(6);
		sendArt(RACOONDOGIMG);

	}

	public static void handleScores(boolean print) {
		String[] scores = { "" + (highScores.size() + 1) + ". " + name + " - survived days: " + age + "" };
		highScores.add(scores);
		for (int i = 0; i < highScores.size(); i++) {
			String[] listing = highScores.get(i);
			appendMessages(listing, false);
		}

	}

	public static boolean process() {
		age++;
		hunger += (double) 0.1 * MULTIPLIER;
		dirtiness += (double) 0.1 * MULTIPLIER;
		boredom += (double) 0.1 * MULTIPLIER;
		if (hunger > MAX_VALUE || boredom > MAX_VALUE || dirtiness > MAX_VALUE) {
			runAway();
			return false;
		}
		Random rand = new Random();
		int n = rand.nextInt(4);
		if (n == 0) {// 25% chance of happening per day.
			randomEvent();
			return false;
		}
		return true;
	}

	static class StageHandler {

		Stages stage;
		int step;

		public StageHandler(Stages stage) {
			this.stage = stage;
			this.step = 0;
		}

		public Stages getStage() {
			return stage;
		}

		public int getStep() {
			return step;
		}

		public int setStep(int step) {
			return this.step = step;
		}

		public void changeStage(Stages stage) {
			this.stage = stage;
		}

		public void handleMessageOptions(String input) {
			if(input.contains("kill")) {
				runAway();
			} else if (input.contains("1")) {
				processSelection(1);
			} else if (input.contains("2")) {
				processSelection(2);
			} else if (input.contains("3")) {
				processSelection(3);
			} else if (input.contains("4")) {
				processSelection(4);
			} else {
				System.out.println("Please select an answer ex: 1, 2, 3");
				grabInput();
			}
		}

		public String grabInput() {
			return grabInput(true);
		}

		public String grabInput(boolean handleInput) {
			int entries = 0;
			String line = "";
			while (scanner.hasNext()) {
				if (entries >= 1) {
					scanner.nextLine();
					continue;
				}
				line = scanner.nextLine();
				entries++;
				if (handleInput)
					handleMessageOptions(line);
				return line;
			}
			return line;
		}

		public void processSelection(int section) {
			if (stage == Stages.NEWBORN) {
				String[] dialogue = { "You tried to get near this thing and it nearly bites your head off.",
						"That must mean it likes you!", "Well, time to name it and bring it home!",
						"-Type in a name below-" };
				appendMessages(dialogue);
				name = grabInput(false);// not handling input here, its just the name.
				System.out.println("" + name + " sounds like a good name.");
				changeStage(Stages.GAMEOPTIONS);
				handleDialogue(3);
			} else if (stage == Stages.GAMEOPTIONS) {
				if (section == 1) {
					checkPet();
				} else if (section == 2) {
					feedPet();
				} else if (section == 3) {
					playWithPet();
				} else if (section == 4) {
					bathePet();
				}
			} else if (stage == Stages.DIRESITUATIONS) {
				if (section == 1) {
					System.out.println("You pay his debt and all is well. Now for " + name + "'s bath.");
					dirtiness -= 0.3 * MULTIPLIER;
				} else if (section == 2) {
					System.out.println(
							"You confront the raccoon just to get jumped by him and his gang. Things are going to be a lot tougher.");
					MULTIPLIER++;
				} else if (section == 3) {
					System.out.println(
							"You escort the forign raccoon to " + name + " and a heated argument starts between them.");
					System.out.println("" + name + " runs his pockets and gives a couple accorns to the other.");
					System.out.println("" + name + " looks at you, and then knaws your leg off.");
					MULTIPLIER++;
				} else {
					System.out.println("There are only three avaliable options. Try again.");
					handleDialogue(3);
					return;
				}
				changeStage(Stages.GAMEOPTIONS);
				handleDialogue(3);
			} else if (stage == Stages.ATEWALLET) {
				if (stageHandler.getStep() == 0) {
					if (section == 1) {
						// rampage and find pet
						stageHandler.setStep(2);
						handleDialogue(0, stageHandler.getStep());
					} else if (section == 2) {
						String[] dialogue = { "You run to the bank and grab all your cash.",
								"The missing cash in your wallet is going to make it",
								"difficult to take care of " + name + "" };
						appendMessages(dialogue);
						MULTIPLIER += 2;
						stageHandler.changeStage(Stages.GAMEOPTIONS);
						handleDialogue(4);
					}
				} else if (stageHandler.getStep() == 2) {
					if (section == 1) {
						// grab cash
						System.out.println("You attempt to get your money back..");
						Random rand = new Random();
						int n = rand.nextInt(2);
						if (n == 0) {
							System.out.println("...and fail - " + name + " wakes up and shreds everything to pieces.");
							MULTIPLIER += 2 * MULTIPLIER;
							boredom -= 0.5 * MULTIPLIER;
						} else {
							System.out.println(
									"...and succeed - You use the cash to buy " + name + " all sorts of supplies!");
							boredom -= 0.2 * MULTIPLIER;
							hunger -= 0.2 * MULTIPLIER;
							dirtiness -= 0.2 * MULTIPLIER;
						}
						stageHandler.changeStage(Stages.GAMEOPTIONS);
						handleDialogue(3);
					} else if (section == 2) {
						// lecture pet
						System.out.println("You start to lecture " + name + "..");
						Random rand = new Random();
						int n = rand.nextInt(2);
						if (n == 0) {
							System.out.println("...and he completely ignores you and nods off.");
							boredom += 0.5;
						} else {
							System.out.println("...and it goes surprisingly well.");
							boredom -= 0.2 * MULTIPLIER;
							hunger -= 0.2 * MULTIPLIER;
							dirtiness -= 0.2 * MULTIPLIER;
						}
						stageHandler.changeStage(Stages.GAMEOPTIONS);
						handleDialogue(3);
					} else if (section == 3) {
						// leave him, looks peaceful.
						System.out.println(
								"You leave " + name + " alone for a very long time... Maybe I should check on him.");
						boredom += 0.2 * MULTIPLIER;
						hunger += 0.2 * MULTIPLIER;
						dirtiness += 0.2 * MULTIPLIER;
						stageHandler.changeStage(Stages.GAMEOPTIONS);
						handleDialogue(3);
					}
				}
			}
		}

	}

}
