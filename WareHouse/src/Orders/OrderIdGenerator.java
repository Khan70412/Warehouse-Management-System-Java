package Orders;


public class OrderIdGenerator {
	private static int counter = 1001; // initializes the counter to initial value

	public static String nextId() {
		String num = String.valueOf(counter); // converts the integer counter to String
		String result = "ORD"+num;
		counter++; // increments counter

		return result; // returns the result
	}
}
