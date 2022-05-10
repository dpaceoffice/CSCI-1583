
//Import scanner and Arraylist
import java.util.Scanner;
import java.util.ArrayList;

//Declare public class named GuessingGame
public class GuessingGame {

	//Declare integers the game uses
	private static int value, lastValue, min, max, count;
	//Declare the array used to check for duplicates
	private static ArrayList<Integer> valueList;
	//Declare and assign the scanner to keyboard
	private static Scanner input = new Scanner(System.in);

	//Declare the main method
	public static void main(String[] args) {
		//Print prompt for user
		System.out.println("Please pick a number 1-100 in your head. I will try and guess the number. :) \nOnce you select a number, I will guess what the number is.\nPlease press enter to begin.");
		//Call init method
		init();
	}

	//Declare static method init
	public static void init() {
		//assigns all the variables, they're dynamic, so in order to restart the game at points, this method is important.
		min = 1;
		max = 100;
		count = 0;
		value = -1;
		lastValue = -1;
		//assigns arraylist to a new ArrayList object, not specific datatype
		valueList = new ArrayList<>();
		//this checks if the user actually pressed enter or input some text
		if(input.nextLine().isEmpty())
			//if so, lets start the game by getting the next value to guess, null because we dont need it right now
			nextValue(null);
		else {
			//if they entered something, lets reprompt them
			System.out.println("Please press enter to begin.");
			//recall the method not going to use a return here, dont want it to send the first message again
			init();
		}
	}

	//declare next value, string argument is >  or <
	public static void nextValue(String nextLine) {
		//if the value is -1, which is should be if we just started, skip everything and set the value
		if(value != -1) {
			//if value is not -1, lets check the input
			//if the input is > then that means we need to change our minimum number to guess
			if(nextLine.equals(">")) {
				//sets the min value to 1 over the previous guess
				min = value ++;
				//lets guess half of the new possible guesses
				value = ((max + min)) / 2;
				//check is needed for numbers that are exactly 100. Otherwise the above algorithm will not work
				if(lastValue == value)
				   value ++;
				//this next line is used for debugging
				//System.out.println("Min:"+min+" Max:"+max+" lastValue"+lastValue);
			//if the input is < then we are changing out maximum guess
			} else if(nextLine.equals("<")) {
				//lets set the max value we can guess to 1 less than the value
				max = value --;
				//the new value is half of our new range of numbers to guess
				value = ((max + min)) / 2;
				//check is need for numbers that are exactly 1
				if(lastValue == value)
				   value --;
				//this is for debugging.
				//System.out.println("Min:"+min+" Max:"+max);
			} else {
				//if the input is not > or < promot the user to re enter everything.
				System.out.println("What does that mean?\nUse > if the number I guessed is to low.\nUse < if the number is too large.");
				//recall this method to start over, looking for > or <
				nextValue(input.nextLine());
				//end this method here, we dont want it to contiue at all.
				return;
			}
		} else
			//set the value to 50 because its -1, 50 is our middle number
		  	value = 50;
		  	//used for debugging
		  	//System.out.println(""+value+" "+lastValue);
		  	//lets add out guess to our array for checking
		  	valueList.add(value);
		  	//lets check if there are any duplicates here and invoke checkDuplicates();
		  	checkDuplicates();
		  	//increase the try count by 1
		  	count ++;
		  	//if the value is not the same as the last guess, and the value is not exceeding our possible answers contiue
		  	if(lastValue != value && (value <= 100 && value >= 1)) {//still going to make sure that the game does not double guess an answer
		  		//lets set the lastvalue to make sure things go smoothly
		  		lastValue = value;
				//prompt user to confirm our guess
				System.out.println("Is your number "+value+"? Type Y for Yes or N for No.");
				//invoke handleGuess for next part
				handleGuess(input.nextLine());	
			} else {//this should never happen.
				//prompt user that the the algorithm is no longer going to work for some reason
		  		System.out.println("You probably entered the wrong operator.. I guess I'll just start over.\nPlease press enter to restart.");
		  		//used for debugging
		  		//System.out.println((value <= 100 && value >= 1));
		  		//restart the game
		  		init();
		  	}
	}

	//declare checkduplicates
	public static void checkDuplicates() {
		for (int i = 0; i < valueList.size(); i++)//scans list indexs
  			for (int a = i+1; a < valueList.size(); a++)//scans indexs 1 ahead of i
    			if (i != a && valueList.get(i) == valueList.get(a)) {//if a, 1 ahead of i, is the same as i, we have a duplicate.
    				valueList.clear();//lets clear the list, init should do this when we instance another array, but just playing it safe.
    				System.out.println("Something isn't right here..,\nDid you enter the wrong operator at some point?\nI guess I'll just start over.\n\nPlease press enter to restart.");
		  			init();//we need to restart and reset our variables here.
    				break;
    			}
	}


	public static void handleGuess(String answer) {
		//if the answer is Y do whats next
		if(answer.equalsIgnoreCase("Y")) {
			//foundAnswer = true;
			System.out.println("That was easy. Only took me "+count+" "+ ((count > 1) ? "tries." : "try."));
			System.exit(0);//a return statment will bring us back to nextValue(), where lastValue has changed. Game is over anyways, lets end the JVM.
		//if the value is N, lets do this
		} else if(answer.equalsIgnoreCase("N")) {
			System.out.println("Okay. Let me try that again. Is your number more or less than "+value+"?\nUse > for greater than and < for less than.");
			nextValue(input.nextLine());
		} else {
			//if other checks are not fulfilled they entered the wrong thing
			System.out.println("I don't understand what you just entered.\nWas I right or not? Use Y if I guessed right and N if I was wrong.");
			handleGuess(input.nextLine());//lets just retry this method.
		}
	}
}

