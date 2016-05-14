import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
//Implementing Runnable will allow us to put this class in a seperate thread
public class GraphicsEngine implements Runnable{
	private int res_w, res_h, fps;
	public GraphicsEngine(int resolution_width, int resolution_height, int set_fps){
		res_w = resolution_width;
		res_h = resolution_height;
		fps = set_fps;
	}
	
	private void initWindow(){
		System.out.println("Creating window.");
		try{
			Display.setDisplayMode(new DisplayMode(res_w,res_h));
			Display.create();
		}catch(LWJGLException e){ e.printStackTrace(); System.exit(0); }
	}
	
	public void exitWindow(){
		Display.destroy();
		System.out.println("Shutting down.");
	}
	
	@Override
	public void run(){
		try{
			initWindow();
			while( !Display.isCloseRequested() && !Thread.currentThread().isInterrupted() ){
				Display.sync(fps);
				//Render stuff here:
				
				
				
				Display.update();
			}
			exitWindow();
		}catch(Exception e){}
	}
}