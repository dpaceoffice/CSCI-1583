
public class HW3 {

	static int personOne;
	static int personTwo;
	static int personThree;
	static int personFour;

	public static void main(String[] args) {
		int counter = 0;
		for (personOne = 1; personOne <= 6 - 3; personOne++) {
			for (personTwo = personOne + 1; personTwo <= 6 - 2; personTwo++) {
				for (personThree = personTwo + 1; personThree <= 6 - 1; personThree++) {
					for (personFour = personThree + 1; personFour <= 6; personFour++) {
						//if(counter >= 100)
							//break;
						System.out.println(personOne + ", " + personTwo + ", " + personThree + ", " + personFour);
						counter++;
						//System.out.println(counter);
					}
				}
			}
		}
		System.out.println("There are "+counter+" different possible conversations.");
	}
}
