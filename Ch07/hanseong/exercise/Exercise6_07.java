package exercise;

class MyPoint {
	int x;
	int y;
	
	public MyPoint(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistance(int x, int y) {
		return Math.sqrt((x-this.x) + (y-this.y));
	}
}

public class Exercise6_07 {
		
	public static void main(String[] args) {
	
		MyPoint p = new MyPoint(1,1);
		
		System.out.println(p.getDistance(3, 4));
	}
	
}
