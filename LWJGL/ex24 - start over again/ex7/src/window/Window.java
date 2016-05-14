package src.window;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window{
	public static void create(int WIDTH, int HEIGHT, String TITLE){
		try{
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
			System.out.println("Successfully created a window: '"+TITLE+"' - "+WIDTH+"x"+HEIGHT);
		}catch(LWJGLException e){
			System.err.println("Window class, error: 001");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	public static void update(){
		Display.update();
	}
	
	public static void close(){
		Display.destroy();
	}
	
	public static int getWidth(){
		return Display.getDisplayMode().getWidth();
	}
	
	public static int getHeight(){
		return Display.getDisplayMode().getHeight();
	}
}