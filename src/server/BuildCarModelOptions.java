package server;

import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;

import adapter.*;
import Model.Automobile;
import adapter.proxyAutomobile;

public class BuildCarModelOptions extends proxyAutomobile
{
	BuildAuto proxyA = new BuildAuto();

	public BuildCarModelOptions()
	{
		
	}

	public Automobile createAutomobile(Properties pobj)
	{
		String carMake = pobj.getProperty("CarMake");
		String carModel = " " + pobj.getProperty("CarModel");

		String basePriceS = pobj.getProperty("BasePrice");
		System.out.println(basePriceS);
		float basePrice = Float.parseFloat(basePriceS);
		
		Automobile auto = new Automobile(carMake, carModel, basePrice, 5);
		
		String Option1 = pobj.getProperty("Option1");
		auto.setOptionSet(0, Option1, 10);
		
		String OptionValue1a = pobj.getProperty("OptionValue1a");
		String OptionPrice1aS = pobj.getProperty("OptionPrice1a");
		float OptionPrice1a = Float.parseFloat(OptionPrice1aS);

		auto.setOption(Option1, 0, OptionValue1a, OptionPrice1a);
		
		//autoA.setOption(osName, index, oName, price);
		
		String OptionValue1b = pobj.getProperty("OptionValue1b");
		String OptionPrice1bS = pobj.getProperty("OptionPrice1b");
		float OptionPrice1b = Float.parseFloat(OptionPrice1bS);
		
		auto.setOption(Option1, 1, OptionValue1b, OptionPrice1b);
		
		String OptionValue1c = pobj.getProperty("OptionValue1c");
		String OptionPrice1cS = pobj.getProperty("OptionPrice1c");
		float OptionPrice1c = Float.parseFloat(OptionPrice1cS);
		
		auto.setOption(Option1, 2, OptionValue1c, OptionPrice1c);
		
		String OptionValue1d = pobj.getProperty("OptionValue1d");
		String OptionPrice1dS = pobj.getProperty("OptionPrice1d");
		float OptionPrice1d = Float.parseFloat(OptionPrice1dS);
		
		auto.setOption(Option1, 3, OptionValue1d, OptionPrice1d);
		
		String OptionValue1e = pobj.getProperty("OptionValue1e");
		String OptionPrice1eS = pobj.getProperty("OptionPrice1e");
		float OptionPrice1e = Float.parseFloat(OptionPrice1eS);
		
		auto.setOption(Option1, 4, OptionValue1e, OptionPrice1e);
		
		String OptionValue1f = pobj.getProperty("OptionValue1f");
		String OptionPrice1fS = pobj.getProperty("OptionPrice1f");
		float OptionPrice1f = Float.parseFloat(OptionPrice1fS);
		
		auto.setOption(Option1, 5, OptionValue1f, OptionPrice1f);
		
		String OptionValue1g = pobj.getProperty("OptionValue1g");
		String OptionPrice1gS = pobj.getProperty("OptionPrice1g");
		float OptionPrice1g = Float.parseFloat(OptionPrice1gS);
		
		auto.setOption(Option1, 6, OptionValue1g, OptionPrice1g);
		
		String OptionValue1h = pobj.getProperty("OptionValue1h");
		String OptionPrice1hS = pobj.getProperty("OptionPrice1h");
		float OptionPrice1h = Float.parseFloat(OptionPrice1hS);
		
		auto.setOption(Option1, 7, OptionValue1h, OptionPrice1h);
		
		String OptionValue1i = pobj.getProperty("OptionValue1i");
		String OptionPrice1iS = pobj.getProperty("OptionPrice1i");
		float OptionPrice1i = Float.parseFloat(OptionPrice1iS);
		
		auto.setOption(Option1, 8, OptionValue1i, OptionPrice1i);
		
		String OptionValue1j = pobj.getProperty("OptionValue1j");
		String OptionPrice1jS = pobj.getProperty("OptionPrice1j");
		float OptionPrice1j = Float.parseFloat(OptionPrice1jS);
		
		auto.setOption(Option1, 9, OptionValue1j, OptionPrice1j);
		
		
		String Option2 = pobj.getProperty("Option2");
		
		auto.setOptionSet(1, Option2, 2);
		
		String OptionValue2a = pobj.getProperty("OptionValue2a");
		String OptionPrice2aS = pobj.getProperty("OptionPrice2a");
		float OptionPrice2a = Float.parseFloat(OptionPrice2aS);

		auto.setOption(Option2, 0, OptionValue2a, OptionPrice2a);

		//autoA.setOption(osName, index, oName, price);
		
		String OptionValue2b = pobj.getProperty("OptionValue2b");
		String OptionPrice2bS = pobj.getProperty("OptionPrice2b");
		float OptionPrice2b = Float.parseFloat(OptionPrice2bS);
		
		auto.setOption(Option2, 1, OptionValue2b, OptionPrice2b);
		
		String Option3 = pobj.getProperty("Option3");
		auto.setOptionSet(2, Option3, 3);
		
		String OptionValue3a = pobj.getProperty("OptionValue3a");
		String OptionPrice3aS = pobj.getProperty("OptionPrice3a");
		float OptionPrice3a = Float.parseFloat(OptionPrice3aS);
		
		auto.setOption(Option3, 0, OptionValue3a, OptionPrice3a);
		
		String OptionValue3b = pobj.getProperty("OptionValue3b");
		String OptionPrice3bS = pobj.getProperty("OptionPrice3b");
		float OptionPrice3b = Float.parseFloat(OptionPrice3bS);
		
		auto.setOption(Option3, 1, OptionValue3b, OptionPrice3b);
		
		String OptionValue3c = pobj.getProperty("OptionValue3c");
		String OptionPrice3cS = pobj.getProperty("OptionPrice3c");
		float OptionPrice3c = Float.parseFloat(OptionPrice3cS);
		
		auto.setOption(Option3, 2, OptionValue3c, OptionPrice3c);
		
		String Option4 = pobj.getProperty("Option4");
		auto.setOptionSet(3, Option4, 2);
		
		String OptionValue4a = pobj.getProperty("OptionValue4a");
		String OptionPrice4aS = pobj.getProperty("OptionPrice4a");
		float OptionPrice4a = Float.parseFloat(OptionPrice4aS);
		
		auto.setOption(Option4, 0, OptionValue4a, OptionPrice4a);
		
		String OptionValue4b = pobj.getProperty("OptionValue4b");
		String OptionPrice4bS = pobj.getProperty("OptionPrice4b");
		float OptionPrice4b = Float.parseFloat(OptionPrice4bS);
		
		auto.setOption(Option4, 1, OptionValue4b, OptionPrice4b);
		
		String Option5 = pobj.getProperty("Option5");
		auto.setOptionSet(4, Option5, 2);
		
		String OptionValue5a = pobj.getProperty("OptionValue5a");
		String OptionPrice5aS = pobj.getProperty("OptionPrice5a");
		float OptionPrice5a = Float.parseFloat(OptionPrice5aS);
		auto.setOption(Option5, 0, OptionValue5a, OptionPrice5a);
		
		String OptionValue5b = pobj.getProperty("OptionValue5b");
		String OptionPrice5bS = pobj.getProperty("OptionPrice5b");
		float OptionPrice5b = Float.parseFloat(OptionPrice5bS);
		
		auto.setOption(Option5, 1, OptionValue5b, OptionPrice5b);
		
		return auto;
	}
	
	public void addAutotoLHM(Automobile a1)
	{
		
		proxyA.getFleet().addAuto(a1.getName(), a1);
		
	}
}


