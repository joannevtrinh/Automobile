// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package Model;
//If this was a real project, all of the functions will check if the objects
// in the arrays were null. But for here, I will only do it for some

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Automobile implements Serializable {
    
	private String name;
	private float baseprice;
	private ArrayList <OptionSet> opset = new ArrayList<OptionSet>();
	private String make;
	private String model;
	private float totalprice;
	
	public Automobile()
	{
		name = "Default";
		baseprice = 0;
		make = "Default";
		model = "Default";
		ArrayList<OptionSet> opset = new ArrayList<OptionSet>();
		
	}
	
	public Automobile(String inputMake, String inputModel, float inputbprice, int size)
	{
		name = inputMake + inputModel;
		baseprice = inputbprice;
		make = inputMake;
		model = inputModel;
		//opset = new OptionSet[size];
		ArrayList<OptionSet> opset = new ArrayList<OptionSet>(size);
		
		//  ArrayList<String> list = new ArrayList<String>
	}
	
	public String getModel()
	{
		return model;
	}
	
	public String getName() // 1
	{
		return name;
	}
	
	public float getTotalPrice()
	{
		float totalprice = 0;
		
		for (int i = 0; i < opset.size(); i++)
		{
			float tempprice = opset.get(i).getTotalPrice();
			totalprice = totalprice + tempprice;
		}
		
		return totalprice+getBPrice();
		
	}
	
	public float getBPrice() // 2
	{
		return baseprice;
	}
	
	public OptionSet getOptionSet(int index) // 3
	{
		return opset.get(index);
	}
	
	public String getMake()
	{
		return make;
	}
	
	public int getOptionSetLength() // 4
	{
		return opset.size();
	}
	
	public String getOptionName(int index, String oName) // 5
	{
		Option tempoption = opset.get(index).getOption(oName);
		
		if(tempoption != null)
		{
			return tempoption.getName();
		}
		
		return "None";
	}
	
	public String getOptionName(int indexO, int indexOS) // 6
	{
		Option tempOption = opset.get(indexO).getOption(indexOS);
		
		if(tempOption != null)
		{
			return tempOption.getName();
		}
		
		return "None";
	}
	
	public float getOptionPrice(int index, String oName) // 7
	{
		Option tempoption = opset.get(index).getOption(oName);
		
		if(tempoption != null)
		{
			return tempoption.getPrice();
		}
		
		return -1;
	}
	
	public float getOptionPrice(int indexO, int indexOS) // 8
	{
		Option tempOption = opset.get(indexO).getOption(indexOS);
		
		if(tempOption != null)
		{
			return tempOption.getPrice();
		}
		
		return -1;
	}
	
	public String getOptionSetName(int index) // 9
	{
		return opset.get(index).getName();
	}
	
	public String getOptionChoice(String OSname)
	{
		return opset.get(this.findOSindex(OSname)).getChoice().getName();
	}
	
	public float getOptionChoicePrice(String OSname)
	{
		return opset.get(this.findOSindex(OSname)).getChoice().getPrice();
	}
	
	public void setOptionChoice(String OSname, String optionName)
	{
		int index = this.findOSindex(OSname);
		Option op = this.findOption(OSname, optionName);
		opset.get(index).setChoice(op);
	}
	
	public void setTotalPrice(float inputtotalprice)
	{
		totalprice = inputtotalprice;
	}

	public OptionSet findOptionSet(String inputname) // 10
	{
		for(int i = 0; i < opset.size(); i++)
		{
			if(opset.get(i).getName().equals(inputname))
			{
				return opset.get(i);
			}
		}
		
		return null;
		
		// if(opset[i].getName().equals(inputname))
	}
	
	public OptionSet findOptionSet(int index) // 11
	{
		return opset.get(index);
	}
	
	public int findOSindex(String inputname) // 12
	{
		for(int i =0; i < opset.size(); i++)
		{
			if(opset.get(i).getName().equals(inputname))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public Option findOption(String osName, String oName) // 13
	{
		OptionSet tempOptset = findOptionSet(osName);
		return tempOptset.getOption(oName);
	}
	
	public Option findOption(String osName, String oname, int index) // 14
	{
		return opset.get(index).getOption(oname);
	}
	
	public void setMake(String inputmake)
	{
		make = inputmake;
	}
	
	public void setChoice(String inputname, float inputprice)
	{
		Option choice = new Option(inputname, inputprice);
		
	}
	
	public void setName(String inputname) // 15
	{
		name = inputname;
	}
	
	public void setModel(String inputmodel)
	{
		model = inputmodel;
	}
	
	public void setbPrice(float inputbprice) //16
	{
		baseprice = inputbprice;
	}
	
	public void setOptionSet(int index, String inputname, ArrayList<Option> inputopt) // 17
	{
		opset.get(index).setOptions(inputopt);
		opset.get(index).setName(inputname);
	}
	
	public void setOptionSetSize(int size) // 18
	{
		ArrayList<OptionSet> opset = new ArrayList<OptionSet>(size);
	}
	
	public void setOptionSet(int index, String inputname, int size) // 19
	{
		if (inputname == null) {
			throw new IllegalArgumentException("Ahhhhh");
		}
		// System.out.printf("setOptionSet(%d, %s, %d)\n", index, inputname, size);
		OptionSet tempOS = new OptionSet(inputname, size);
		opset.add(index, tempOS);
	}
	
	public void setOption(String inputosName, int index, String inputoName, float inputprice) // 20
	{
		for(int i = 0; i < opset.size(); i++)
		{
			// System.out.printf("opset[%d], %s\n", i, opset.get(i).getName());
			if(opset.get(i).getName().equals(inputosName))
			{
				opset.get(i).setOption(index, inputoName, inputprice);
				return;
			}
		}
	
	}
	
	public void updateOptionSet(String inputname, ArrayList<Option> inputopt) // 21
	{
		OptionSet tempOS = findOptionSet(inputname);
		
		tempOS.setName(inputname);
		tempOS.setOptions(inputopt);
	}
	
	public void updateOption(String optionsetName, String inputname, float inputprice) // 22
	{
		Option tempOpt = findOption(optionsetName, inputname);
		
		tempOpt.setName(inputname);
		tempOpt.setPrice(inputprice);
	}
	
	public void updateOptionName(int index, String oName, String newName) // 23
	{
		Option tempoption = opset.get(index).getOption(oName);
		
		if(tempoption != null)
		{
			tempoption.setName(newName);
			
			System.out.println("Done ");
		}
	}
	
	public void updateOptionPrice(int index, String oName, float newPrice) // 24
	{
		Option tempoption = opset.get(index).getOption(oName);
		
		if(tempoption != null)
		{
			tempoption.setPrice(newPrice);
			
			System.out.println("Done");
		}
	}
	
	public void updateOSName(int index, String osnewName) // 25
	{
		opset.get(index).setName(osnewName);
	}
	
	
	public void updateOSName(String osnewName, String oldosName) // 26
	{
		for(int i = 0; i < opset.size(); i++)
		{
			if(opset.get(i).getName().equals(oldosName))
			{
				opset.get(i).setName(osnewName);
				System.out.println("Done");
			}
		}
	}
	
	public void updateOName(String osName, String newOName, String oldoName) //27
	{
		for(int i = 0; i <opset.size(); i++)
		{
			if(opset.get(i).getName().equals(osName))
			{
				Option tempO = opset.get(i).getOption(oldoName);
				if(tempO != null)
				{
					int x = opset.get(i).getOptionIndex(tempO);
					tempO.setName(newOName);
					
					opset.get(i).setOption(x, tempO);
				}
				
			}
		}
	}
	
	public void updateOPrice(String osName, String oName, float newOPrice) //28
	{
		for(int i = 0; i < opset.size(); i++)
		{
			if(opset.get(i).getName().equals(osName))
			{
				Option tempO = opset.get(i).getOption(oName);
				
				if(tempO != null)
				{
					int x = opset.get(i).getOptionIndex(tempO);
					tempO.setPrice(newOPrice);
					
					opset.get(i).setOption(x, tempO);
					
					System.out.println("Done");
				}
				
			}
		}
	}
	
	public void deleteOption(String osName, String oName) //29
	{
		for(int i = 0; i < opset.size(); i++)
		{
			if(opset.get(i).getName().equals(osName))
			{
				Option tempO = opset.get(i).getOption(oName);
				tempO = null;
				opset.get(i).setOption(i, tempO);
			}
		}
	}
	
	public void deleteOption(int index, String oName, String osName) //30
	{
		Option tempO = opset.get(index).getOption(oName);
		int a = opset.get(index).getOptionIndex(tempO);
		tempO = null;
		
		opset.get(index).setOption(a, tempO);
	}
	
	public void deleteOption(int indexO, int indexOS, String oName) // 31
	{
		Option tempO = opset.get(indexO).getOption(oName);
		tempO = null;
		
		opset.get(indexO).setOption(indexOS, tempO);
	}
	
	public void deleteOption(int indexO, int indexOS) //32
	{
		Option tempO = null;
		opset.get(indexOS).setOption(indexO, tempO);
	}
	
	public void deleteOptionSet(String osName) // 33
	{
		for(int i = 0; i < opset.size(); i++)
		{
			if(opset.get(i).getName().equals(osName))
			{
				opset.remove(i);
			}
		}
	}
	
	public void deleteOptionSet(int index) //34
	{
		opset.remove(index);
	}
	
	public void deleteAllOS() //35
	{
		opset.clear();
	}
	
	public void hasOptionSet(String osName) // 36
	{
		for(int i = 0; i < opset.size(); i++)
		{
			if(opset.get(i).getName().equals(osName))
			{
				System.out.println("This option set exists");
			}
			
		}
		
		
		
		
	}
	
	public void hasOptionSet(int index) // 37
	{
		OptionSet tempOS = opset.get(index);
		
		if(tempOS != null)
		{
			System.out.println("OptionSet exists");
		}
		else
		{
			System.out.println("OptionSet does not exist");
		}
	}
	
	public void hasOption(String oName, String osName) // 38
	{
		for(int i =0; i < opset.size(); i++)
		{
			if(opset.get(i).getName().equals(osName))
			{
				Option tempO = opset.get(i).getOption(oName);
				
				if(tempO.getName().equals(oName))
				{
					System.out.println("Option exists");
				}
			}
		}
		
	}
	
	public void hasOption(int indexO, String osName) // 39
	{
		Option tempO = opset.get(indexO).getOption(osName);
		
		if(tempO != null)
		{
			System.out.println("Option exists");
		}
		
		else
		{
			System.out.println("Option does not exist");
		}
	}
	
	public void printAttributes() //40
	{
		System.out.println(getName());
		System.out.println(" ");
		System.out.println(getBPrice());
		System.out.println(" ");
		
		for(int i = 0; i < opset.size(); i++)
		{
			opset.get(i).printAttributes();
		}
	}
	
	/*
	 
	 // Please don't worry about the serialize and deserializing methods in here. 
	 // I just want to leave them here just in case I want to use it in future labs/classes
	public void serialize(String filename) 
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

	/*public static Automobile deserialize(String filename)
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
	*/
}
