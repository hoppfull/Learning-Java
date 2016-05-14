package src.engine;

import src.window.Window;
import src.utilities.time.Synchronizer;
import src.utilities.time.Frequencer;

public class GameEngine{
	private static boolean isRunning = false;
	private static Synchronizer loop = new Synchronizer(200);
	private static Frequencer logic = new Frequencer(60);
	private static Frequencer render = new Frequencer(25);
	
	private static void start(){
		if( isRunning ) return;
		isRunning = true;
		EngineUpdate.start();
	}
	
	public static void run(){
		start();
		mainLoop();
		close();
	}
	
	public static void stop(){
		if( !isRunning ) return;
		isRunning = false;
	}
	
	private static void mainLoop(){
		while( isRunning )
		{
			if( !logic.skip() ) EngineUpdate.logic();
			
			if( !render.skip() ) EngineUpdate.render();
			
			loop.sync();
			if( Window.isCloseRequested() ) stop();
		}
	}
	
	private static void close(){
		Window.close();
	}
}