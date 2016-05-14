import java.awt.*;
import javax.swing.JFrame;

class ex9 extends JFrame{
	public static void main(String args[]){
		DisplayMode dm = new DisplayMode(
				480,		//Resolution height
				320,		//Resolution width
				16,		//Color depth
				DisplayMode.REFRESH_RATE_UNKNOWN //Refresh rate. We don't know what our rate is so we pass this argument...
				);
		
		ex9 myObject = new ex9();
		myObject.run(dm);
	}
	
	public void run(DisplayMode displaymode){
		setBackground(Color.BLUE);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 36));
		
		ex9extra screen = new ex9extra();
		try{
			screen.setFullScreen(displaymode, this);
			/* 'this' is a reference to the object we're working on.
			 * In this case, myObject of class ex9 extends JFrame
			 * It's kind of magic to me why this works. We're going
			 * to have to play around more with 'this'
			 */
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
		}finally{
			screen.restoreScreen();
		}
	}
	public void paint(Graphics graphics){
		graphics.drawString("Hello world!", 240, 160);
	}
}