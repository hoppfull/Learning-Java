package src.engine.objects;

import src.utilities.mathematics.mat4;
import src.utilities.mathematics.Linalg;

public class WorldGrid{
	private static mat4 W;
	public static mat4 apply(mat4 scene){
		W = new mat4();
		W.setIdentity();
		W.setM(1,1, 0); W.setM(1,2, 1);
		W.setM(2,1, 1); W.setM(2,2, 0);
		
		return Linalg.MatrixMult(W, scene);
	}
}