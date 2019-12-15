package ee402;

import java.net.*;
import java.util.Map;
import java.util.Vector;
import java.io.*;

public class ThreadedConnectionHandler extends Thread
{
    private Socket clientSocket = null;				// Client socket object
    private ObjectInputStream is = null;			// Input stream
    private ObjectOutputStream os = null;			// Output stream
    private Vector<TransferData> previousData;
    private Map<String, Curve>multipleclient;
	
	// The constructor for the connection handler
    public ThreadedConnectionHandler(Socket clientSocket, Map<String, Curve>multipleclient) {

        this.clientSocket = clientSocket;  
        this.previousData = new Vector<TransferData>();
        this.multipleclient= multipleclient;
    }

    // Will eventually be the thread execution method - can't pass the exception back
    public void run() {

         try {
            this.is = new ObjectInputStream(clientSocket.getInputStream());
            this.os = new ObjectOutputStream(clientSocket.getOutputStream());
            
            while (this.readCommand()) {}
         } 

         catch (IOException e) 
         {
        	System.out.println("XX. There was a problem with the Input/Output Communication:");
            e.printStackTrace();
         }
    }

    // Receive and process incoming string commands from client socket 
    private boolean readCommand() {
        TransferData data = null;

        try {
            data = (TransferData) is.readObject();
            System.out.println(data.toString());
            float r = (float)(Math.random()*50);
            data.setTemp(r);
            
            if(!this.multipleclient.containsKey(data.getclientID()))
            {
            	Curve v = new Curve();
            	this.multipleclient.put(data.getclientID(), v);
            }
            
    		if(previousData.size() == 20)
    		{
    			previousData.removeElementAt(0);
    		}
            previousData.add(data);
            Curve curve = multipleclient.get(data.getclientID());
            curve.Generate(previousData);
            
            System.out.println("The Vector contains " + previousData.size() + " elements");
        } 

        catch (Exception e){    // catch a general exception
        	this.closeSocket();

            return false;
        }
        
        this.frequency();
   
        return true;
    }

  
   // send the frequency to the server
    private void frequency()
    {
    	this.send(1000);
    }
    
    // Send a generic object back to the client 
    private void send(Object o) {

        try {
            System.out.println("02. -> Sending (" + o +") to the client.");
            this.os.writeObject(o);
            this.os.flush();
        } 

        catch (Exception e) {
            System.out.println("XX." + e.getStackTrace());
        }
    }
    
    // Send a pre-formatted error message to the client 
    public void sendError(String message) { 
        this.send("Error:" + message);	//remember a String IS-A Object!
    }
    
    // Close the client socket 
    public void closeSocket() { //gracefully close the socket connection

        try {
            this.os.close();
            this.is.close();
            this.clientSocket.close();
        } 

        catch (Exception e) {
            System.out.println("XX. " + e.getStackTrace());
        }
    }
}