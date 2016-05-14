class Main{
	private boolean isRunning; //Is program running?
	private final double FRAME_TIMECAP = (double)(1E3 / 30);		//ms per frame
	private final double UPDATE_TIMECAP = (double)(1E3 / 100);		//ms per update
	private final double LOOP_TIMECAP = (double)(1E3 / 200);		//ms per mainLoop
	
	Time maintimer = new Time();
	Time updtimer = new Time();
	Time rentimer = new Time();
	
	public Main(){
		Window.create(800, 600, "3D-Engine");
		isRunning = false;
	}
	
	public void start(){
		if( isRunning ) return; //If we're already running, skip rest
		run();
	}
	
	public void stop(){
		if( !isRunning ) return; //If we're not running, skip rest
		
		isRunning = false;
	}
	
	private void run(){
		isRunning = true;
		
		updtimer.setT_1();
		rentimer.setT_1();
		
		double ms_since_last_update = UPDATE_TIMECAP;
		double ms_since_last_render = FRAME_TIMECAP;
		
		while( isRunning ){
			maintimer.setT_1();
			
			updtimer.setT_2();
			ms_since_last_update += updtimer.getDelta(); //Count time since last update
			if( ms_since_last_update > (UPDATE_TIMECAP -(LOOP_TIMECAP/2)) ){ //-(LOOP_TIMECAP/2) allows for error margin
				update(); //Update game logic
				ms_since_last_update = 0; //Reset timer
			}
			updtimer.setT_1();
			
			rentimer.setT_2();
			ms_since_last_render += rentimer.getDelta(); //Count time since last render
			if( ms_since_last_render > (FRAME_TIMECAP -(LOOP_TIMECAP/2)) ){ //-(LOOP_TIMECAP/2) allows for error margin
				render(); //Update render
				System.out.println("FPS: " + (int)(1E3 / ms_since_last_render)); //Print FPS
				ms_since_last_render = 0; //Reset timer
			}
			rentimer.setT_1();
			
			maintimer.setT_2();
			try{ if(LOOP_TIMECAP > maintimer.getDelta()){ //If time left, wait to keep loops/s capped
				Thread.sleep( (int)(LOOP_TIMECAP - maintimer.getDelta()) ); }
			}catch(InterruptedException e){ e.printStackTrace(); }
			if( Window.isCloseRequested() ) stop(); //Check if to stop before next loop
		}
		cleanUp();
	}
	
	private void update(){
		//Game logic here
		/* Might be interesting to pass ms_since_last_update to this method
		 * to tell game logic if it should hurry up or slow down a bit. */
	}
	
	private void render(){
		Window.update();
	}
	
	private void cleanUp(){
		Window.destroy();
	}
	
	public static void main(String[] args){
		Main application = new Main();
		application.start();
	}
}