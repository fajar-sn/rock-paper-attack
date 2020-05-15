package View;

import Message.PlayerStatus;
import java.awt.Image;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.text.Document;

public class ClientFrame extends javax.swing.JFrame {
    
    private final Consumer<String> CONSUMER_CALLBACK;
    
    public ClientFrame(Consumer<String> consumerCallback) {
        initComponents();
        this.CONSUMER_CALLBACK = consumerCallback; 
        enemyTextArea.setEditable(false);
        playerTextArea.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        sendButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        selectMovementLabel = new javax.swing.JLabel();
        movementComboBox = new javax.swing.JComboBox<>();
        enemyScrollPane = new javax.swing.JScrollPane();
        enemyTextArea = new javax.swing.JTextArea();
        enemyPic = new javax.swing.JLabel();
        myPicture = new javax.swing.JLabel();
        playerScrollPane = new javax.swing.JScrollPane();
        playerTextArea = new javax.swing.JTextArea();
        vsLabel = new javax.swing.JLabel();
        enemyLabel = new javax.swing.JLabel();
        playerLabel = new javax.swing.JLabel();
        enemyHealthPoint = new javax.swing.JLabel();
        myHealthPoint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Rock, Paper, Attack !");

        selectMovementLabel.setText("Select your movement : ");

        movementComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rock", "Paper", "Scissor" }));
        movementComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movementComboBoxActionPerformed(evt);
            }
        });

        enemyTextArea.setColumns(20);
        enemyTextArea.setRows(5);
        enemyScrollPane.setViewportView(enemyTextArea);

        playerTextArea.setColumns(20);
        playerTextArea.setRows(5);
        playerScrollPane.setViewportView(playerTextArea);

        vsLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        vsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vsLabel.setText("VS");

        enemyLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        enemyLabel.setText("Your Enemy");

        playerLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        playerLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        playerLabel.setText("Your Status");

        enemyHealthPoint.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        myHealthPoint.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enemyScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(playerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(movementComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendButton))
                            .addComponent(selectMovementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(enemyPic, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(vsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(enemyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyHealthPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(myHealthPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enemyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(playerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(enemyHealthPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myHealthPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(enemyPic, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addComponent(myPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(vsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enemyScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(selectMovementLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movementComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String movement;
        Object selectedItem = movementComboBox.getSelectedItem();
        if(selectedItem.equals("Rock"))
            movement = "Rock";
        else if(selectedItem.equals("Paper"))
            movement = "Paper";
        else
            movement = "Scissor";
        if(CONSUMER_CALLBACK != null)
            CONSUMER_CALLBACK.accept(movement);
        setSendButtonStatus(false);
    }//GEN-LAST:event_sendButtonActionPerformed

    private void movementComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movementComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movementComboBoxActionPerformed

    public void setOpponentStatus(String message){
        enemyTextArea.append(message);
        enemyTextArea.append("\n");
        Document enemyDocument = enemyTextArea.getDocument();
        enemyTextArea.setCaretPosition(enemyDocument.getLength());
    }
    
    public void setMyStatus(PlayerStatus myStatus){
        playerTextArea.append("Your Port   : " + String.valueOf(myStatus.getSourcePort()));
        playerTextArea.append("\nYour Health : " + String.valueOf(myStatus.getHealthPoint()));
        playerTextArea.append("\nYour Move : " + myStatus.getMovement() + "\n\n");
        Document playerDocument = playerTextArea.getDocument();
        playerTextArea.setCaretPosition(playerDocument.getLength());
        String matchStatus = myStatus.getMatchStatus();
        if(matchStatus.equalsIgnoreCase("Lose"))
            setStatus(myHealthPoint);
        else if(matchStatus.equalsIgnoreCase("Win"))
            setStatus(enemyHealthPoint);
    }
    
    private void setStatus(javax.swing.JLabel playerHealthPoint) {
        ImageIcon healthPoint = (ImageIcon) playerHealthPoint.getIcon();
        Image healthPointBar = healthPoint.getImage();
        healthPointBar = healthPointBar.getScaledInstance(healthPoint.getIconWidth() - (myHealthPoint.getWidth()/5), myHealthPoint.getHeight(), Image.SCALE_SMOOTH);
        myHealthPoint.setIcon(new ImageIcon(healthPointBar));
    }
    
    public void setImage(String image, int index) {
        ImageIcon imageIcon = new ImageIcon(image);
        Image picture = imageIcon.getImage();
        picture = picture.getScaledInstance(myPicture.getWidth(), myPicture.getHeight(), Image.SCALE_SMOOTH);
        switch(index) {
            case 1: 
                myPicture.setIcon(new ImageIcon(picture));
                break;
            case 2: 
                enemyPic.setIcon(new ImageIcon(picture));
                break;
        }
    }
    
    public void setSendButtonStatus(Boolean status){
        sendButton.setEnabled(status);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel enemyHealthPoint;
    private javax.swing.JLabel enemyLabel;
    private javax.swing.JLabel enemyPic;
    private javax.swing.JScrollPane enemyScrollPane;
    private javax.swing.JTextArea enemyTextArea;
    private javax.swing.JComboBox<String> movementComboBox;
    private javax.swing.JLabel myHealthPoint;
    private javax.swing.JLabel myPicture;
    private javax.swing.JLabel playerLabel;
    private javax.swing.JScrollPane playerScrollPane;
    private javax.swing.JTextArea playerTextArea;
    private javax.swing.JLabel selectMovementLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel vsLabel;
    // End of variables declaration//GEN-END:variables
}
