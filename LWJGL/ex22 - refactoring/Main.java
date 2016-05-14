class Main{ /**Everything is run from here*/
	private boolean isRunning; //Is program supposed to be running?
	
	private Time main_timer = new Time();	//Timer for mainLoop
	private Time logic_timer = new Time();	//Timer for logicUpdate
	private Time render_timer = new Time();	//Timer for renderUpdate
	
	Mesh mesh;
	Shader shader;
	float temp_size = 1;
	
	public Main(){
		Window.create(800, 600, "3D-engine"); //Has to be in constructor or Mesh class will fail!
		
		Vertex[] vertices = new Vertex[]{
				new Vertex(new vec3( 0.0, 1.0, 0.0)),
				new Vertex(new vec3(-1.0,-1.0, 0.0)),
				new Vertex(new vec3( 1.0,-1.0, 0.0)),
				new Vertex(new vec3( 0.0, 0.0,-0.3))
		};
		
		int[] indices = new int[]{
				0,1,2,
				0,1,3,
				1,2,3,
				2,0,3
		};
		
		
		mesh = new Mesh(vertices, indices);
		
		shader = new Shader();
		shader.addVertexShader(Utilities.loadShader("vertex_shader.GLSL"));
		shader.addFragmentShader(Utilities.loadShader("fragment_shader.GLSL"));
		
		shader.compileShader();
		shader.addUniform("scale");
	}
	
	public void start(){
		/*Starts application*/
		if(isRunning) return;
		isRunning = true;
		Renderer.setDefaults();
		mainLoop();
	}
	
	private void stop(){
		/*Stops application*/
		if(!isRunning) return;
		isRunning = false;
	}
	
	private void mainLoop(){
		/*Keeps application running*/
		int mainLoop_FPS = 200;
		
		while(isRunning){
			main_timer.setT1();
			
			
			runLogicUpdate(40); //Pass 40 as update rate to method
			
			runRenderUpdate(30); //Pass 30 as update rate to method
			
			
			main_timer.setT2();
			try{
				if((1E3 / mainLoop_FPS) > main_timer.getDelta())
					Thread.sleep((int)((1E3 / mainLoop_FPS) - main_timer.getDelta()));
			}catch(Exception e){ e.printStackTrace(); }
			
			if(Window.isCloseRequested()) stop();
		}
		close();
	}
	
	private void runLogicUpdate(int FPS){ //TODO: nothing!
		/*Keeps logic updaterate*/
		logic_timer.setT2();
		if( logic_timer.getDelta() > (1E3 / FPS) ){
			logicUpdate(logic_timer.getDelta());
			logic_timer.setT1();
		}
	}
	
	private void runRenderUpdate(int FPS){ //TODO: nothing!
		/*Keeps render updaterate*/
		render_timer.setT2();
		if( render_timer.getDelta() > (1E3 / FPS) ){
			renderUpdate(render_timer.getDelta());
			render_timer.setT1();
		}
	}
	
	private void logicUpdate(double ms_since_last_update){
		/*Updates application logic*/
		Window.updateInputEvents();
		if(Window.getKbEvent(1, 2)){//KeyID and KeyState
			System.out.println("Released!");
			stop();
		}
		//if(Window.isKbDown(16)) temp_size += 0.02; //KeyID: q
		//if(Window.isKbDown(30)) temp_size -= 0.02; //KeyID: a
		
		shader.setUniformf("scale", temp_size);
		Window.clearInputEvents();
	}
	
	private void renderUpdate(double ms_since_last_update){
		/*Updates application rendering*/
		Renderer.clearScreen();
		shader.useProgram();
		Renderer.drawMesh(mesh);
		Window.render();
	}
	
	private void close(){
		/*Close and clean up after application*/
		Window.close();
	}
	
	public static void main(String[] args){
		/*Java runs this first of all*/
		Main application = new Main();
		application.start();
	}
	
}