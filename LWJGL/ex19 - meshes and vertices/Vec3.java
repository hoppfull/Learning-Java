class Vec3{
	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	public Vec3(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getMag(){ //Tested and works!
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	public void setMag(double scalar){ //Tested and works!
		double x_ = x * scalar / Math.sqrt(x*x + y*y + z*z);
		double y_ = y * scalar / Math.sqrt(x*x + y*y + z*z);
		double z_ = z * scalar / Math.sqrt(x*x + y*y + z*z);
		this.x = x_;
		this.y = y_;
		this.z = z_;
	}
	
	public String toString(){ //Tested and works!
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getZ(){
		return z;
	}
	
	public void setX(double scalar){
		this.x = scalar;
	}
	
	public void setY(double scalar){
		this.y = scalar;
	}
	
	public void setZ(double scalar){
		this.z = scalar;
	}
}