package scale;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Automobile;
import Model.OptionSet;
import adapter.*;

public class EditOptions extends proxyAutomobile implements Runnable, ScaleThread
{
	//class EditOptions extends ProxyAutomotive implements Runnable, ScaleThread
	private String name;
	Thread a1; 
	int ops;
	
	// edit optionset and options
	public EditOptions()
	{
		name = "Default";
		Thread a1 = new Thread();
		ops = -1;
	}
	
	public EditOptions(String givenName, int ops)
	{
		//create an instance of a1 for a given ops
		name = givenName;
		Thread a1 = new Thread();
		this.ops = ops;
		
	}
	
	public void run()
	{
		switch(ops)
		{
			case 0:
				try
				{
					System.out.println(name + " has started");
					
					System.out.println("Please enter the Model Name. HINT : Ford Focus Wagon ZTW");
					Scanner in = new Scanner(System.in);
					String modelName = in.nextLine();
					System.out.println("Please enter the Option Set Name");
					String OSName = in.nextLine();
					System.out.println("Please enter the new Option Set Name");
					String newName = in.nextLine();
				
					updateOSName(modelName, OSName, newName);
					Thread.sleep(10000);
				}
		
				catch (InterruptedException e1) 
				{
					System.out.println(name + " has been interrupted");
				}
				
				System.out.println(name + " is over");
			
			break;
			
			case 1:
				try
				{
					System.out.println("Please enter the Model Name. HINT : Ford Focus Wagon ZTW");
					Scanner out = new Scanner(System.in);
					String modelNameB = out.nextLine();
					System.out.println("Please enter the Option Set Name");
					String OsName = out.nextLine();
					System.out.println("Please enter the Option Name");
					String OName = out.nextLine();
					System.out.println("Please enter the new Option Price");
					float newPrice = out.nextFloat();
	
					updateOptionPrice(modelNameB, OsName, OName, newPrice);
				
					Thread.sleep(10000);
				}
				
				catch (InterruptedException e) 
				{
					System.out.println(name + " has been interrupted");
				}
				
				System.out.println(name + " is over");
			break;
			
		}
	}
	
	public void start()
	{
		//run();
		
		if(a1 == null)
		{
			a1 = new Thread(this, name);
			a1.start();
			
		}
		
	}
	
	public void stop()
	{
		System.out.println(name + " has stopped");
	}
	
	public synchronized void updateOSName(String modelName, String OSName, String newName)
	{
		super.updateOSName(modelName, OSName, newName);
	

		super.printAuto(modelName);
	}
	
	public synchronized void updateOptionPrice(String modelName, String OName, String OSName, float newPrice)
	{
		super.updateOPrice(modelName, OName, OSName, newPrice);
	
		
		super.printAuto(modelName);
	}

	
	/*
	 * Thread a1;
    int ops;
    EditOptions(int ops, Object [] args) {
        this.ops = ops; //create an instance of a1 for a given ops
    }
    
    void run() {
        switch(ops)
        {
           case 0:  updateOptionName(..); break;
           case 1:  updateOptionPrice(..); break;
        }
    }

    void start () {

    }

    void stop () {

    }    
	 */
	
	/*
	//Update operations for Fleet/Automobile/OptionSet/Option - Wrapper methods
	    synchronized void updateOptionName (...) { - 
	        call methods in proxyAuto - updateOptionName is implemented in proxyAuto - methods are declared in scaleThread or whatever interface.
	    }

	    synchronized void updateOptionPrice (...) {
	        call methods in proxyAuto - updateOptionPrice is implemented in proxyAuto - methods are declared in scaleThread or whatever interface.
	    }
	*/


	
}
