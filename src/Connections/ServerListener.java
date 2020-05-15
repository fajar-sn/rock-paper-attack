package Connections;

import Controller.GameController;
import Controller.IGameController;
import Message.PlayerStatus;
import View.ServerFrame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerListener extends Thread implements IConnectionListener {
        private final Socket client;
        private final Server server;
        
        public ServerListener(Socket socket, Server server) throws IOException{
            client = socket;
            this.server = server;
        }
        
        @Override
        public void run(){
            try {
                receiveMessage();
            } catch (IOException exception) {
                Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, exception);
            } catch (ClassNotFoundException exception) {
                Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
        
        public Socket getClientSocket(){
            return client;
        }
        
        @Override
        public void receiveMessage() throws IOException, ClassNotFoundException{
            PlayerStatus playerStatus;
            IGameController gameController = GameController.getInstance();
            while(!gameController.gameOver()){
                ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                playerStatus = (PlayerStatus) objectInputStream.readObject();
                server.appendTextArea(playerStatus);
                gameController.addPlayerMovementStatus(playerStatus);
                if(gameController.allPlayersIn()){
                    gameController.processPlayerMovements();
                    server.sendMessage();
                    List<PlayerStatus> playerMovementStat = getPlayerMovementStats(gameController);
                    playerMovementStat.clear();
                }
            }
        }
        
        private List<PlayerStatus> getPlayerMovementStats(IGameController gameController) {
            return gameController.getPlayerMovementStats();
        }
        
    }
    