public class Game{
	//Here we declare some private variables for use in our program.
	private int time;
	private boolean running = true;
	
	public Game(int t){
		//Our constructor initialize some private variables.
		time = t;
	}
	
	
	
	
	
	
	private void eventHandler(){
		//TODO: Write code here!
	}
	
	private void updateScene(){
		//TODO: Write code here!
	}
	
	private void drawScene(){
		//TODO: Write code here!
	}
	
	private void mainLoop(){
		//TODO: Sort out an exit function in the eventHandler()
		/*while(running)
		{
			eventHandler();
			updateScene();
			drawScene();
		}*/
		System.out.print("Hello world!" + time);
	}
	
	public void run(){
		mainLoop();
	}
	
	public static void main(String[] args){
		Game GameObject = new Game(5000);
		GameObject.run();
	}
}
