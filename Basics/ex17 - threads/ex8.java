class ex8{
	public static void main(String args[]){
		//Threads!
		ex8extra object1 = new ex8extra("Thread 1", 1000);
		ex8extra object2 = new ex8extra("Thread 2", 0);
		ex8extra object3 = new ex8extra("Thread 3", 3000);
		
		Thread thread1 = new Thread(object1);
		Thread thread2 = new Thread(object2);
		Thread thread3 = new Thread(object3);
		
		/* Observe that object1, object2, and object3 are executed in order below here.
		 * But we will find that they don't necessarily start in order and they will finish
		 * in the order of the ones with least code to execute first. It's as if we are
		 * running them simultaniously, parallel rather than linearly. Fascinating!
		 * This can be more efficient. I don't think that means that this code runs three
		 * times as fast. It's not that simple...but still!
		 */
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}