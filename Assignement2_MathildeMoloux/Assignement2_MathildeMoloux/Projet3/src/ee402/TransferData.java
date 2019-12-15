package ee402;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class TransferData implements Serializable {

	private String name;
	private Date date;
	private String clientID; 
	private float temperature;
	private Vector<Float> vecteur;
	
	
public TransferData(String id) {
	
		//TYPE OF THE OBJECT
		this.name = "TransferData";
		this.vecteur = new Vector<Float>();
		
		///read the value in the file : for the raspberry
		
		//String fichier = "/sys/class/thermal/thermal_zone0/temp";
		
		
		//READ OF THE TEMPERATURE VALUE
	/*	int i = 0;
		try {
			InputStream ips= new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br= new BufferedReader(ipsr);
			String ligne;
			while((ligne=br.readLine())!=null)
			{
				i=Integer.parseInt(ligne);
			}
			br.close();
		} catch (Exception e) {System.out.println(e.toString());}
		*/
		
		//ASSIGN READ TEMPERATURE VALUE : generate random values between O and 50
		
		this.temperature = (float)(Math.random() * 50);
		vecteur.add(temperature);
		//CREATION OF THE CALENDAR AND READ VALUE
	    Calendar C = Calendar.getInstance();
	    this.date = C.getTime();
	    this.clientID =id;
	   
	}

	   public String toString()
	   {
		   //System.out.println("The client" + clientID + "temperature is" +temperature+ "at date" +date.toString());
		   return "The client " +clientID + " temperature is " +temperature+ " at date " + date.toString();
	   }
	    
	  ///getter
	   public String getName()
	   {
		   return this.name;
	   }

	   public float getTemp()
	   {
		   return this.temperature;
	   }
	
	   public Date getDate()
	   {
		   return this.date;
	   }
	
	   public String getclientID()
	   {
		   return clientID;
	   }
	   public void setTemp(float x)
	   {
		   temperature=x;
	   }
}
