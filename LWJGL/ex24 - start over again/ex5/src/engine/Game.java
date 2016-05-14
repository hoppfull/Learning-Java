package src.engine;

import src.window.Input;
import src.utilities.mathematics.vec3;
import src.utilities.mathematics.vec2;
import src.utilities.mathematics.Vertex;
import src.utilities.resourceloaders.ShaderLoader;
import src.utilities.resourceloaders.objLoader;
import src.utilities.resourceloaders.texLoader;
import src.opengl.Shader;
import src.opengl.Mesh;
import src.opengl.Renderer;
import src.opengl.Texture;
import src.engine.objects.Pivot;
import src.engine.objects.FreeCam;

public class Game{
	private Shader shader;
	private Mesh mesh;
	private Vertex[] triangle;
	private int[] indices;
	private Texture texture;
	private Pivot pivot;
	private FreeCam camera;
	
	public Game(){
		triangle = new Vertex[]{
				new Vertex(new vec3( 0, 1, 0), new vec2( 0.5, 0)),
				new Vertex(new vec3(-1,-1, 0), new vec2( 0, 1)),
				new Vertex(new vec3( 1,-1, 0), new vec2( 1, 1))
		};
		
		indices = new int[]{
				0,2,1
		};
		
		texture = texLoader.load("default.png");
		
		mesh = new Mesh(triangle, indices);
		pivot = new Pivot();
		camera = new FreeCam(new vec3(0,0,-5), 0.1, 1000, 0.2);
		
		
		
		String vs_source = ShaderLoader.load("vertex_shader.GLSL");
		String fs_source = ShaderLoader.load("fragment_shader.GLSL");
		shader = new Shader();
		shader.addVertexShader(vs_source);
		shader.addFragmentShader(fs_source);
		shader.compileShader();
		shader.addUniform("transform");
	}
	
	public void update(){
		
		shader.setUniformMat4( "transform", camera.getView().x(pivot.getPivot()) );
	}
	
	public void render(){
		shader.useProgram();
		texture.bind();
		Renderer.drawMesh(mesh);
	}
}
/**Good to know!:
 * KEY_Q = 16
 * KEY_A = 30
 * KEY_Z = 44
 * KEY_UP = 200
 * KEY_LEFT = 203
 * KEY_DOWN = 208
 * KEY_RIGHT = 205
 */