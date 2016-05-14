import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;

public class Matrix4{
	private double[][] nxm;
	
	public Matrix4(){
		nxm = new double[4][4];
	}
	
	public void setIdentity(){ //Tested and works!
		nxm[0][0] = 1; nxm[0][1] = 0; nxm[0][2] = 0; nxm[0][3] = 0;
		nxm[1][0] = 0; nxm[1][1] = 1; nxm[1][2] = 0; nxm[1][3] = 0;
		nxm[2][0] = 0; nxm[2][1] = 0; nxm[2][2] = 1; nxm[2][3] = 0;
		nxm[3][0] = 0; nxm[3][1] = 0; nxm[3][2] = 0; nxm[3][3] = 1;
	}
	
	public void setTranslate(Vec3 v){
		nxm[0][0] = 1; nxm[0][1] = 0; nxm[0][2] = 0; nxm[0][3] = v.getX();
		nxm[1][0] = 0; nxm[1][1] = 1; nxm[1][2] = 0; nxm[1][3] = v.getY();
		nxm[2][0] = 0; nxm[2][1] = 0; nxm[2][2] = 1; nxm[2][3] = v.getZ();
		nxm[3][0] = 0; nxm[3][1] = 0; nxm[3][2] = 0; nxm[3][3] = 1;
	}
	
	public void setRotate(Vec3 v, double turns){
		double sin = Math.sin(turns * 6.28318530718);
		double cos = Math.cos(turns * 6.28318530718);
		
		double x = v.getX(); double y = v.getY(); double z = v.getZ();
		
		//Row 0:
		nxm[0][0] = x*x*(1 - cos) +   cos;
		nxm[0][1] = y*x*(1 - cos) - z*sin;
		nxm[0][2] = z*x*(1 - cos) + y*sin;
		nxm[0][3] = 0;
		
		//Row 1:
		nxm[1][0] = x*y*(1 - cos) + z*sin;
		nxm[1][1] = y*y*(1 - cos) +   cos;
		nxm[1][2] = z*y*(1 - cos) - x*sin;
		nxm[1][3] = 0;
		
		//Row 2:
		nxm[2][0] = x*z*(1 - cos) - y*sin;
		nxm[2][1] = y*z*(1 - cos) + x*sin;
		nxm[2][2] = z*z*(1 - cos) +   cos;
		nxm[2][3] = 0;
		
		//Row 3:
		nxm[3][0] = 0; nxm[3][1] = 0; nxm[3][2] = 0; nxm[3][3] = 1;
	}
	
	public void setScale(Vec3 v){
		nxm[0][0] = v.getX(); 	nxm[0][1] = 0; 			nxm[0][2] = 0; 			nxm[0][3] = 0;
		nxm[1][0] = 0; 			nxm[1][1] = v.getY(); 	nxm[1][2] = 0; 			nxm[1][3] = 0;
		nxm[2][0] = 0; 			nxm[2][1] = 0; 			nxm[2][2] = v.getZ(); 	nxm[2][3] = 0;
		nxm[3][0] = 0; 			nxm[3][1] = 0; 			nxm[3][2] = 0; 			nxm[3][3] = 1;
	}
	
	
	
	public double[][] getM(){ //Tested and works!
		return nxm;
	}
	
	public void setM(int n, int m, double value){ //Tested and works!
		this.nxm[n][m] = value;
	}
}