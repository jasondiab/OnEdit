package src;

import java.awt.Color;
import java.awt.Graphics;

// to get a line option
@SuppressWarnings("serial")
public  class Line extends WhiteboardShape 
{

	public Line(int x1, int y1, int x2, int y2, Color colorInst) 
	{
		super(x1, y1, x2, y2, colorInst);
	}
	public void paint(Graphics graphicsInst)
	{
		graphicsInst.setColor(this.colorInst);
		graphicsInst.drawLine(x1, y1, x2, y2);
	}
}
