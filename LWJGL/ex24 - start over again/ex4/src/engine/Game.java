package src.engine;

import src.window.Input;
import src.utilities.mathematics.vec3;
import src.utilities.resourceloaders.ShaderLoader;
import src.utilities.resourceloaders.objLoader;
import src.opengl.Shader;
import src.opengl.Mesh;
import src.opengl.Renderer;
import src.engine.objects.Pivot;
import src.engine.objects.FreeCam;

public class Game{
	private Shader shader;
	private Mesh mesh;
	private Pivot pivot;
	private FreeCam Cam;
	
	public Game(){
		pivot = new Pivot();
		pivot.setPos(new vec3(0,0,0));
		Cam = new FreeCam(new vec3(0,0,-5), 0.1, 1000, 0.2);
		
		mesh = objLoader.load("box2.obj");
		String vs_source = ShaderLoader.load("vertex_shader.GLSL");
		String fs_source = ShaderLoader.load("fragment_shader.GLSL");
		
		shader = new Shader();
		shader.addVertexShader(vs_source);
		shader.addFragmentShader(fs_source);
		shader.compileShader();
		
		shader.addUniform("transform");
	}
	
	public void update(){
		if(Input.isKbDown(17)){//key_w
			Cam.move(2, 0.03);
		}
		if(Input.isKbDown(31)){//key_s
			Cam.move(2,-0.03);
		}
		if(Input.isKbDown(30)){//key_a
			Cam.move(0,-0.03);
		}
		if(Input.isKbDown(32)){//key_d
			Cam.move(0, 0.03);
		}
		if(Input.isKbDown(44)){//key_z
			Cam.move(1, 0.03);
		}
		if(Input.isKbDown(45)){//key_x
			Cam.move(1,-0.03);
		}
		if(Input.isKbDown(16)){//key_q
			Cam.rotate(1,-0.005);
		}
		if(Input.isKbDown(18)){//key_e
			Cam.rotate(1, 0.005);
		}
		if(Input.isKbDown(200)){//key_up
			Cam.rotate(0, 0.005);
		}
		if(Input.isKbDown(208)){//key_down
			Cam.rotate(0,-0.005);
		}
		if(Input.isKbDown(205)){//key_right
			Cam.rotate(2,-0.005);
		}
		if(Input.isKbDown(203)){//key_left
			Cam.rotate(2, 0.005);
		}
		
		shader.setUniformMat4( "transform", Cam.getView().x(pivot.getPivot()) );
	}
	
	public void render(){
		shader.useProgram();
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