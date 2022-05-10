
import java.util.Scanner;

public class BloggingInHTML {

	public static void main(String[] args) {
        grabParameters();
	}

	public static void grabParameters() {
		String header, imageURL, body, author, date;
		Scanner scanner = new Scanner(System.in);

		//System.out.println("What is your header?");
        	header = scanner.nextLine();

        //System.out.println("What is your image URL?");
       		imageURL = scanner.nextLine();

       	//System.out.println("Enter a text for the page's body.");
       		body = scanner.nextLine();

       	//System.out.println("Enter the author for the page's footer.");
       		author = scanner.nextLine();
       //	System.out.println("Enter the date for the page's footer.");
       		date = scanner.nextLine();
       	scanner.close();
        outputHTML(header, imageURL, body, author, date);
	}

	public static void outputHTML(String header, String imageURL, String body, String author, String date) {
		System.out.print("<html><body><h1>"+header+"</h1><img src='"+imageURL+"' /><p>"+body+"</p><small>By "+author+", "+date+"</small></body></html>");
	}
}