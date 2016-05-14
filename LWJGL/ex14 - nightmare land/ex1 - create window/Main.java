class Main{
	Window myWindow = new Window(
			800,	//Resolution width
			600,	//Resolution height
			25		//Maximum FPS
			);
	
	private void mainLoop(){
		while ( !myWindow.isCloseRequested() ){
			//Do stuff here!
			System.out.println("Hello!");
			
			
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