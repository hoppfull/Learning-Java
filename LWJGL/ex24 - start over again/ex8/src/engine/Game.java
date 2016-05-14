package src.engine;

import src.window.Input;
import src.utilities.mathematics.vec3;
import src.utilities.mathematics.vec2;
import src.utilities.mathematics.Vertex;
import src.utilities.resourceloaders.objLoader;
import src.utilities.resourceloaders.texLoader;
import src.opengl.shaders.PhongShader;
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
	private PhongShader shader;
	private Material mat_basic001;
	
	public Game(){
		triangle = new Vertex[]{
				new Vertex(new vec3( 0  , 0  , 0  ), new vec2( 0, 0)),
				new Vertex(new vec3( 0  , 0  ,-1  ), new vec2( 1, 0)),
				new Vertex(new vec3( 1  , 0  , 0  ), new vec2( 1, 1)),
				new Vertex(new vec3( 0  , 1  , 0  ), new vec2( 0, 1))
		};
		
		indices = new int[]{
				0,1,2,
				1,0,3,
				2,3,0,
				3,2,1
		};
		
		mat_basic001 = new Material();
		mat_basic001.setDiffuseColor(new vec3(0.5,1,0.8));
//		mat_basic001.setDiffuseTexture("default.png");
//		mat_basic001.getDiffuseTexture().bind();
		
		mesh = new Mesh(triangle, indices, true);
		pivot = new Pivot();
		camera = new FreeCam(new vec3(0,0,-5), 0.1, 1000, 0.2);
		
		shader = PhongShader.getInstance();
		shader.setLightAmbient(new vec3(0.3,0.3,0.3));
	}
	
	public void update(){
		if(Input.isKbDown(17)){ camera.move(2, 0.03); }
		if(Input.isKbDown(31)){ camera.move(2,-0.03); }
		if(Input.isKbDown(30)){ camera.move(0,-0.03); }
		if(Input.isKbDown(32)){ camera.move(0, 0.03); }
		if(Input.isKbDown(44)){ camera.move(1,-0.03); }
		if(Input.isKbDown(45)){ camera.move(1, 0.03); }
		if(Input.isKbDown(16)){ camera.rotate(1,-0.003); }
		if(Input.isKbDown(18)){ camera.rotate(1, 0.003); }
		
		shader.update(camera.getView(), pivot.getPivot(), mat_basic001);
	}
	
	public void render(){
		shader.render();
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