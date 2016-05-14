package src.opengl;

import src.utilities.mathematics.Vertex;
import src.utilities.mathematics.Linalg;
import src.utilities.mathematics.vec3;

import org.lwjgl.opengl.GL15;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Mesh{
	private int VBO;
	private int IBO;
	private int n_vertices;
	private int n_indices;
	
	public Mesh(Vertex[] vertices, int[] indices, boolean calc_normals){
		VBO = GL15.glGenBuffers();
		IBO = GL15.glGenBuffers();
		n_vertices = vertices.length;
		n_indices = indices.length;
		
		if(calc_normals){
			calcNormals(vertices, indices);
		}
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBO); //Select VBO
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, genBuffer(vertices), GL15.GL_STATIC_DRAW);
		
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, IBO); //Select VBO
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, genBuffer(indices), GL15.GL_STATIC_DRAW);
		
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0); //Deselect VBO
	}
	
	private FloatBuffer genBuffer(Vertex[] vertices){ //This isn't necessary in C++
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);
		
		for(int i = 0; i < vertices.length; i++){ //Add every item of data to FloatBuffer
			buffer.put((float)vertices[i].getPos().getX());
			buffer.put((float)vertices[i].getPos().getY());
			buffer.put((float)vertices[i].getPos().getZ());
			buffer.put((float)vertices[i].getCoord().getX());
			buffer.put((float)vertices[i].getCoord().getY());
			buffer.put((float)vertices[i].getNormal().getX());
			buffer.put((float)vertices[i].getNormal().getY());
			buffer.put((float)vertices[i].getNormal().getZ());
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
	
	private void calcNormals(Vertex[] vertices, int[] indices){
		int i0, i1, i2;
		vec3 v1, v2, n;
		
		for(int i = 0; i < indices.length; i += 3){
			i0 = indices[i];
			i1 = indices[i + 1];
			i2 = indices[i + 2];
			
			v1 = Linalg.subtract(vertices[i1].getPos(), vertices[i0].getPos());
			v2 = Linalg.subtract(vertices[i2].getPos(), vertices[i0].getPos());
			n = Linalg.cross(v1, v2);
			
			vertices[i0].setNormal( Linalg.add(vertices[i0].getNormal(), n) );
			vertices[i1].setNormal( Linalg.add(vertices[i1].getNormal(), n) );
			vertices[i2].setNormal( Linalg.add(vertices[i2].getNormal(), n) );
		}
		
		for(int i = 0; i < vertices.length; i++){
			vertices[i].normalizeNormal();
		}
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