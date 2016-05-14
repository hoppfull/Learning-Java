class Matrix4f{
	private float[][] M;
	
	public Matrix4f(){//Initalizing values?
		M = new float[4][4];
	}
	
	public Matrix4f identity(){
		Matrix4f I = new Matrix4f()
		
		I[0][0] = 1;	I[0][1] = 0;	I[0][2] = 0;	I[0][3] = 0;
		I[1][0] = 0;	I[1][1] = 1;	I[1][2] = 0;	I[1][3] = 0;
		I[2][0] = 0;	I[2][1] = 0;	I[2][2] = 1;	I[2][3] = 0;
		I[3][0] = 0;	I[3][1] = 0;	I[3][2] = 0;	I[3][3] = 1;
		
		return I;
	}
	
	public Matrix4f dot(Matrix4f A){
		Matrix4f MA = new Matrix4f;
		
		for(int n=0;n<4;n++){
			for(int m=0;m<4;m++){
				MA[n][m] = M[n][0]*A[0][m] + M[n][1]*A[1][m] + M[n][2]*A[2][m] + M[n][3]*A[3][m];
			}
		}
		return MA;
		
	}
	
	public float getElement(int n, int m){
		return M[n][m];
	}
	
	public void setElement(int n, int m, float value){
		M[n][m] = value;
	}
	
	public float[][] getM(){
		return M;
	}
	public void setM(float[][] M){
		this.M = M;
	}
}