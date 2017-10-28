
public class SwapValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer a = new Integer(8);
		//Integer b = new Integer(7);
		int [] numbers = new int[2];
		numbers[0] = 5;
		numbers[1] = 7;
		swap(numbers[0],numbers[1], numbers);
		System.out.println(numbers[0] + " " + numbers[1]);
		System.out.println(98 / 64);

	}
	
	public static void swap(int a, int b, int[] array) {
		int c = array[0];
		array[0] = array[1];
		array[1] = c;
			
	}
	

}
