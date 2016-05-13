package client;

import java.util.Properties;

import Util.ReadSource;

public class CarModelOptionsIO 
{
	public Properties readData(String filename)
	{
		ReadSource helper = new ReadSource();
	    Properties pObj = helper.readProp(filename);
	    
	    return pObj;
	}
	//public Properties readdata(String fname
}
