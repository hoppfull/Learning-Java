package src.utilities.mathematics;

public class Vertex{
	public static final int SIZE = 5; //Number of elements in a vertex
	
	private vec3 pos = new vec3(0,0,0);
	private vec2 coord = new vec2(0,0);
	
	public Vertex(vec3 pos){
		this.pos = pos;
	}
	
	public Vertex(vec3 pos, vec2 coord){
		this.pos = pos;
		this.coord = coord;
	}
	
	public vec3 getPos(){
		return pos;
	}
	
	public void setPos(vec3 pos){
		this.pos = pos;
	}
	
	public vec2 getCoord(){
		return coord;
	}
	
	public void setCoord(vec2 coord){
		this.coord = coord;
	}
}