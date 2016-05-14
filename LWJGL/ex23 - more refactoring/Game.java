class Game{
	private Mesh mesh;
	private Shader shader;
	
	private mat4 TransformMatrix;
	private vec3 global_pos;
	private vec3 local_axis;
	private double turns;
	
	public Game(){
		Vertex[] vertices = new Vertex[]{
				new Vertex(new vec3( 0.0, 1.0, 0.0)),
				new Vertex(new vec3(-1.0,-1.0, 0.0)),
				new Vertex(new vec3( 1.0,-1.0, 0.0)),
				new Vertex(new vec3( 0.0, 0.0,-0.3))
		};
		
		int[] indices = new int[]{
				0,2,1,
				0,1,3,
				1,2,3,
				2,0,3
		};
		
		TransformMatrix = new mat4();
		global_pos = new vec3(0,0,0);
		local_axis = new vec3(0,1,0);
		turns = 0;
		
		mesh = new Mesh(vertices, indices);
		
		shader = new Shader();
		shader.addVertexShader(Utilities.loadShader("vertex_shader.GLSL"));
		shader.addFragmentShader(Utilities.loadShader("fragment_shader.GLSL"));
		
		shader.compileShader();
		shader.addUniform("transform");
	}
	
	public void update(){
		if(Window.isKbDown(203)){ //KEY_LEFT
			local_axis.rotateZ(0.01);
			turns += 0.01;
		}
		if(Window.isKbDown(205)){ //KEY_RIGHT
			local_axis.rotateZ(-0.01);
			turns -= 0.01;
		}
		if(Window.isKbDown(200)){ //KEY_UP
			global_pos = LinAlg.add(global_pos, LinAlg.scale(local_axis, 0.02));
		}
		if(Window.isKbDown(208)){ //KEY_DOWN
			global_pos = LinAlg.add(global_pos, LinAlg.scale(local_axis,-0.02));
		}
		
		TransformMatrix.setTransform(new vec3(0,0,1), turns, global_pos);
		
		shader.setUniformMat4("transform", TransformMatrix);
	}
	
	public void render(){
		shader.useProgram();
		Renderer.drawMesh(mesh);
	}
}