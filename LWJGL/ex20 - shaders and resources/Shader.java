import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;

class Shader{
	private int program;
	
	public Shader(){
		program = GL20.glCreateProgram(); //Get memory location for shader program
		
		if(program == 0){ //If we didn't get proper pointer, show error message and quit
			System.err.println("Shader: Error acquiring pointer 'program'");
			System.exit(1);
		}
		
	}
	
	public void bind(){
		GL20.glUseProgram(program);
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