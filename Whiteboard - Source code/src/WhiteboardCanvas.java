package src;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.LinkedList;

@SuppressWarnings("serial")
//Board for client
public class WhiteboardCanvas extends Canvas
{
	//shapes in whiteboard
	private LinkedList<WhiteboardShape> shapes;
	
	//shape being drown now
	private WhiteboardShape currentShape;
	
	public WhiteboardCanvas()
	{
		super();
		shapes = new LinkedList<WhiteboardShape>();
		currentShape = null;
	}
	
	public void paint(Graphics graphicsInst)	
	{
		for(WhiteboardShape s: shapes)
		{
			s.paint(graphicsInst);
		}
		if(currentShape!=null)
		{	
			//shapes effect
			currentShape.paint(graphicsInst);
			currentShape=null;
		}
	}
	
	//added shapes
	public void add(WhiteboardShape s)	
	{
		shapes.add(s);
		repaint();
	}
	
	//shapes effect
	public void addTemp(WhiteboardShape s)
	{
		currentShape = s;
		repaint();
	}
	
	//clear board
	public void clear()	
	{
		shapes.clear();
		repaint();
	}
}
