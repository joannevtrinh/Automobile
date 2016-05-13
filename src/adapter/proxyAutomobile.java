// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package adapter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;
import server.BuildCarModelOptions;
import exception.BadDataException;
import Model.*;
import Model.automobileFleet.*;
import Util.*;

public abstract class proxyAutomobile implements CreateAuto, UpdateAuto
{
	//private static LinkedHashMap<String, Automobile> a1 = new LinkedHashMap<String, Automobile>();
	
	
	public proxyAutomobile()
	{
		//auto = new automobileFleet();
		//a1 = new LinkedHashMap<String, Automobile>();
	}
	
	public automobileFleet getFleet()
	{
		return automobileFleet.getInstance();
	}
	
	public void buildAuto(String filename, int filetype) throws BadDataException, IOException
	{
		Automobile dummy = null;
		
		try 
		{
			dummy = ReadSource.buildAutoObject(filename);
			//a1 = ReadSource.buildAutoObject(filename);
			
			if(dummy != null)
			{
				getFleet().getHashMap().put(dummy.getName(), dummy);
				System.out.println(dummy.getName());
			}
		}
		
		catch (FileNotFoundException e) 
		{
			throw new BadDataException(101, "File name wasn't found");
			//throw new RuntimeException(e);
		}
	}
	
	public void printAuto(String modelName)
	{
		getFleet().getHashMap().get(modelName).printAttributes();
	}
	
	public void updateOPrice(String modelName, String OName, String OSName, float newPrice)
	{
		getFleet().get(modelName).updateOPrice(OName, OSName, newPrice);
		//public void updateOPrice(String osName, String oName, float newOPrice)
	}
	
	public void updateOSName(String modelName, String OSName, String newName)
	{
		getFleet().get(modelName).updateOSName(newName, OSName);
		// public void updateOSName(String osnewName, String oldosName)
	}

	
}
