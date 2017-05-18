/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Elisa
 */
public class StartGameGUI extends javax.swing.JFrame {

    private int nPlayers;
    private JTextField[] playerTexts;
    private JCheckBox[] aiChecks;
    private JComboBox[] colorBoxs;
    private ColorBoxListener cbListener;
    private UserDialog regDialog;
    private JButton[] logins;

    /**
     * Creates new form startGame
     */
    public StartGameGUI() {
        initComponents();
        init();
    }

    /**
     * Inizializzazione
     */
    private void init() {

        nPlayers = 2;
        regDialog = new UserDialog(this);
        regDialog.setVisible(false);

        playerTexts = new JTextField[]{this.playerText1, this.playerText2, this.playerText3, this.playerText4, this.playerText5, this.playerText6};
        aiChecks = new JCheckBox[]{ai1, ai2, ai3, ai4, ai5, ai6};
        logins = new JButton[]{login1, login2, login3, login4, login5, login6};

        this.playerText3.setVisible(false);
        this.playerText4.setVisible(false);
        this.playerText5.setVisible(false);
        this.playerText6.setVisible(false);
        this.ai3.setVisible(false);
        this.ai4.setVisible(false);
        this.ai5.setVisible(false);
        this.ai6.setVisible(false);

        AIListener aiListener = new AIListener(playerTexts, aiChecks, logins);

        this.ai1.addActionListener(aiListener);
        this.ai2.addActionListener(aiListener);
        this.ai3.addActionListener(aiListener);
        this.ai4.addActionListener(aiListener);
        this.ai5.addActionListener(aiListener);
        this.ai6.addActionListener(aiListener);

        String[] colors = new String[]{"Rosso", "Blu", "Nero", "Viola", "Verde", "Giallo"};
        colorBox1.setModel(new DefaultComboBoxModel(colors));
        colorBox2.setModel(new DefaultComboBoxModel(colors));
        colorBox3.setModel(new DefaultComboBoxModel(colors));
        colorBox4.setModel(new DefaultComboBoxModel(colors));
        colorBox5.setModel(new DefaultComboBoxModel(colors));
        colorBox6.setModel(new DefaultComboBoxModel(colors));

        colorBox1.setSelectedItem(colors[0]);
        colorBox2.setSelectedItem(colors[1]);
        colorBox3.setSelectedItem(colors[2]);
        colorBox4.setSelectedItem(colors[3]);
        colorBox5.setSelectedItem(colors[4]);
        colorBox6.setSelectedItem(colors[5]);

        colorBox3.setVisible(false);
        colorBox4.setVisible(false);
        colorBox5.setVisible(false);
        colorBox6.setVisible(false);

        colorBoxs = new JComboBox[]{colorBox1, colorBox2, colorBox3, colorBox4, colorBox5, colorBox6};

        cbListener = new ColorBoxListener(colorBoxs, colors.clone());
        colorBox1.addActionListener(cbListener);
        colorBox2.addActionListener(cbListener);
        colorBox3.addActionListener(cbListener);
        colorBox4.addActionListener(cbListener);
        colorBox5.addActionListener(cbListener);
        colorBox6.addActionListener(cbListener);

        login3.setVisible(false);
        login4.setVisible(false);
        login5.setVisible(false);
        login6.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        playerText1 = new javax.swing.JTextField();
        playerText2 = new javax.swing.JTextField();
        playerText3 = new javax.swing.JTextField();
        playerText4 = new javax.swing.JTextField();
        playerText5 = new javax.swing.JTextField();
        playerText6 = new javax.swing.JTextField();
        ai1 = new javax.swing.JCheckBox();
        ai2 = new javax.swing.JCheckBox();
        ai3 = new javax.swing.JCheckBox();
        ai4 = new javax.swing.JCheckBox();
        ai5 = new javax.swing.JCheckBox();
        ai6 = new javax.swing.JCheckBox();
        startButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        colorBox1 = new javax.swing.JComboBox<>();
        colorBox2 = new javax.swing.JComboBox<>();
        colorBox3 = new javax.swing.JComboBox<>();
        colorBox4 = new javax.swing.JComboBox<>();
        colorBox5 = new javax.swing.JComboBox<>();
        colorBox6 = new javax.swing.JComboBox<>();
        registrationButton = new javax.swing.JButton();
        login1 = new javax.swing.JButton();
        login2 = new javax.swing.JButton();
        login3 = new javax.swing.JButton();
        login4 = new javax.swing.JButton();
        login5 = new javax.swing.JButton();
        login6 = new javax.swing.JButton();
        commentsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("RISIKO");

        ai1.setText("Giocatore artificiale");

        ai2.setText("Giocatore artificiale");

        ai3.setText("Giocatore artificiale");

        ai4.setText("Giocatore artificiale");

        ai5.setText("Giocatore artificiale");

        ai6.setText("Giocatore artificiale");

        startButton.setText("Gioca");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Rimuovi giocatore");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addButton.setText("Aggiungi giocatore");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        registrationButton.setText("Registra giocatore");
        registrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationButtonActionPerformed(evt);
            }
        });

        login1.setText("Login");
        login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login1ActionPerformed(evt);
            }
        });

        login2.setText("Login");
        login2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login2ActionPerformed(evt);
            }
        });

        login3.setText("Login");
        login3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login3ActionPerformed(evt);
            }
        });

        login4.setText("Login");
        login4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login4ActionPerformed(evt);
            }
        });

        login5.setText("Login");
        login5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login5ActionPerformed(evt);
            }
        });

        login6.setText("Login");
        login6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(registrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playerText2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playerText3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playerText4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playerText5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playerText6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playerText1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ai1)
                                                .addComponent(ai2))
                                            .addComponent(ai5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ai4))
                                        .addComponent(ai6, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(ai3))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(login4, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(login5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(login2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(login1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(login3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(login6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(colorBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(playerText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ai3)
                            .addComponent(login3))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ai4)
                            .addComponent(login4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ai5)
                            .addComponent(login5))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ai6)
                            .addComponent(login6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(ai2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ai1)
                            .addComponent(login1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(colorBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(commentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (nPlayers > 2) {
            playerTexts[nPlayers - 1].setVisible(false);
            aiChecks[nPlayers - 1].setVisible(false);
            colorBoxs[nPlayers - 1].setVisible(false);
            logins[nPlayers - 1].setVisible(false);
            nPlayers--;
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (nPlayers < 6) {
            playerTexts[nPlayers].setVisible(true);
            aiChecks[nPlayers].setVisible(true);
            colorBoxs[nPlayers].setVisible(true);
            logins[nPlayers].setVisible(true);
            nPlayers++;
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        List<String> list = new ArrayList<>();
        boolean valid = true;
        for (int i = 0; i < playerTexts.length; i++) {
            if (aiChecks[i].isSelected() || !aiChecks[i].isSelected() && playerTexts[i].isVisible()) {
                list.add(playerTexts[i].getText());
            }
        }

        for (String text : list) {
            if (text.length() == 0) {
                commentsLabel.setText("Inserisci i nomi di tutti i giocatori per iniziare la partita");
                return;
            }
        }

        /*if (!checkUsername(list)) {
            commentsLabel.setText("I nomi dei giocatori devono essere diversi tra loro");
            return;
        }*/

        GUI gui;
        Map<String, Boolean> players = new HashMap<>();
        Map<String, String> playersColor = new HashMap<>();
        String[] colors = cbListener.getUpdateColors(list.size());

        for (int i = 0; i < list.size(); i++) {
            players.put(list.get(i), aiChecks[i].isSelected());
            playersColor.put(list.get(i), colors[i]);
        }
        try {
            gui = new GUI(players, playersColor);
            gui.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(StartGameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_startButtonActionPerformed

    private void registrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationButtonActionPerformed
        regDialog.setRegistrationMode(true);
        regDialog.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registrationButtonActionPerformed

    private void login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login1ActionPerformed
        doLogin(0);
    }//GEN-LAST:event_login1ActionPerformed

    private void login2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login2ActionPerformed
        doLogin(1);
    }//GEN-LAST:event_login2ActionPerformed

    private void login3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login3ActionPerformed
        doLogin(2);
    }//GEN-LAST:event_login3ActionPerformed

    private void login4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login4ActionPerformed
        doLogin(3);
    }//GEN-LAST:event_login4ActionPerformed

    private void login5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login5ActionPerformed
        doLogin(4);
    }//GEN-LAST:event_login5ActionPerformed

    private void login6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login6ActionPerformed
        doLogin(5);
    }//GEN-LAST:event_login6ActionPerformed

    /**
     * Setta il nome del player nel input e lo rende non editabile; cambia il
     * bottone di login a logout
     *
     * @param username
     * @param index
     */
    public void setPlayerName(String username, int index) {
        playerTexts[index].setText(username);
        playerTexts[index].setEditable(false);
        logins[index].setText("Logout");
    }

    /**
     * Consente di aprire il JDialog per effettuare la login se il giocatore
     * scelto non è loggato; se è già loggato consente di effettuare il logout
     *
     * @param index
     */
    public void doLogin(int index) {
        if (logins[index].getText().equals("Login")) {
            regDialog.setRegistrationMode(false);
            regDialog.setIndex(index);
            regDialog.setPlayers(getPlayers());
            regDialog.setVisible(true);
            this.setVisible(false);
        } else {
            logins[index].setText("Login");
            playerTexts[index].setEditable(true);
            playerTexts[index].setText("");
        }
    }

    /**
     * Ritorna la lista dei giocatori già loggati
     *
     * @return
     */
    private List getPlayers() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < playerTexts.length; i++) {
            if (playerTexts[i].getText().length() != 0 && logins[i].getText().equals("Logout")) {
                list.add(playerTexts[i].getText());
            }
        }
        return list;
    }

    private boolean checkUsername(List<String> players) {
        System.out.println("sono qui");
        Object[] players1=players.toArray();
        Object[] players2 =players1.clone();
        for (Object s1 : players1) {
            for (Object s2 : players2) {
                System.out.println(s1+" "+s2);
                if (((String)s1).equals((String)s2)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JCheckBox ai1;
    private javax.swing.JCheckBox ai2;
    private javax.swing.JCheckBox ai3;
    private javax.swing.JCheckBox ai4;
    private javax.swing.JCheckBox ai5;
    private javax.swing.JCheckBox ai6;
    private javax.swing.JComboBox<String> colorBox1;
    private javax.swing.JComboBox<String> colorBox2;
    private javax.swing.JComboBox<String> colorBox3;
    private javax.swing.JComboBox<String> colorBox4;
    private javax.swing.JComboBox<String> colorBox5;
    private javax.swing.JComboBox<String> colorBox6;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton login1;
    private javax.swing.JButton login2;
    private javax.swing.JButton login3;
    private javax.swing.JButton login4;
    private javax.swing.JButton login5;
    private javax.swing.JButton login6;
    private javax.swing.JTextField playerText1;
    private javax.swing.JTextField playerText2;
    private javax.swing.JTextField playerText3;
    private javax.swing.JTextField playerText4;
    private javax.swing.JTextField playerText5;
    private javax.swing.JTextField playerText6;
    private javax.swing.JButton registrationButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

}
