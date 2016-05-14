public class ex7extra{
	private int x = 10;	//All of these are initiated globally in this class
	private int y = 20;
	private int z = 30;
	private int c;		//Only c isn't declared
	private int b = 50;
	
	public void function(int x, int y, int z, int a){
		/* Any arguments with same name as variables already declared
		 * in this class will ignore assigned values when function is
		 * called from another class. And values assigned inside the
		 * function is also overriden except when you use the 'this'
		 * 
		 */
		this.x = 1; //Here we force x to be assigned this value.
		y = 2; //This will be ignored.
		c = z; //c isn't declared yet so it will accept a new value.
		b = a; //the fourth argument in this function isn't declared in this class so it will override b
	}
	
	public void method(){
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("c: " + c);
		System.out.print(  "b: " + b);
	}
	
}