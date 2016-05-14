package src.engine;

import src.window.Window;
import src.window.Input;
import src.opengl.Renderer;

class EngineUpdate{
	private static Game game;
	
	public static void start(){ //Runs once
		Window.create(800, 600, "3D-engine");
		Renderer.setDefaults();
		game = new Game();
	}
	
	public static void logic(){ //Runs with frequency
		Input.updateInputEvents();
		game.update();
		Input.clearInputEvents();
	}
	
	public static void render(){ //Runs with frequency
		Renderer.clearScreen();
		game.render();
		Window.update();
	}
}