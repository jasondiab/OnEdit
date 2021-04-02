package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Text extends WhiteboardShape	
{
	String text;
	public Text(int x1, int y1, int x2, int y2, Color colorInst,String s) 
	{
		super(x1, y1, x2, y2, colorInst);
		text = s;
	}
	public void paint(Graphics graphicsInst)
	{
		graphicsInst.setColor(this.colorInst);
		Font fontInst = new Font(Font.SANS_SERIF,Font.PLAIN,18);
		graphicsInst.setFont(fontInst);
		graphicsInst.drawString(text,x1,y1);
	}
}
