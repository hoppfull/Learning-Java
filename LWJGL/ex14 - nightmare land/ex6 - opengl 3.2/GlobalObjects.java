import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GlobalObjects{
	/* Here we declare variables that can be initialized from Main class
	 * and then used by other classes, functions and threads.
	 */
	public int VAO_ID; //Pointer to VAO
	public int VBO_ID; //Pointer to VBO
	
	
	
	public int n_keyIDs; //Range of available keyIDs
	//Each element in arrays represent a keyID.
	//Value of each element represent how many unused events.
	public int[] key_pr; //Press events
	public int[] key_re; //Release events
	public boolean[] key_hold; //holding?
	
	public int n_buttonIDs; //Range of available buttonIDs
	//Each element in arrays represent a buttonID.
	//Value of each element represent how many unused events.
	public int[] mb_pr_evX; //MB-press event, x-position - Must be cleared before entering new value
	public int[] mb_pr_evY; //MB-press event, y-position - Must be cleared before entering new value
	public int[] mb_re_evX; //MB-release event, x-position - Must be cleared before entering new value
	public int[] mb_re_evY; //MB-release event, y-position - Must be cleared before entering new value
	public boolean[] mb_hold; //holding?
	public int[] mouse_pos; //Absolute mouse position
	public int[] mouse_Dpos; //Relative mouse position to last position
	public int m_DWheel; //Relative mouse wheel ...position?
	
	public GlobalObjects(){ //We initialize variables it this constructor:
		//Initialize variables for keyboard:
		n_keyIDs = 300; //range of keyID values
		key_pr = new int[n_keyIDs]; //Keyboard press events
		key_re = new int[n_keyIDs]; //Keyboard release events
		key_hold = new boolean[n_keyIDs];
		//Initialize variables for mouse:
		n_buttonIDs = 5; //Range of buttonID values
		//Initializing following four arrays with value -1
		mb_pr_evX = new int[n_buttonIDs]; for(int i=0;i<n_buttonIDs;i++) mb_pr_evX[i] = -1;
		mb_pr_evY = new int[n_buttonIDs]; for(int i=0;i<n_buttonIDs;i++) mb_pr_evY[i] = -1;
		mb_re_evX = new int[n_buttonIDs]; for(int i=0;i<n_buttonIDs;i++) mb_re_evX[i] = -1;
		mb_re_evY = new int[n_buttonIDs]; for(int i=0;i<n_buttonIDs;i++) mb_re_evY[i] = -1;
		mb_hold = new boolean[n_buttonIDs];
		mouse_pos = new int[2]; //Absolute mouse position
		mouse_Dpos = new int[2]; //Relative mouse position
		m_DWheel = 0; //Relative mouse wheel position
	}
	
	public boolean kbQUIT(){
		//true if KEY_ESCAPE has been pressed and released atleast once
		return key_re[1] > 0;
	}
}