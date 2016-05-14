class Main{
	Thread Windowthread = new Thread(new Window(
			800,	//Resolution width
			600,	//Resolution height
			25		//Maximum FPS
			));
	
	IntObj x2 = Windowthread.x1;
	
	public void run(){
		Windowthread.start();
		//Windowthread.interrupt();
	}
	
	public static void main(String[] args){
		Main application = new Main();
		application.run();
	}
}

/* Here is how we're going to structure this program:
 * 
 * Our window class will define our window and user input.
 * It will also create and store input in objects and pass
 * pointers to our Main class. The Main class can then pass
 * those pointers to other classes. That way we have one
 * unified source of input.
 * It'll be fun to experiment with this!
 */
