package src.utilities.time;

public class Synchronizer{
	private Time timer;
	private double freq_inv;
	
	public Synchronizer(double frequency){
		timer = new Time();
		freq_inv = 1E3 / frequency;
	}
	
	public void sync(){
		timer.setT2();
		try
		{
			if( freq_inv > timer.getDelta() )
			{
				Thread.sleep( (int)(freq_inv - timer.getDelta()) );
			}
		}
		catch(Exception e)
		{
			System.err.println("src.utilities.Synchronizer error: 001");
			e.printStackTrace();
			System.exit(1);
		}
		timer.setT1();
	}
}