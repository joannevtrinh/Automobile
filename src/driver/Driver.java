// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package driver;

import java.io.IOException;
import exception.BadDataException;
import Model.Automobile;
import Util.*;
import Model.*;

public class Driver {

	public static void main(String[] args) throws IOException, BadDataException
	{
		String filename = "src/CarProperties.txt";
		Automobile auto = ReadSource.buildAutoObject(filename);
		
		auto.printAttributes();
		ReadSource test = new ReadSource();
		test.serialize(auto);
	
		Automobile newAuto = test.deserialize("auto.ser");
		newAuto.printAttributes();
		
		System.out.println("Done");
		
		/*
		//Build Automobile Object from a file.
		 Automobile FordZTW = (Some instance method in a class of Util
		package).readFile("FordZTW.txt");
		 //Print attributes before serialization
		 FordZTW.print();
		 //Serialize the object
		 Lab1.autoutil.FileIO.serializeAuto(FordZTW);
		 //Deserialize the object and read it into memory.
		 Automobile newFordZTW = Lab1.autoutil.FileIO.DeserializeAuto("auto.ser");
		 //Print new attributes.
		 newFordZTW.print();
		 */
		
		
	}
}
