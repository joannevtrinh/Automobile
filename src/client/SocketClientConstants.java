package client;

public interface SocketClientConstants 
{
	int iECHO_PORT = 7;
    int iDAYTIME_PORT = 13;
    int iSMTP_PORT = 25;
    boolean DEBUG = true;
    
    
    final int WAITING = 1;
    
    final int BUILD_AUTO_FROM_PROPS = 100;
    final int GET_AUTO_FROM_LHM = 24;
	

    final int GOING_TO_TALK_TO_YOU = 200; 
	final int READ_FIRST_LINE = 201;
	final int I_HATE_YOU = 202;

    final int SELECT_SERVICE = 101;
    final int PERFORM_OPERATION = 102;
    final int SERVER_SEND_LHM = 104;
    final int DONE_BUILD_AUTO = 105;
    /*
     * //Client selects service option
    final int SELECT_SERVICE = 1;
    //Client performs operation on service selection
    final int PERFORM_OPERATION = 2;
    //Server build automobile object from properties file
    final int BUILD_AUTO_FROM_PROPS = 3;
    //Client sends Linked Hash Map Request to Server
    final int SERVER_SEND_LHM_REQUEST = 4;
     */
}
