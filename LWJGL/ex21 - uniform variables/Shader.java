import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;
import java.util.HashMap;

class Shader{
	private int program;
	private HashMap<String, Integer> uniforms;
	
	public Shader(){
		program = GL20.glCreateProgram(); //Get memory location for shader program
		uniforms = new HashMap<String, Integer>();
		
		if(program == 0){ //If we didn't get proper pointer, show error message and quit
			System.err.println("Shader: Error acquiring pointer 'program'");
			System.exit(1);
		}
		
	}
	
	public void useProgram(){ //benny calls it bind()
		GL20.glUseProgram(program);
	}
	
	public void addUniform(String uniform){
		int uniform_pointer = GL20.glGetUniformLocation(program, uniform);
		
		if(uniform_pointer == -1){
			System.err.println("Shader, Error: Phallus!");
			System.exit(1);
		}
		
		uniforms.put(uniform, uniform_pointer);
	}
	
	public void setUniformi(String uniform, int value){
		GL20.glUniform1i(uniforms.get(uniform), value);
	}
	
	public void setUniformf(String uniform, float value){
		GL20.glUniform1f(uniforms.get(uniform), value);
	}
	
	public void setUniform3f(String uniform, Vec3 vector){
		GL20.glUniform3f(uniforms.get(uniform), (float)vector.getX(), (float)vector.getY(), (float)vector.getZ());
	}
	
	public void setUniformMatrix4(String uniform, Matrix4 matrix){
		GL20.glUniformMatrix4(uniforms.get(uniform), true,  ResourceManager.genBuffer(matrix));
	}
	
	
	
	
	
	
	
	
	
	public void addVertexShader(String text){
		addProgram(text, GL20.GL_VERTEX_SHADER);
	}
	
	public void addGeometryShader(String text){
		addProgram(text, GL32.GL_GEOMETRY_SHADER);
	}
	
	public void addFragmentShader(String text){
		addProgram(text, GL20.GL_FRAGMENT_SHADER);
	}
	
	public void compileShader(){
		GL20.glLinkProgram(program);
		
		if(GL20.glGetProgrami(program, GL20.GL_LINK_STATUS) == 0){ //glGetProgram is deprecated, use glGetProgrami instead
			System.err.println("Shader, Error: Penis!");
			System.err.println(GL20.glGetProgramInfoLog(program, 1024));
			System.exit(1);
		}
		
		GL20.glValidateProgram(program);
		
		if(GL20.glGetProgrami(program, GL20.GL_VALIDATE_STATUS) == 0){ //glGetProgram is deprecated, use glGetProgrami instead
			System.err.println("Shader, Error: Kuk!");
			System.err.println(GL20.glGetProgramInfoLog(program, 1024));
			System.exit(1);
		}
	}
	
	private void addProgram(String text, int type){
		int shader = GL20.glCreateShader(type); //Get memory location for shader code
		
		if(shader == 0){ //If we didn't get proper pointer, show error message and quit
			System.err.println("Shader, Error: Snopp!");
			System.exit(1);
		}
		GL20.glShaderSource(shader, text);
		GL20.glCompileShader(shader);
		
		if(GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == 0){ //glGetShader is deprecated, use glGetShaderi instead
			System.err.println("Shader, Error: Petter Niklas!");
			System.err.println(GL20.glGetShaderInfoLog(shader, 1024));
			System.exit(1);
		}
		
		GL20.glAttachShader(program, shader);
		
	}
}