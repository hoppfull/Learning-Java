package src.engine.objects;

import src.utilities.mathematics.vec3;
import src.utilities.mathematics.mat4;
import src.utilities.mathematics.Linalg;
import src.window.Window;

public class TargetCamera{
	private mat4 Projection;
	private vec3 CameraPos, TargetPos, CTvector;
	private double roll;
	
	public TargetCamera(double z_near, double z_far, double fov){
		Projection = new mat4();
		Projection.setProjection(
				Window.getWidth(),
				Window.getHeight(),
				z_near, z_far, fov);
		CameraPos = new vec3(5,-5,5);
		TargetPos = new vec3(0,0,0);
		CTvector = new vec3(-5,5,-5);
		roll = 0;
	}
	
	public void setCameraPos(vec3 pos){
		CameraPos = pos;
		setCTvector();
	}
	
	public void setTargetPos(vec3 pos){
		TargetPos = pos;
		setCTvector();
	}
	
	private void setCTvector(){
		CTvector = Linalg.subtract(TargetPos, CameraPos);
	}
	
	public void roll(double turns){
		roll += turns;
	}
	
}
/* TODO:
 * Hitta en metod som skapar ett rotationsmatris
 * som alignar kameran längs med CTvector!
 */