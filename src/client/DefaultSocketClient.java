package client;
import java.net.*;
import java.util.Properties;
import java.io.*;

import client.SocketClientConstants.*;
import server.CreateServer;

public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants
{
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket sock;
	private InetAddress strHost;
	private int iPort;
	private CreateClient client;
	private CreateServer server;
	
	public DefaultSocketClient(String strHost, int iPort)
	{
		setPort(iPort);
		
		try 
		{
			setHost(InetAddress.getLocalHost());
		} 
		catch (UnknownHostException e)
		{
			System.out.println("Could not connect to the host");
		}
	}
	
	public DefaultSocketClient(int iPort)
	{
		try 
		{
			setHost(InetAddress.getLocalHost());
		} 
		catch (UnknownHostException e)
		{
			System.out.println("Could not connect to the host");
		}
		
		setPort(iPort);
	}
	
	public DefaultSocketClient(Socket inputSock)
	{
		this.sock = inputSock;
	}
	
	public void run()
	{
		if(openConnection())
		{
			handleSession();
			closeSession();
		}
		
	}

	public boolean openConnection()
	{
		if(sock == null)
		{
		   try 
		   {
			   sock = new Socket(InetAddress.getLocalHost(), iPort);                    
		   }
		   catch(IOException socketError)
		   {
		     if (DEBUG) System.err.println
		        ("Unable to connect to " + strHost);
		     return false;
		   }
		}
		   try 
		   {
			 writer = new ObjectOutputStream(this.getSocket().getOutputStream());
		     reader = new ObjectInputStream(this.getSocket().getInputStream());
		   }
		  catch (Exception e)
		   {
		     if (DEBUG) System.err.println
		       ("Unable to obtain stream to/from " + strHost);
		     return false;
		  }
		  return true;
		}
	
	public void handleSession()
	{
		if (server != null)
		{
			server.handleSession();
		}
		else if (client != null)
		{
			client.handleSession();
		}
		else
		{
			throw new RuntimeException("Neither a server or a client, OMG.");
		}
	}   
	
	public Object getInput()
	{
		try 
		{
			return reader.readObject();
		} 
		catch (Exception e) 
		{
			System.out.println("This object that was read is null");
			return null;
		}
	}

	public void sendOutput(Object inputObj)
	{
		if(inputObj != null)
		{
			try 
			{
				System.out.println("Writing: " + inputObj.toString());
				writer.writeObject(inputObj);
				writer.flush();
			}
			catch (IOException e)
			{
				if (DEBUG) System.out.println ("Error writing to " + strHost);
			}
		}
		
		else if(inputObj == null)
		{
			System.out.println("Object was null. Cannot write/send");
			return;
		}
	}     

    public void closeSession()
    {
    	System.out.println("Let's close.");
       try 
       {
          writer.close();
          reader.close();
          sock.close();
       }
       catch (IOException e)
       {
         if (DEBUG) System.err.println
          ("Error closing socket to " + strHost);
       }       
    }

    public void setClient(CreateClient inputClient)
    {
    	if(inputClient == null)
    	{
    		System.out.println("ITS SO NULL");
    		throw new RuntimeException("SO NULL");
    		
    	}
    	this.client = inputClient;
    }
    
    public CreateClient getClient()
    {
    	return client;
    }
    
    public void setServer(CreateServer inputServer)
    {
    	this.server = inputServer;
    }
    
    public void setHost(InetAddress inetAddressX)
    {
            this.strHost = inetAddressX;
    }

    public void setPort(int iPort)
    {
            this.iPort = iPort;
    }
    
    public Socket getSocket()
    {
    	return this.sock;
    }
    
}
