package src;

import java.awt.Color;
import java.awt.Graphics;

//to get a disc option
public  class FilledCircle extends WhiteboardShape	
{
	public FilledCircle(int x1, int y1, int x2, int y2, Color colorInst) 
	{
		super(x1, y1, x2, y2, colorInst);
	}
	public void paint(Graphics graphicsInst)
	{
		graphicsInst.setColor(this.colorInst);
		if(x1>x2&&y1<y2)
			graphicsInst.fillOval(x2, y1, (x1-x2), (y2-y1));
		if(x1<x2&&y1<y2)
			graphicsInst.fillOval(x1, y1, (x2-x1), (y2-y1));
		if(x1<x2&&y1>y2)
			graphicsInst.fillOval(x1, y2, (x2-x1), (y1-y2));
		if(x1>x2&&y1>y2)
			graphicsInst.fillOval(x2, y2, (x1-x2), (y1-y2));
	}
}
