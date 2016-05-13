// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package adapter;
import java.io.IOException;
import exception.BadDataException;
import Model.*;
import Util.*;

public interface CreateAuto {

	public void buildAuto(String filename, int filetype) throws BadDataException, IOException;
	public void printAuto(String modelName);
}
