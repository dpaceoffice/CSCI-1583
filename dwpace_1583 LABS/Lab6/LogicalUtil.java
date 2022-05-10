public class LogicalUtil {
	public static boolean thereExists(boolean p, boolean q, boolean r) {
		return p || q || r;
	}
	public static boolean forAll(boolean p, boolean q, boolean r) {
		return p && q && r;
	}
	public static boolean majority(boolean p, boolean q, boolean r) {
		int trueCount = 0;
		if(p)
			trueCount ++;
		if(q)
			trueCount ++;
		if(r)
			trueCount ++;
		if(trueCount >= 2)
			return true;
		return false;
	}
	public static boolean minority(boolean p, boolean q, boolean r) {
		int trueCount = 0;
		if(p)
			trueCount ++;
		if(q)
			trueCount ++;
		if(r)
			trueCount ++;
		if(trueCount < 2)
			return true;
		return false;
	}
	public static boolean implies(boolean p, boolean q) {
		if(p && !q)
			return false;
		return true;
	}
	public static boolean implies(boolean p, boolean q, boolean r) {
		if(p && q && !r)
			return false;
		return true;
	}

	/*public static void main(String[] args) {
		System.out.println(""+thereExists(false, false, true));
		System.out.println(""+forAll(true, true, true));
		System.out.println(""+majority(true, true, false)); 
		System.out.println(""+minority(false,false,false)); 
		System.out.println(""+implies(true, false));
		System.out.println(""+implies(true, true, false));
	}*/
}