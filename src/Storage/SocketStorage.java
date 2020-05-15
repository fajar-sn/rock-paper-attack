package Storage;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketStorage implements ISocketStorage {
    
    private List<Socket> clientSockets;
    
    private SocketStorage() {
        clientSockets = new ArrayList<>();
    }

    @Override
    public List<Socket> getClientSockets() {
        return clientSockets;
    }

    @Override
    public void setClientSockets(List<Socket> clientSockets) {
        this.clientSockets = clientSockets;
    }
    
    public static SocketStorage getInstance() {
        return SocketStorageHolder.INSTANCE;
    }
    
    private static class SocketStorageHolder {

        private static final SocketStorage INSTANCE = new SocketStorage();
    }
}
