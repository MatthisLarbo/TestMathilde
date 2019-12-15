package ee402;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Vector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


///Class for the graphic
public class Graph extends JPanel{
	
	
	private Map<String, Curve>multipleclient;	
	private Bool client;
		
	public Graph(Bool cl, Map<String, Curve>multipleclient) {		
		
		this.client = cl;
		this.multipleclient = multipleclient;		
	}
	
	///method to print the curve and the axis
	public void paint(Graphics g){
		
		///dimension of the Rectangle
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, 700, 530);
		
		///axis x and y
		g.setColor(Color. black);
		g.drawLine(10, 40, 10, 450);
	    g.drawLine(10, 450, 700, 450);
	    
	    ///drawing string on the gui
	    g.drawString("50°C", 2 ,38);
	    g.drawString("0°C", 2, 463);
	    g.drawString("Temp (°C)", 4, 15);
	    g.drawString("Time (s)", 650, 465);
	    
	    ///browsing the map to know clientID
	    Set<String> keys = this.multipleclient.keySet();
	    Iterator<String> iterateur = keys.iterator();
	    int j = 0;
	    while(iterateur.hasNext())
	    {
	    	j++;
	    	
	    	Curve c = multipleclient.get(iterateur.next());
	    	Vector<Point> p = c.getPoint();
	    	Color colour = c.getColor();
	    	
	    	///for 5 Clients 
	    	if(j==1 && p.size()>1 && client.c1==true)
	    	{
	    		for(int i=0; i<p.size()-1; i++){
			    	
		    	    ///drawing the curve of the first client
					Point p1=p.get(i);
					Point p2=p.get(i+1);
					int x1=(int)p1.getX();
					int y1=(int)p1.getY();
					int x2=(int)p2.getX();
					int y2=(int)p2.getY();

					g.setColor(colour);
					g.drawLine(x1, y1, x2, y2);
					
					///drawing lines to print a cross for the different point
					g.setColor(Color.black);
					g.drawLine(x1-4, y1, x1+4, y1);
					g.drawLine(x1, y1-4, x1, y1+4);
					
			    
				}
	    	}
	    		if(j==2 && p.size()>1 && client.c2==true)
		    	{
		    		for(int i=0; i<p.size()-1; i++){
				    	
			    	  
						Point p1=p.get(i);
						Point p2=p.get(i+1);
						int x1=(int)p1.getX();
						int y1=(int)p1.getY();
						int x2=(int)p2.getX();
						int y2=(int)p2.getY();

						g.setColor(colour);
						g.drawLine(x1, y1, x2, y2);

						g.setColor(Color.black);
						g.drawLine(x1-4, y1, x1+4, y1);
						g.drawLine(x1, y1-4, x1, y1+4);
						
				    
					}
		    	}
		    		if(j==3 && p.size()>1 && client.c3==true)
			    	{
			    		for(int i=0; i<p.size()-1; i++){
					    	
				    	    
							Point p1=p.get(i);
							Point p2=p.get(i+1);
							int x1=(int)p1.getX();
							int y1=(int)p1.getY();
							int x2=(int)p2.getX();
							int y2=(int)p2.getY();

							g.setColor(colour);
							g.drawLine(x1, y1, x2, y2);

							g.setColor(Color.black);
							g.drawLine(x1-4, y1, x1+4, y1);
							g.drawLine(x1, y1-4, x1, y1+4);
							
					    
						}
			    	}
			    		if(j==4 && p.size()>1 && client.c4==true)
				    	{
				    		for(int i=0; i<p.size()-1; i++){
						    	
					    	    
								Point p1=p.get(i);
								Point p2=p.get(i+1);
								int x1=(int)p1.getX();
								int y1=(int)p1.getY();
								int x2=(int)p2.getX();
								int y2=(int)p2.getY();

								g.setColor(colour);
								g.drawLine(x1, y1, x2, y2);

								g.setColor(Color.black);
								g.drawLine(x1-4, y1, x1+4, y1);
								g.drawLine(x1, y1-4, x1, y1+4);
								
						    
							}
				    	}
				    		if(j==5 && p.size()>1 && client.c5==true)
					    	{
					    		for(int i=0; i<p.size()-1; i++){
							    	
						    	    
									Point p1=p.get(i);
									Point p2=p.get(i+1);
									int x1=(int)p1.getX();
									int y1=(int)p1.getY();
									int x2=(int)p2.getX();
									int y2=(int)p2.getY();

									g.setColor(colour);
									g.drawLine(x1, y1, x2, y2);

									g.setColor(Color.black);
									g.drawLine(x1-4, y1, x1+4, y1);
									g.drawLine(x1, y1-4, x1, y1+4);
									
							    
								}
	    	}
	    }      
	}
	
}
 