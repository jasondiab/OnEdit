package src;

import java.util.LinkedList;

public class Whiteboard
{	
	//shapes in board
	public LinkedList<WhiteboardShape> shapes;
	
	//clients connected
	private LinkedList<Reference> clients;
	public String boardID;
	
	//new whiteboard
	public Whiteboard(String boardID)	
	{
		shapes = new LinkedList<WhiteboardShape>();
		clients = new LinkedList<Reference>();
		this.boardID = boardID;
	}
	
	//add a shape to the board
	public synchronized void add(WhiteboardShape s,Reference refInst)	
	{
		shapes.add(s);
		for(Reference r:clients)	//broadcast to all connected clients
		{
			if(r!=refInst)
				r.sendShape(s);
		}
	}
	
	//new client
	public void addClient(Reference refInst)	
	{
		clients.add(refInst);

	}
	
	//client diconnects
	public void removeClient(Reference refInst)	
	{
		clients.remove(refInst);
	}
	
}
