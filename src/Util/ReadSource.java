// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package Util;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Properties;

import exception.*;
import Model.*;


public class ReadSource implements Serializable
{
	public ReadSource()
	{
		
	}
	
	public Properties readProp(String filename)
	{
			Properties props = new Properties();
			
			try
			{
				FileInputStream in = new FileInputStream(filename);
				
				try 
				{
					props.load(in);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String carMake = props.getProperty("CarMake");
				
				System.out.println(carMake);
				
				if(!carMake.equals(null))
				{
					
					String carModel = props.getProperty("CarModel");
					String basePriceS = props.getProperty("BasePrice");	
					float basePrice = Float.parseFloat(basePriceS);
					
					String Option1 = props.getProperty("Option1");
					
					String OptionValue1a = props.getProperty("OptionValue1a");
					String OptionPrice1aS = props.getProperty("OptionPrice1a");
					float OptionPrice1a = Float.parseFloat(OptionPrice1aS);
					
					String OptionValue1b = props.getProperty("OptionValue1b");
					String OptionPrice1bS = props.getProperty("OptionPrice1b");
					float OptionPrice1b = Float.parseFloat(OptionPrice1bS);
					
					String OptionValue1c = props.getProperty("OptionValue1c");
					String OptionPrice1cS = props.getProperty("OptionPrice1c");
					float OptionPrice1c = Float.parseFloat(OptionPrice1cS);
					
					String OptionValue1d = props.getProperty("OptionValue1d");
					String OptionPrice1dS = props.getProperty("OptionPrice1d");
					float OptionPrice1d = Float.parseFloat(OptionPrice1dS);
					
					String OptionValue1e = props.getProperty("OptionValue1e");
					String OptionPrice1eS = props.getProperty("OptionPrice1e");
					float OptionPrice1e = Float.parseFloat(OptionPrice1eS);
					
					String OptionValue1f = props.getProperty("OptionValue1f");
					String OptionPrice1fS = props.getProperty("OptionPrice1f");
					float OptionPrice1f = Float.parseFloat(OptionPrice1fS);
					
					String OptionValue1g = props.getProperty("OptionValue1g");
					String OptionPrice1gS = props.getProperty("OptionPrice1g");
					float OptionPrice1g = Float.parseFloat(OptionPrice1gS);
					
					String OptionValue1h = props.getProperty("OptionValue1h");
					String OptionPrice1hS = props.getProperty("OptionPrice1h");
					float OptionPrice1h = Float.parseFloat(OptionPrice1hS);
					
					String OptionValue1j = props.getProperty("OptionValue1j");
					String OptionPrice1jS = props.getProperty("OptionPrice1j");
					float OptionPrice1j = Float.parseFloat(OptionPrice1jS);
					
					String OptionValue1i = props.getProperty("OptionValue1i");
					String OptionPrice1iS = props.getProperty("OptionPrice1i");
					float OptionPrice1i = Float.parseFloat(OptionPrice1iS);
					
					String Option2 = props.getProperty("Transmission");
					
					String OptionValue2a = props.getProperty("OptionValue2a");
					String OptionPrice2aS = props.getProperty("OptionPrice2a");
					float OptionPrice2a = Float.parseFloat(OptionPrice2aS);
					
					String OptionValue2b = props.getProperty("OptionValue2b");
					String OptionPrice2bS = props.getProperty("OptionPrice2b");
					float OptionPrice2b = Float.parseFloat(OptionPrice2bS);
					
					String Option3 = props.getProperty("Brakes/Traction Control");
					
					String OptionValue3a = props.getProperty("OptionValue3a");
					String OptionPrice3aS = props.getProperty("OptionPrice3a");
					float OptionPrice3a = Float.parseFloat(OptionPrice3aS);
					
					String OptionValue3b = props.getProperty("OptionValue3b");
					String OptionPrice3bS = props.getProperty("OptionPrice3b");
					float OptionPrice3b = Float.parseFloat(OptionPrice3bS);
					
					String OptionValue3c = props.getProperty("OptionValue3c");
					String OptionPrice3cS = props.getProperty("OptionPrice3c");
					float OptionPrice3c = Float.parseFloat(OptionPrice3cS);
					
					String Option4 = props.getProperty("Side Impact Air Bags");
					
					String OptionValue4a = props.getProperty("OptionValue4a");
					String OptionPrice4aS = props.getProperty("OptionPrice4a");
					float OptionPrice4a = Float.parseFloat(OptionPrice4aS);
					
					String OptionValue4b = props.getProperty("OptionValue4b");
					String OptionPrice4bS = props.getProperty("OptionPrice4b");
					float OptionPrice4b = Float.parseFloat(OptionPrice4bS);
					
					String Option5 = props.getProperty("Power Moonroof");
					
					String OptionValue5a = props.getProperty("OptionValue5a");
					String OptionPrice5aS = props.getProperty("OptionPrice5a");
					float OptionPrice5a = Float.parseFloat(OptionPrice5aS);
					
					String OptionValue5b = props.getProperty("OptionValue5b");
					String OptionPrice5bS = props.getProperty("OptionPrice5b");
					float OptionPrice5b = Float.parseFloat(OptionPrice5bS);
					
				}
			}
				
			
			catch(FileNotFoundException fnfe)
			{
				System.out.println("Invalid file name. Please try again with another file name");
			}
			
			return props;
	}
	
	public static Automobile buildAutoObject(String filename) throws IOException, BadDataException
	{
			FileReader file = new FileReader(filename);
			BufferedReader buffy = new BufferedReader(file);
			boolean eof = false;
			
			while(!eof)
			{
				String line = buffy.readLine();
				
				if(line == null)
				{
					eof = true;
				}
				
				else
				{
					String[] firstLineArray = line.split(",");
					String carMake = firstLineArray[0];
					String carModel = firstLineArray[1];
					int baseprice = Integer.parseInt(firstLineArray[2]);
					int numofOS = Integer.parseInt(firstLineArray[3]);
					
					Automobile auto = new Automobile(carMake, carModel, baseprice, numofOS);
					
					try
					{
						readOS(auto, numofOS, buffy);
					}
					catch (NoSuchElementException e)
					{
						throw new BadDataException(102, "Could not read Option Set Data");
						//System.out.println(e.getMessage());
					}
					
					return auto;
		
				}
				
			}
			
			buffy.close();
		
		return null;
		
	}
	
	static void readOS(Automobile autoA, int numofOS, BufferedReader buffy) throws BadDataException
	  {
	  		for(int i = 0; i < numofOS; i++)
	  		{
	  			String line;
	  			
				try 
				{
					line = buffy.readLine();
		  			String[] tempArray = line.split(",");
		  			int index = Integer.parseInt(tempArray[0]);
					String osName = tempArray[1];
					int osSize = Integer.parseInt(tempArray[2]);
					autoA.setOptionSet(index, osName, osSize);
					
					try
					{
						readO(autoA, osName, osSize, buffy);
					}
					
					catch (NoSuchElementException e)
					{
						throw new BadDataException(103,"Could not read options");
						//System.out.println(e.getMessage());
					}

				} 
				
				catch (IOException e) 
				{
					throw new BadDataException(e);
				}
				catch (NullPointerException e)
				{
					autoA.setOptionSet(i, "None", 0);
					continue;
				}
				
	  		}
	  		
	 }
	
	static void readO(Automobile autoA, String osName, int osSize, BufferedReader buffy) throws BadDataException
	{
		for(int a = 0; a < osSize; a++)
		{
			String line;
			
			try 
			{
				line = buffy.readLine();
			} 
			catch (IOException e) 
			{
				throw new BadDataException(e);
			}
			
			String[] tempArray = line.split(",");
			int index = Integer.parseInt(tempArray[0]);
		
			try
			{
				String oName = tempArray[1];
			}
			catch (NumberFormatException e)
			{
				throw new BadDataException(104, "Mission Option Name");
			}
			
			String oName = tempArray[1];
			
			try
			{
				int price = Integer.parseInt(tempArray[2]);
			}
			catch(NumberFormatException e)
			{
				throw new BadDataException(105, "Missing Option Price");
			}
			
			int price = Integer.parseInt(tempArray[2]);
				
			autoA.setOption(osName, index, oName, price);
			
		}
	}
	
	public void serialize(Automobile testauto) 
	{
		try
		{
		 //testauto = ReadSource.buildAutoObject("CarProperties.txt");
		
		 ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("auto.ser"));
		 out.writeObject(testauto);
		 out.close();
		}
		
		catch(Exception e)
		{
			System.out.print("Error:" + e);
			System.exit(1);
		}
	}
	
    /*
	public void serialize(String filename) // 37
	{
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(this);
			out.close();
		}
		
		catch(IOException e)
		{
			System.out.println("Cannot serialize");
		}
	}
	*/
	
	
	public Automobile deserialize(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			return (Automobile) in.readObject();
		}
		
		catch(Exception e)
		{
			System.out.println("Cannot deserialize");
			return null;
		}
	}
}

/*
for(int i = 0; i < numofOS; i++)
{
	line = buffy.readLine();
	String[] tempArray = line.split(",");
	int index = Integer.parseInt(tempArray[0]);
	String osName = tempArray[1];
	int osSize = Integer.parseInt(tempArray[2]);
	
	auto.setOptionSet(index, osName, osSize);
	*/
	
	/*
	 * void readOS(Automobile autoA, int numofOS, BufferedReader buffy)
	 * {
	 * 		for(int i = 0; i < numofOS; i++)
	 * 		{
	 * 			String line = buffy.readLine();
	 * 			String[] tempArray = line.spilt(",");
	 * 			int index = Integer.parseInt(tempArray[0]);
				String osName = tempArray[1];
				int osSize = Integer.parseInt(tempArray[2]);
				
				autoA.setOptionSet(index, osName, osSize);
	 * 		
	 * }
	 * 
	 * void readO(Automobile autoA, int osSize, BufferedReader buffy)
	 * {
	 * 	for(int a = 0; a < osSize; a++)
	
		String line = buffy.readLine();
		String[] tempArray = line.split(",");
		int index = Integer.parseInt(tempArray[0]);
		String oName = tempArray[1];
		int price = Integer.parseInt(tempArray[2]);
		
		autoA.setOption(osName, index, oName, price);
	
	 * }
	 * 
	 * 
	 */
	
	/*for(int a = 0; a < osSize; a++)
	{
		line = buffy.readLine();
		tempArray = line.split(",");
		index = Integer.parseInt(tempArray[0]);
		String oName = tempArray[1];
		int price = Integer.parseInt(tempArray[2]);
		
		auto.setOption(osName, index, oName, price);
	}
}
*/

