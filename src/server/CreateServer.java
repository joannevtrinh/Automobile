package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import client.DefaultSocketClient;
import adapter.BuildAuto;
import adapter.proxyAutomobile;
import Model.Automobile;
import Model.automobileFleet;
import client.SocketClientConstants;

public class CreateServer implements SocketClientConstants
{
	
	
	private ServerSocket a1;
	private DefaultSocketClient dsc;
	private int state = WAITING;
	private automobileFleet fleet;
	private Automobile auto;
	
	CreateServer(int port)
	{
		a1 = null;
		
		try 
		{
			a1 = new ServerSocket(port);
			System.out.println("Server has been created ");
		} 
		
		catch (IOException e) 
		{
			System.err.println("Could not listen on port : " + port);
		}
	}
	
	public void startServer()
	{   
		while(true)
		{	
			try
			{
				Socket clientSocket = a1.accept();
				dsc = new DefaultSocketClient(clientSocket);
				dsc.setServer(this);
			}
			
			catch(IOException e)
			{
				 System.err.println("Accept failed.");
		         System.exit(1);
			}
			
			dsc.start();
		}
		
	}

	public void handleSession()
	{
		state = WAITING;
		Object tempObj;
		
		while((tempObj = dsc.getInput()) != null)
		{
			if (state == WAITING)
			{
				if (tempObj.getClass() != Integer.class)
				{
					throw new RuntimeException("tempObj is not an integer");
				}
				state = (Integer) tempObj;
			}
			else if (state == GOING_TO_TALK_TO_YOU)
			{
				System.out.println("First line: " + tempObj.toString());
				state = READ_FIRST_LINE;
			}
			else if (state == READ_FIRST_LINE)
			{
				System.out.println("Second line: " + tempObj.toString());
				dsc.sendOutput("I hate you.");
				state = I_HATE_YOU;
			}
			else if (state == I_HATE_YOU)
			{
				System.out.println("Third line: " + tempObj.toString());
				dsc.sendOutput("Bye.");
				state = WAITING;
			}
			else if (state == BUILD_AUTO_FROM_PROPS)
			{
				Properties tempPobj = (Properties) tempObj;
				BuildCarModelOptions bcmo = new BuildCarModelOptions();
				Automobile auto = bcmo.createAutomobile(tempPobj);
				bcmo.addAutotoLHM(auto);
				automobileFleet fleet = bcmo.getFleet();
				setFleet(fleet);
				System.out.println(fleet.getAllAutoNames());
				dsc.sendOutput("Server is done with building auto");
				state = WAITING;
			}
			
			else if (state == SERVER_SEND_LHM)
			{
				String dummy = "Dummy";
				if(dummy.equals(tempObj.toString()))
				{
					sendLHM();	
					state = WAITING;
				}
			}
			
			else if(state == GET_AUTO_FROM_LHM)
			{
				String name = tempObj.toString();
				System.out.println(name);
				
				Automobile auto = getFleet().get(name);
				
				dsc.sendOutput(auto);
				state = WAITING;
			}
			
		}
	}
	
	public void setFleet(automobileFleet fleet)
	{
		this.fleet = fleet;
	}
	
	public automobileFleet getFleet()
	{
		return fleet;
	}
	
	public void sendLHM()
	{	
		BuildAuto baObj = new BuildAuto();
		automobileFleet fleet = baObj.getFleet().getInstance();
		setFleet(fleet);
		dsc.sendOutput(fleet.getAllAutoNames());
		state = WAITING;
	}
	
	public void stopServer()
	{
		System.out.println("WE SO DONE");
		try 
		{
			a1.close();
		} 
		catch (IOException e)
		{
			System.out.println("Could not close server");
		}
		
		dsc.closeSession();
	}
	
	public static void main(String [] args)
	{
		CreateServer cs = new CreateServer(4444);
		cs.startServer();
		cs.stopServer();
	}
		
	/*
	 * Server has been created 
		18445
		Name: Ford Focus Wagon ZTW
		[Ford Focus Wagon ZTW]
		Writing: Server is done with building auto
		18445
		Name: Toyota Corolla
		[Ford Focus Wagon ZTW, Toyota Corolla]
		Writing: Server is done with building auto
		Writing: [Ford Focus Wagon ZTW, Toyota Corolla]
		Ford Focus Wagon ZTW
		Writing: Model.Automobile@5099681b
		This object that was read is null
		Let's close.

	 */
	
}
