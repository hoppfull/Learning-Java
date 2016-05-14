package src.engine.objects;

import src.utilities.mathematics.vec3;
import src.utilities.mathematics.mat4;
import src.utilities.mathematics.Linalg;
import src.window.Window;

public class FreeCam{
	private mat4 SpinX, SpinY, SpinZ, Projection;
	private Pivot piv;
	private double x_turns, y_turns, z_turns;
	
	public FreeCam(vec3 pos, double z_near, double z_far, double fov){
		SpinX = new mat4();
		SpinY = new mat4();
		SpinZ = new mat4();
		Projection = new mat4();
		Projection.setProjection(
				Window.getWidth(),
				Window.getHeight(),
				z_near, z_far, fov);
		piv = new Pivot();
		piv.setPos(Linalg.scale(pos, -1));
		x_turns = y_turns = z_turns = 0;
	}
	
	public void move(int axis, double distance){
		piv.move(axis, -distance);
	}
	
	public void rotate(int axis, double turns){
		if(axis == 0){
			x_turns += turns;
		}else if(axis == 1){
			y_turns += turns;
			piv.rotateAlong(new vec3(0,1,0), turns);
		}else if(axis == 2){
			z_turns += turns;
			piv.rotate(2, turns);
		}else{
			System.err.println("src.engine.objects.FreeCam error: 001");
			System.err.println("axis needs to be 0, 1 or 2 for x, y or z");
			System.exit(1);
		}
	}
	
	public mat4 getView(){
		SpinY.setRotation(new vec3(0,1,0), -y_turns);
		SpinX.setRotation(piv.getXAxis(), -x_turns);
		SpinZ.setRotation(piv.getZAxis(), -z_turns);
		
		
		return Projection.x(SpinY.x(SpinZ.x(SpinX.x(piv.getMoveMatrix()))));
	}
}