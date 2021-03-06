package controllers;

import exceptions.FileManagerException;
import exceptions.LogoutException;
import gui.startGameGUI.PlayerInfoRow;
import gui.startGameGUI.PlayersPanel;
import gui.startGameGUI.StartGameGUI;
import gui.startGameGUI.UserDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import services.FileManager;

/**
 * Changes the default name assigned to the player accordingly to the chosen
 * type of player. If the player wants to login it opens a dedicated dialog.
 *
 */
public class SelectTypeListener implements ActionListener {

    private List<PlayerInfoRow> players;
    private StartGameGUI gui;
    private final String LANG = "ITA";

    /**
     * Creates a new SelectTypeListener.
     *
     * @param gui
     * @param players
     */
    public SelectTypeListener(StartGameGUI gui, List<PlayerInfoRow> players) {
        this.players = players;
        this.gui = gui;
    }

    /**
     * Changes the type of player for the selected row. If the player previously
     * chosen for that row was logged in, asks him to logout.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        JComboBox source = (JComboBox) e.getSource();
        PlayerInfoRow player = getSelectedRow(source);
        String type = ((String) source.getSelectedItem()).toLowerCase();
        // Se il player era loggato, lo slogghiamo
        if (player.isLogged()) {
            try {
                askLogout(player);
            } catch (LogoutException ex) {
                return;
            }
        }
        changePlayerRow(player, type);

    }

    /**
     * Changes the <code>PlayerInfoRow</code> player accordingly to the type of
     * player.
     *
     * @param player
     * @param type
     */
    private void changePlayerRow(PlayerInfoRow player, String type) {
        switch (type) {
            case "normale":
                player.resetPlayerName();
                player.setPlayerNameEditable(true);
                break;
            case "artificiale":
                player.setPlayerNameEditable(false);
                player.setPlayerName(getAIName());
                break;
            case "loggato":
                player.resetPlayerName();
                player.setPlayerNameEditable(false);
                showLogin(players.indexOf(player));
                break;

        }
    }

    /**
     * Opens a new <code>JOptionPane</code> that asks for the logout of the
     * player.
     *
     * @param player
     * @throws LogoutException
     */
    private void askLogout(PlayerInfoRow player) throws LogoutException {

        try {
            int decision = JOptionPane.showConfirmDialog(gui, FileManager.getInstance().getInfoFor("ASK_LOGOUT", LANG) + player.getPlayerName());
            if (decision != 0) { // Non vuole sloggarsi
                player.setType("Loggato");
                throw new LogoutException("Player doesn't want to logout");
            }
            player.setLogged(false);
        } catch (FileManagerException ex) {
            Logger.getLogger(SelectTypeListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Opens the <code>UserDialog</code> to log in.
     *
     * @param index
     */
    private void showLogin(int index) {
        UserDialog userDialog = new UserDialog(gui, players, false);
        userDialog.setIndex(index);
        userDialog.setPlayers(getAllLoggedPlayers());
        userDialog.setVisible(true);
    }

    /**
     * Returns the <code>PlayerInfoRow</code> that contains
     * <code>JComboBox</code> type.
     *
     * @param type
     * @return
     */
    private PlayerInfoRow getSelectedRow(JComboBox type) {
        for (PlayerInfoRow info : players) {
            if (info.getTypeComboBox().equals(type)) {
                return info;
            }
        }
        return null; // Non dovrebbe mai arrivarci
    }

    /**
     * Returns a valid name for an artificial player, depending on the number of
     * artificial players already in the game.
     *
     * @return
     */
    private String getAIName() {

        String name;
        for (int i = 0; i < PlayersPanel.N_PLAYERS_MAX; i++) {
            name = "GiocatoreIA" + (i + 1);
            if (!getAllAINames().contains(name)) {
                return name;
            }
        }
        return null; // Non dovrebbe mai arrivarci
    }

    /**
     * Returns all the names of the artificial players.
     *
     * @return
     */
    private List<String> getAllAINames() {

        List<String> names = new ArrayList<>();
        for (PlayerInfoRow player : players) {
            if (player.isArtificial()) {
                names.add(player.getPlayerName());
            }
        }
        return names;
    }

    /**
     * Returns the list of all the logged players.
     *
     * @return
     */
    private List getAllLoggedPlayers() {
        List<String> list = new ArrayList<>();
        for (PlayerInfoRow player : players) {
            if (player.isLogged()) {
                list.add(player.getPlayerName());
            }
        }
        return list;
    }

}
