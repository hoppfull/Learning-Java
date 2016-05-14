class SuperClass{
	public void myPrint(){
		System.out.print("From SuperClass!");
	}
}

class Main extends SuperClass {
	public static void main(String[] args){
		myPrint();
	}
	
	public void myPrint() { //Here we override the method from SuperClass
		super.myPrint();
		System.out.print("From subclass...");
	}
}