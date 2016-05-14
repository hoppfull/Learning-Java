import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

class Window{
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
	
	public static void render(){
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
	
	/** Event handling: */
	private static int[][] mb_events = new int[4][6]; //four properties, six events
	private static int[][] kb_events = new int[2][12]; //two properties, twelve events
	
	public static void clearInputEvents(){
		/* Run this every update after using all events */
		for(int n=0;n<mb_events.length;n++){
			for(int m=0;m<mb_events[0].length;m++){ mb_events[n][m] = 0; }
		} //Set all values in mb_events to 0
		
		for(int n=0;n<kb_events.length;n++){
			for(int m=0;m<kb_events[0].length;m++){ kb_events[n][m] = 0; }
		} //Set all values in kb_events to 0
	}
	
	public static void updateInputEvents(){ //Update all 'buffers' with mouse- and keyboard-events
		for(int i=0;i<mb_events[0].length;i++){
			if( Mouse.next() ){ //Select next event in list
				mb_events[0][i] = Mouse.getEventButton(); //Button ID
				mb_events[1][i] = Mouse.getEventButtonState() ? 1 : 2; //Press or release
				mb_events[2][i] = Mouse.getEventX(); //Event x position
				mb_events[3][i] = Mouse.getEventY(); //Event y position
			}
		}
		
		for(int i=0;i<kb_events[0].length;i++){
			if( Keyboard.next() ){ //Select next event in list
				kb_events[0][i] = Keyboard.getEventKey(); //Key ID
				kb_events[1][i] = Keyboard.getEventKeyState() ? 1 : 2; //Press or release
			}
		}
	}
	
	public static boolean getKbEvent(int KeyID, int KeyState){ //Test if keyID and keyState is in eventlist
		for(int i=0;i<kb_events[0].length;i++){
			if(	kb_events[0][i] == KeyID && kb_events[1][i] == KeyState) return true;
			//KeyState: 1 is pressed, 2 is released
		}
		return false;
	}
	
	public static int[] getMbEvent(int ButtonID, int ButtonState){
		int[] coordinates = new int[3];
		for(int i=0;i<mb_events[0].length;i++){
			if( mb_events[0][i] == ButtonID && mb_events[1][i] == ButtonState ){
				coordinates[1] = mb_events[2][i];
				coordinates[2] = mb_events[3][i];
				coordinates[0] = 1; //If event is present
			}
		}
		return coordinates;
	}
	
	public static int getMouseX(){
		return Mouse.getX();
	}
	
	public static int getMouseY(){
		return Mouse.getY();
	}
	
	public static boolean isMbDown(int buttonID){
		return Mouse.isButtonDown(buttonID);
	}
	
	public static boolean isKbDown(int keyID){
		return Keyboard.isKeyDown(keyID);
	}
}