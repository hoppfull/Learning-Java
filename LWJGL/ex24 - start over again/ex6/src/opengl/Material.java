package src.opengl;

import src.utilities.mathematics.vec3;
import src.utilities.resourceloaders.texLoader;

public class Material{
	private vec3 diffuse_color;
	private Texture diffuse_texture = null;
	private int test;
	
	public Material(){
		diffuse_color = new vec3(0.8,0.8,0.8);
	}
	
	public Texture getDiffuseTexture(){
		return diffuse_texture;
	}
	
	public vec3 getDiffuseColor(){
		return diffuse_color;
	}
	
	public void setDiffuseTexture(String filename){
		diffuse_texture = texLoader.load(filename);
	}
	
	public void setDiffuseColor(vec3 color){
		diffuse_color = color;
	}
}