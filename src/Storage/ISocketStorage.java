package Storage;

import java.net.Socket;
import java.util.List;

public interface ISocketStorage {
    
    public List<Socket> getClientSockets();
    public void setClientSockets(List<Socket> clientSockets);
    
}
