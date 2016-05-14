package src.opengl;

import org.lwjgl.opengl.GL11;

public class Texture{
	private int ID;
	public Texture(int ID){
		this.ID = ID;
	}
	
	public void bind(){
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, ID);
	}
	
	public int getID(){
		return ID;
	}
}