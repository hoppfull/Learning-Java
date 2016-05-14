import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import java.util.Arrays;

public class InputHandler{
	public int[] keymap = { // 0 = not pressed, 1 = pressed, 2 = held, 3 = released
			0	// 0: KEY_ESCAPE
	};
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
				buttonmap[0] = ( Mouse.getEventButtonState() ) ? 1 : 3;
			}
			if( Mouse.getEventButton() == 1 ){
				buttonmap[1] = ( Mouse.getEventButtonState() ) ? 1 : 3;
			}
			if( Mouse.getEventButton() == 2 ){
				buttonmap[2] = ( Mouse.getEventButtonState() ) ? 1 : 3;
			}
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
		if( Mouse.isButtonDown(0) ){
			//System.out.println("Holding l_mouse!");
		}
		if( Mouse.isButtonDown(1) ){
			//System.out.println("Holding r_mouse!");
		}
		if( Mouse.isButtonDown(2) ){
			//System.out.println("Holding m_mouse!");
		}
		
		return buttonmap;
	}
	public int[] keyboardEvents(){
		Arrays.fill(keymap, 0); //Resetting keymap
		//Following code generate one event per button press or button release
		while( Keyboard.next() ){
			if( Keyboard.getEventKey() == Keyboard.KEY_ESCAPE && Keyboard.getEventKeyState() ){
				keymap[0] = 1; /**keymap for KEY_ESCAPE is set to pressed*/
			}
			if( Keyboard.getEventKey() == Keyboard.KEY_ESCAPE && !Keyboard.getEventKeyState() ){
				keymap[0] = 3; /**keymap for KEY_ESCAPE is set to released*/
			}
		}
		//Following code generate one event per frame while buttons are held
		if( Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) ){
			keymap[0] = 2; /**keymap for KEY_ESCAPE is set to held*/
		}
		
		return keymap;
	}
}