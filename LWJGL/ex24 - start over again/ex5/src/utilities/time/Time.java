package src.utilities.time;

public class Time{//Provides timing functions
	private long t1, t2;
	
	public Time(){
		t1 = 0;
		t2 = 0;
	}
	
	public void setT1(){ //Set timer start
		t1 = System.nanoTime();
	}
	
	public void setT2(){ //Set timer stop
		t2 = System.nanoTime();
	}
	
	public double getDelta(){ //Measure elapsed time
		return ( (double)(t2 - t1) / 1E6 );
	}
}