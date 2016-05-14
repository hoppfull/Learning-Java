package src.utilities.resourceloaders;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

import src.opengl.Texture;

public class texLoader{
	public static Texture load(String filename){
		BufferedImage img = null;
		
		try
		{
			img = ImageIO.read(new File("./res/textures/" + filename));
		}
		catch(Exception e)
		{
			System.err.println("src.utilities.resourceloaders.texLoader error: 001");
			e.printStackTrace();
			System.exit(1);
		}
		//Allocate 4 bytes for each pixel if RGBA, 3 bytes if RGB
		ByteBuffer bytebuffer = ByteBuffer.allocateDirect(4 * img.getWidth() * img.getHeight());
		
		byte data[] = (byte[]) img.getRaster().getDataElements(0, 0, img.getWidth(), img.getHeight(), null);
		bytebuffer.clear();
		bytebuffer.put(data);
		bytebuffer.rewind();
		
		IntBuffer intbuffer = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asIntBuffer();
		GL11.glGenTextures(intbuffer);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, intbuffer.get(0));
		
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, img.getWidth(), img.getHeight(), 0, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, bytebuffer);
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		
		return new Texture(intbuffer.get(0));
	}
	
	
//	public static Texture load(String filename){
//		String[] split_filename = filename.split("\\."); //Split filename by punctuation
//		String ext = split_filename[split_filename.length -1]; //Retrieve string after last punctuation
//		
//		try
//		{
//			int ID = TextureLoader.getTexture(ext, new FileInputStream(
//					new File("./res/textures/" + filename))).getTextureID();
//			return new Texture(ID);
//		}
//		catch(Exception e)
//		{
//			System.err.println("src.utilities.resourceloaders.texLoader error: 001");
//			e.printStackTrace();
//			System.exit(1);
//		}
//		
//		return null;
//	}
}