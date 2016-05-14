import java.util.Random;

class ex4{
	public static void main(String args[]){
			Random random = new Random();
			
			for(int i=0; i<10; i++){
				int x = random.nextInt(5);
				System.out.println(x);
			}
			//This program spits out values between 0 (including 0) and 2 (not including 2)
	}
}