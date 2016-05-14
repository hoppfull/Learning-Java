package src.engine;

import src.utilities.mathematics.Vertex;
import src.utilities.mathematics.vec3;
import src.utilities.resourceloaders.ShaderLoader;
import src.opengl.Shader;
import src.opengl.Mesh;
import src.opengl.Renderer;

public class Game{
	private Shader shader;
	private Mesh mesh;
	
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
		
		mesh = new Mesh(vertices, indices);
		
		String vs_source = ShaderLoader.load("vertex_shader.GLSL");
		String fs_source = ShaderLoader.load("fragment_shader.GLSL");
		
		shader = new Shader();
		shader.addVertexShader(vs_source);
		shader.addFragmentShader(fs_source);
		shader.compileShader();
	}
	
	public void update(){
	}
	
	public void render(){
		Renderer.drawMesh(mesh);
	}
}