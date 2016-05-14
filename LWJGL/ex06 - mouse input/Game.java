import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;

public class Game extends GameEngine{
	public Game(int s_width, int s_height){
		//Our constructor initialize some code
		super(s_width, s_height); //OMG! This works!
		/* Here is >how< this works. Notice we are extending class GameEngine. The constructor
		 * in this class, builds on the constructor in the superclass. The constructor in the
		 * superclass still require some arguments to be passed. We do this with super.
		 * Amazing that I would finally understand how this shit works!
		 */
	}
	
	
	
	
	
	@Override //Not sure why I need this. Things seem to work fine without it...
	public void eventHandler(){ //This totally overrides the method in the superclass and redefines it.
		super.eventHandler(); //This is so that we can keep what's in the original eventHandler-method.
		
		while( Mouse.next() ){ //This function is going through a buffer that holds button events. When cycled once, I don't think you can go back and retrieve earlier events.
			if( Mouse.getEventButton() == 1 && Mouse.getEventButtonState()){ //Notice that getEventButtonState returns true if the button has been pressed
				System.out.println("Pressed: right mouse button at x: "+ Mouse.getX() + ", y: " + Mouse.getY());
			}
			if( Mouse.getEventButton() == 2 && !Mouse.getEventButtonState()){ //Notice that getEventButtonState returns false if the button has been released
				System.out.println("Released: middle mouse button at x: "+ Mouse.getX() + ", y: " + Mouse.getY());
			}
		}
		
		if( Mouse.isButtonDown(0) ){
			System.out.println("Holding: Left mouse at x: "+ Mouse.getX() + ", y: " + Mouse.getY());
		}
		
		
		
		while( Keyboard.next() ){ //This function is going through a buffer that holds key events. When cycled once, I don't think you can go back and retrieve earlier events.
			if( Keyboard.getEventKey() == Keyboard.KEY_ESCAPE && !Keyboard.getEventKeyState() ){
				System.out.println("Please shut down!");
				isrunning = false; //This is a variable that can be found in GameEngine class.
			}
			if( Keyboard.getEventKey() == Keyboard.KEY_R && Keyboard.getEventKeyState()){ //Notice that getEventKeyState returns true if the button has been pressed
				System.out.println("Pressed r!");
			}
			if( Keyboard.getEventKey() == Keyboard.KEY_P && !Keyboard.getEventKeyState()){ //Notice that getEventKeyState returns false if the button has been released
				System.out.println("Released p!");
			}
		}
		
		if( Keyboard.isKeyDown(Keyboard.KEY_A) ){
			System.out.println("Holding a!");
		}
		
		if( Keyboard.isKeyDown(Keyboard.KEY_B) ){
			System.out.println("Holding b!");
		}
		
	}
	
	@Override //Might as well keep them. Apparently they do some good for the compiler.
	public void updateScene(){
		//TODO: Write code here!
	}
	
	@Override
	public void drawScene(){
		//TODO: Write code here!
	}
	
	//No more code below unless for passing to the constructor!
	public static void main(String[] args){
		Game GameObject = new Game(800,600);
		GameObject.run();
		System.out.println("Program shut down successfully.");
	}
}
