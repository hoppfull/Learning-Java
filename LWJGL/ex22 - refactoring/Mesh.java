import org.lwjgl.opengl.GL15;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

class Mesh{
	private int VBO;
	private int IBO;
	private int n_vertices;
	private int n_indices;
	
	public Mesh(Vertex[] vertices, int[] indices){
		VBO = GL15.glGenBuffers();
		IBO = GL15.glGenBuffers();
		n_vertices = vertices.length;
		n_indices = indices.length;
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBO); //Select VBO
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, genBuffer(vertices), GL15.GL_STATIC_DRAW);
		
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, IBO); //Select VBO
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, genBuffer(indices), GL15.GL_STATIC_DRAW);
		
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0); //Deselect VBO
	}
	
	private FloatBuffer genBuffer(Vertex[] vertices){ //This isn't necessary in C++
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * 3);
		
		for(int i = 0; i < vertices.length; i++){ //Add every item of data to FloatBuffer
			buffer.put((float)vertices[i].getPos().getX());
			buffer.put((float)vertices[i].getPos().getY());
			buffer.put((float)vertices[i].getPos().getZ());
		}
		buffer.flip(); //Flip buffer from write mode to read mode
		return buffer;
	}
	
	private IntBuffer genBuffer(int[] indices){ //This isn't necessary in C++
		IntBuffer buffer = BufferUtils.createIntBuffer(indices.length);
		
		for(int i = 0; i < indices.length; i++){ //Add every item of data to FloatBuffer
			buffer.put(indices[i]);
		}
		buffer.flip(); //Flip buffer from write mode to read mode
		return buffer;
	}
	
	public int getVBO(){
		return VBO;
	}
	
	public int getIBO(){
		return IBO;
	}
	
	public int getNVertices(){
		return n_vertices;
	}
	
	public int getNIndices(){
		return n_indices;
	}
}