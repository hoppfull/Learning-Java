package src.opengl.shaders;

import src.opengl.Shader;
import src.opengl.Material;
import src.utilities.resourceloaders.ShaderLoader;
import src.utilities.mathematics.mat4;
import src.utilities.mathematics.vec3;

public class PhongShader extends Shader{
	private static final PhongShader INSTANCE = new PhongShader();
	public static PhongShader getInstance(){ return INSTANCE; } //Singleton pattern
	
	private final String NAME = "PhongShader";
	private vec3 light_ambient;
	
	private PhongShader(){
		super();
		addVertexShader(ShaderLoader.load(NAME + "/vertex_shader01.GLSL"));
		addFragmentShader(ShaderLoader.load(NAME + "/fragment_shader01.GLSL"));
		compileShader();
		
		addUniform("transform");
		addUniform("color_diffuse");
		addUniform("light_ambient");
		
		light_ambient = new vec3(0.0,0.0,0.0);
	}
	
	public void setLightAmbient(vec3 vector){
		light_ambient = vector;
	}
	
	public vec3 getLightAmbient(){
		return light_ambient;
	}
	
	
	public void update(mat4 View, mat4 World, Material material){
		setUniform("transform", View.x(World));
		setUniform("color_diffuse", material.getDiffuseColor());
		setUniform("light_ambient", light_ambient);
	}
	
	public void render(){
		useProgram();
	}
}