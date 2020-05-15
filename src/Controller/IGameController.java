package Controller;

import Message.PlayerStatus;
import java.util.List;

public interface IGameController {
    
    public PlayerStatus getPlayerStats(int index);
    public String getMessage(String matchStatus);
    public boolean gameOver();
    public void addPlayerMovementStatus(PlayerStatus playerStatus);
    public boolean allPlayersIn();
    public void processPlayerMovements();
    public List<PlayerStatus> getPlayerMovementStats();
    public void addPlayerStatus(PlayerStatus playerStatus);
    public String gameOverMessage();
    public PlayerStatus getStatusByPort(int port);
    
}
