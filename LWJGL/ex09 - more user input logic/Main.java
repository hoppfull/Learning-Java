class Main{
	GLEngine glengine = new GLEngine(800, 600);
	InputHandler inputhandler = new InputHandler();
	
	//These arrays keep track of user input. Look in InputHandler.java for more info!
	private int[] mouse_events = inputhandler.mouse_events;
	private int[] keyboard_events = inputhandler.keyboard_events;
	
	public Main(){
		//Constructor
	}
	
	
	
	
	
	
	
	
	
	public void mainLoop(){
		while( !glengine.isCloseRequested() && (keyboard_events[1] != 3) ){
			mouse_events = inputhandler.mouseEvents();
			keyboard_events = inputhandler.keyboardEvents();
			glengine.applyScreen();
		}
	}
	
	public void run(){
		glengine.initOpenGL();
		mainLoop();
		glengine.exitOpenGL();
	}
	
	public static void main(String[] args){
		Main application = new Main();
		application.run();
	}
}