import java.util.Arrays;

class Main{
	GLEngine glengine = new GLEngine(800, 600);
	InputHandler inputhandler = new InputHandler();
	
	public int[] mouse_events = inputhandler.buttonmap;
	public int[] keyboard_events = inputhandler.keymap;
	
	public Main(){
		//Constructor
	}
	
	
	
	
	
	
	
	
	
	public void mainLoop(){
		while( !glengine.isCloseRequested() && keyboard_events[0] != 3){
			mouse_events = inputhandler.mouseEvents();
			keyboard_events = inputhandler.keyboardEvents();
			glengine.applyScreen();
			if(mouse_events[0] == 1){System.out.println("Pressed l_mouse!");}
			if(mouse_events[0] == 3){System.out.println("Released l_mouse!");}
			if(mouse_events[1] == 1){System.out.println("Pressed r_mouse!");}
			if(mouse_events[1] == 3){System.out.println("Released r_mouse!");}
			if(mouse_events[2] == 1){System.out.println("Pressed m_mouse!");}
			if(mouse_events[2] == 3){System.out.println("Released m_mouse!");}
		}
	}
	
	public void run(){
		glengine.initOpenGL();
		mainLoop();
		glengine.exitOpenGL();
	}
	
	public static void main(String[] args){
		Main application = new Main();
		application.run();
	}
}