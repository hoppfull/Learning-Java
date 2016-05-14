import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Game{
	//Here we declare some private variables for use in our program.
	private boolean running = true; //Is the application running?
	private int res_x, res_y;
	
	public Game(int screen_width, int screen_height){
		//Our constructor initialize some code
		System.out.println("Construct!");
		res_x = screen_width;
		res_y = screen_height;
	}
	
	private void initOpenGL(){
		//Init OpenGL here!
		System.out.println("Initialize OpenGL!");
		try{
			Display.setDisplayMode(new DisplayMode(res_x,res_y));
			Display.create();
		}catch(LWJGLException e){ //I think I might not care about throwing an exception but I might as well keep it here, right?
			e.printStackTrace();
			System.exit(0);
		}
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
		while(!Display.isCloseRequested())
		{
			eventHandler();
			updateScene();
			drawScene();
			Display.update(); //I think this is like pygame.display.flip(), it applies drawing onto screen.
		}
		Display.destroy();
		System.out.println("Shutting down.");
	}
	
	public void run(){
		initOpenGL();
		mainLoop();
	}
	
	public static void main(String[] args){
		Game GameObject = new Game(800,600);
		GameObject.run();
		System.out.println("Program shut down successfully!");
	}
}
