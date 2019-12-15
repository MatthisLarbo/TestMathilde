package ee402;

import  javax.swing.*;

import javax.swing.JToggleButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import  java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

///gui of the application  
public class GuiApp extends JFrame implements ItemListener{ 
	
	///declaration of a map. String corresponds to clientID
	private Map<String, Curve>multipleclient;
	private ThreadedServer server;
	
	///boolean for the client
	private Bool client; 
	private Graph C;
	
	///Toggle Button for ON and OFF
	  private JToggleButton bt1;  
	  private JToggleButton bt2;  
	  private JToggleButton bt3;  
	  private JToggleButton bt4;
	  private JToggleButton bt5;
	  
	  ///panel for the button
	  private JPanel panel;
	  
	  ///combinaison of the panel for the button and the panel for the curve
	  private JPanel GeneralPanel;
 
	public GuiApp(){
		
		this.setTitle("Assignment");
		
		this.setSize(700, 530);
		this.setResizable(false);
 
		///exit the frame 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    
	    
	    this.client = new Bool();  
		this.multipleclient = new HashMap<String, Curve>();
		this.C=new Graph( client, this.multipleclient);
		this.panel = new JPanel(new GridLayout(1, 5));
		
		///creation of 5 ToggleButtons
	    bt1 = new JToggleButton("Client 1 ON"); 
	    bt2 = new JToggleButton("Client 2 ON");
	    bt3 = new JToggleButton("Client 3 ON");	    
	    bt4 = new JToggleButton("Client 4 ON");	    
	    bt5 = new JToggleButton("Client 5 ON");

	    bt1.addItemListener(this);	    
	    bt2.addItemListener(this);	    
	    bt3.addItemListener(this);	    
	    bt4.addItemListener(this);	    
	    bt5.addItemListener(this);
	    
	    panel.add(bt1);
	    panel.add(bt2);	    
	    panel.add(bt3);	    
	    panel.add(bt4); 	    
	    panel.add(bt5);
	    
	    	    
		this.GeneralPanel = new JPanel(new BorderLayout());

		this.GeneralPanel.add(panel, BorderLayout.NORTH);
		this.GeneralPanel.add(this.C, BorderLayout.CENTER);
		
	    this.server = new ThreadedServer(this.multipleclient);  
	    this.server.start();
 
		this.getContentPane().add(this.GeneralPanel);
 
		this.setVisible(true);
 
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		go();
	}

	      
///method for the action on the button ON/ OFF
	  public void itemStateChanged(ItemEvent eve)
	  {
	      if(bt1.isSelected())
	      {
	    	  bt1.setText(" Client 1 OFF");
	    	  client.c1=false;
	      }
	    	 		 
		  else {
			  
			  bt1.setText(" Client 1 ON");
			  client.c1=true;
		  }
			      
	      if(bt2.isSelected())
	      {
	    	  bt2.setText(" Client 2 OFF");
	    	  client.c2=false;
	      }    	 
			 
		  else {
			  
			  bt2.setText(" Client 2 ON");
			  client.c2=true;
		  }
	      
	      if(bt3.isSelected())
	      {
	    	  bt3.setText(" Client 3 OFF");
	    	  client.c3=false;
	      }
	    	 			 
		  else {
			  
			  bt3.setText(" Client 3 ON");
			  client.c3=true;
		  }
	      
	      if(bt4.isSelected())
	      {
	    	  bt4.setText(" Client 4 OFF");
	    	  client.c4=false;
	      }
	    		    	 			 
		  else {
			  
			  bt4.setText(" Client 4 ON");
			  client.c4=true;
		  }
	      
	      if(bt5.isSelected())
	      {
	    	  bt5.setText(" Client 5 OFF");
	    	  client.c5=false;
	      }
	    	 			 
		  else {
			  
			  bt5.setText(" Client 5 ON");
			  client.c5=true;
		  }	  
	      
	  }
	  
///method to repaint the JPanel
	  
	  private void go(){  
   

		    while(true){

		      C.repaint();

		      try {

		        Thread.sleep(3);

		      } catch (InterruptedException e) {

		        e.printStackTrace();

		      }

		    }    

		  } 
	  
	  public static void main(String[] args)
	  {
		  new GuiApp();
	  }

}