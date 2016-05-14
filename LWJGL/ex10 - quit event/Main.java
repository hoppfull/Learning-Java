class Main{
	GLEngine glengine = new GLEngine(800, 600);
	InputHandler inputhandler = new InputHandler();
	
	//These arrays keep track of user input. Look in InputHandler.java for more info!
	private int[] mouse_events = inputhandler.mouse_events;
	private int[] keyboard_events = inputhandler.keyboard_events;
	//Initiate and declare event variables to be mapped to functions later:
	private boolean kb_QUIT = false; // Quit program?
	private boolean m_HELLO = false; // Write "Hello!" in command shell?
	
	private void inputManager(){ //Here we manage user input
		//Update user input arrays for this loop:
		mouse_events = inputhandler.mouseEvents();
		keyboard_events = inputhandler.keyboardEvents();
		//Map event variables to keyboard:
		kb_QUIT = (keyboard_events[1/*ID*/] == 3/*STATE*/);
		//Map event variables to mouse:
		m_HELLO = (mouse_events[0/*ID*/] == 1/*STATE*/);
	}
	
	public void mainLoop(){
		while( !glengine.isCloseRequested() && !kb_QUIT ){
			inputManager();
			//This is an example of how to use event variables:
			if(m_HELLO){ System.out.println("Hello!"); }
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