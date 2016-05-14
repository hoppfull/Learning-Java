public class Vec3f{
	private float x;
	private float y;
	private float z;
	
	public Vec3f(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getLength(){
		return (float)Math.sqrt(x*x + y*y + z*z);
	}
	
	public void setLength(float scalar){
		this.x = x * scalar / (float)Math.sqrt(x*x + y*y + z*z);
		this.y = y * scalar / (float)Math.sqrt(x*x + y*y + z*z);
		this.z = z * scalar / (float)Math.sqrt(x*x + y*y + z*z);
	}
	
	public void rotate(){
		
	}
	
	public Vec3f cross(Vec3f vector){
		float x_ = y * vector.getZ() - z * vector.getY();
		float y_ = z * vector.getX() - x * vector.getZ();
		float z_ = x * vector.getY() - y * vector.getX();
		
		return new Vec3f(x_, y_, z_);
		
	}
	
	public float dot(Vec3f vector){
		return ( x * vector.getX() ) + ( y * vector.getY() ) + ( z * vector.getZ() );
	}
	
	public Vec3f add(float scalar){
		return new Vec3f(x + scalar, y + scalar, z + scalar);
	}
	
	public Vec3f add(Vec3f vector){
		return new Vec3f(x + vector.getX(), y + vector.getY(), z + vector.getZ());
	}
	
	public Vec3f sub(float scalar){
		return new Vec3f(x - scalar, y - scalar, z - scalar);
	}
	
	public Vec3f sub(Vec3f vector){
		return new Vec3f(x - vector.getX(), y - vector.getY(), z - vector.getZ());
	}
	
	public Vec3f mul(float scalar){
		return new Vec3f(x * scalar, y * scalar, z * scalar);
	}
	
	public Vec3f mul(Vec3f vector){
		return new Vec3f(x * vector.getX(), y * vector.getY(), z * vector.getZ());
	}
	
	public Vec3f div(float scalar){
		return new Vec3f(x / scalar, y / scalar, z / scalar);
	}
	
	public Vec3f div(Vec3f vector){
		return new Vec3f(x / vector.getX(), y / vector.getY(), z / vector.getZ());
	}
	
	public String toString(){
		return "(" + x + ", " + y + ", " + z + ")";
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public float getZ(){
		return z;
	}
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public void setZ(float z){
		this.z = z;
	}
}