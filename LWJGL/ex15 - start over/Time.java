public class Time{
	private long t_1 = 0; //Initialize in case user forgets to set time
	private long t_2 = 0;
	
	public void setT_1(){
		//Set system time in ms:
		t_1 = System.nanoTime();
	}
	
	public void setT_2(){
		//Set system time in ms:
		t_2 = System.nanoTime();
	}
	
	public double getDelta(){
		return ((double)t_2 - (double)t_1) / 1E6; //Convert to ms then to
	}
}