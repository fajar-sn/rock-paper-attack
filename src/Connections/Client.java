package Connections;

import Controller.GameController;
import Controller.IGameController;
import Message.PlayerStatus;
import View.ClientFrame;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private final ClientFrame FRAME;
    private PlayerStatus playerStatus;
    private final int ID;
    private final IGameController GAME_CONTROLLER;

    public Client(int id){
        this.ID = id;
        FRAME = new ClientFrame((t) -> {
            sendMessage(t);
        });
        playerStatus = new PlayerStatus();
        GAME_CONTROLLER = GameController.getInstance();
        GAME_CONTROLLER.addPlayerStatus(playerStatus);
        openClient();
    }
    
    private void setImageOnFrame(){
        String[] images = new String[2];
        images[0] = "/SlimeBiru.png";
        images[1] = "/SlimeMerah.png";
        int i;
        switch(ID) {
            case 1:
                for(i = 0; i < images.length; i++)
                    FRAME.setImage(images[i], i + 1);
                break;
            default:
                for(i = 1; i >= 0; i--)
                    FRAME.setImage(images[i], i + 1);
        }
    }
    
    private void openClient(){
        String host = "localhost";
        int port = 2002;
        try{
            socket = new Socket(host, port);
            FRAME.setVisible(true);
            setImageOnFrame();
            ClientListener clientListener = new ClientListener(socket, this);
            clientListener.start();
        }catch(IOException exception){
            System.out.println(exception);
        }
    }

    public Socket getSocket() {
        return socket;
    }
    
    public void sendMessage(String movement){
        playerStatus.setSourcePort(socket.getLocalPort());
        playerStatus.setMovement(movement);
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(playerStatus);
        }catch(IOException exception){
            System.out.println(exception);
        }
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }
    
    public void setOpponentStatus(PlayerStatus status){
        FRAME.setOpponentStatus("From : " + status.getSourcePort());
        FRAME.setOpponentStatus("Health Point : " + status.getHealthPoint());
        FRAME.setOpponentStatus("Movement : " + status.getMovement());
        FRAME.setOpponentStatus(status.getStatusMessage() + "\n");
    }
    
    public void setMyStatus(){
        PlayerStatus stat = GAME_CONTROLLER.getStatusByPort(socket.getLocalPort());
        FRAME.setMyStatus(stat);
    }
    
    public void setGameOverMessage(String message){
        FRAME.setOpponentStatus(message);
        FRAME.setSendButtonStatus(false);
    }
    
    public void setSendButtonStatus(Boolean status){
        FRAME.setSendButtonStatus(status);
    }

}
