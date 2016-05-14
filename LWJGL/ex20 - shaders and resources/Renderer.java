import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

class Renderer{
	public static void clearScreen(){
		//TODO: Stencil buffer, whatever that is...
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	public static void setDefaults(){
		System.out.println("OpenGL available on system: " + GL11.glGetString(GL11.GL_VERSION));
		GL11.glClearColor(0.1f, 0.2f, 0.3f, 1.0f);
		
		//I think this is enabled by default:
		GL11.glEnable(GL11.GL_CULL_FACE);		//Enable face culling
		GL11.glFrontFace(GL11.GL_CCW);			//CCW seems to be standard
		GL11.glCullFace(GL11.GL_BACK);			//Cull the backside
		
		
		GL11.glEnable(GL11.GL_DEPTH_TEST); //Check depth of pixel
		//TODO: Depth clamping, whatever that is...
		
		GL11.glEnable(GL30.GL_FRAMEBUFFER_SRGB); //I think this is on by default
	}
	
	
	
	
}