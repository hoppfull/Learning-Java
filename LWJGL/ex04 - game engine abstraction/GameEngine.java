import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GameEngine{
	private int res_x, res_y;
	
	public GameEngine(int screen_width, int screen_height){
		System.out.println("Constructing!");
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
	
	public void eventHandler(){
		//TODO: Write code here!
	}
	
	public void updateScene(){
		//TODO: Write code here!
	}
	
	public void drawScene(){
		//TODO: Write code here!
	}
	
	private void mainLoop(){
		while(!Display.isCloseRequested()){
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
}