package hw02;

public class hw {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE - 1);
		System.out.println(Integer.MAX_VALUE + 1);
		
		char ch = 'P';
		int humidity = 21;
		int speed = 4;
		long rain = 6L;
		double temperature = 25.0;
		
		System.out.println(humidity + speed);
		System.out.println(temperature + (int)speed);
		System.out.println((int)temperature + speed);
		System.out.println(humidity%rain);
		System.out.println(ch + speed);
		System.out.println((char)(ch + speed));
		System.out.println(1 / 2 * temperature);
		
		int x = 10;
		int y = 5;
		boolean a = true;
		boolean b = false;
		boolean c = false;
		
		System.out.println(x < 5);
		System.out.println(y > 5);
		System.out.println(y < 100 && x * y == 50);
		System.out.println(!(a || b));
		System.out.println(a && !(b || c));

	}

}
