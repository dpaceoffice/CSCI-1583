/**
* @author David Pace
* @version 1.0
* @since 8/26/2019
*/

import org.junit.*;

public class ShapeTests {
	
	/**
	 * Test cases for a triangles area
	 */
	@Test
	public void testTriangleArea() {
		Point2D p1 = new Point2D(0, 0);
		Point2D p2 = new Point2D(1, 0);
		Point2D p3 = new Point2D(0, 1);
		Triangle tri = new Triangle(p1, p2, p3);
		Assert.assertEquals(tri.getArea(), (double) 0.50, 0);
		
		p1 = new Point2D(15, 10);
		p2 = new Point2D(20, 5);
		p3 = new Point2D(10, 5);
		tri = new Triangle(p1, p2, p3);
		Assert.assertEquals(tri.getArea(), (double) 25.0, 0);

		p1 = new Point2D(45, -6);
		p2 = new Point2D(56, 24);
		p3 = new Point2D(10, 5);
		tri = new Triangle(p1, p2, p3);
		Assert.assertEquals(tri.getArea(), (double) 585.50, 0.1);
	}

	/**
	 * Test cases for a triangles perimeter
	 */
	@Test
	public void testTrianglePerimeter() {
		Point2D p1 = new Point2D(0, 0);
		Point2D p2 = new Point2D(1, 0);
		Point2D p3 = new Point2D(0, 1);
		Triangle tri = new Triangle(p1, p2, p3);
		Assert.assertEquals(tri.getPerimeter(), 3.4, 0.1);

		p1 = new Point2D(32.2, 203.1);
		p2 = new Point2D(444.2, 222.1);
		p3 = new Point2D(333.0, 2.0);
		tri = new Triangle(p1, p2, p3);
		Assert.assertEquals(tri.getPerimeter(), 1020.8, 0.1);
		
		p1 = new Point2D(13, 2);
		p2 = new Point2D(13, 5);
		p3 = new Point2D(100, 100);
		tri = new Triangle(p1, p2, p3);
		Assert.assertEquals(tri.getPerimeter(), 262.85, 0.1);
	}
	
	/**
	 * Test cases for a rectangle's area
	 */
	@Test
	public void testRectangleArea() {
		Point2D p1 = new Point2D(3, 2);
		Point2D p2 = new Point2D(3, 1);
		Point2D p3 = new Point2D(1, 1);
		Point2D p4 = new Point2D(1, 2);
		Rectangle rec = new Rectangle(p1, p2, p3, p4);
		Assert.assertEquals(rec.getArea(), 2, 0.0);
		
		p1 = new Point2D(20, 15);
		p2 = new Point2D(20, 0);
		p3 = new Point2D(0, 0);
		p4 = new Point2D(0, 15);
		rec = new Rectangle(p1, p2, p3, p4);
		Assert.assertEquals(rec.getArea(), 300, 0.0);
		
		p1 = new Point2D(19, 26);
		p2 = new Point2D(19, 10);
		p3 = new Point2D(-10, 10);
		p4 = new Point2D(-10, 26);
		rec = new Rectangle(p1, p2, p3, p4);
		Assert.assertEquals(rec.getArea(), 464.0, 0.0);
	}
	
	/**
	 * Test cases for a rectangle's perimeter
	 */
	@Test
	public void testRectanglePerimeter() {
		Point2D p1 = new Point2D(3, 2);
		Point2D p2 = new Point2D(3, 1);
		Point2D p3 = new Point2D(1, 1);
		Point2D p4 = new Point2D(1, 2);
		Rectangle rec = new Rectangle(p1, p2, p3, p4);
		Assert.assertEquals(rec.getPerimeter(), 6, 0.0);
		
		p1 = new Point2D(45, 26);
		p2 = new Point2D(45, 10);
		p3 = new Point2D(10, 10);
		p4 = new Point2D(10, 26);
		rec = new Rectangle(p1, p2, p3, p4);
		Assert.assertEquals(rec.getPerimeter(), 102.0, 0.0);
		
		p1 = new Point2D(19, 26);
		p2 = new Point2D(19, 10);
		p3 = new Point2D(-10, 10);
		p4 = new Point2D(-10, 26);
		rec = new Rectangle(p1, p2, p3, p4);
		Assert.assertEquals(rec.getPerimeter(), 90.0, 0.0);
	}

	/**
	* Test cases for shape
	*/
	@Test
	public void testShapeMethods() {
		//Tests if getVertex works properly
		Point2D p1 = new Point2D(3, 2);
		Point2D p2 = new Point2D(3, 1);
		Point2D p3 = new Point2D(1, 1);
		Point2D p4 = new Point2D(1, 2);
		Shape shape = new Rectangle(p1, p2, p3, p4);
		Assert.assertEquals(shape.getVertex(2), p2);

		//Tests the method setPoint.
		Point2D z = new Point2D(0,0);
		shape.setPoint(1, z);
		Assert.assertEquals(shape.getVertex(1), z);
		shape.setPoint(1, p1);

		//annd we are testing the abstract methods even tho its pretty redundant...
		Shape shape2 = new Rectangle(p1, p2, p3, p4);
		Assert.assertEquals(shape.getArea(), shape2.getArea(), 0.0);
		Assert.assertEquals(shape.getPerimeter(), shape2.getPerimeter(), 0.0);
	}

}