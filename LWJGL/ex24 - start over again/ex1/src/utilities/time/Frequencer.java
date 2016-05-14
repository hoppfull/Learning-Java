package src.utilities.time;

public class Frequencer{
	private Time timer;
	private double freq_inv;
	
	public Frequencer(double frequency){
		timer = new Time();
		freq_inv = 1E3 / frequency;
	}
	
	public boolean skip(){
		timer.setT2();
		if( timer.getDelta() > freq_inv )
		{
			timer.setT1();
			return false;
		}
		
		return true;
	}
}