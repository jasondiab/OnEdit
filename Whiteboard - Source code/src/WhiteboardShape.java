package src;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

// white board shape
@SuppressWarnings("serial")
public abstract class WhiteboardShape implements Serializable   
{
	int x1,y1,x2,y2;	
	Color colorInst;
	public WhiteboardShape(int x1,int y1, int x2, int y2, Color colorInst)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.colorInst = colorInst;
	}
	//all shapes must have the paint method
	public abstract void paint(Graphics graphicsInst);	
}