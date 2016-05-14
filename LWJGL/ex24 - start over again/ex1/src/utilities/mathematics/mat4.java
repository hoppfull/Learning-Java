package src.utilities.mathematics;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;

public class mat4{
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
	
	public void setIdentity(){
		M[0][0] = 1; M[0][1] = 0; M[0][2] = 0; M[0][3] = 0;
		M[1][0] = 0; M[1][1] = 1; M[1][2] = 0; M[1][3] = 0;
		M[2][0] = 0; M[2][1] = 0; M[2][2] = 1; M[2][3] = 0;
		M[3][0] = 0; M[3][1] = 0; M[3][2] = 0; M[3][3] = 1;
	}
	
	public void setTransform(vec3 i, double turns, vec3 p){
		double sin = Math.sin(turns * 6.28318530718);
		double cos = Math.cos(turns * 6.28318530718);
		double a = i.getX(); double b = i.getY(); double c = i.getZ(); //Rotation parameters
		double x = p.getX(); double y = p.getY(); double z = p.getZ(); //Position parameters
		
			//Row 0:
			M[0][0] = ( a*a*(1 - cos) +   cos );
			M[0][1] = ( b*a*(1 - cos) - c*sin );
			M[0][2] = ( c*a*(1 - cos) + b*sin );
			M[0][3] = x;
			
			//Row 1:
			M[1][0] = ( a*b*(1 - cos) + c*sin );
			M[1][1] = ( b*b*(1 - cos) +   cos );
			M[1][2] = ( c*b*(1 - cos) - a*sin );
			M[1][3] = y;
			
			//Row 2:
			M[2][0] = ( a*c*(1 - cos) - b*sin );
			M[2][1] = ( b*c*(1 - cos) + a*sin );
			M[2][2] = ( c*c*(1 - cos) +   cos );
			M[2][3] = z;
			
			//Row 3:
			M[3][0] = 0; M[3][1] = 0; M[3][2] = 0; M[3][3] = 1;
	}
	
	public FloatBuffer getFloatBuffer(){
		FloatBuffer buffer = BufferUtils.createFloatBuffer(4 * 4);
		for(int n = 0; n < 4; n++){
			for(int m = 0; m < 4; m++){
				buffer.put( (float)(M[n][m]) );
			}
		}
		buffer.flip(); //Flip from writemode to readmode
		return buffer;
	}
}