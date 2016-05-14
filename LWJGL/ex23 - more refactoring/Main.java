class Main{ /**Everything is run from here*/
	private boolean isRunning; //Is program supposed to be running?
	
	private Time main_timer = new Time();	//Timer for mainLoop
	private Time logic_timer = new Time();	//Timer for logicUpdate
	private Time render_timer = new Time();	//Timer for renderUpdate
	
	Game game;
	
	public Main(){
		Window.create(800, 600, "3D-engine"); //Has to be in constructor or Mesh class will fail!
		game = new Game();
	}
	
	public void start(){
		/*Starts application*/
		if(isRunning) return;
		isRunning = true;
		Renderer.setDefaults();
		Mesh kuk = Utilities.loadMesh("object.obj");
		mainLoop();
	}
	
	private void stop(){
		/*Stops application*/
		if(!isRunning) return;
		isRunning = false;
	}
	
	private void mainLoop(){
		/*Keeps application running*/
		int mainLoop_FPS = 200;
		
		while(isRunning){
			main_timer.setT1();
			
			
			runLogicUpdate(40); //Pass 40 as update rate to method
			
			runRenderUpdate(30); //Pass 30 as update rate to method
			
			
			main_timer.setT2();
			try{
				if((1E3 / mainLoop_FPS) > main_timer.getDelta())
					Thread.sleep((int)((1E3 / mainLoop_FPS) - main_timer.getDelta()));
			}catch(Exception e){ e.printStackTrace(); }
			
			if(Window.isCloseRequested()) stop();
		}
		close();
	}
	
	private void runLogicUpdate(int FPS){ //TODO: nothing!
		/*Keeps logic updaterate*/
		logic_timer.setT2();
		if( logic_timer.getDelta() > (1E3 / FPS) ){
			logicUpdate(logic_timer.getDelta());
			logic_timer.setT1();
		}
	}
	
	private void runRenderUpdate(int FPS){ //TODO: nothing!
		/*Keeps render updaterate*/
		render_timer.setT2();
		if( render_timer.getDelta() > (1E3 / FPS) ){
			renderUpdate(render_timer.getDelta());
			render_timer.setT1();
		}
	}
	
	private void logicUpdate(double ms_since_last_update){
		/*Updates application logic*/
		Window.updateInputEvents();
		if(Window.getKbEvent(1, 2)){//KeyID and KeyState
			System.out.println("Released!");
			stop();
		}
		game.update();
		Window.clearInputEvents();
	}
	
	private void renderUpdate(double ms_since_last_update){
		/*Updates application rendering*/
		Renderer.clearScreen();
		game.render();
		Window.render();
	}
	
	private void close(){
		/*Close and clean up after application*/
		Window.close();
	}
	
	public static void main(String[] args){
		/*Java runs this first of all*/
		Main application = new Main();
		application.start();
	}
	
}