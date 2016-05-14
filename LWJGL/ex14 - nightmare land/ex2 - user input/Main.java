class Main{
	Window myWindow = new Window(
			800,	//Resolution width
			600,	//Resolution height
			1		//Maximum FPS
			);
	
	private void mainLoop(){
		while ( !myWindow.isCloseRequested() && myWindow.KEY_ESCAPE_status != 3){
			//Do stuff here!
			myWindow.mouseInput();
			myWindow.keyboardInput();
			
			System.out.println(myWindow.MOUSE_BUTTON0_status);
			
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