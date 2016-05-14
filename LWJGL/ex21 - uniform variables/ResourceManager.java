import java.io.BufferedReader;
import java.io.FileReader;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

class ResourceManager{
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
			e.printStackTrace();
			System.exit(1);
		}
		
		
		return shader_source.toString();
	}
	
	public static FloatBuffer genBuffer(Vertex[] vertices){ //This isn't necessary in C++
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);
		//TODO: Look up buffers...
		
		for(int i = 0; i< vertices.length; i++){ //Add every item of data to FloatBuffer
			buffer.put((float)vertices[i].getPos().getX());
			buffer.put((float)vertices[i].getPos().getY());
			buffer.put((float)vertices[i].getPos().getZ());
		}
		buffer.flip(); //Arrange buffer in some kind of order
		return buffer;
	}
	
	public static FloatBuffer genBuffer(Matrix4 matrix){
		FloatBuffer buffer = BufferUtils.createFloatBuffer(4 * 4);
		
		for(int n = 0; n < 4; n++) for(int m = 0; m < 4; m++)
		{
			buffer.put((float)matrix.getM()[n][m]);
		}
		buffer.flip();
		return buffer;
	}
}