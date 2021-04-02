package src;

import java.awt.Color;
import java.awt.Graphics;

// to get a filled square option
@SuppressWarnings("serial")
public  class FilledSquare extends WhiteboardShape
{

	public FilledSquare(int x1, int y1, int x2, int y2, Color colorInst) 
	{
		super(x1, y1, x2, y2, colorInst);
	}
	public void paint(Graphics graphicsInst)
	{
		graphicsInst.setColor(this.colorInst);
		if(x1>x2&&y1<y2)
			graphicsInst.fillRect(x2, y1, (x1-x2), (y2-y1));
		if(x1<x2&&y1<y2)
			graphicsInst.fillRect(x1, y1, (x2-x1), (y2-y1));
		if(x1<x2&&y1>y2)
			graphicsInst.fillRect(x1, y2, (x2-x1), (y1-y2));
		if(x1>x2&&y1>y2)
			graphicsInst.fillRect(x2, y2, (x1-x2), (y1-y2));
	}
}
