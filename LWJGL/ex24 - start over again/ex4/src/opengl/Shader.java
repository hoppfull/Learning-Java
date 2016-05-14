package src.opengl;

import src.utilities.mathematics.vec3;
import src.utilities.mathematics.mat4;

import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;
import java.util.HashMap;

public class Shader{
	private int program;
	private HashMap<String, Integer> UniformList;
	
	public Shader(){
		program = GL20.glCreateProgram();
		UniformList = new HashMap<String, Integer>();
		
		if(program == 0){
			System.err.println("src.opengl.Shader error: 001"); System.exit(1); }
	}
	
	public void addUniform(String uniform_name){
		int uniform_pointer = GL20.glGetUniformLocation(program, uniform_name);
		
		if(uniform_pointer == -1){
			System.err.println("src.opengl.Shader error: 002"); System.exit(1); }
		
		UniformList.put(uniform_name, uniform_pointer);
	}
	
	public void setUniformi(String uniform_name, int value){
		GL20.glUniform1i(UniformList.get(uniform_name), value);
	}
	
	public void setUniformf(String uniform_name, float value){
		GL20.glUniform1f(UniformList.get(uniform_name), value);
	}
	
	public void setUniformVec3(String uniform_name, vec3 vector){
		GL20.glUniform3f(UniformList.get(uniform_name), (float)vector.getX(), (float)vector.getY(), (float)vector.getZ());
	}
	
	public void setUniformMat4(String uniform_name, mat4 matrix){
		GL20.glUniformMatrix4(UniformList.get(uniform_name), true,  matrix.getFloatBuffer());
	}
	
	public void useProgram(){ //benny calls it bind()
		GL20.glUseProgram(program);
	}
	
	public void addVertexShader(String shader_source){
		addProgram(shader_source, GL20.GL_VERTEX_SHADER);
	}
	
	public void addGeometryShader(String shader_source){
		addProgram(shader_source, GL32.GL_GEOMETRY_SHADER);
	}
	
	public void addFragmentShader(String shader_source){
		addProgram(shader_source, GL20.GL_FRAGMENT_SHADER);
	}
	
	public void compileShader(){
		GL20.glLinkProgram(program);
		
		if(GL20.glGetProgrami(program, GL20.GL_LINK_STATUS) == 0){
			System.err.println("src.opengl.Shader error: 003");
			System.err.println(GL20.glGetProgramInfoLog(program, 1024));
			System.exit(1); }
		
		GL20.glValidateProgram(program);
		
		if(GL20.glGetProgrami(program, GL20.GL_VALIDATE_STATUS) == 0){
			System.err.println("src.opengl.Shader error: 004");
			System.err.println(GL20.glGetProgramInfoLog(program, 1024));
			System.exit(1); }
	}
	
	private void addProgram(String shader_source, int type){
		int shader = GL20.glCreateShader(type); //Get memory location for shader code
		
		if(shader == 0){
			System.err.println("src.opengl.Shader error: 005"); System.exit(1); }
		
		GL20.glShaderSource(shader, shader_source);
		GL20.glCompileShader(shader);
		
		if(GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == 0){
			System.err.println("src.opengl.Shader error: 006");
			System.err.println(GL20.glGetShaderInfoLog(shader, 1024));
			System.exit(1); }
		
		GL20.glAttachShader(program, shader);
	}
}