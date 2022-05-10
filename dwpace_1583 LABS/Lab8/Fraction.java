public class Fraction {
	private int num, denom;
	public Fraction(int num, int denom) {
		this.num = Math.abs(num);
		this.num *= (num * denom >= 0) ? 1 : -1;
		this.denom = Math.abs(denom);
	}

	public int getNumerator() {
		return num;
	}

	public int getDenominator() {
		return denom;
	}

	public Fraction add(Fraction other) {
		int numerator = (this.num * other.getDenominator()) + (other.getNumerator() * this.denom);
		int denominator = this.denom * other.getDenominator();
		return simplify(numerator, denominator);
	}

	public Fraction subtract(Fraction other) {
		int numerator = (this.num * other.getDenominator()) - (other.getNumerator() * this.denom);
		int denominator = this.denom * other.getDenominator();
		return simplify(numerator, denominator);
	}
	public Fraction multiply(Fraction other) {
		int numerator = (this.num * other.getNumerator());
		int denominator = (this.denom * other.getDenominator());
		return simplify(numerator, denominator);
	}

	public Fraction divide(Fraction other) {
		int numerator = this.num * other.getDenominator();
		int denominator = this.denom * other.getNumerator();
		return simplify(numerator, denominator);

	}

	public Fraction simplify(int numerator, int denominator) {
		for(int i = denominator; i > 0; i--) {
			if(numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
			}
		}
		return new Fraction(numerator, denominator);
	}

	public String toString() {
		return "("+this.num+"/"+this.denom+")";
	}
}