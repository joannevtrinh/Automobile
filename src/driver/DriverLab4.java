package driver;

import java.io.IOException;

import scale.EditOptions;
import exception.BadDataException;
import adapter.BuildAuto;
import adapter.proxyAutomobile;
import scale.*;

public class DriverLab4 
{
	public static void main(String [] args) throws BadDataException, IOException
	{
		String filename = "src/CarProperties.txt";
		BuildAuto test = new BuildAuto();
		test.buildAuto(filename,0);
		String modelName = "Ford Focus Wagon ZTW";
		//test.printAuto(modelName);
		
		EditOptions t1 = new EditOptions("Thread 1", 0);
		EditOptions t2 = new EditOptions("Thread 2", 0);
		
		
		t1.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test.printAuto(modelName);		
		
	}

}
