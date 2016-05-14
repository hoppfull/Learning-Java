class ex8extra implements Runnable{ //It appears Runnable is the one behind all this... Threads and all.
	
	private int time = 0;
	private String name = "Thread";
	
	public ex8extra(String s, int t){
		//This function is a constructor
		time = t;
		name = s;
	}
	
	/* The run()-method comes from Runnable class and we implement it here.
	 * run() is called when you call start()
	 */
	public void run(){
		try{//If the following lines won't work, no worries. We move on.
			
			System.out.println("Starting: " + name);
			
			Thread.sleep(time);
			System.out.println("Finished: " + name);
			
		}catch(Exception e){}
	}
}