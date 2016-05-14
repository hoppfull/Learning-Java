package src.utilities.resourceloaders;

import src.utilities.mathematics.Vertex;
import src.utilities.mathematics.vec3;
import src.opengl.Mesh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class objLoader{
	public static Mesh load(String filename){
		String[] split_filename = filename.split("\\."); //Split filename by punctuation
		String ext = split_filename[split_filename.length -1]; //Retrieve string after last punctuation
		
		if( !ext.equals("obj") ){ //If file extention isn't .obj, print error and exit
			System.err.println("src.utilities.resourceloaders.objLoader error: 001");
			new Exception().printStackTrace();
			System.exit(1);
		}
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		BufferedReader obj_reader = null;
		
		try
		{
			obj_reader = new BufferedReader(new FileReader("./res/models/" + filename));
			String line;
			
			while((line = obj_reader.readLine()) != null)
			{
				String[] tokens = line.split(" "); //Looks like split removes what it's splitting by
				
				if( tokens.length == 0 ){
					continue;
				}
				else if( tokens[0].equals("v") )
				{
					vertices.add( new Vertex(new vec3(
							Double.valueOf(tokens[1]),
							Double.valueOf(tokens[2]),
							Double.valueOf(tokens[3])
							)) );
				}
				else if( tokens[0].equals("f") )
				{
					indices.add( Integer.parseInt(tokens[1]) - 1 );
					indices.add( Integer.parseInt(tokens[2]) - 1 );
					indices.add( Integer.parseInt(tokens[3]) - 1 );
				}
			}
			
			obj_reader.close();
			
			//Mechanism for loading ArrayList of Vertex into a Vertex[] array:
			Vertex[] vertexData = new Vertex[vertices.size()];
			vertices.toArray(vertexData);
			
			//Mechanism for loading ArrayList of Integer into an int[] array:
			int[] indexData = new int[indices.size()];
			Integer[] TEMP = new Integer[indices.size()];
			indices.toArray(TEMP);
			for(int i = 0; i < TEMP.length; i++){
				indexData[i] = TEMP[i].intValue();
			}
			
			return new Mesh(vertexData, indexData);
			
		}
		catch(Exception e)
		{
			System.err.println("src.utilities.resourceloaders.objLoader error: 002");
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}