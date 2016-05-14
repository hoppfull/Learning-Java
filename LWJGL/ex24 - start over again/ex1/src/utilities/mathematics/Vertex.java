package src.utilities.mathematics;

public class Vertex{
	private vec3 pos;
	
	public Vertex(vec3 pos){
		this.pos = pos;
	}
	
	public vec3 getPos(){
		return pos;
	}
	
	public void setPos(vec3 pos){
		this.pos = pos;
	}
}