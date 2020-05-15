package Connections;

import Controller.GameController;
import Controller.IGameController;
import Message.PlayerStatus;
import View.ServerFrame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientListener extends Thread implements IConnectionListener {
    
    private final Socket clientSocket;
    private final Client client; 
    
    public ClientListener(Socket socket, Client client) throws IOException{
        this.clientSocket = socket;
        this.client = client;
    }
    
    @Override
    public void run(){
        try {
            receiveMessage();
        } catch (IOException exception) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, exception);
        } catch (ClassNotFoundException exception) {
            Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
        
    @Override
    public void receiveMessage() throws IOException, ClassNotFoundException{
        IGameController gameController = GameController.getInstance();
        while(!gameController.gameOver()){
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            PlayerStatus status = (PlayerStatus) objectInputStream.readObject();
            client.setOpponentStatus(status);
            client.setMyStatus();
            client.setSendButtonStatus(true);
        }
        client.setGameOverMessage(gameController.gameOverMessage());
    }
}
