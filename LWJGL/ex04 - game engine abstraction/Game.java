//import org.lwjgl.LWJGLException;
//import org.lwjgl.opengl.Display;
//import org.lwjgl.opengl.DisplayMode;

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
		//TODO: Write code here!
	}
	
	@Override //Might as well keep them. Seems like they do some good for the compiler.
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
		System.out.println("Program shut down successfully!");
	}
}
