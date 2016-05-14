import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GLEngine{
	private int res_x, res_y;
	public boolean isrunning = true;
	
	public GLEngine(int resolution_x, int resolution_y){
		res_x = resolution_x;
		res_y = resolution_y;
	}
	
	public void initOpenGL(){
		//Init OpenGL here!
		System.out.println("Initializing OpenGL.");
		try{
			Display.setDisplayMode(new DisplayMode(res_x,res_y));
			Display.create();
		}catch(LWJGLException e){ //I think I might not care about throwing an exception but I might as well keep it here, right?
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void exitOpenGL(){
		Display.destroy();
		System.out.println("Shutting down.");
	}
	
	public boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	public void applyScreen(){
		Display.update();
	}
}