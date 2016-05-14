class Main{
	private GlobalObjects GO = new GlobalObjects();
	public Main(){
		//Initialize GO-variables for keyboard:
	}
	
	Window myWindow = new Window(
			800,	//Resolution width
			600,	//Resolution height
			5,		//Maximum FPS
			GO		//Pass object to window-class
			);
	
	private void mainLoop(){
		while ( !myWindow.isCloseRequested() ){
			//Do stuff here!
			myWindow.mouseInput();
			myWindow.keyboardInput();
			
			myWindow.sync();
			myWindow.update();
		}
	}
	
	public void run(){
		myWindow.create();
		mainLoop();
		myWindow.destroy();
		
		
	}
	
	public static void main(String[] args){
		Main application = new Main();
		application.run();
	}
}

/* These are basics for creating and maintaining a window
 * with object oriented programming.
 */