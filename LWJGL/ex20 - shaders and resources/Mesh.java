import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

class Mesh{
	private int vbo; //Pointer to our vertex buffer object on video card
	private int n_vertices; //Number of vertices
	private int n_elements; //Number of coordinates
	
	public Mesh(){
		vbo = GL15.glGenBuffers(); //Get memory adress
		n_vertices = 0;
		n_elements = 0;
	}
	
	
	
	
	/**Mechanism to load a set of vertices START*/
	public void addVertices(Vertex[] vertices){
		n_vertices = vertices.length;
		n_elements = n_vertices * Vertex.SIZE; //How many numbers describe set of vertices
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo); //Select VBO
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, genBuffer(vertices), GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0); //Deselect VBO
	}
	
	private FloatBuffer genBuffer(Vertex[] vertices){ //This is necessary step in Java
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);
		//TODO: Look up buffers...
		
		for(int i = 0; i< vertices.length; i++){ //Add every item of data to FloatBuffer
			buffer.put((float)vertices[i].getPos().getX());
			buffer.put((float)vertices[i].getPos().getY());
			buffer.put((float)vertices[i].getPos().getZ());
		}
		buffer.flip(); //Arrange buffer in some kind of order
		return buffer;
	}/**Mechanism to load a set of vertices END*/
	
	
	
	
	
	
	
	
	
	public void draw(){
		GL20.glEnableVertexAttribArray(0); //Enable VBO, assign it to a VAO I think, at position 0
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo); //Select VBO
		
		
		GL20.glVertexAttribPointer(
				0,						//Not sure about this one...
				3,						//Three elements to whatever the previous value is
				GL11.GL_FLOAT,			//Floats? alrighty
				false,					//Normalize? Don't know what that means...
				Vertex.SIZE*4,			//Size in bytes of one vertex, floats would be 4, doubles are 8
				0);						//Where in each vertex, does data in previous function entry start?
		
		GL11.glDrawArrays(
				GL11.GL_TRIANGLES, 		//How to draw
				0,						//Where to start
				n_vertices);			//How many vertices to draw
		
		
		GL20.glDisableVertexAttribArray(0);
	}
}