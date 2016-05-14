package src.engine.objects;

import src.utilities.mathematics.vec3;
import src.utilities.mathematics.mat4;
import src.utilities.mathematics.Linalg;

public class Pivot{ //Tested and works!
	private vec3 x_axis, y_axis, z_axis, pos;
	private mat4 A, B;
	
	public Pivot(){
		this.x_axis = new vec3(1,0,0);
		this.y_axis = new vec3(0,1,0);
		this.z_axis = new vec3(0,0,1);
		this.pos = new vec3(0,0,0);
		A = new mat4();		B = new mat4();
		A.setIdentity();	B.setIdentity();
	}
	
	public mat4 getPivot(){ //Tested and works!
		B.setTranslation(pos);
		return Linalg.MatrixMult(B, A);
	}
	
	public void rotate(int axis, double turns){ //Tested and works!
		/*Rotates along local axis, lefthanded rule*/
		if(axis == 0)
		{
			x_axis.setMag(1);
			B.setRotation(x_axis, turns);
			y_axis = matrix_multiply(B, y_axis);
			z_axis = matrix_multiply(B, z_axis);
			y_axis.setMag(1);
			z_axis.setMag(1);
		}
		else if(axis == 1)
		{
			y_axis.setMag(1);
			B.setRotation(y_axis, turns);
			z_axis = matrix_multiply(B, z_axis);
			x_axis = matrix_multiply(B, x_axis);
			z_axis.setMag(1);
			x_axis.setMag(1);
		}
		else if(axis == 2)
		{
			z_axis.setMag(1);
			B.setRotation(z_axis, turns);
			x_axis = matrix_multiply(B, x_axis);
			y_axis = matrix_multiply(B, y_axis);
			x_axis.setMag(1);
			y_axis.setMag(1);
		}
		else
		{
			System.err.println("src.engine.objects.Pivot error: 001");
			System.err.println("axis needs to be 0, 1 or 2 for x, y or z");
			System.exit(1);
		}
		
		A = Linalg.MatrixMult(B, A);
	}
	
	public void move(int axis, double distance){ //Tested and works!
		/*Move along local axis*/
		if(axis == 0){
			pos.plus(x_axis, distance);
		}
		else if(axis == 1){
			pos.plus(y_axis, distance);
		}
		else if(axis == 2){
			pos.plus(z_axis, distance);
		}
		else
		{
			System.err.println("src.engine.objects.Pivot error: 002");
			System.err.println("axis needs to be 0, 1 or 2 for x, y or z");
			System.exit(1);
		}
	}
	
	public void rotateAlong(vec3 i, double turns){ //Tested and works!
		/*Rotates along specified axis, lefthanded rule*/
		i.setMag(1);
		
		B.setRotation(i, turns);
		x_axis = matrix_multiply(B, x_axis);
		y_axis = matrix_multiply(B, y_axis);
		z_axis = matrix_multiply(B, z_axis);
		
		x_axis.setMag(1);
		y_axis.setMag(1);
		z_axis.setMag(1);
		
		A = Linalg.MatrixMult(B, A);
	}
	
	public void moveAlong(vec3 i, double distance){ //Tested and works!
		/*Move along specified axis*/
		pos.plus(i, distance);
	}
	
	public void setPos(vec3 i){ //Tested and works!
		/*Set global position*/
		pos = i;
	}
	
	public void setAlignment(mat4 B){ //Tested and works!
		/*Set global rotation or "alignment"*/
		A.setM(0,0, B.getM(0,0)); A.setM(0,1, B.getM(0,1)); A.setM(0,2, B.getM(0,2));
		A.setM(1,0, B.getM(1,0)); A.setM(1,1, B.getM(1,1)); A.setM(1,2, B.getM(1,2));
		A.setM(2,0, B.getM(2,0)); A.setM(2,1, B.getM(2,1)); A.setM(2,2, B.getM(2,2));
		
		x_axis = matrix_multiply(B, new vec3(1,0,0));
		y_axis = matrix_multiply(B, new vec3(0,1,0));
		z_axis = matrix_multiply(B, new vec3(0,0,1));
	}
	
	private vec3 matrix_multiply(mat4 A, vec3 b){ //Tested and works!
		/*Special 3x3 matrix multiplication with 3vector*/
		return new vec3(
				A.getM(0,0)*b.getX() + A.getM(0,1)*b.getY() + A.getM(0,2)*b.getZ(),
				A.getM(1,0)*b.getX() + A.getM(1,1)*b.getY() + A.getM(1,2)*b.getZ(),
				A.getM(2,0)*b.getX() + A.getM(2,1)*b.getY() + A.getM(2,2)*b.getZ()
				);
	}
}