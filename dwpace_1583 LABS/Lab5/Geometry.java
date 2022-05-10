public class Geometry {
	public static double getAreaRectangle(double width, double length) {
		return width * length;
	}

	public static double getAreaCircle(double radius) {
		return Math.PI * Math.pow(radius, 2);
		//return 2 ^ 4;
	}

	public static double getAreaTriangle(double base, double height) {
		return (0.5) * (base) * (height);
	}

	public static double getPerimeterRectangle(double width, double height) {
		return (width * 2) + (height *2);
	}

	public static double getPerimeterCircle(double radius) {
		return (Math.PI * 2) * radius;
	}

	public static double getPerimeterTriangle(double side1, double side2, double side3) {
		return side1+side2+side3;
	}

}

