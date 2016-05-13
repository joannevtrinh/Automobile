package scale;

public interface ScaleThread 
{
	public void updateOSName(String modelName, String OSName, String newName);
	public void updateOptionPrice(String modelName, String OName, String OSName, float newPrice);
}

/*
//Update operations for Fleet/Automobile/OptionSet/Option - Wrapper methods
    synchronized void updateOptionName (...) { - 
        call methods in proxyAuto - updateOptionName is implemented in proxyAuto - methods are declared in scaleThread or whatever interface.
    }

    synchronized void updateOptionPrice (...) {
        call methods in proxyAuto - updateOptionPrice is implemented in proxyAuto - methods are declared in scaleThread or whatever interface.
    }
*/
