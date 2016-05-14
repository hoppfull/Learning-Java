package src.engine;

import src.window.Window;
import src.window.Input;
import src.utilities.mathematics.mat4;
import src.utilities.mathematics.vec3;
import src.utilities.mathematics.Linalg;
import src.utilities.resourceloaders.ShaderLoader;
import src.utilities.resourceloaders.objLoader;
import src.opengl.Shader;
import src.opengl.Mesh;
import src.opengl.Renderer;
import src.engine.objects.Pivot;
import src.engine.objects.WorldGrid;

public class Game{
	private Shader shader;
	private Mesh mesh;
	private mat4 projM;
	private Pivot pivot;
	
	public Game(){
		pivot = new Pivot();
		
		mesh = objLoader.load("box2.obj");
		String vs_source = ShaderLoader.load("vertex_shader.GLSL");
		String fs_source = ShaderLoader.load("fragment_shader.GLSL");
		
		projM = new mat4();
		projM.setProjection(
				Window.getWidth(),
				Window.getHeight(),
				0.1, 1000, 0.3);//zNear, zFar, fov angle 1 * pi
		
		pivot.setPos(new vec3(0,5,0));
		
		shader = new Shader();
		shader.addVertexShader(vs_source);
		shader.addFragmentShader(fs_source);
		shader.compileShader();
		
		shader.addUniform("transform");
	}
	
	public void update(){
		if(Input.isKbDown(17)){//key_w
			pivot.rotate(0, 0.01);
		}
		if(Input.isKbDown(31)){//key_s
			pivot.rotate(0,-0.01);
		}
		if(Input.isKbDown(30)){//key_a
			pivot.rotate(1,-0.01);
		}
		if(Input.isKbDown(32)){//key_d
			pivot.rotate(1, 0.01);
		}
		if(Input.isKbDown(16)){//key_q
			pivot.rotate(2, 0.01);
		}
		if(Input.isKbDown(18)){//key_e
			pivot.rotate(2,-0.01);
		}
		
		shader.setUniformMat4("transform", Linalg.MatrixMult(
				projM,
				WorldGrid.apply(pivot.getPivot())
				));
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