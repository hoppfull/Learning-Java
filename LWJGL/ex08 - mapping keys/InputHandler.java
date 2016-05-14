import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import java.util.Arrays;


public class InputHandler{
	/* First we create an array with 300 allocated elements.
	 * Each element represent a keyboard key element. Escape
	 * is 1, a is 30, q is 16 I think. And later we assign
	 * a value to tell us how that key is behaving.
	 * '0' Means the key isn't being used.
	 * '1' Means the key has been pressed down. A one-time event.
	 * '2' Means the key is being held down. A continous event.
	 * '3' Means the key has been released. */
	private int keymap_allocation = 300;
	private int[] keymap = new int[keymap_allocation];
	
	public int[] buttonmap= { // 0 = not pressed, 1 = pressed, 2 = held, 3 = released
			0,	// 0: Left mouse button
			0,	// 1: Right mouse button
			0	// 2: Middle mouse button
	};
	
	public InputHandler(){
	}
	
	public int[] mouseEvents(){
		Arrays.fill(buttonmap, 0); //Resetting buttonmap
		//Following code generate one event per button press or button release
		while( Mouse.next() ){
			if( Mouse.getEventButton() == 0 ){
				buttonmap[0] = ( Mouse.getEventButtonState() ) ? 1 : 3; }
			if( Mouse.getEventButton() == 1 ){
				buttonmap[1] = ( Mouse.getEventButtonState() ) ? 1 : 3; }
			if( Mouse.getEventButton() == 2 ){
				buttonmap[2] = ( Mouse.getEventButtonState() ) ? 1 : 3; }
			/* Here is how this works: while( Mouse.next() ) cycle through a buffer with a list
			 * of mouse button events. When it has cycled through them, I don't think you can go
			 * back again. So when the loop comes back for another round, it checks what buttons
			 * were pressed while the loop was busy. This way we don't loose anything if a button
			 * is pressed but the loop isn't there in time to check if it's pressed. Also this way
			 * we get single events for each press and release respectively.
			 * 
			 * Mouse.getEventButtonState returns true if event is a button press
			 * and returns false if event is a button release.
			 */
		}
		//Following code generate one event per frame while buttons are held
		if( Mouse.isButtonDown(0) && buttonmap[0] == 0){ buttonmap[0] = 2; }
		if( Mouse.isButtonDown(1) && buttonmap[1] == 0){ buttonmap[1] = 2; }
		if( Mouse.isButtonDown(2) && buttonmap[2] == 0){ buttonmap[2] = 2; }
		
		return buttonmap;
	}
	
	public void keyboardEvents(){
		for(int i=0; i<keymap_allocation; i++){
			if		( keymap[i] == 1 ){ keymap[i] = 2; }
			else if	( keymap[i] == 3 ){ keymap[i] = 0; }
		}
		
		while( Keyboard.next() ){
			keymap[Keyboard.getEventKey()] = Keyboard.getEventKeyState() ? 1 : 3;
		}
	}
}