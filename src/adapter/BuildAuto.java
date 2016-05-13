// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package adapter;

import java.util.Properties;

import Model.Automobile;
import server.AutoServer;

public class BuildAuto extends proxyAutomobile implements CreateAuto, UpdateAuto, AutoServer
{
	public Automobile createAutomobile(Properties pobj) {
		return null;
	}
	

	public void addAutotoLHM(Automobile a1) {
	}
	
}


// extends proxyAutomobile implements createAuto, updateAuto