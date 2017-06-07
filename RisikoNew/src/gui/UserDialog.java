/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import services.FileManager;

/**
 *
 * @author Elisa
 */
public class UserDialog extends javax.swing.JDialog {

    private StartGameGUI gui;
    private int index;
    private List<String> players;

    /**
     * Creates new form RegistrationDialog
     *
     * @param gui
     */
    public UserDialog(StartGameGUI gui) {
        this.gui = gui;
        initComponents();
        commentsText.setBackground(new Color(240, 240, 240));

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowClosed(WindowEvent e) {
                gui.setEnabled(true);
                gui.setVisible(true);
            }

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        password2Label = new javax.swing.JLabel();
        saveUserButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();
        password2Text = new javax.swing.JPasswordField();
        commentsText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        password2Label.setText("Ripeti la password");

        saveUserButton.setText("Registra");
        saveUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(password2Label)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(passwordText)
                        .addComponent(password2Text)
                        .addComponent(commentsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password2Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(commentsText, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveUserButton)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Bottone per salvare il nuovo utente
     *
     * @param evt
     */
    private void saveUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUserButtonActionPerformed
        if (usernameText.getText().length() == 0 || passwordText.getPassword().length == 0 || password2Text.getPassword().length == 0) {
            commentsText.setText("Compila tutti i campi");
            return;
        }
        if (!String.valueOf(passwordText.getPassword()).equals(String.valueOf(password2Text.getPassword()))) {
            commentsText.setText("Le password non coincidono");
            return;
        }

        if (FileManager.getInstance().checkUsernameInFile(usernameText.getText())) {
            try {
                registerUser(usernameText.getText(), String.valueOf(passwordText.getPassword()));
            } catch (IOException ex) {
                Logger.getLogger(UserDialog.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                JOptionPane.showMessageDialog(null, "Utente " + usernameText.getText() + " registrato correttamente");
                this.setVisible(false);
                gui.setVisible(true);
                gui.setEnabled(true);
            }
        } else {
            commentsText.setText("Username già presente nel gioco");
        }

    }//GEN-LAST:event_saveUserButtonActionPerformed

    /**
     * Bottone per fare la login
     *
     * @param evt
     */
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String url = "files/players.txt";
        String username = usernameText.getText();
        String password = String.valueOf(passwordText.getPassword());
        if (checkUsername(username)) {
            try (BufferedReader br = new BufferedReader(new FileReader(url))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] tmp = line.split(";");
                    byte[] encryptedBytes = tmp[1].getBytes();
                    byte[] decryptedBytes = Base64.getDecoder().decode(encryptedBytes);
                    String decryptedString = new String(decryptedBytes, "UTF-8");
                    if (tmp[0].equals(username) && decryptedString.equals(password)) {
                        JOptionPane.showMessageDialog(null, "Utente " + usernameText.getText() + " inserito correttamente");
                        this.setVisible(false);

                        gui.setPlayerName(username, getIndex());
                        gui.setVisible(true);
                        gui.setEnabled(true);
                        return;
                    }

                }

            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            } catch (IOException ex) {
                Logger.getLogger(UserDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

            commentsText.setText("Nome giocatore o password errati");
        } else {
            commentsText.setText("Giocatore già presente nel gioco");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * Salva nel file players.txt lo username e la password criptata
     *
     * @param username
     * @param password
     * @throws IOException
     */
    private void registerUser(String username, String password) throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encryptedBytes = encoder.encode(password.getBytes());
        String encryptedString = new String(encryptedBytes, "UTF-8");
        try (PrintWriter out = new PrintWriter(new FileOutputStream("files/players.txt", true))) {
            out.println(username + ";" + encryptedString);

        }

    }

    /**
     * Imposta il JDialog in modo che si vedano le informazioni relative alla
     * registrazione o alla login
     *
     * @param isRegistration
     */
    public void setRegistrationMode(boolean isRegistration) {
        if (isRegistration) {
            this.setTitle("Registrazione");
            password2Text.setVisible(true);
            loginButton.setVisible(false);
            password2Label.setVisible(true);
            saveUserButton.setVisible(true);
        } else {
            this.setTitle("Login");
            password2Text.setVisible(false);
            password2Label.setVisible(false);
            saveUserButton.setVisible(false);
            loginButton.setVisible(true);
        }

        Dimension dim = getToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);
        commentsText.setText("");
        passwordText.setText("");
        password2Text.setText("");
        usernameText.setText("");
    }

    /**
     * Setta l'indice del player da cui è stata richiesta la login
     *
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Ritorna l'indice del player che ha richiesto la login
     *
     * @return
     */
    private int getIndex() {
        return index;
    }

    /**
     * Setta la lista dei players già loggati nel gioco
     *
     * @param list
     */
    public void setPlayers(List<String> list) {
        this.players = list;
    }

    /**
     * Controlla se lo username inserito è già presente tra quelli degli utenti
     * loggati; se si ritorna false
     *
     * @param username
     * @return
     */
    private boolean checkUsername(String username) {
        for (String s : players) {
            if (s.equals(username)) {
                return false;
            }
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commentsText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel password2Label;
    private javax.swing.JPasswordField password2Text;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton saveUserButton;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables

}
