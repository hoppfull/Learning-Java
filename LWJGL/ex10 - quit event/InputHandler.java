import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;

class InputHandler{
	private int keyboard_allocation = 300; //Amount of keyboard KeyIDs we want to be able to use
	public int[] keyboard_events = new int[keyboard_allocation];
	private int mouse_allocation = 10; //Amount of mouse ButtonIDs we want to be able to use
	public int[] mouse_events = new int[mouse_allocation];
	
	public int[] mouseEvents(){
		for(int i=0; i<mouse_allocation; i++){
			if( mouse_events[i] == 1 ){ mouse_events[i] = 2; }
			//If button is marked as "pressing" (1) from previous loop, mark it as "held" (2)
			else if( mouse_events[i] == 3 ){ mouse_events[i] = 0; }
			//If button is marked as "releasing" (3) from previous loop, mark it as "inactive" (0)
		}
		
		while( Mouse.next() ){
			//if-statement guard against 'ArrayIndexOutOfBoundsException':
			if( (Mouse.getEventButton() >= 0) && (Mouse.getEventButton() < mouse_allocation)){
				mouse_events[Mouse.getEventButton()] = Mouse.getEventButtonState() ? 1 : 3;
			}//Button is marked "pressing" (1), or "releasing" (3) based on user activity
		}
		return mouse_events;
	}
	
	public int[] keyboardEvents(){
		for(int i=0; i<keyboard_allocation; i++){
			if( keyboard_events[i] == 1 ){ keyboard_events[i] = 2; }
			//If key is marked as "pressing" (1) from previous loop, mark it as "held" (2)
			else if	( keyboard_events[i] == 3 ){ keyboard_events[i] = 0; }
			//If key is marked as "releasing" (3) from previous loop, mark it as "inactive" (0)
		}
		
		while( Keyboard.next() ){
			//if-statement guard against 'ArrayIndexOutOfBoundsException':
			if( (Keyboard.getEventKey() >= 0) && (Keyboard.getEventKey() < keyboard_allocation)){
				keyboard_events[Keyboard.getEventKey()] = Keyboard.getEventKeyState() ? 1 : 3;
			}//Key is marked "pressing" (1), or "releasing" (3) based on user activity
		}
		return keyboard_events;
	}
}