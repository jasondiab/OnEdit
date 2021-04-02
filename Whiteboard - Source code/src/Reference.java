package src;

import java.net.*;
import java.util.LinkedList;
import java.io.*;

public class Reference extends Thread
{
    public static LinkedList<Whiteboard> whiteBoards = new LinkedList<Whiteboard>();
	
	//keeping gui server up to date by keeping track of board and clients
    public static int numClients=0;
    public static int numBoards=0;
	
	// Client socket Instance 
    private final Socket clientSocket;
	
	// Input 
    private ObjectInputStream inStreamInst;
	
    // Output 
    private ObjectOutputStream outStreamInst;
	
	//local board 
    private Whiteboard whiteboardInst;
	
	//to read commands
    private Object objectInst;
    
    // connection handler constructer
    public Reference(Socket clientSocket) 	
    {
        this.clientSocket = clientSocket;
    }
    // incoming command from client socket are received and processed
	
    //reads inputs from client
    private boolean readCommand() 
    {
    	//try reading input
        try 
        {
            objectInst = inStreamInst.readObject();
        } 
		
        //for a null
        catch (Exception e) 
        {
            objectInst = null;
        }
		
        //close socket if objectInst is null
        if (objectInst == null) 
        {
            this.closeSocket();
            return false;
        }
		
        // if input is string do the following
        if(objectInst.getClass() == String.class)	
        {
        	String s = (String) objectInst;
        	if(s.compareTo("new")==0)
        		newBoard();
        	if(s.compareTo("disconnect")==0)
        			disconnect();
        }
		
        //else shape added to correct whiteboard
        else	
        {
        	WhiteboardShape whiteboardInst = (WhiteboardShape) objectInst;
        	addShape(whiteboardInst);
        }
        
        return true;
    }
	
	//main thread execution
    @Override
    public void run() 
    {
		// store in inStreamInst and outStreamInst the inputs and outputs to processe them later
        try 
        {
            this.inStreamInst = new ObjectInputStream(clientSocket.getInputStream());
            this.outStreamInst = new ObjectOutputStream(clientSocket.getOutputStream());
            while (this.readCommand()) { }

         } 
         catch (IOException e) 
         {
                e.printStackTrace();
         }
    }


    public synchronized void addShape(WhiteboardShape shape)
    {
    	whiteboardInst.add(shape,this);
    }
	
    //inStreamInst sent to client
    public void sendShape(WhiteboardShape shape)	
    {
    	try {
			outStreamInst.writeObject(shape);
			outStreamInst.flush();
		} catch (IOException e) {
			System.err.println("Error writing shape to client");
		}
    	
    }
	
    // when a client joins a  new board we use the following to display the shapes present.  
	public void updateClient()
    {
    	for(WhiteboardShape s: whiteboardInst.shapes)
    	{
    		try {
    			outStreamInst.writeObject(s);
    			outStreamInst.flush();
    		} catch (IOException e) {
    			System.err.println("Error writing initial shapes to client");
    		}
    	}
    }
    
    // Close client socketInst 
    public void closeSocket()		
    {
        try 
        {
        	if(whiteboardInst!=null)
        		whiteboardInst.removeClient(this);
            this.outStreamInst.close();
            this.inStreamInst.close();
            this.clientSocket.close();
        } 
        catch (Exception ex) 
        {
            System.err.println(ex.toString());
        }
    }
	
    //when a client connects to server
    public void newBoard()	
    {
    	numClients++;
    	Server.updateServer();
		
		//used to see if there inStreamInst already
    	boolean isMatch = false;
		
    	String s = null;
		try {
			// boardID
			s = (String) inStreamInst.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	for(Whiteboard board: whiteBoards)
    	{
			//checks for required board
    		if(s.compareTo(board.boardID)==0)	
    		{
				//client joins existing board
    			try{    			
    				whiteboardInst = board;	
    				whiteboardInst.addClient(this);
    				updateClient();
    				isMatch=true;
    				break;
    			}
    			catch(Exception e1)
    			{
    				e1.printStackTrace();
    			}
    		}
    	}
		
		//if no existing board matched
		//new board inStreamInst created
    	if(!isMatch)
    	{
    		whiteboardInst = new Whiteboard(s);	
    		whiteboardInst.addClient(this);
    		whiteBoards.add(whiteboardInst);
    		numBoards++;
    		Server.updateServer();
    	}
    }
	
	//when client disconnect from board
    public void disconnect()	
    {
    	whiteboardInst.removeClient(this);
    	numClients--;
    	Server.updateServer();
    	Server.updateGUI();
    }
}