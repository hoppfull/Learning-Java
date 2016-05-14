package src.utilities.mathematics;

public class vec2{
	private double x = 0;
	private double y = 0;
	
	public vec2(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getMag(){
		return Math.sqrt(x*x + y*y);
	}
	public void setMag(double scalar){
		double mag = this.getMag();
		x *= scalar / mag;
		y *= scalar / mag;
	}
	
	public void rotate(double turns){
		double sin = Math.sin(turns * 6.28318530718);
		double cos = Math.cos(turns * 6.28318530718);
		double x_ = x*cos - y*sin;
		double y_ = x*sin + y*cos;
		x = x_;
		y = y_;
	}
	
	public void plus(vec2 vector, double scalar){
		x += vector.getX() * scalar;
		y += vector.getY() * scalar;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double scalar){
		x = scalar;
	}
	
	public void setY(double scalar){
		y = scalar;
	}
}