package Connections;

import java.io.IOException;

public interface IConnectionListener {
    
    public void receiveMessage() throws IOException, ClassNotFoundException;
    
}
