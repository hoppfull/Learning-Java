class ex6{
	public static void main(String args[]){
		int result[] = function(51, 2, 18);
		System.out.print(result[1]);
	}
	/* I'm not sure but it seems like it's impossible to define functions
	 * inside my main function. Wierd but hey, whatevs...
	 */
	public static int[] function(int...arguments){
		int total = 0;
		for(int i:arguments)
			total++;
		
		return arguments;
	}
}
/* I'm not sure that 'int...arguments' could be called arguments but
 * rather just an array of unspecified size. Anyway, this is good to know!
 */