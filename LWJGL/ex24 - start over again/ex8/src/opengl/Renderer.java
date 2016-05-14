package src.opengl;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import src.utilities.mathematics.Vertex;

public class Renderer{
	public static void clearScreen(){
		//TODO: Stencil buffer, whatever that is...
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	public static void setDefaults(){
		System.out.println("OpenGL available on system: " + GL11.glGetString(GL11.GL_VERSION));
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		//I think this is enabled by default:
		GL11.glEnable(GL11.GL_CULL_FACE);		//Enable face culling
		GL11.glFrontFace(GL11.GL_CW);			//CCW seems to be standard
		GL11.glCullFace(GL11.GL_BACK);			//Cull the backside
		
		
		GL11.glEnable(GL11.GL_DEPTH_TEST); //Check depth of pixel
		//TODO: Depth clamping, whatever that is...
		
//		GL11.glEnable(GL11.GL_TEXTURE_2D);	//This does nothing it seems
		GL11.glEnable(GL30.GL_FRAMEBUFFER_SRGB); //I think this is on by default
	}
	
	public static void enableTextures(boolean enabled){ //This also seems unnecessary
		if(enabled){
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}else{
			GL11.glDisable(GL11.GL_TEXTURE_2D);
		}
	}
	
	public static void drawMesh(Mesh mesh){
		GL20.glEnableVertexAttribArray(0); //Enable VBO, assign it to a VAO I think, at position 0
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, mesh.getVBO()); //Select VBO
		GL20.glVertexAttribPointer(//Position coordinate attribute
				0,						//Attribute 0 in this attribute array
				3,						//Three elements to whatever the previous value is
				GL11.GL_FLOAT,			//Floats? alrighty
				false,					//Normalize? Don't know what that means...
				Vertex.SIZE * 4,		//Size in bytes of one vertex, floats would be 4, doubles are 8
				0);						//Where in each vertex, does desired data start? In bytes.
		GL20.glVertexAttribPointer(//Texture coordinate attribute
				1,						//Attribute 1 in this attribute array
				2,
				GL11.GL_FLOAT,
				false,
				Vertex.SIZE * 4,
				3 * 4);					//Where in each vertex, does desired data start? In bytes.
		GL20.glVertexAttribPointer(//Normal coordinate attribute
				2,						//Attribute 2 in this attribute array
				2,
				GL11.GL_FLOAT,
				false,
				Vertex.SIZE * 4,
				5 * 4);					//Where in each vertex, does desired data start? In bytes.
		
		
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, mesh.getIBO()); //Select IBO
		GL11.glDrawElements(
				GL11.GL_TRIANGLES,
				mesh.getNIndices(),
				GL11.GL_UNSIGNED_INT,
				0);
		
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);
		
	}	
}