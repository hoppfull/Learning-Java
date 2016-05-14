package src.engine;

import src.window.Input;
import src.utilities.mathematics.vec3;
import src.utilities.mathematics.vec2;
import src.utilities.mathematics.Vertex;
import src.utilities.resourceloaders.objLoader;
import src.utilities.resourceloaders.texLoader;
import src.opengl.shaders.BasicShader;
import src.opengl.Mesh;
import src.opengl.Renderer;
import src.opengl.Material;
import src.engine.objects.Pivot;
import src.engine.objects.FreeCam;

public class Game{
	private Mesh mesh;
	private Vertex[] triangle;
	private int[] indices;
	private Pivot pivot;
	private FreeCam camera;
	private BasicShader basicshader;
	private Material mat_basic001;
	
	public Game(){
		triangle = new Vertex[]{
				new Vertex(new vec3( 0, 1, 0), new vec2( 0.5, 0)),
				new Vertex(new vec3(-1,-1, 0), new vec2( 0, 1)),
				new Vertex(new vec3( 1,-1, 0), new vec2( 1, 1))
		};
		
		indices = new int[]{
				0,2,1
		};
		
		mat_basic001 = new Material();
		mat_basic001.setDiffuseTexture("default.png");
		mat_basic001.getDiffuseTexture().bind();
		
		mesh = new Mesh(triangle, indices);
		pivot = new Pivot();
		camera = new FreeCam(new vec3(0,0,-5), 0.1, 1000, 0.2);
		
		basicshader = BasicShader.getInstance(); //This is a so called "singleton"
	}
	
	public void update(){
		basicshader.update(pivot.getPivot(), camera.getView(), mat_basic001);
	}
	
	public void render(){
		basicshader.render();
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