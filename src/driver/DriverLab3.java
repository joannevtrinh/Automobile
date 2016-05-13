package driver;
import java.io.IOException;
import java.util.ArrayList;

import exception.BadDataException;
import adapter.BuildAuto;
import adapter.proxyAutomobile;
import Model.*;
import Util.*;

public class DriverLab3
{
	public static void main(String [] args) throws BadDataException, IOException
	{
		String filename = "src/CarProperties.txt";
		proxyAutomobile test = new BuildAuto();
		test.buildAuto(filename, 0);
		String modelName = "Ford Focus Wagon ZTW";
		test.printAuto(modelName);	
		
		test.getFleet().getHashMap().get("Ford Focus Wagon ZTW").setOptionChoice("Color","Gold Clearcoat Metallic");
		test.getFleet().getHashMap().get("Ford Focus Wagon ZTW").setOptionChoice("Transmission","Automatic");
		test.getFleet().getHashMap().get("Ford Focus Wagon ZTW").setOptionChoice("Brakes/Traction Control","ABS with Advance Trac");
		test.getFleet().getHashMap().get("Ford Focus Wagon ZTW").setOptionChoice("Side Impact Air Bags","Side Impact Air Bags");
		test.getFleet().getHashMap().get("Ford Focus Wagon ZTW").setOptionChoice("Power Moonroof","Power Moonroof");	
				
		System.out.println("$" + test.getFleet().getHashMap().get("Ford Focus Wagon ZTW").getTotalPrice() + " Total Price");
	
	}

}
