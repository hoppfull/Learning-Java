class Testing{
	public static void run(){
		Mesh mesh = new Mesh();
		Vertex[] v = new Vertex[3];
		
		v[0] = new Vertex(new Vec3( 0.0, 0.7, 0.0));
		v[2] = new Vertex(new Vec3(-0.7,-0.2, 0.0));
		v[1] = new Vertex(new Vec3( 0.7,-0.2, 0.0));
		
		mesh.addVertices(v);
		mesh.draw();
	}
}