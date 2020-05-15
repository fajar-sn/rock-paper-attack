package Connections;

import Controller.GameController;
import Controller.IGameController;
import Message.PlayerStatus;
import Storage.ISocketStorage;
import Storage.SocketStorage;
import View.ServerFrame;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    private static int port;
    private static ServerSocket serverSocket;
    public ServerFrame serverFrame;
    private List<Socket> clientSockets;
    
    public Server() throws IOException{
        port = 2002;
        this.serverFrame = new ServerFrame();
        openServer();
        ISocketStorage socketStorage = SocketStorage.getInstance();
        clientSockets = getClientSockets(socketStorage);
    }
    
    private List<Socket> getClientSockets(ISocketStorage socketStorage) {
        return socketStorage.getClientSockets();
    }
    
    private void openServer(){
        try{
            serverSocket = new ServerSocket(port);
            serverFrame.setVisible(true);
            ServerConnection serverConnection = new ServerConnection(this);
            serverConnection.start();
        }catch(IOException exception){
            System.out.println(exception);
        }
    }
    
    private Socket getSocketByPort(int port){
        for(Socket socket : clientSockets){
            if(socket.getPort() == port)
                return socket;
        }
        return null;
    }
    
    public void sendMessage() throws IOException{
        PlayerStatus[] playerStatuses = new PlayerStatus[2];
        IGameController gameController = GameController.getInstance();
        int i;
        for(i = 0; i < playerStatuses.length; i++)
            playerStatuses[i] = getPlayerStats(gameController, i);
        String[] playerMatchStatuses = new String[2];
        for(i = 0; i < playerMatchStatuses.length; i++)
            playerMatchStatuses[i] = playerStatuses[i].getMatchStatus();
        
        String[] matchStatuses = {"Win", "Lose", "Draw"};
        if(playerMatchStatuses[0].equalsIgnoreCase(matchStatuses[2]) /*&& playerMatchStatuses[1].equalsIgnoreCase(matchStatuses[2])*/) {
            for(i = 0; i < playerStatuses.length; i++) 
                sendMatchStatus(playerStatuses[i], gameController, matchStatuses[2]);
        }
        if(playerMatchStatuses[0].equalsIgnoreCase(matchStatuses[0])) {
            for(i = 0; i < playerStatuses.length; i++) 
                sendMatchStatus(playerStatuses[i], gameController, matchStatuses[Math.abs(i - 1)]);
        }
        if(playerMatchStatuses[1].equalsIgnoreCase(matchStatuses[0])) {
            for(i = 0; i < playerStatuses.length; i++) 
                sendMatchStatus(playerStatuses[Math.abs(i - 1)], gameController, matchStatuses[i]);
        }
    }
    
    private PlayerStatus getPlayerStats(IGameController gameController, int index) {
        return gameController.getPlayerStats(index);
    }
    
    private void sendMatchStatus(PlayerStatus playerStatus, IGameController gameController, String matchStatus) throws IOException {
        playerStatus.setStatusMessage(gameController.getMessage(matchStatus));
        Socket socket = getSocketByPort(playerStatus.getSourcePort());
        ObjectOutputStream objectOutputStreams = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStreams.writeObject(playerStatus);
//        winnerPlayer.setStatusMessage(gameController.loserMessage());
//        Socket loserSocket = getSocketByPort(loserPlayer.getSourcePort());
//        objectOutputStreams[1] = new ObjectOutputStream(loserSocket.getOutputStream());
//        objectOutputStreams[1].writeObject(winnerPlayer);
    }
    
    private void sendMatchStatus(PlayerStatus[] playerStatuses, IGameController gameController, ObjectOutputStream[] objectOutputStreams, String matchStatus) throws IOException {
        for(int i = 0; i < playerStatuses.length; i++) {
            playerStatuses[Math.abs(i - 1)].setStatusMessage(gameController.getMessage(matchStatus));
            Socket player1Socket = getSocketByPort(playerStatuses[i].getSourcePort());
            objectOutputStreams[i] = new ObjectOutputStream(player1Socket.getOutputStream());
            objectOutputStreams[i].writeObject(playerStatuses[Math.abs(i - 1)]);
        }
    }
    
    public void appendTextArea(PlayerStatus stat){
        serverFrame.setTextArea("\nFrom : " + stat.getSourcePort());
        serverFrame.setTextArea("Health Point : " + stat.getHealthPoint());
        serverFrame.setTextArea("Movement : " + stat.getMovement());
    }

    public static ServerSocket getServerSocket() {
        return serverSocket;
    }
    
}
