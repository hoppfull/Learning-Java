public class LinAlg{
	public static Vec3 cross(Vec3 u, Vec3 v){ //Tested and works!
		return new Vec3(
				( u.getY() * v.getZ() - u.getZ() * v.getY() ),
				( u.getZ() * v.getX() - u.getX() * v.getZ() ),
				( u.getX() * v.getY() - u.getY() * v.getX() ));
	}
	
	public static double dot(Vec3 u, Vec3 v){ //Tested and works!
		return u.getX()*v.getX() + u.getY()*v.getY() + u.getZ()*v.getZ();
	}
	
	public static Vec3 add(Vec3 u, Vec3 v){ //Tested and works!
		return new Vec3(
				(u.getX() + v.getX()),
				(u.getY() + v.getY()),
				(u.getZ() + v.getZ()));
	}
	
	public static Vec3 add(Vec3 u, double a){ //Tested and works!
		return new Vec3(
				(u.getX() + a),
				(u.getY() + a),
				(u.getZ() + a));
	}
	
	public static Vec3 subtract(Vec3 u, Vec3 v){ //Tested and works!
		return new Vec3(
				(u.getX() - v.getX()),
				(u.getY() - v.getY()),
				(u.getZ() - v.getZ()));
	}
	
	public static Vec3 subtract(Vec3 u, double a){ //Tested and works!
		return new Vec3(
				(u.getX() - a),
				(u.getY() - a),
				(u.getZ() - a));
	}
	
	public static Vec3 scale(Vec3 u, double scalar){ //Tested and works!
		return new Vec3(
				(u.getX() * scalar),
				(u.getY() * scalar),
				(u.getZ() * scalar)
				);
	}
}