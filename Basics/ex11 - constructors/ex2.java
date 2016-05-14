class ex2{
	public static void main(String args[]){
		//Constructors! oh noes...! :S
		
		/*
		 * A constructor is a mechanism that initiates values
		 * for private variables when an object is created.
		 * In this case the variable x inside the ex2extra class is private.
		 * The function ex2extra (same name as the class), gets inputs from
		 * when the class is created. In this case '5'.
		 * Not sure if we can't use the ex2extra function again...
		 */
		ex2extra object = new ex2extra(5);
		
		int value = object.retrieve_x();
		System.out.print(value);
	}
}