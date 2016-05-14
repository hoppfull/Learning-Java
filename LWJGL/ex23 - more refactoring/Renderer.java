import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

class Renderer{
	public static void clearScreen(){
		//TODO: Stencil buffer, whatever that is...
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	public static void setDefaults(){
		System.out.println("OpenGL available on system: " + GL11.glGetString(GL11.GL_VERSION));
		GL11.glClearColor(0.1f, 0.3f, 0.2f, 1.0f);
		
		//I think this is enabled by default:
		GL11.glEnable(GL11.GL_CULL_FACE);		//Enable face culling
		GL11.glFrontFace(GL11.GL_CCW);			//CCW seems to be standard
		GL11.glCullFace(GL11.GL_BACK);			//Cull the backside
		
		
		GL11.glEnable(GL11.GL_DEPTH_TEST); //Check depth of pixel
		//TODO: Depth clamping, whatever that is...
		
		GL11.glEnable(GL30.GL_FRAMEBUFFER_SRGB); //I think this is on by default
	}
	
	public static void drawMesh(Mesh mesh){
		GL20.glEnableVertexAttribArray(0); //Enable VBO, assign it to a VAO I think, at position 0
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, mesh.getVBO()); //Select VBO
		GL20.glVertexAttribPointer(
				0,						//Not sure about this one...
				3,						//Three elements to whatever the previous value is
				GL11.GL_FLOAT,			//Floats? alrighty
				false,					//Normalize? Don't know what that means...
				3 * 4,					//Size in bytes of one vertex, floats would be 4, doubles are 8
				0);						//Where in each vertex, does data in previous function entry start?
		
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, mesh.getIBO()); //Select IBO
		GL11.glDrawElements(
				GL11.GL_TRIANGLES,
				mesh.getNIndices(),
				GL11.GL_UNSIGNED_INT,
				0);
		
		
		GL20.glDisableVertexAttribArray(0);
	}	
}