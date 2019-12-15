package ee402;

import java.util.Vector;
import java.awt.Color;
import java.util.Random;

///class where the curve is generated
public class Curve {

	private Vector<Point>listePoints;
	private float time;
	private Color color;
	
	public Curve(){
		this.listePoints = new Vector<Point>();
		this.time = 1;
	
		///random colours
		Random rand = new Random();

	    float r= rand.nextFloat();
	    float gr= rand.nextFloat();
	    float b= rand.nextFloat();
	    
	    this.color = new Color (r, gr, b);
 
	}
	
	
 ///method to add a point into the curve
	public void addingPoint(TransferData data, TransferData first){
		
		int y = 450 - (int)((data.getTemp()/50)*410.0f);
		int x = 700 - (int) (((first.getDate().getTime() - data.getDate().getTime())/1000.0f)/(time/(690.0f/20.0f)));
		
		Point p = new Point(x, y);
		//System.out.println("New Point " + x + " " + y + " for temperature " + data.getTemp());
		this.listePoints.add(p);
		
		
			
	}
	
///function that generate the curve
	public void Generate(Vector<TransferData> previousData)
	{
		this.listePoints.clear();
		if(previousData.size() > 1)
		{
			for(int i = previousData.size()-1; i>-1; i--)
			{
				this.addingPoint(previousData.get(i), previousData.get(previousData.size()-1));
				
			}
		}
	}
 
///getter to return the list of the Point
	public Vector<Point> getPoint()
	{
		   return this.listePoints;
	}
	
///getter to return the color
	public Color getColor()
	{
		   return this.color;
	}
}
