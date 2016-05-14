public class Vertex{
	private Vec3 pos;
	public static final int SIZE = 3;
	
	public Vertex(Vec3 pos){
		this.pos = pos;
	}
	
	public Vec3 getPos(){
		return pos;
	}
	
	public void setPos(Vec3 pos){
		this.pos = pos;
	}
}