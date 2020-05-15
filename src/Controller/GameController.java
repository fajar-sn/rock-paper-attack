package Controller;

import Message.PlayerStatus;
import java.util.ArrayList;
import java.util.List;

public class GameController implements IGameController {
    
    private List<PlayerStatus> playerStatuses;
    private List<PlayerStatus> playerMovementStatuses;
    
    private GameController() {
        playerStatuses = new ArrayList<>();
        playerMovementStatuses = new ArrayList<>();
    }
    
    @Override
    public void addPlayerStatus(PlayerStatus playerStatus){
        playerStatuses.add(playerStatus);
    }

    @Override
    public PlayerStatus getPlayerStats(int index) {
        return playerStatuses.get(index);
    }

    public void updatePlayerStat(PlayerStatus playerStatus){
        for(int i = 0; i < playerStatuses.size(); i++){
            if(playerStatuses.get(i).getSourcePort() == playerStatus.getSourcePort())
               playerStatuses.set(i, playerStatus);        
        }
    }
    
    @Override
    public void addPlayerMovementStatus(PlayerStatus playerStatus){
        playerMovementStatuses.add(playerStatus);
    }
    
    @Override
    public List<PlayerStatus> getPlayerMovementStats() {
        return playerMovementStatuses;
    }
    
    @Override
    public boolean allPlayersIn(){
        return playerMovementStatuses.size() == 2;
    }
    
    public int getDamagePoint(){
        int damage = 20;
        return damage;
    }
    
    private void setPlayerStatusByPort(PlayerStatus playerStatus){
        for(int i = 0; i < playerStatuses.size(); i++){
            if(playerStatus.getSourcePort() == playerStatuses.get(i).getSourcePort())
                playerStatuses.set(i, playerStatus);
        }
    }
    
    @Override
    public void processPlayerMovements(){
        PlayerStatus[] playerMovementStatuses = new PlayerStatus[2];
        int i;
        int playerStatusesLength = playerMovementStatuses.length;
        String[] playerMovements = new String[2];
        for(i = 0; i < playerStatusesLength; i++) {
            playerMovementStatuses[i] = this.playerMovementStatuses.get(i);
            playerMovements[i] = playerMovementStatuses[i].getMovement();
        }
        String[] matchStatuses = {"Win", "Lose", "Draw"};
        String[] movements = {"Rock", "Paper", "Scissor"};
        for(i = 0; i < movements.length; i++) {
            if(playerMovements[0].equalsIgnoreCase(movements[i])) {
                for(int j = 0; j < movements.length; j++) {
                    if(playerMovements[1].equalsIgnoreCase(movements[j])) {
                        if(i == j) {
                            for(int k = 0; k < playerStatusesLength; k++) {
                                playerMovementStatuses[k].setMatchStatus(matchStatuses[2]);
                                processPlayerMovements(playerMovementStatuses[k], matchStatuses[2]);
                            }
                        }
                        if((i == 2 && j == 0) || (i < j)) {
                            processPlayerMovements(playerMovementStatuses[0], matchStatuses[1]);
                            processPlayerMovements(playerMovementStatuses[1], matchStatuses[0]);
                        }
                        if((i == 0 && j == 2) || (j < i)) {
                            processPlayerMovements(playerMovementStatuses[1], matchStatuses[0]);
                            processPlayerMovements(playerMovementStatuses[0], matchStatuses[1]);
                        }
                    }
                }
            }
        }
    }
    
    private void processPlayerMovements(PlayerStatus playerStatus, String matchStatus) {
        playerStatus = getStatusByPort(playerStatus.getSourcePort());
        playerStatus.setMatchStatus(matchStatus);
        if("Lose".equals(matchStatus))
            playerStatus.setHealthPoint(playerStatus.getHealthPoint() - getDamagePoint());
        setPlayerStatusByPort(playerStatus);
    }
    
    @Override
    public String getMessage(String matchStatus) {
        switch(matchStatus) {
            case "Win" :
                return "You won ! you inflicted " + String.valueOf(getDamagePoint()) + " Damage towards your opponent";
            case "Lose" :
                return "You lost ! you got " + String.valueOf(getDamagePoint()) + " Damage from your opponent";
            case "Draw" :
                return "It's a Draw ! no damages inflicted";
        }
        return null;
    }
    
    @Override
    public String gameOverMessage(){
        PlayerStatus winner;
        PlayerStatus loser;
        String message;
        
        if(playerStatuses.get(0).getHealthPoint() <= 0){
            winner = playerStatuses.get(1);
            loser = playerStatuses.get(0);
        }else{
            winner = playerStatuses.get(0);
            loser = playerStatuses.get(1);
        }
        
        message = "The game is over";
        message += "\nCongratulations, " + winner.getSourcePort() + " won the game";
        message += "\n" + loser.getSourcePort() + ", better luck next time";
        
        return message;
    }
    
    @Override
    public PlayerStatus getStatusByPort(int port){
        for(PlayerStatus playerStat : playerStatuses){
            if(playerStat.getSourcePort() == port)
                return playerStat;
        }
        return null;
    }
    
    @Override
    public boolean gameOver(){
        if(playerStatuses.size() < 2)
            return false;
        else
            return(playerStatuses.get(0).getHealthPoint() <= 0 || playerStatuses.get(1).getHealthPoint() <= 0);
    }
    
    public static GameController getInstance() {
        return GameControllerHolder.INSTANCE;
    }
    
    private static class GameControllerHolder {
        private static final GameController INSTANCE = new GameController();
    }
}
