package src;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends JFrame implements Runnable
{
	/**
	 * Static Elements
	 */
	
	//comunication with the server
	public Socket socketInst = null;
	public ObjectOutputStream outStreamInst = null;
	public ObjectInputStream inStreamInst = null;
	
	//to draw all the shapes we implemented
	public int x1;
	public int y1;
	public WhiteboardShape s;
	Color colorInst;
	
    //to color the buttons
	public JRadioButton redButton;
	public JRadioButton blueButton;
	public JRadioButton greenButton;
	public JRadioButton yellowButton;
	public JRadioButton blackButton;    
	
	//tool for buttons
	public JRadioButton lineButton;
	public JRadioButton squareButton;
	public JRadioButton filledSquareButton;
	public JRadioButton circleButton;
	public JRadioButton filledCircleButton;
	public JRadioButton textButton;
	
	//where we will draw shapes
	public WhiteboardCanvas Board;
	
	//buttons for the connections
	public JButton newBoardButton;	
	public JButton disconnectButton;
    public JButton saveButton;
	
    //Left bar has those
	public ButtonGroup toolbar;	
	public ButtonGroup colorbar;
	
    //different areas of frame
	public JPanel connectionPanel;
	public JPanel eastPanel;
	public JPanel toolsPanel;
	public JPanel colorPanel;
	
	
	/**
	 * Constructor
	 */
	
	public Client(String ip,String clientID) 	
	{
		super("OnEdit: Whiteboard- "+clientID);
		
		//failure to connect to server
		if(failconnect(ip))	
		{
			System.err.println("Cannot open socketInst connection...");
		} else { 
			//connect to hardcoded server
			this.setBounds(100, 100, 860, 600);
			this.setResizable(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setLayout(new BorderLayout());	//chooses layout
			connectionPanel = new JPanel(new FlowLayout());	//sets our areas
			eastPanel = new JPanel(new GridLayout(2,2));
			colorPanel = new JPanel(new GridLayout(0,2));
			toolsPanel = new JPanel(new GridLayout(0,2));
			Board = new WhiteboardCanvas();
			connectionPanel.setBorder(BorderFactory.createBevelBorder(2));
			toolsPanel.setBorder(BorderFactory.createBevelBorder(2));
			colorPanel.setBorder(BorderFactory.createBevelBorder(2));
			connectionPanel.setBackground(Color.DARK_GRAY);
			colorPanel.setBackground(Color.white);
			toolsPanel.setBackground(Color.white);
			eastPanel.add(toolsPanel);
			eastPanel.add(colorPanel);

			//we added the pannels
			this.add("North",connectionPanel);	
			this.add("East",eastPanel);
			this.add("Center",Board);
                        
			newBoardButton = new JButton("Join or create a new board");
			Color oyellow = new Color(255,204,0);
			newBoardButton.setBackground(oyellow);
			newBoardButton.setOpaque(true);
			saveButton = new JButton("Save as PNG");
			saveButton.setBackground(oyellow);
			saveButton.setOpaque(true);
			saveButton.setEnabled(false);
                        
			//initiantion of the buttons
			disconnectButton = new JButton("Leave Board");
			disconnectButton.setBackground(oyellow);
			disconnectButton.setEnabled(false);
			lineButton = new JRadioButton("",true);
			lineButton.setBackground(Color.WHITE);
			squareButton = new JRadioButton("",true);
			squareButton.setBackground(Color.WHITE);
			filledSquareButton = new JRadioButton("");
			filledSquareButton.setBackground(Color.WHITE);
			circleButton = new JRadioButton("");
			circleButton.setBackground(Color.WHITE);
			filledCircleButton  = new JRadioButton("");
			filledCircleButton.setBackground(Color.WHITE);
			textButton = new JRadioButton("");
			textButton.setBackground(Color.WHITE);
			lineButton.setEnabled(false);
			squareButton.setEnabled(false);
			filledSquareButton.setEnabled(false);
			circleButton.setEnabled(false);
			filledCircleButton.setEnabled(false);
			textButton.setEnabled(false);
			lineButton.setActionCommand("line");
			squareButton.setActionCommand("rect");
			filledSquareButton.setActionCommand("filledSquare");
			circleButton.setActionCommand("circle");
			filledCircleButton.setActionCommand("filledCircle");
			textButton.setActionCommand("text");
			redButton = new JRadioButton("");
			redButton.setBackground(Color.WHITE);
			blueButton = new JRadioButton("");
			blueButton.setBackground(Color.WHITE);
			greenButton = new JRadioButton("");
			greenButton.setBackground(Color.WHITE);
			yellowButton = new JRadioButton("");
			yellowButton.setBackground(Color.WHITE);
			blackButton = new JRadioButton("");
			blackButton.setBackground(Color.WHITE);
			redButton.setEnabled(false);
			blueButton.setEnabled(false);
			greenButton.setEnabled(false);
			yellowButton.setEnabled(false);
			blackButton.setEnabled(false);
			redButton.setActionCommand("red");
			blueButton.setActionCommand("blue");
			greenButton.setActionCommand("green");
			yellowButton.setActionCommand("yellow");
			blackButton.setActionCommand("black");
			toolbar = new ButtonGroup();
			colorbar = new ButtonGroup();
			toolbar.add(textButton);     
			toolbar.add(lineButton);	
			toolbar.add(squareButton);
			toolbar.add(filledSquareButton);
			toolbar.add(circleButton);
			toolbar.add(filledCircleButton);
			colorbar.add(yellowButton);
			colorbar.add(redButton);
			colorbar.add(blueButton);
			colorbar.add(greenButton);
			colorbar.add(blackButton);
			connectionPanel.add(newBoardButton);
			connectionPanel.add(new JLabel(new ImageIcon("res/hii.png")));
			connectionPanel.add(new JLabel(new ImageIcon("res/whiteboard.png")));
			connectionPanel.add(new JLabel(new ImageIcon("res/hii.png")));
			connectionPanel.add(disconnectButton);
			connectionPanel.add(saveButton);
			connectionPanel.add(new JLabel(new ImageIcon("res/hii.png")));
			connectionPanel.add(new JLabel(new ImageIcon("res/hi.png")));
           
			lineButton.setSelected(true);
			
			toolsPanel.add(new JLabel(new ImageIcon("res/text.png")));
			toolsPanel.add(textButton);
			
			toolsPanel.add(new JLabel(new ImageIcon("res/line.png")));
			toolsPanel.add(lineButton);
			
			toolsPanel.add(new JLabel(new ImageIcon("res/squarenofill.png")));
			toolsPanel.add(squareButton);
			
			toolsPanel.add(new JLabel(new ImageIcon("res/squarefill.png")));
			toolsPanel.add(filledSquareButton);
			
			toolsPanel.add(new JLabel(new ImageIcon("res/circlenofill.png")));
			toolsPanel.add(circleButton);
			
			toolsPanel.add(new JLabel(new ImageIcon("res/circlefill.png")));
			toolsPanel.add(filledCircleButton);
			
			
			
			blackButton.setSelected(true);
			
			colorPanel.add(new JLabel(new ImageIcon("res/black.png")));
			colorPanel.add(blackButton);

			colorPanel.add(new JLabel(new ImageIcon("res/yellow.png")));
			colorPanel.add(yellowButton);

			colorPanel.add(new JLabel(new ImageIcon("res/red.png")));
			colorPanel.add(redButton);
			
			colorPanel.add(new JLabel(new ImageIcon("res/blue.png")));
			colorPanel.add(blueButton);
			
			colorPanel.add(new JLabel(new ImageIcon("res/green.png")));
			colorPanel.add(greenButton);
			       
			Board.setBackground(Color.WHITE);
			
			Board.setEnabled(false);
			this.pack();
			
			
            //shape painting on board
			MouseAdapter mouseAdapter = (new MouseAdapter()	
			{
				public void mousePressed ( MouseEvent e )
	            {
					System.out.println("5");
					Color ored = new Color(251,51,0);
					Color oblue = new Color(47,85,151);
					Color ogreen = new Color(146,208,80);
					if(colorbar.getSelection().getActionCommand()=="red")
						colorInst = ored;
					if(colorbar.getSelection().getActionCommand()=="blue")
						colorInst = oblue;
					if(colorbar.getSelection().getActionCommand()=="green")
						colorInst = ogreen;
					if(colorbar.getSelection().getActionCommand()=="yellow")
						colorInst = Color.white;
					if(colorbar.getSelection().getActionCommand()=="black")
						colorInst = Color.black;
					x1 = e.getX();
					y1 = e.getY();
					if(toolbar.getSelection().getActionCommand()=="line")
						Board.addTemp(new Line(e.getX(),e.getY(),e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="rect")
						Board.addTemp(new Square(e.getX(),e.getY(),e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="filledSquare")
						Board.addTemp(new FilledSquare(e.getX(),e.getY(),e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="circle")
						Board.addTemp(new Circle(e.getX(),e.getY(),e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="filledCircle")
						Board.addTemp(new FilledCircle(e.getX(),e.getY(),e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="text")
						writeText();
	            }
	            public void mouseDragged ( MouseEvent e )	
	            {
	            	if(toolbar.getSelection().getActionCommand()=="line")
						Board.addTemp(new Line(x1,y1,e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="rect")
						Board.addTemp(new Square(x1,y1,e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="filledSquare")
						Board.addTemp(new FilledSquare(x1,y1,e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="circle")
						Board.addTemp(new Circle(x1,y1,e.getX(),e.getY(),colorInst));
					if(toolbar.getSelection().getActionCommand()=="filledCircle")
						Board.addTemp(new FilledCircle(x1,y1,e.getX(),e.getY(),colorInst));

	            }
				
                //saving shape
	            public void mouseReleased ( MouseEvent e )	
	            {
	            	if(toolbar.getSelection().getActionCommand()=="line")
	            	{
	            		Line l = new Line(x1,y1,e.getX(),e.getY(),colorInst);
						Board.add(l);
						try {
							outStreamInst.writeObject(l);
							outStreamInst.flush();
						} catch (IOException e1) {
							System.err.println("Error writing object");
						}
	            	}
	            	
					if(toolbar.getSelection().getActionCommand()=="rect")
					{
	            		Square r = new Square(x1,y1,e.getX(),e.getY(),colorInst);
						Board.add(r);
						try {
							outStreamInst.writeObject(r);
							outStreamInst.flush();
						} catch (IOException e1) {
							System.err.println("Error writing object");
						}
	            	}
					if(toolbar.getSelection().getActionCommand()=="filledSquare")
					{
	            		FilledSquare r = new FilledSquare(x1,y1,e.getX(),e.getY(),colorInst);
						Board.add(r);
						try {
							outStreamInst.writeObject(r);
							outStreamInst.flush();
						} catch (IOException e1) {
							System.err.println("Error writing object");
						}
	            	}
					if(toolbar.getSelection().getActionCommand()=="circle")
					{
	            		Circle objectInst = new Circle(x1,y1,e.getX(),e.getY(),colorInst);
						Board.add(objectInst);
						try {
							outStreamInst.writeObject(objectInst);
							outStreamInst.flush();
						} catch (IOException e1) {
							System.err.println("Error writing object");
						}
	            	}
					if(toolbar.getSelection().getActionCommand()=="filledCircle")
					{
	            		FilledCircle objectInst = new FilledCircle(x1,y1,e.getX(),e.getY(),colorInst);
						Board.add(objectInst);
						try {
							outStreamInst.writeObject(objectInst);
							outStreamInst.flush();
						} catch (IOException e1) {
							System.err.println("Error writing object");
						}
	            	}
	            }
			});
			
			//connect button
			newBoardButton.addActionListener(new ActionListener()	
			{
				public void actionPerformed(ActionEvent e) {
					newBoard();
				}
			});
                        
                        saveButton.addActionListener(new ActionListener()	
			{
				public void actionPerformed(ActionEvent e) {
					try {
						String s = JOptionPane.showInputDialog(null,"Enter PNG file name","Save",1);
						saveimage(s+".png");
					} catch (IOException ex) {
						Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			});
			
			//disconnect button
			disconnectButton.addActionListener
			(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) {
					leave();
				}
			}
			);
			Board.addMouseListener(mouseAdapter);
			Board.addMouseMotionListener(mouseAdapter);
                        System.out.println("run");
                        String displayname = JOptionPane.showInputDialog(null,"Choose your display name","Welcome",1);
                        this.setTitle("OnEdit WhiteBoard- "+displayname);
                        newBoard();
                        this.run();
            }

	}//end of constructor
	
	/**
	 * Called by saveimage for exporting board as PNG
	 */
	public static BufferedImage getScreenShot(Component component) 
	{
		BufferedImage image = new BufferedImage
		(
			component.getWidth(),
			component.getHeight(),
			BufferedImage.TYPE_INT_RGB
		);
	
		// call the Component's paint method, using
		// the Graphics object of the image.
		component.printAll( image.getGraphics() ); // alternately use .printAll(..)
		return image;
	}
	
	
	/**
	 * Saves image to PNG
	 */
	public void saveimage(String fileName) throws IOException{
		BufferedImage img = getScreenShot(Board);
		ImageIO.write(img, "png", new File(fileName));
	}
		
	/**
	 * Client connect to a new or existing board
	 */
	public void newBoard()
	{
		try {
			outStreamInst.writeObject("new");	
			outStreamInst.flush();
		} catch (IOException e) {
			System.err.println("Error creating conversation");
		}
		
		String s = JOptionPane.showInputDialog(null,"Create or join a board","Project",1);
		if(s!=null)
		{
			if(s.compareTo("")==0)
				JOptionPane.showMessageDialog (this, "Please provide a board name");
			else
				try {
					outStreamInst.writeObject(s);
					outStreamInst.flush();
				} catch (IOException e) {
					System.err.println("Server was interrupted");
				}
		}
		
		//update the client gui
		lineButton.setEnabled(true);	
		squareButton.setEnabled(true);
		filledSquareButton.setEnabled(true);
		circleButton.setEnabled(true);
		filledCircleButton.setEnabled(true);
		textButton.setEnabled(true);
		
		redButton.setEnabled(true);
		blueButton.setEnabled(true);
		greenButton.setEnabled(true);
		yellowButton.setEnabled(true);
		blackButton.setEnabled(true);
		
		Board.setEnabled(true);
		newBoardButton.setEnabled(false);
		disconnectButton.setEnabled(true);
		saveButton.setEnabled(true);
			
	}

	/**
	 * Connection to server attempt via ip
	 */
	private boolean failconnect(String ip)	 //
	{
        System.out.println("connect to server");
		//new socket Instance and create streams
		try
        {
			this.socketInst = new Socket(ip,5050);
			this.outStreamInst = new ObjectOutputStream(this.socketInst.getOutputStream());
			this.inStreamInst = new ObjectInputStream(this.socketInst.getInputStream());
			System.out.print("Connected to Server\n");
        } 
        catch (Exception ex) 
        {
        	System.err.print("Failed to Connect to Server\n" + ex.toString());	
        	System.err.println(ex.toString());
        	return true;
        }
		return false;
	}
	
	/**
	 * Special method to type text
	 */
	public void writeText()
	{
		String s = JOptionPane.showInputDialog(null,"Enter Text: ","",1);	//input box for dialoge
		if(s!=null)
		{
			Text t = new Text(x1,y1,0,0,colorInst,s);
			Board.add(t);
			try {
				outStreamInst.writeObject(t);
				outStreamInst.flush();
			} catch (IOException e1) {
				System.err.println("Error writing object");
			}
		}
	}
	
	
	/**
	 * Client leaves a board
	 */
	public void leave()
	{
		//writes to the reference to handle the disconnection
		try {
			outStreamInst.writeObject("disconnect");
			outStreamInst.flush();
		} catch (IOException e) {
			System.err.println("Error creating conversation");
		}
		
		//buttons updated
		lineButton.setEnabled(false);
		squareButton.setEnabled(false);
		filledSquareButton.setEnabled(false);
		circleButton.setEnabled(false);
		filledCircleButton.setEnabled(false);
		textButton.setEnabled(false);
		redButton.setEnabled(false);
		blueButton.setEnabled(false);
		greenButton.setEnabled(false);
		yellowButton.setEnabled(false);
		blackButton.setEnabled(false);
		Board.setEnabled(false);
		newBoardButton.setEnabled(true);
		disconnectButton.setEnabled(false);
		
		//board cleared
		Board.clear();
	}
	
	/**
	 * Client has joined a board
	 * listens for inputed shapes from server
	 */
	public void run()
	{
		//Server status
		boolean isRunning = true;
		
		//infinitely checks for new inputs as long as the server is running
		while(isRunning)
		{
		try {
			Object objectInst = inStreamInst.readObject();
			s = (WhiteboardShape) objectInst;
		} catch (Exception e){
			
			//Server status updated
			isRunning = false;
			
			//Error shows
			JOptionPane.showMessageDialog(null, "Server has stopped responding. Your work is offline and not being saved");
			System.err.println("Server has stopped running, please exit");
		}
		
		//new shape is added
		if(s!=null)
			 Board.add(s);
		}
		
	}
	
	/**
	 * Main method: connects client to localhost
	 */
	public static void main(String [] args)	
	{
		if(args.length>0)
		{
		   new Client(args[0],args[1]);
                   System.out.println("main");
		}
                
		else
		{
			new Client("127.0.0.1","");
		}
	}
}