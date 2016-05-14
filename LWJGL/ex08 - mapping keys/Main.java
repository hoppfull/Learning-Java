class Main{
	GLEngine glengine = new GLEngine(800, 600);
	InputHandler inputhandler = new InputHandler();
	
	//Look in InputHandler.java to get details on the following two lines!
	public int[] mouse_events = inputhandler.buttonmap;
	
	public Main(){
		//Constructor
	}
	
	
	
	
	
	
	
	
	
	public void mainLoop(){
		while( !glengine.isCloseRequested() ){
			mouse_events = inputhandler.mouseEvents();
			inputhandler.keyboardEvents();
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