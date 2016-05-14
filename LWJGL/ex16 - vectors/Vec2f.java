public class Vec2f{
	private float x;
	private float y;
	
	public Vec2f(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getLength(){ //How long is this vector?
		return (float)Math.sqrt(x*x + y*y);
	}
	
	public void setLength(float scalar){ //Set the length of this vector
		this.x = x * scalar / (float)Math.sqrt(x*x + y*y);
		this.y = y * scalar / (float)Math.sqrt(x*x + y*y);
	}
	
	public void rotate(float turns){ //Rotate this vector
		float rad = turns * 2 * (float)3.14159265359;
		float cos = (float)Math.cos(rad);
		float sin = (float)Math.sin(rad);
		float x_temp = x;
		float y_temp = y;
		this.x = x_temp * cos - y_temp * sin;
		this.y = x_temp * sin + y_temp * cos;
	}
	
	public float dot(Vec2f vector){ //Dot product
		return ( x * vector.getX() ) + ( y * vector.getY() );
	}
	
	public Vec2f add(float scalar){
		return new Vec2f(x + scalar, y + scalar); //Scalar addition
	}
	
	public Vec2f add(Vec2f vector){ //Vector addition
		return new Vec2f(x + vector.getX(), y + vector.getY());
	}
	
	public Vec2f sub(float scalar){ //Scalar subtraction
		return new Vec2f(x - scalar, y - scalar);
	}
	
	public Vec2f sub(Vec2f vector){ //Vector subtraction
		return new Vec2f(x - vector.getX(), y - vector.getY());
	}
	
	public Vec2f mul(float scalar){ //Scalar multiplication
		return new Vec2f(x * scalar, y * scalar);
	}
	
	public Vec2f mul(Vec2f vector){ //Elementwise vector multiplication
		return new Vec2f(x * vector.getX(), y * vector.getY());
	}
	
	public Vec2f div(float scalar){ //Scalar division
		return new Vec2f(x / scalar, y / scalar);
	}
	
	public Vec2f div(Vec2f vector){ //Elementwise vector division
		return new Vec2f(x / vector.getX(), y / vector.getY());
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
}