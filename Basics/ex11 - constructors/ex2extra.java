class ex2extra{
	private int x;
	
	public ex2extra(int a){
		/* This is the constructor function.
		 * Note that it has the same name as its class.
		 * It also doesn't have a returntype such as the
		 * function lower down (retrieve_x) on this page
		 * which has the return type int.
		 */
		x = a;
		/* This function is only called once during the
		 * creation of an object of this class. This is
		 * interesting becouse now finally....... I know
		 * what a constructor is. Gorram...!
		 */
	}
	
	public int retrieve_x(){
		return x;
	}
}