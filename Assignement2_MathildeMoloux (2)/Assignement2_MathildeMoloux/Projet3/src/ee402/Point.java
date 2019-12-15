package ee402;

///class for the coordinate x and y of a point 
public class Point {
 
	private double x;
	private double y;
 
 
	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
 
	public double getX(){
		return this.x;
	}
 
	public double getY(){
		return this.y;
	}
}