class vec3{ /**3D vector object*/
	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	public vec3(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getMag(){
		/* Get vector magnitude */
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	public void setMag(double scalar){
		/* Set vector magnitude */
		double x_ = x * scalar / Math.sqrt(x*x + y*y + z*z);
		double y_ = y * scalar / Math.sqrt(x*x + y*y + z*z);
		double z_ = z * scalar / Math.sqrt(x*x + y*y + z*z);
		this.x = x_;
		this.y = y_;
		this.z = z_;
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
	
	public String toString(){
		/* Return vector in string format */
		return "(" + x + ", " + y + ", " + z + ")";
	}
}