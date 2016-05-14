public class LinAlg{
	public static vec3 cross(vec3 u, vec3 v){ //Tested and works!
		return new vec3(
				( u.getY() * v.getZ() - u.getZ() * v.getY() ),
				( u.getZ() * v.getX() - u.getX() * v.getZ() ),
				( u.getX() * v.getY() - u.getY() * v.getX() ));
	}
	
	public static double dot(vec3 u, vec3 v){ //Tested and works!
		return u.getX()*v.getX() + u.getY()*v.getY() + u.getZ()*v.getZ();
	}
	
	public static vec3 add(vec3 u, vec3 v){ //Tested and works!
		return new vec3(
				(u.getX() + v.getX()),
				(u.getY() + v.getY()),
				(u.getZ() + v.getZ()));
	}
	
	public static vec3 add(vec3 u, double a){ //Tested and works!
		return new vec3(
				(u.getX() + a),
				(u.getY() + a),
				(u.getZ() + a));
	}
	
	public static vec3 subtract(vec3 u, vec3 v){ //Tested and works!
		return new vec3(
				(u.getX() - v.getX()),
				(u.getY() - v.getY()),
				(u.getZ() - v.getZ()));
	}
	
	public static vec3 subtract(vec3 u, double a){ //Tested and works!
		return new vec3(
				(u.getX() - a),
				(u.getY() - a),
				(u.getZ() - a));
	}
	
	public static vec3 scale(vec3 u, double scalar){ //Tested and works!
		return new vec3(
				(u.getX() * scalar),
				(u.getY() * scalar),
				(u.getZ() * scalar)
				);
	}
}