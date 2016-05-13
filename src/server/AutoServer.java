package server;

import java.util.Properties;

import Model.Automobile;
import adapter.*;

public interface AutoServer
{
	public Automobile createAutomobile(Properties pobj);
	public void addAutotoLHM(Automobile a1);
}
