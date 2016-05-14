package src.utilities.mathematics;

public class Vertex{
	private vec3 pos = new vec3(0,0,0);
	
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