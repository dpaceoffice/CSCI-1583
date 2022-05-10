/**
 * @author David Pace
 * @version 1.0
 * @since 8/26/2019
 */
public class Triangle extends Shape {
	
	private Point2D A,B,C;


	/**
	 * Constructor for Triangle
	 * 
	 * @param p1,p2,p3 Requires three Point2D object arguments that define the
	 *        vertices of the triangle
	 */
	public Triangle(Point2D p1, Point2D p2, Point2D p3) {
		super();
		setPoint(1, p1);
		setPoint(2, p2);
		setPoint(3, p3);
		this.A = p1;
		this.B = p2;
		this.C = p3;
	}

	/**
	 * @return a double that represents the area of the triangle
	 */
	@Override
	public double getArea() {
		double bh = (A.getX() * (B.getY() - C.getY())) + (B.getX() * (C.getY() - A.getY()))
				+ (C.getX() * (A.getY() - B.getY()));

		return Math.abs((bh) / 2.0);
	}

	/**
	 * @return a double that represents the perimeter of the triangle
	 */
	@Override
	public double getPerimeter() {
		return A.distance(B) + B.distance(C) + C.distance(A);
	}

}