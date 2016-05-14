import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/* We create this class in a static context, that
 * way we can't create objects of this class. No
 * point I guess since we can't maintain more than
 * one window anyway... */
public class Window{
	public static void create(int WIDTH, int HEIGHT, String TITLE){
		try{
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
			System.out.println("Successfully created a window: '"+TITLE+"' - "+WIDTH+"x"+HEIGHT);
		}catch(LWJGLException e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void destroy(){
		Display.destroy();
	}
	
	public static void render(){
		Display.update();
	}
	
	public static boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	public static int getWidth(){
		return Display.getDisplayMode().getWidth();
	}
	
	public static int getHeight(){
		return Display.getDisplayMode().getHeight();
	}
	
	public static String getTitle(){
		return Display.getTitle();
	}
	
}