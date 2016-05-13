// Joanne Trinh
// Professor Singh
// Lab 2
// May 2, 2015

package exception;

public class BadDataException extends Exception
{
	private String errMsg;
	private int errNum;
	
	public BadDataException()
	{
		super();
		printProb();
		
	}
	
	public BadDataException(String message)
	{
		super(message);
		errMsg = message;
		printProb();
	}
	
	public BadDataException(int errNumber)
	{
		super();
		errNum = errNumber;
		printProb();
	}

	public BadDataException(int errNumber, String message)
	{
		super();
		errNum = errNumber;
		errMsg = message;
		printProb();
	}
	
	public BadDataException(Exception e) 
	{
		super(e);
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public int getErrNum() {
		return errNum;
	}

	public void setErrNum(int errNum) {
		this.errNum = errNum;
	}

	public void printProb()
	{
		System.out.println("Bad Data Exception of " + errNum + "error message" + errMsg);
	}
}
