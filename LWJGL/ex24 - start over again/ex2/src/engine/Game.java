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

public class Game{
	private Shader shader;
	private Mesh mesh;
	private mat4 projectionMatrix;
	private mat4 scaleMatrix;
	private mat4 translationMatrix;
	private mat4 transformMatrix;
	private mat4 finalMatrix;
	
	public Game(){
		mesh = objLoader.load("object.obj");
		String vs_source = ShaderLoader.load("vertex_shader.GLSL");
		String fs_source = ShaderLoader.load("fragment_shader.GLSL");
		
		projectionMatrix = new mat4();
		projectionMatrix.setProjection(
				Window.getWidth(),
				Window.getHeight(),
				0.1, 1000, 0.3);
		
		scaleMatrix = new mat4();
		
		translationMatrix = new mat4();
		translationMatrix.setTransform(new vec3(1,0,0), 0, new vec3(0.5,0,5));
		
		transformMatrix = new mat4();
		transformMatrix.setIdentity();
		
		finalMatrix = new mat4();
		finalMatrix.setIdentity();
		
		shader = new Shader();
		shader.addVertexShader(vs_source);
		shader.addFragmentShader(fs_source);
		shader.compileShader();
		
		shader.addUniform("transform");
	}
	
	public void update(){
		transformMatrix.setTransform(new vec3(0,1,0), 0.005, new vec3(0,0,0));
		
		
		finalMatrix = Linalg.MatrixMult(finalMatrix, transformMatrix);
		shader.setUniformMat4("transform",
				Linalg.MatrixMult(
						projectionMatrix,
				Linalg.MatrixMult(
						translationMatrix,
						finalMatrix
				)));
	}
	
	public void render(){
		shader.useProgram();
		Renderer.drawMesh(mesh);
	}
}