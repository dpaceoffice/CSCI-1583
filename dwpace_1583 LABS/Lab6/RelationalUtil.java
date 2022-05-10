public class RelationalUtil {
	public static boolean isIncreasing(int x, int y, int z) {
		return x < y && y < z;
	}
	public static boolean isDecreasing(int x, int y, int z) {
		return x > y && y > z;
	}
	public static boolean isBetween(int x, int y, int z) {
		if(x < y && y < z)
			return true;
		else if(x > y && y > z)
			return true;
		return false;
	}
	public static boolean isPositive(int x) {
		return x >= 0;
	}
	public static boolean isNegative(int x) {
		return x < 0;
	}
	public static boolean overlaps(int x1, int y1, int x2, int y2) {
		if(x1 + y1 == x2+y2)
			return true;
		else
			return false;
	}

	/*public static void main(String[] args) {
		System.out.println(""+isIncreasing(1,2,3));
		 System.out.println(""+isDecreasing(3,2,1));
		  System.out.println(""+isBetween(-1,0,1));
		   System.out.println(""+isPositive(1));
		    System.out.println(""+isNegative(-1));
		     System.out.println(""+overlaps(0,1,-1,2)); 
		     System.out.println(""+overlaps(0,1,2,3));
	}*/
}