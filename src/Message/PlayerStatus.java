package Message;

import java.io.Serializable;

public class PlayerStatus implements Serializable{
    private int sourcePort;
    private int destinationPort;
    private int healthPoint;
    private String movement;
    private String matchStatus;
    private String statusMessage;

    public PlayerStatus() {
        this.healthPoint = 100;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(int sourcePort) {
        this.sourcePort = sourcePort;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(int destinationPort) {
        this.destinationPort = destinationPort;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }
    
    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String gameStatus) {
        this.statusMessage = gameStatus;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }
    
}
