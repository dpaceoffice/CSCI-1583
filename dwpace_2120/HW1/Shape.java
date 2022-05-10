/**
* @author David Pace
* @version 1.0
* @since 8/26/2019
*/
public abstract class Shape {
	
	private Point2D[] points;

	/**
	* Constructor for Shape
	* Builds an array of Point2D objects of indicies 0-4 inclusive, or size of 5.
	* @see Point2D
	*/
	public Shape() {
		this.points = new Point2D[5];
	}

	/**
	* @param index indicates the position in the array of the vertex
	*/
	public Point2D getVertex(int index) {
		return points[index];
	}

	/**
	* @param index indicates the position in the array of the vertex being set
	* @param point is the object Point2D of your coordinants
	* @see Point2D
	*/
	public void setPoint(int index, Point2D point) {
		points[index] = point;
	}

	public abstract double getArea();
	public abstract double getPerimeter();
}