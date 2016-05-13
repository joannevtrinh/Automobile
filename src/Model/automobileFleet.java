package Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class automobileFleet 
{
	private static LinkedHashMap<String, Automobile> a1 = new LinkedHashMap<String, Automobile>();
	private static automobileFleet instance = null;
	
	public automobileFleet()
	{
		a1 = new LinkedHashMap<String, Automobile>();
	}
	
	public LinkedHashMap<String, Automobile> getHashMap()
	{
		return a1;
	}
	
	public void addAuto(String modelname, Automobile auto)
	{
		a1.put(modelname, auto);
		System.out.println("Name: " + auto.getName());
	}
	
	public void removeAuto(String modelName)
	{
		a1.remove(modelName);
	}
	
	public Automobile get(String name)
	{
		return (Automobile) a1.get(name);
	}
	
	public static automobileFleet getInstance()
	{
		if(instance == null)
		{
			instance = new automobileFleet();
		}
		
		return instance;
	}
	
	public ArrayList<String> getAllAutoNames()
	{
		ArrayList<String> aList = new ArrayList<String>();
		
		for (String name : a1.keySet())
		{
			aList.add(name);
		}
		return aList;
	}
	
}
