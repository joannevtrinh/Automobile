// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable {
	
	private String name;
	private ArrayList<Option> opt = new ArrayList<Option>();
	private Option choice;
	
	public void setChoice(Option choice) {
		this.choice = choice;
	}

	OptionSet()
	{
		name = "No name Options";
		ArrayList<Option> opt = new ArrayList<Option>(null);
	}
	
	OptionSet(String inputname)
	{
		name = inputname;
		ArrayList<Option> opt = new ArrayList<Option>(null);;
	}
	
	OptionSet(String inputname, int size)
	{
		name = inputname;
		ArrayList<Option> opt = new ArrayList<Option>(size);
		
		//ArrayList<String> list = new ArrayList<String>();
	}
	
	protected void setArraySize(int size)
	{
		ArrayList<Option> opt = new ArrayList<Option>(size);
	}
	
	protected void setName(String inputname)
	{
		name = inputname;
	}
	
	protected void setChoice(String inputname, float inputprice)
	{
		choice.setName(inputname);
		choice.setPrice(inputprice);
	}
	
	protected String getName()
	{
		return name;
	}
	
	protected Option getChoice()
	{
		return choice;
	}
	
	protected Option[] getOptions()
	{
		return (Option[]) opt.toArray();
		//This code originally returns the entire option[] array.
		// return opt;
	}
	
	protected int getOptionIndex(Option tempobj)
	{
		for(int i = 0; i < opt.size(); i++)
		{
			if(opt.get(i).getName().equals(tempobj.getName()))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	protected void setOptions(ArrayList<Option> inputopt)
	{
		opt = inputopt;
		
	}
	
	protected void setOption(int i, String inputname, float inputprice)
	{
		Option tempobj = new Option(inputname, inputprice);
		opt.add(i, tempobj);
		//opt[i].setName(inputname);
		//opt[i].setPrice(inputprice);
	}
	
	protected void setOption(int i, Option tempobj)
	{
		String tempname = tempobj.getName();
		float tempprice = tempobj.getPrice();
		
		opt.get(i).setName(tempname);
		opt.get(i).setPrice(tempprice);
	}
	
	protected Option getOption(String inputname)
	{
		for(int i = 0; i < opt.size(); i++)
		{
			if(opt.get(i).getName().equals(inputname))
			{
				return opt.get(i);
			}
		}
		
		return null;
	}
	
	protected float getOptionPrice(String inputname)
	{
		for(int i = 0; i < opt.size(); i++)
		{
			if(opt.get(i).getName().equals(inputname))
			{
				return opt.get(i).getPrice();
			}
		}
		
		return 0;
	}
	
	protected Option getOption(int i)
	{
		String tempname = opt.get(i).getName();
		float tempprice = opt.get(i).getPrice();
		
		Option tempO = new Option(tempname,tempprice);
		return tempO;
	}
	
	protected int findOption(String inputname)
	{
		for(int i = 0; i < opt.size(); i++)
		{
			if(opt.get(i).getName().equals(inputname))
			{
				return i;
			}
		}
		
		return 0;
	}
	
	protected float getTotalPrice()
	{	
		float total = 0; 
		
		//for(int i = 0; i < opt.size(); i++)
		//{
			//float tempprice = opt.get(i).getTotalPrice();
			//total = total + tempprice;
		//}
		
		//return total;
		
		
		Option tempchoice = this.getChoice();
		float tempprice = tempchoice.getPrice();
		
		return tempprice;
		

	}
	
	// choice is of type option
	
	protected void printAttributes()
	{
		System.out.println("Option Set: " + getName());
		
		for(int i = 0; i < opt.size(); i++)
		{
			opt.get(i).printAttributes();
		}
	}

		/*public static class Option implements Serializable {
		
			private String name;
			private float price;
			
			Option()
			{
				name = "";
				price = 0;
				
			}
			
			Option(String inputname, float inputprice)
			{
				name = inputname;
				price = inputprice;
			}
			
			Option(Option obj)
			{
				name = obj.getName();
				price = obj.getPrice();
			}
			
			protected void setName(String inputname)
			{
				name = inputname;
			}
			
			protected String getName()
			{
				return name;
			}
			
			protected void setPrice(float inputprice)
			{
				price = inputprice;
				
			}
			
			protected float getPrice()
			{
				return price;
			}
			
			protected void printAttributes()
			{
				System.out.println("Option name: " + name);
				System.out.println("Cost:" + price);
				System.out.println(" ");
			}
			
			protected float getTotalPrice()
			{
				float tempprice = this.getPrice();
				return tempprice;
			}
			*/
	
}
	
	
	
	
