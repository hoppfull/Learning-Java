package src.utilities.mathematics;

public class Linalg{
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
	
	public static mat4 MatrixMult(mat4 A, mat4 B){
		mat4 AB = new mat4();
		double value = 0;
		
		for(int n = 0; n < 4; n++){
			for(int m = 0; m < 4; m++){
				value = 0;
				for(int i = 0; i < 4; i++){
					value += A.getM()[n][i] * B.getM()[i][m];
				}
				AB.setM(n, m, value);
			}
		}
		return AB;
	}
}