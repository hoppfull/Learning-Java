import java.io.BufferedReader;
import java.io.FileReader;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

class Utilities{
	public static String loadShader(String filename){
		StringBuilder shader_source = new StringBuilder();
		BufferedReader shader_reader = null;
		
		try
		{
			shader_reader = new BufferedReader(new FileReader("./res/shaders/" + filename));
			String line;
			while((line = shader_reader.readLine()) != null){
				shader_source.append(line + "\n");
			}
			shader_reader.close();
		}
		catch(Exception e){
			System.err.println("Utilities class, error: 001");
			e.printStackTrace();
			System.exit(1);
		}
		
		
		return shader_source.toString();
	}
}