package src.utilities.time;

public class Synchronizer{
	private Time sync_timer;
	private double freq_inv;
	
	public Synchronizer(double frequency){
		sync_timer = new Time();
		freq_inv = 1E3 / frequency;
	}
	
	public void sync(){
		sync_timer.setT2();
		try
		{
			if( freq_inv > sync_timer.getDelta() )
			{
				Thread.sleep( (int)(freq_inv - sync_timer.getDelta()) );
			}
		}
		catch(Exception e)
		{
			System.err.println("src.utilities.Synchronizer error: 001");
			e.printStackTrace();
			System.exit(1);
		}
		sync_timer.setT1();
	}
}