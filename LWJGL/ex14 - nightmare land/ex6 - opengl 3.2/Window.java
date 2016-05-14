import java.nio.FloatBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Window implements Runnable{
	private int res_w, res_h, fps;
	private boolean fullscreen;
	private String title;
	private int TEMP_INT; //Store temporary values here to reduce function calls
	private boolean TEMP_BOOL; //Store temporary values here to reduce function calls
	private GlobalObjects GO;

	public Window(
			int resolution_width,
			int resolution_height,
			int set_fps,
			boolean set_fullscreen,
			String set_title,
			GlobalObjects globalobjects
			){
		res_w = resolution_width;
		res_h = resolution_height;
		fps = set_fps;
		fullscreen = set_fullscreen;
		title = set_title;
		GO = globalobjects;
	}
	
	private void WindowLoop(){
		
		float[] triangle = { //We define a triangle with vertex coordinates:
				 0.0f,  0.5f,  0.0f,
				-0.5f,  0.0f,  0.0f,
				 0.5f,  0.0f,  0.0f };
		int n_vertices = 3;
		FloatBuffer trianglebuffer = BufferUtils.createFloatBuffer(triangle.length); //Create a buffer of appropriate size
		trianglebuffer.put(triangle); //Send our triangle to the buffer
		trianglebuffer.flip();
		
		GO.VAO_ID = GL30.glGenVertexArrays(); //Create a new VAO in memory
		GL30.glBindVertexArray(GO.VAO_ID); //Now we 'select', or 'bind', it
		
		GO.VBO_ID = GL15.glGenBuffers(); //Create a new VBO in memory
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, GO.VBO_ID); //Select our buffer
		
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, trianglebuffer, GL15.GL_STATIC_DRAW);
		//"Put the VBO in the attributes list at index 0"
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0); //Deselect the VBO object
		GL30.glBindVertexArray(0); //Deselect the VAO object
		
		
		
		while( !Display.isCloseRequested() && !Thread.currentThread().isInterrupted() && !GO.kbQUIT() ){
			keyboardInput();
			mouseInput();
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); //Not sure what this does.
			GL30.glBindVertexArray(GO.VAO_ID); //Select our VAO
			GL20.glEnableVertexAttribArray(0); //Enable our VBO
			
			GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, n_vertices); //Draw our triangle
			
			GL20.glDisableVertexAttribArray(0); //Disable our VBO
			GL30.glBindVertexArray(0); //Deselect our VAO
			
			
			
			
			Display.update();
			Display.sync(fps); //If there's time spare time, function will wait to keep fps
		}
		
		//Cleanup:
		GL20.glDisableVertexAttribArray(0); //Disable VBO from VAO
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0); //Deselect our buffer
		GL15.glDeleteBuffers(GO.VBO_ID); //Delete the VBO
		
		GL30.glBindVertexArray(0); //Deselect VAO
		GL30.glDeleteVertexArrays(GO.VAO_ID);
		
		
		
	}
	
	@Override
	public void run(){
		create();
		try{ WindowLoop();
		}catch(Exception e){}
		destroy();
	}
	
	public void create(){
		try{ System.out.println("Creating window.");
			PixelFormat pixelformat = new PixelFormat();
			ContextAttribs contextattribs = new ContextAttribs(3,2)//Use OpenGL 3.2
				.withForwardCompatible(true)//Deprecated functionality will be removed
				.withProfileCore(true);//Set standard API (as of this writing, 2014-08-06)
			/* Following code is a mechanism to get a mode that support
			 * fullscreen. Creating a new one generates a default
			 * displaymode without fullscreen support. */
			DisplayMode displaymode = null;
			DisplayMode[] modes = Display.getAvailableDisplayModes();
			for(int i=0;i<modes.length;i++){
				if( modes[i].getWidth() == res_w &&
						modes[i].getHeight() == res_h &&
						modes[i].isFullscreenCapable() ){
					displaymode = modes[i]; //Assigning a displaymode supporting fullscreen
				}
			}/* Here the mechanism ends */
			Display.setDisplayMode(displaymode);
			Display.setFullscreen(fullscreen);
			Display.setTitle(title);
			Display.create(pixelformat, contextattribs);
		}catch(LWJGLException e){ e.printStackTrace(); System.exit(0); }
		
		GL11.glClearColor(0.3f, 0.9f, 0.4f, 0f); //Sets background color
		GL11.glViewport(0,0, res_w, res_h); //No idea what this does.
	}
	
	public void destroy(){
		System.out.println("Shutting down.");
		Display.destroy();
	}
	
	public void mouseInput(){
		GO.mouse_pos[0] = Mouse.getX(); //Assign mouse x position
		GO.mouse_pos[1] = Mouse.getY(); //Assign mouse y position
		GO.mouse_Dpos[0] = Mouse.getDX(); //Assign change in mouse x position
		GO.mouse_Dpos[1] = Mouse.getDY(); //Assign change in mouse y position
		if( Mouse.hasWheel() ){ GO.m_DWheel = Mouse.getDWheel(); } //Assign change in wheel position
		
		while( Mouse.next() ){
			TEMP_INT = Mouse.getEventButton(); //Store this value to reduce #function calls
			//if-statement guard against 'ArrayIndexOutOfBoundsException':
			if( (TEMP_INT >= 0) && (TEMP_INT < GO.n_buttonIDs) ){
				//If button is pressed and it isn't carrying a valid value
				if( Mouse.getEventButtonState() &&
						GO.mb_pr_evX[TEMP_INT] < 0 &&
						GO.mb_pr_evY[TEMP_INT] < 0 ){
					GO.mb_pr_evX[TEMP_INT] = Mouse.getEventX(); //Assign mouse button press event x position
					GO.mb_pr_evY[TEMP_INT] = Mouse.getEventY(); //Assign mouse button press event y position
				}
				//If button is released and it isn't carrying a valid value
				if( !Mouse.getEventButtonState() &&
						GO.mb_re_evX[TEMP_INT] < 0 &&
						GO.mb_re_evY[TEMP_INT] < 0 ){
					GO.mb_re_evX[TEMP_INT] = Mouse.getEventX(); //Assign mouse button release event x position
					GO.mb_re_evY[TEMP_INT] = Mouse.getEventY(); //Assign mouse button release event y position
				}
			}
		}
		
		for(int ID=0;ID<GO.n_buttonIDs;ID++){
			TEMP_BOOL = Mouse.isButtonDown(ID); //Store this value to reduce #function calls
			if		( TEMP_BOOL && !GO.mb_hold[ID] ) GO.mb_hold[ID] = true; //If set to false, yet held, set to true
			else if	( !TEMP_BOOL && GO.mb_hold[ID] ) GO.mb_hold[ID] = false; //If set to true, yet not held, set to false
		}
	}
	
	public void keyboardInput(){
		while( Keyboard.next() ){
			//if-statement guard against 'ArrayIndexOutOfBoundsException':
			if( (Keyboard.getEventKey() >= 0) && (Keyboard.getEventKey() < GO.n_keyIDs) ){
				if( Keyboard.getEventKeyState() ){ //If key is pressed:
					GO.key_pr[Keyboard.getEventKey()]++; //Increment the press event counter for keyID.
				}else{ //If key is released:
					GO.key_re[Keyboard.getEventKey()]++; //Increment the release event counter for keyID.
				}
			}
		}
		
		for(int ID=0;ID<GO.n_keyIDs;ID++){
			if( GO.key_pr[ID] > GO.key_re[ID] ){ //Since we logically can't have more releases than presses,
				GO.key_hold[ID] = true; //if we got more presses than releases, we are holding a button
			}else{
				GO.key_hold[ID] = false; //Otherwise, the button is inactive
			}
		}
	}
}