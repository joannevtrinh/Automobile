// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package driver;
import java.io.IOException;
import exception.BadDataException;
import Model.*;
import Util.*;
import adapter.*;

public class DriverLab2 
{
	public static void main(String [] args) throws BadDataException, IOException
	{
		String filename = "src/CarProperties.txt";
		proxyAutomobile test = new BuildAuto();
		test.buildAuto(filename, 0);
		String modelName = "Ford Focus Wagon ZTW";
		float num = (float) 1.45;
		test.printAuto(modelName);
		test.updateOPrice("Ford Focus Wagon ZTW", "Color", "Gold Clearcoat Metallic", num);
		test.updateOSName("Ford Focus Wagon ZTW", "Color", "Colour");
		test.printAuto(modelName);
	
		System.out.println("Corrupted Car Properties");
		System.out.println(" ");
		filename = "src/CorruptedCarProperties.txt";
		test = new BuildAuto();
		test.buildAuto(filename, 0);
		modelName = "Ford Focus Wagon ZTW";
		test.printAuto(modelName);
		
	}
	
}

