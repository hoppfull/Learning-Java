//Implementing Runnable will allow us to put this class in a seperate thread
public class GraphicsEngine implements Runnable{
	@Override
	public void run(){
		System.out.println("yo!");
	}
}