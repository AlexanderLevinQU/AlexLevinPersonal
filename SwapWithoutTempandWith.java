
public class SwapWithoutTempandWith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = new Integer(5);
		int b = new Integer(7);
		swap(a,b);
		//swapWithTemp(a,b);
		

	}
	public static void swap(Integer a, Integer b) {
		a = 5;
		b = 7;
		a = a + b; // a = 12
		b = a - b; // b = 5
		a = a - b; // a = 7	
		System.out.println(a + " " + b);
	}
	
	public static void swapWithTemp(Integer a, Integer b) {
		int c;
		c = a;
		a = b;
		b = c;
		System.out.println(a + " " + b);
		
	}

}
