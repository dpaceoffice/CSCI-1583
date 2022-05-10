/**
* @author David Pace
* @version 1.0
* @since 8/26/2019
*/
public class Rectangle extends Shape {

	private double width;
	private double height;

	/**
	* Constructor for Rectanle
	* @param p1,p2,p3,p4 Requires four Point2D objects that define the vertices of the rectangle
	**/
	public Rectangle(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
		super();
		setPoint(1, p1);
		setPoint(2, p2);
		setPoint(3, p3);
		setPoint(4, p4);
		this.height = getVertex(1).distance(getVertex(2));
		this.width = getVertex(2).distance(getVertex(3));
	}

	/**
	* @return The area of the rectangle as a double
	*/
	public double getArea() {
		return width * height;
	}

	/**
	* @return The perimeter of the rectangle as a double
	*/
	public double getPerimeter() {
		return (2*width) + (2*height);
	}
}