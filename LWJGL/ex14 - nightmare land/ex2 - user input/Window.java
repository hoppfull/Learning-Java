import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Window{
	private int res_w, res_h, fps;
	public int KEY_ESCAPE_status = 0;
	public int KEY_A_status = 0;
	public int MOUSE_BUTTON0_status = 0;
	

	public Window(int resolution_width, int resolution_height, int set_fps){
		res_w = resolution_width;
		res_h = resolution_height;
		fps = set_fps;
	}
	
	public void create(){
		try{ System.out.println("Creating window.");
			Display.setDisplayMode(new DisplayMode(res_w,res_h));
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
	
	public void mouseInput(){
		if		(MOUSE_BUTTON0_status == 1){ MOUSE_BUTTON0_status = 2; }
		else if	(MOUSE_BUTTON0_status == 3){ MOUSE_BUTTON0_status = 0; }
		while( Mouse.next() ){
			if( Mouse.getEventButton() == 0 ){
				MOUSE_BUTTON0_status = Mouse.getEventButtonState() ? 1 : 3;
			}
		}
	}
	
	public void keyboardInput(){
		if		(KEY_ESCAPE_status == 1){ KEY_ESCAPE_status = 2; }
		else if	(KEY_ESCAPE_status == 3){ KEY_ESCAPE_status = 0; }
		if		(KEY_A_status == 1){ KEY_A_status = 2; }
		else if	(KEY_A_status == 3){ KEY_A_status = 0; }
		while( Keyboard.next() ){
			if( Keyboard.getEventKey() == Keyboard.KEY_ESCAPE ){
				KEY_ESCAPE_status = Keyboard.getEventKeyState() ? 1 : 3;
			}
			if( Keyboard.getEventKey() == Keyboard.KEY_A ){
				KEY_A_status = Keyboard.getEventKeyState() ? 1 : 3;
			}
		}
	}
}