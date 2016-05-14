class ex9{
	public static void main(String args[]){
		//Multiple classes!
		ex9extra object1 = new ex9extra();
		int value = object1.function(51, 2);
		
		System.out.print(value);
	}
}
/* Python version:
import ex9extra as e

main:
	object1 = e.ex9extra()
	value = object1.function(51, 2)
	print(value)
*/