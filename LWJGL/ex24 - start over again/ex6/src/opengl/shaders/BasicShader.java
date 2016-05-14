package src.opengl.shaders;

import src.opengl.Shader;
import src.utilities.resourceloaders.ShaderLoader;
import src.utilities.mathematics.mat4;
import src.opengl.Material;

public class BasicShader extends Shader{
	private static final BasicShader INSTANCE = new BasicShader();
	private final String NAME = "BasicShader";
	
	private BasicShader(){ //A new instance cannot be created outside since the constructor is private
		super(); //This calls the corresponding constructor in Shader
		
		addVertexShader(ShaderLoader.load(NAME + "/basicshader_vertex_01.GLSL"));
		addFragmentShader(ShaderLoader.load(NAME + "/basicshader_fragment_01.GLSL"));
		compileShader();
		
		addUniform("transform");
		addUniform("diffuse_color");
	}
	
	public static BasicShader getInstance(){
		return INSTANCE;
	}
	
	public void update(mat4 World, mat4 Projection, Material material){
		setUniform( "transform", Projection.x(World) );
		setUniform( "diffuse_color", material.getDiffuseColor() );
	}
	
	public void render(){
		useProgram();
	}
}