class Main{
	Thread GEthread = new Thread(new GraphicsEngine(
			800,	//Resolution width
			600,	//Resolution height
			25		//Maximum FPS
			));
	
	public void run(){
		GEthread.start();
		GEthread.interrupt();
	}
	
	public static void main(String[] args){
		Main application = new Main();
		application.run();
	}
}
