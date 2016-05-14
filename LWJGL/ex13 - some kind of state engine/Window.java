import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
//Implementing Runnable will allow us to put this class in a seperate thread
public class Window implements Runnable{
	private int res_w, res_h, fps;
	public Window(int resolution_width, int resolution_height, int set_fps){
		res_w = resolution_width;
		res_h = resolution_height;
		fps = set_fps;
	}
	
	public IntObj x1 = new IntObj();
	
	private void createWindow(){
		try{ System.out.println("Creating window.");
			Display.setDisplayMode(new DisplayMode(res_w,res_h));
			Display.create();
		}catch(LWJGLException e){ e.printStackTrace(); System.exit(0); }
	}
	
	private void destroyWindow(){
		System.out.println("Shutting down.");
		Display.destroy();
	}
	
	@Override
	public void run(){
		try{
			createWindow();
			while( !Display.isCloseRequested() && !Thread.currentThread().isInterrupted() ){
				Display.sync(fps);
				//Render stuff here:
				
				
				
				Display.update();
			}
			destroyWindow();
		}catch(Exception e){}
	}
}

class IntObj{
	public int value;
}