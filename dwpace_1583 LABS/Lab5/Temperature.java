public class Temperature {
	public static double celsiusToFahrenheit(double celsius) {
		return ((1.8) * celsius) + 32;
	}
	public static double celsiusToKelvin(double celsius) {
		return celsius + 273.15;
	}
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}
	public static double fahrenheitToKelvin(double f) {
		f += 459.67;
		//System.out.println(f);
		f *= (double)5/9;
		return f;
	}
	public static double kelvinToFahrenheit(double kelvin) {
		return (1.8 * kelvin) - 459.67;
	}
	public static double kelvinToCelsius(double kelvin) {
		return kelvin - 273.15;
	}

	/*public static void main(String[] args) {
		/*print(celsiusToFahrenheit(1.0)); 
		print(celsiusToKelvin(1.0)); 
		print(fahrenheitToCelsius(1.0));
		print(fahrenheitToKelvin(1.0)); 
		/*print(kelvinToFahrenheit(1.0));
		print(kelvinToCelsius(1.0));
	}
	private static void print(double num) {
		System.out.println(""+num);
	}
	/*255.92777777777778
	255.9277777777778*/
}