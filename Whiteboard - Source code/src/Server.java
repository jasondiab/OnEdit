package src;

import java.net.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class Server extends JFrame
{   
    private static JLabel numClients;
    private static JLabel numBoards;
    
    //simple gui for displaying server status
    public void Server()
    {
        JFrame server = new JFrame("Server");
        server.setVisible(true);
        server.setDefaultCloseOperation(EXIT_ON_CLOSE);
        server.setBounds(100,500,700,200);
        server.setResizable(true);
        JLabel running = new JLabel ("                 The server is running...                 ",JLabel.CENTER);
        numClients = new JLabel(Reference.numClients + " connected to boards    ", new ImageIcon("res/users.png"),JLabel.CENTER);
        numBoards = new JLabel(Reference.numBoards + " available    ", new ImageIcon("res/boards.png"), JLabel.CENTER);
        server.setLayout(new GridLayout(0,1));
        server.add(running);
        server.add(numClients);
        server.add(numBoards);
        server.pack(); 
    }
	
    //updates server gui
    public static void updateServer()
    {
        numClients.setText(Reference.numClients + " connected to boards");
        numBoards.setText(Reference.numBoards + " available");
    }
    
	//called when server GUI needs to be updated
    public static void updateGUI()
    {
        numClients.setText(Reference.numClients + " connected to boards    ");
        numBoards.setText(Reference.numBoards + " available    ");
    }
    
    // connection approval
    public static void main(String args[])  
    {
        new Server().Server();
        
        ServerSocket serverSocket = null;
        
        try 
        {
            serverSocket = new ServerSocket(5050);  
            System.out.println("Server has started listening on port 5050");
        } 
        catch (IOException e) 
        {
            System.err.println("Error: Cannot listen on port 5050: " + e);
            System.exit(1);
        }
		
        //keep listening to clients 
        while (true)
        {
            Socket clientSocket = null;
            try 
            {
                clientSocket = serverSocket.accept(); //waits until a client connects
                System.out.println("Server has just accepted socketInst connection from a client");
            } 
            catch (IOException e) 
            {
                System.err.println("Accept failed: 5050 " + e);
                break;
            }   
            // Create the Reference Connection object
            Reference con = new Reference(clientSocket);
            con.start();

        }
        try
        {
            System.out.println("Closing server socketInst. ");
            serverSocket.close();
        } 
        catch (IOException e) 
        {
            System.err.println("Could not close server socketInst. " + e.getMessage());
        }
        
    }
}