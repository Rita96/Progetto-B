package gui.startGameGUI;

import controllers.ColorBoxListener;
import controllers.RemovePlayerListener;
import controllers.SelectTypeListener;
import exceptions.TranslationException;
import gui.DefaultColor;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import services.Translator;
import shared.PlayerInfo;

/**
 * Panel for player insertion. It's a table with a row for each player and and a
 * column for each JComponent that sets a property to the player(name, type,
 * troops color).
 *
 */
public class PlayersPanel extends JPanel {

    public static final int N_PLAYERS_MIN = 2;
    public static final int N_PLAYERS_MAX = 6;
    private List<PlayerInfoRow> players;
    private JComponent header;
    private final static String[] TYPES = {"Normale", "Artificiale", "Loggato"};
    private ColorBoxListener colorListener;
    private SelectTypeListener typeListener;
    private RemovePlayerListener removeListener;
    private final StartGameGUI gui;
    private final String LANG = "ITA";

    /**
     * Creates a new PlayersPanel and initializes it.
     *
     * @param gui
     */
    public PlayersPanel(StartGameGUI gui) {
        players = new ArrayList<>();
        this.gui = gui;
        init();
    }

    /**
     * Initialization.
     */
    private void init() {
        this.setLayout(new GridLayout(7, 1));
        initListeners();
        initHeader();
        initPlayerRows();
    }

    /**
     * Sets the header of the table.
     */
    private void initHeader() {
        header = new PlayerHeader();
        addToPanel(header);
    }

    /**
     * Adds to the table as many rows as the minimun number of players.
     */
    private void initPlayerRows() {
        for (int i = 0; i < N_PLAYERS_MIN; i++) {
            createPlayerRow(i);
        }
    }

    /**
     * Initializes the listeners.
     */
    private void initListeners() {
        DefaultColor[] colors = DefaultColor.values();
        String[] colorNames = new String[colors.length];
        for (int i = 0; i < colors.length; i++) {
            colorNames[i] = colors[i].toStringLC();
        }
        colorListener = new ColorBoxListener(players, colorNames);
        typeListener = new SelectTypeListener(gui, players);
        removeListener = new RemovePlayerListener(this, players);
    }

    /**
     * Adds a JComponent to the panel.
     *
     * @param component
     */
    private void addToPanel(JComponent component) {
        this.add(component);
        component.setVisible(true);
    }

    /**
     * Adds a row in the table. (Only if the number of players doesn't exceed
     * the maximum number allowed).
     */
    public void addPlayerRow() {
        if (players.size() >= N_PLAYERS_MAX) {
            return;
        }
        createPlayerRow(players.size());
        setRemovable(true);
        gui.setAddButtonVisible(players.size() < N_PLAYERS_MAX);

    }

    /**
     * Creates a new row and adds it to the panel.
     *
     * @param index
     */
    private void createPlayerRow(int index) {
        PlayerInfoRow player = new PlayerInfoRow(index, TYPES, colorListener, typeListener, removeListener);
        players.add(player);
        addToPanel((JComponent) player);

    }

    /**
     * Sets the visibility of the remove button of every row.
     *
     * @param removable
     */
    public void setRemovable(boolean removable) {
        for (PlayerInfoRow p : players) {
            p.setRemovable(removable);
        }
    }

    /**
     * Removes a row from the table.
     *
     * @param player
     */
    public void removePlayer(PlayerInfoRow player) {
        this.remove(player);
        repaint();
        updateGUI();
    }

    /**
     * Updates the GUI as soon as a new row has been added; sets the visibility
     * of the <code>removeButton</code> of each row and of the
     * <code>addButton</code> of StartGameGUI; it also updates the indexes of
     * the rows.
     */
    private void updateGUI() {
        setRemovable(players.size() > N_PLAYERS_MIN);
        gui.setAddButtonVisible(players.size() < N_PLAYERS_MAX);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setIndex(i);
        }
        revalidate();
    }

    /**
     * It retrives all the inserted names
     *
     * @return
     */
    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for (PlayerInfoRow player : players) {
            names.add(player.getPlayerName());
        }
        return names;
    }

    /**
     * Cretes a List of PlayerInfo, one for each player inserted in the game.
     *
     * @return
     */
    public List<PlayerInfo> getAllplayers() {
        List<PlayerInfo> list = new ArrayList<>();
        for (PlayerInfoRow player : players) {
            list.add(new PlayerInfo(player.getPlayerName(), player.getColor(), getFormattedType(player.getType().toLowerCase())));
        }
        return list;
    }

    /**
     * Returns the string that specifies the type of player in English.
     *
     * @param type
     * @return
     */
    private String getFormattedType(String type) {
        try {
            return Translator.translate(type, LANG, true);
        } catch (TranslationException ex) {
            return "";
        }
    }
}
