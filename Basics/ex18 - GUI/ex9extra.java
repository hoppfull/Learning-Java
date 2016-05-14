import java.awt.*;
import javax.swing.JFrame;

class ex9extra{
	private GraphicsDevice video_card;
	/* The video_card variable gives us access to our videocard.
	 */
	
	public ex9extra(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		video_card = env.getDefaultScreenDevice();
		/* The video_env variable will hold information about our system
		 * I think. In order to get an interface to our graphics card,
		 * we assign it to the video_card variable. After that I think
		 * we have access to our graphics card.
		 */
	}
	
	public void setFullScreen(DisplayMode displaymode, JFrame jframe){
		jframe.setUndecorated(true);
		jframe.setResizable(false);
		
		video_card.setFullScreenWindow(jframe);
		
		if(displaymode != null && video_card.isDisplayChangeSupported()){
			try{
				video_card.setDisplayMode(displaymode);
			}catch(Exception e){}
		}
	}
	
	public Window getFullScreenWindow(){
		return video_card.getFullScreenWindow();
	}
	
	public void restoreScreen(){
		Window w = video_card.getFullScreenWindow();
		if(w != null){
			w.dispose();
		}
		video_card.setFullScreenWindow(null);
	}
	
}