import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window{
	private int res_w, res_h, fps;
	public Window(int resolution_width, int resolution_height, int set_fps){
		res_w = resolution_width;
		res_h = resolution_height;
		fps = set_fps;
	}
	
	public void create(){
		try{ System.out.println("Creating window.");
			Display.setDisplayMode(new DisplayMode(res_w,res_h));
			Display.setFullscreen(true);
			Display.create();
		}catch(LWJGLException e){ e.printStackTrace(); System.exit(0); }
	}
	
	public void destroy(){
		System.out.println("Shutting down.");
		Display.destroy();
	}
	
	public boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	public void update(){
		Display.update();
	}
	
	public void sync(){
		Display.sync(fps);
	}
}