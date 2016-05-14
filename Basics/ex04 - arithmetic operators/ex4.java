import java.util.Scanner;
import java.lang.Math;

class ex4{
	public static void main(String args[]){
		double x, y;
		x = 5;
		y = 2;
		
		System.out.println(x+" + "+y+" = "+(x + y));
		System.out.println(x+" + "+y+" = "+(x - y));
		System.out.println(x+" + "+y+" = "+(x * y));
		System.out.println(x+" + "+y+" = "+(x / y));
		System.out.println(x+" + "+y+" = "+(x % y));
		System.out.print(  x+" + "+y+" = "+(Math.pow(x, y)));
		
	}
}