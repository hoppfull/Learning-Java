package src.utilities.resourceloaders;

import java.io.FileInputStream;
import java.io.File;
import org.newdawn.slick.opengl.TextureLoader;
import src.opengl.Texture;

public class texLoader{
	public static Texture load(String filename){
		String[] split_filename = filename.split("\\."); //Split filename by punctuation
		String ext = split_filename[split_filename.length -1]; //Retrieve string after last punctuation
		
		try
		{
			int ID = TextureLoader.getTexture(ext, new FileInputStream(
					new File("./res/textures/" + filename))).getTextureID();
			return new Texture(ID);
		}
		catch(Exception e)
		{
			System.err.println("src.utilities.resourceloaders.texLoader error: 001");
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
}