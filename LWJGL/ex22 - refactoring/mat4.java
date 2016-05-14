import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;

class mat4{
	private double[][] M;
	
	public mat4(){
		M = new double[4][4];
	}
	
	public void setM(int n, int m, double value){
		M[n][m] = value;
	}
	
	public double[][] getM(){
		return M;
	}
	
	public void setTransform(vec3 r, double turns, vec3 p, vec3 s){ //Rotation, position, scale
		double sin = Math.sin(turns * 6.28318530718);
		double cos = Math.cos(turns * 6.28318530718);
		double a = r.getX(); double b = r.getY(); double c = r.getZ(); //Rotation parameters
		double x = p.getX(); double y = p.getY(); double z = p.getZ(); //Position parameters
		double u = s.getX(); double v = s.getY(); double w = s.getZ(); //Scaling parameters
		
			//Row 0:
			M[0][0] = u*( a*a*(1 - cos) +   cos );
			M[0][1] = v*( b*a*(1 - cos) - c*sin );
			M[0][2] = w*( c*a*(1 - cos) + b*sin );
			M[0][3] = x;
			
			//Row 1:
			M[1][0] = u*( a*b*(1 - cos) + c*sin );
			M[1][1] = v*( b*b*(1 - cos) +   cos );
			M[1][2] = w*( c*b*(1 - cos) - a*sin );
			M[1][3] = y;
			
			//Row 2:
			M[2][0] = u*( a*c*(1 - cos) - b*sin );
			M[2][1] = v*( b*c*(1 - cos) + a*sin );
			M[2][2] = w*( c*c*(1 - cos) +   cos );
			M[2][3] = z;
			
			//Row 3:
			M[3][0] = 0; M[3][1] = 0; M[3][2] = 0; M[3][3] = 1;
	}
	
	public FloatBuffer getFloatBuffer(){
		FloatBuffer buffer = BufferUtils.createFloatBuffer(4 * 4);
		for(int n = 0; n < 4; n++)
			for(int m = 0; m < 4; m++)
				buffer.put( (float)(M[n][m]) );
		buffer.flip(); //Flip from writemode to readmode
		return buffer;
	}
}