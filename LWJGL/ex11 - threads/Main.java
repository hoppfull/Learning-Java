class Main{
	Thread GEthread = new Thread(new GraphicsEngine());
	
	public void run(){
		GEthread.run();
		System.out.println("Hello");
	}
	
	public static void main(String[] args){
		Main application = new Main();
		application.run();
	}
}

/* I start over becouse I realised I had problems with basing my
 * event handling on frame update. So I thought I should base my
 * app on threads. This way we can keep several program loops.
 */

/* These appears to be the basics of multithreading.
 * Amazing!
 */
 
// This is me from about two years into the future. You're not ready son.