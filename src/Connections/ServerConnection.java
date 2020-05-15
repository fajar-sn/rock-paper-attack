package Connections;

import Storage.ISocketStorage;
import Storage.SocketStorage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerConnection extends Thread{
    private final ServerSocket SERVER_SOCKET;
    private Socket socket;
    private final List<Socket> CLIENT_SOCKETS;
    private final Server SERVER;
    private final ISocketStorage SOCKET_STORAGE;
    
    public ServerConnection(Server server){
        SERVER_SOCKET = server.getServerSocket();
        this.SERVER = server;
        SOCKET_STORAGE = SocketStorage.getInstance();
        CLIENT_SOCKETS = getClientSockets(SOCKET_STORAGE);
    }
    
    private List<Socket> getClientSockets(ISocketStorage socketStorage) {
        return socketStorage.getClientSockets();
    }
    
    @Override
    public void run(){
        while(true){
            try {
                socket = SERVER_SOCKET.accept();
                ServerListener serverListener = new ServerListener(socket, SERVER);
                CLIENT_SOCKETS.add(serverListener.getClientSocket());
                SOCKET_STORAGE.setClientSockets(CLIENT_SOCKETS);
                serverListener.start();
            } catch (IOException exception) {
                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }
}
