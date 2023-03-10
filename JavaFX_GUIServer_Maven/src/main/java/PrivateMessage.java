import java.io.Serializable;
import java.util.ArrayList;

public class PrivateMessage implements Serializable {

    String privateMessage;
    ArrayList<String> cList, clients;
    boolean bool;

    PrivateMessage(){
        cList = new ArrayList<String>();
        clients = new ArrayList<String>();
        bool = false;
    }
}
