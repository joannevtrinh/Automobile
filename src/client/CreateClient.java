package client;

import java.io.IOException
;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import Model.Automobile;
import Model.automobileFleet;
import Util.ReadSource;

public class CreateClient implements SocketClientConstants
{
	private DefaultSocketClient socketClient;
	private Scanner scanner;
	
	public CreateClient(int portNum)
	{
		scanner = new Scanner(System.in);
		socketClient = new DefaultSocketClient(portNum);
		
		socketClient.setClient(this);
		
		socketClient.start();
		
		//ReadSource helper = new ReadSource();
		//Properties pObj = helper.readProp("src/PropertiesFile.txt");
	}
	
	public void handleSession()
	{
		selectServiceOption();
	}
	
	public void selectServiceOption()
	{
		System.out.println("Choose either options");
		System.out.println("1. Upload a properties file");
		System.out.println("2. Configure a car");
		performOperation();
		
	}
	
	public void performOperation()
	{	
			Scanner scanner = new Scanner(System.in);
			System.out.println("What option do you want to choose?");
			String inputS = scanner.nextLine();
			int input = Integer.parseInt(inputS);
				
			switch(input)
			{
				case(1):
				{
					socketClient.sendOutput(BUILD_AUTO_FROM_PROPS);
					loadProps();
					break;
				}
					
				case(2):
				{	
					socketClient.sendOutput(SERVER_SEND_LHM);
					configureCar(scanner);
					
					break;
				}
					
				default:
				{
					System.out.println("Not an available option. Please press 1 or 2");
					performOperation();
					socketClient.sendOutput(SELECT_SERVICE);
					break;
				}
			}
		
		char choice;
		System.out.println("Do you (still) want to run this program? Please press Y or N");
		
		String selectionS = scanner.nextLine();
		char selection = selectionS.charAt(0);
		
		if(selection == 'n' || selection == 'N')
		{
			System.out.println("Program closing");
			scanner.close();
			socketClient.closeSession();
		}
		
		else if(selection != 'n' && selection != 'N' && selection != 'Y' && selection != 'y')
		{
			System.out.println("Not a valid selection. Try again");
			performOperation();
		}
		
		else
		{
			selectServiceOption();
		}
		
	}
	
	public void loadProps()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the properties file. Please use src/PropertiesFileFord or src/PropertiesFileCorolla");
		String filename = scanner.nextLine();
		
		
		System.out.println(filename);
		
		CarModelOptionsIO cmoi = new CarModelOptionsIO();
		Properties tempProp = cmoi.readData(filename);
		socketClient.sendOutput(tempProp);
		String response = (String) socketClient.getInput();
		System.out.println("Response from server: " + response);
	}
	
	//TO DO.
	public void configureCar(Scanner scannerObj)
	{
		socketClient.sendOutput("Dummy");
		ArrayList<String> jojo = (ArrayList<String>) socketClient.getInput();
		System.out.println(jojo.toString());
		
		System.out.println("Which car do you want to configure?");
		String inputName = scanner.nextLine();
		
		socketClient.sendOutput(GET_AUTO_FROM_LHM);
		socketClient.sendOutput(inputName);
		Automobile auto = (Automobile) socketClient.getInput();
		
		System.out.println("What color do you want for your car?");
		String inputColor = scanner.nextLine();
		System.out.println("Which type of transmission do you want for your car?");
		String inputTrans = scanner.nextLine();
		System.out.println("Which type of brakes do you want for your car?");
		String inputBrakes = scanner.nextLine();
		System.out.println("Which type of airbags do you want for your car?");
		String inputAir = scanner.nextLine();
		System.out.println("Which type of moonroof do you want for your car?");
		String inputMoon = scanner.nextLine();
		
		auto.setName(inputName);
		auto.setOptionChoice("Color",inputColor);
		auto.setOptionChoice("Transmission",inputTrans);
		auto.setOptionChoice("Brakes/Traction Control",inputBrakes);
		auto.setOptionChoice("Side Impact Air Bags",inputAir);
		auto.setOptionChoice("Power Moonroof",inputMoon);
			
		System.out.println("Total cost of options with this auto is $" + auto.getTotalPrice());
		
		
		//float cost = auto.getTotalPrice();
		//System.out.println("Total cost for this car model choice :$" + cost);
		
		
		//Server k this how much eveyrhting is, and send back to client.
		
	}
	
	public static void main(String [] args)
	{
		System.out.println("Creating a client...");
		CreateClient cc = new CreateClient(4444);
	}

	/*
	 * Creating a client...
		Choose either options
		1. Upload a properties file
		2. Configure a car
		What option do you want to choose?
		1
		Writing: 100
		Please enter the properties file. Please use src/PropertiesFileFord or src/PropertiesFileCorolla
		src/PropertiesFileFord.txt
		src/PropertiesFileFord.txt
		Ford
		Writing: {OptionValue1j=Cloud 9 White Clearcoat, OptionValue1i=Pitch Black Clearcoat, OptionValue1h=CD Silver Clearcoat Metallic, OptionValue1g=Twilight Blue Clearcoat Metallic, OptionValue1f=French Blue Clearcoat Metallic, Option5=Power Moonroof, OptionValue1e=Sangria Red Clearcoat Metallic, Option4=Side Impact Air Bags, OptionValue1d=Grabber Green Clearcoat Metallic, OptionValue1c=Infra-Red Clearcoat, Option3=Brakes/Traction Control, OptionValue1b=Liquid Grey Clearcoat Metallic, Option2=Transmission, OptionValue1a=Fort Knox Gold Clearcoat Metallic, Option1=Color, OptionValue4b=None, OptionValue4a=Side Impact Air Bags, CarModel=Focus Wagon ZTW, OptionPrice1j=0, OptionPrice1i=0, OptionPrice1h=0, OptionPrice1g=0, OptionPrice1f=0, OptionPrice1e=0, OptionPrice1d=0, OptionPrice1c=0, OptionPrice1b=0, OptionPrice1a=0, OptionPrice4b=0, OptionPrice4a=350, OptionValue3c=ABS with Advance Trac, CarMake=Ford, OptionValue3b=ABS, OptionValue3a=Standard, BasePrice=18445, OptionPrice3c=1625, OptionPrice3b=400, OptionPrice3a=0, OptionValue2b=Standard, OptionValue2a=Automatic, OptionValue5b=None, OptionValue5a=Power Moonroof, OptionPrice2b=-815, OptionPrice2a=0, OptionPrice5b=0, OptionPrice5a=595}
		Response from server: Server is done with building auto
		Do you (still) want to run this program? Please press Y or N
		y
		Choose either options
		1. Upload a properties file
		2. Configure a car
		What option do you want to choose?
		1
		Writing: 100
		Please enter the properties file. Please use src/PropertiesFileFord or src/PropertiesFileCorolla
		src/PropertiesFileCorolla.txt
		src/PropertiesFileCorolla.txt
		Toyota
		Writing: {OptionValue1j=Joanne Metallic, OptionValue1i=Super White, OptionValue1h=Slate Metallic, OptionValue1g=Classic Silver Metallic, OptionValue1f=Brown Sugar Metallic, Option5=Power Moonroof, OptionValue1e=Blue Crush Metallic, Option4=Side Impact Air Bags, OptionValue1d=Blizzard Pearl, OptionValue1c=Black Sand Mica, Option3=Brakes/Traction Control, OptionValue1b=Barcelona Red Metallic, Option2=Transmission, Option1=Color, OptionValue4b=None, OptionValue4a=Side Impact Air Bags, CarModel=Corolla, OptionPrice1j=0, OptionPrice1i=0, OptionPrice1h=0, OptionPrice1g=0, OptionPrice1f=0, OptionPrice1e=0, OptionPrice1d=0, OptionPrice1c=0, OptionPrice1b=0, OptionPrice1a=0, OptionPrice4b=0, OptionPrice4a=350, OptionValue3c=ABS with Advance Trac, CarMake=Toyota, OptionValue3b=ABS, OptionValue3a=Standard, BasePrice=18445, OptionPrice3c=1625, OptionPrice3b=400, OptionPrice3a=0, OptionValue1a4=Evergreen Mica, OptionValue2b=Standard, OptionValue2a=Automatic, OptionValue5b=None, OptionValue5a=Power Moonroof, OptionPrice2b=-815, OptionPrice2a=0, OptionPrice5b=0, OptionPrice5a=595}
		Response from server: Server is done with building auto
		Do you (still) want to run this program? Please press Y or N
		y
		Choose either options
		1. Upload a properties file
		2. Configure a car
		What option do you want to choose?
		2
		Writing: 104
		Writing: Dummy
		[Ford Focus Wagon ZTW, Toyota Corolla]
		Which car do you want to configure?
		Ford Focus Wagon ZTW
		Writing: 24
		Writing: Ford Focus Wagon ZTW
		What color do you want for your car?
		Fort Knox Gold Clearcoat Metallic
		Which type of transmission do you want for your car?
		Automatic
		Which type of brakes do you want for your car?
		ABS with Advance Trac
		Which type of airbags do you want for your car?
		Side Impact Air Bags
		Which type of moonroof do you want for your car?
		Power Moonroof
		Total cost of options with this auto is $21015.0
		Do you (still) want to run this program? Please press Y or N
		n
		Program closing
		Let's close.
		Let's close.

		 */
}



