package gui;

import exceptions.PendingOperationsException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import risiko.Country;
import risiko.Phase;
import risiko.Game;
import risiko.Player;
import utils.PlayAudio;

/**
 * @author andrea
 */
public class GUI extends JFrame implements GameObserver{

    private Game game;
    private final Map<Color, String> colorCountryNameMap;
    private final Map<String, JLabel> countryLabelMap;
    private AttackDialog inputArmies;
    

    public GUI(Map<String, Boolean> players, String[] colors) throws Exception {
        initComponents();
        countryLabelMap = new HashMap<>();
        colorCountryNameMap = readColorTextMap("files/ColorCountry.txt");
        init(players, colors);
    }

    /**
     * Inizializza la gui e il game.
     *
     * @throws IOException
     * @throws Exception
     */
    private void init(Map<String, Boolean> players, String[] colors) throws IOException, Exception {
        initLabels("files/labelsTerritori.txt");
        mapLayeredPane.setComponentZOrder(labelMap, mapLayeredPane.getComponentCount() - 1);
        game = new Game(players, colors, this);
        LabelMapListener labelMapListener = new LabelMapListener(labelMap, colorCountryNameMap, game);
        labelMap.addMouseListener(labelMapListener);
        labelMap.addMouseMotionListener(labelMapListener);
        inputArmies = new AttackDialog(game);
        inputArmies.setPreferredSize(new Dimension(500,600));
        inputArmies.pack();
        labelAdvice.setText("Clicca su un tuo territorio per rinforzarlo con 1 armata");
        labelAdvice.setFont(new Font("Serif", Font.PLAIN, 13));
    }

    /**
     * Inizializza i labels
     *
     * @param src
     * @throws IOException
     */
    private void initLabels(String src) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(src))) {
            String line;
            String[] tokens;
            int x, y;
            while ((line = br.readLine()) != null) {
                tokens = line.split("\t");
                x = Integer.parseInt(tokens[0].split(",")[0]);
                y = Integer.parseInt(tokens[0].split(",")[1]);
                createLabel(tokens[1], x, y);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    /**
     * Crea un label e lo aggiunge a <code>countryLabelMap</code>.
     *
     * @param countryName
     * @param x
     * @param y
     */
    private void createLabel(String countryName, int x, int y) {
        JLabel label = new JLabel("0");
        label.setFont(new Font("Serif", Font.BOLD, 16));
        label.setBounds(x, y, 8, 16);
        //label.setOpaque(true);
        //label.setBackground(new Color(255, 255, 255, 100));
        mapLayeredPane.add(label);
        mapLayeredPane.setComponentZOrder(label, 1);
        countryLabelMap.put(countryName, label);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPlayerPhase = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaInfo = new javax.swing.JTextArea();
        buttonAttack = new javax.swing.JButton();
        buttonNextPhase = new javax.swing.JButton();
        buttonMoreInfo = new javax.swing.JButton();
        mapLayeredPane = new javax.swing.JLayeredPane();
        labelMap = new GraphicsJLabel();
        labelAdvice = new javax.swing.JLabel();
        buttonShowMission = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelPlayerPhase.setBackground(new java.awt.Color(225, 207, 218));
        labelPlayerPhase.setForeground(new java.awt.Color(1, 1, 1));

        textAreaInfo.setColumns(20);
        textAreaInfo.setRows(5);
        jScrollPane1.setViewportView(textAreaInfo);

        buttonAttack.setText("attack");
        buttonAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttackActionPerformed(evt);
            }
        });

        buttonNextPhase.setText("nextPhase");
        buttonNextPhase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextPhaseActionPerformed(evt);
            }
        });

        buttonMoreInfo.setText("MoreInfo");
        buttonMoreInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoreInfoActionPerformed(evt);
            }
        });

        mapLayeredPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/mapparisiko.png"))); // NOI18N

        mapLayeredPane.setLayer(labelMap, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mapLayeredPaneLayout = new javax.swing.GroupLayout(mapLayeredPane);
        mapLayeredPane.setLayout(mapLayeredPaneLayout);
        mapLayeredPaneLayout.setHorizontalGroup(
            mapLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMap)
        );
        mapLayeredPaneLayout.setVerticalGroup(
            mapLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMap)
        );

        buttonShowMission.setText("ShowMission");
        buttonShowMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowMissionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPlayerPhase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mapLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonAttack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonNextPhase, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(buttonMoreInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(buttonShowMission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelAdvice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPlayerPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAdvice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonShowMission, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNextPhase, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(mapLayeredPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMoreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoreInfoActionPerformed
        String format = "%-30s %-15s %s";
        String info = String.format(format, "territorio", "proprietario", "numero armate") + "\n";
        for (Map.Entry<Country, Player> e : game.getCountryPlayer().entrySet()) {
            info += String.format(format, e.getKey().getName(), e.getValue().getName(), e.getKey().getArmies()) + "\n";
        }
        JOptionPane.showMessageDialog(null, info);
    }//GEN-LAST:event_buttonMoreInfoActionPerformed

    private void buttonNextPhaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextPhaseActionPerformed
        //System.out.println(javax.swing.SwingUtilities.isEventDispatchThread());
        ((GraphicsJLabel) labelMap).resetCone();

        try {
            game.nextPhase();
        } catch (PendingOperationsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        repaint();
    }//GEN-LAST:event_buttonNextPhaseActionPerformed

    private void buttonAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttackActionPerformed
        if (game.getPhase().equals(Phase.FIGHT)) {
            if (game.getAttackerCountryName() != null && game.getDefenderCountryName() != null) {
                inputArmies.setVisible(true);
            }
            game.resetFightingCountries();
        }
    }//GEN-LAST:event_buttonAttackActionPerformed

    private void buttonShowMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowMissionActionPerformed
        String mission= game.getActivePlayer().getMission().getDescription();
        JOptionPane.showMessageDialog(null, mission);
    }//GEN-LAST:event_buttonShowMissionActionPerformed

    /**
     * Procedurone per la creazione di una map<Color,String> a partire da un
     * file di testo contenente un numero a piacere di linee, dove ogni linea
     * contiene un [token] avente la forma: [token] -> [Country] = [RGB]
     * [Country] -> qualsiasi sequenza di caratteri ASCII diversi dal carattere
     * = e interruzioni di linea [RGB] -> [R],[G],[B] [R] -> un numerCountryo
     * intero da 0 a 255 [G] -> un numero intero da 0 a 255 [B] -> un numero
     * intero da 0 a 255.
     */
    private static Map<Color, String> readColorTextMap(String relativeURL) throws FileNotFoundException {
        Map<Color, String> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader(relativeURL))) {
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split("=");
                String[] RGB = tokens[1].split(",");
                String country = tokens[0];
                int R = Integer.parseInt(RGB[0].trim());
                int G = Integer.parseInt(RGB[1].trim());
                int B = Integer.parseInt(RGB[2].trim());
                Color color = new Color(R, G, B);
                map.put(color, country);
            }
        }
        return map;
    }
    /**
     * Aggiorna <code> textAreaInfo</code> e <code>labelAdvice</code> dopo 
     * che la country <code>countryName</code> è stata rinforzata.
     * @param countryName
     * @param bonusArmies 
     */
    @Override
    public void updateOnReinforce(String countryName, int bonusArmies) {

        String s;
        s = "Hai rinforzato " + countryName + ".\n ";
        if (bonusArmies == 0) {
            s += "Fase di rinforzo conlusa.\n";
            String s1 = "Clicca nextPhase per continuare il tuo turno";
            this.labelAdvice.setText(s1);
        } else {
            s += "Ti rimangono " + bonusArmies + " armate.\n";
        }
        this.textAreaInfo.setText(s);
    }
    
    /**
     * Aggiorna <code>textAreaInfo</code> e <code>labelAdvice</code> quando
     * cambia la fase del gioco.
     * @param player
     * @param phase 
     */
    @Override
    public void updateOnPhaseChange(String player, String phase) {
        this.labelPlayerPhase.setText(player + " " + phase);
        this.textAreaInfo.setText("");
        switch (phase) {
            case "REINFORCE":
                labelAdvice.setText("Clicca su un tuo territorio per rinforzarlo con 1 armata");
                break;
            case "FIGHT":
                labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");
                break;
        }
    }
    
    /**
     * Aggiorna <code>textAreaInfo</code> e <code>labelAdvice</code> quando è
     * stato scelto il territorio da cui attaccare.
     * @param countryName 
     */
    @Override
    public void updateOnSetAttacker(String countryName) {
        ((GraphicsJLabel)labelMap).resetCone();
        if (countryName != null) {
            this.textAreaInfo.setText("Attaccante : " + countryName);
            labelAdvice.setText("Clicca su un territorio confinante per sceglierlo come difensore");
        } else {
            this.textAreaInfo.setText("");
        }
    }
    
    /**
     * Aggiorna  <code>textAreaInfo</code> e <code>labelAdvice</code> quando è
     * stato scelto il territorio da attaccare.
     * Aggiorna anche i valori di massimo numero di armate dell'attaccante/difensore
     * per preparare il jspinner dell'AttackDialog.
     * @param countryAttackerName
     * @param countryDefenderName
     * @param defenderPlayer
     * @param maxArmiesAttacker
     * @param maxArmiesDefender 
     */
    @Override
    public void updateOnSetDefender(String countryAttackerName, String countryDefenderName, String defenderPlayer, int maxArmiesAttacker, int maxArmiesDefender) {
        ((GraphicsJLabel) labelMap).drawCone(countryLabelMap.get(countryAttackerName).getBounds(), countryLabelMap.get(countryDefenderName).getBounds());

        if (countryDefenderName != null) {
            String s = "Attaccante : " + countryAttackerName + "\n";
            s += "Difensore : " + countryDefenderName + " ( " + defenderPlayer + " ).\n";
            this.textAreaInfo.setText(s);
            labelAdvice.setText("Clicca su attack per iniziare l'attacco(oppure clicca un territorio confinate per cambiare il territorio in difesa)");
        } else {
            this.textAreaInfo.setText("");
            labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");
        }
        this.inputArmies.setMaxArmies(maxArmiesAttacker, maxArmiesDefender);
        repaint();
    }
    
    /**
     * Aggiorna  <code>textAreaInfo</code> e <code>labelAdvice</code> una volta
     * concluso l'attacco.
     * @param attackResultInfo
     * @param isConquered
     * @param canAttackFromCountry
     * @param maxArmiesAttacker
     * @param maxArmiesDefender 
     */
    @Override
    public void updateOnAttackResult(String attackResultInfo, boolean isConquered, boolean canAttackFromCountry, int maxArmiesAttacker, int maxArmiesDefender, int[] attackerDice, int[] defenderDice) {
        textAreaInfo.setText(attackResultInfo);
        inputArmies.setMaxArmiesAttacker(maxArmiesAttacker);
        inputArmies.setMaxArmiesDefender(maxArmiesDefender);
        inputArmies.updateDice(attackerDice, defenderDice);
        inputArmies.setIsConquered(isConquered);
        inputArmies.setCanAttackFromCountry(canAttackFromCountry);
        inputArmies.setDefenderCountryName(game.getDefenderCountryName());        
        labelAdvice.setText("Clicca su un tuo territorio per sceglierlo come attaccante");
    }
    
    /**
     * ...
     * @param winner 
     */
    @Override
    public void updateOnVictory(String winner) {
        JOptionPane.showMessageDialog(null, "Complimenti " + winner + " hai vinto!");
        //this.dispose();
        // etc
    }
    
    /**
     * Aggiorna le etichette dei dopo l'assegnazione iniziale delle armate.
     * @param countries
     * @param armies
     * @param colors 
     */
    @Override
    public void updateOnCountryAssignment(String[] countries, int[] armies, Color[] colors) {
        int i = 0;
        for (String country : countries) {
            updateOnArmiesChange(country, armies[i], colors[i]);
            i++;
        }
    }
    
    /**
     * Aggiorna l'etichetta del territorio <code>country</code> quando cambia il
     * numero di armate.
     * @param country
     * @param armies
     * @param color 
     */
    @Override
    public void updateOnArmiesChange(String country, int armies, Color color) {
        JLabel label = countryLabelMap.get(country);
        int width = (armies > 9) ? 16 : 8;
        label.setBounds((int) label.getBounds().getX(), (int) label.getBounds().getY(), width, 13);
        label.setForeground(color);
        label.setText(Integer.toString(armies));
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAttack;
    private javax.swing.JButton buttonMoreInfo;
    private javax.swing.JButton buttonNextPhase;
    private javax.swing.JButton buttonShowMission;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAdvice;
    private javax.swing.JLabel labelMap;
    private javax.swing.JLabel labelPlayerPhase;
    private javax.swing.JLayeredPane mapLayeredPane;
    private javax.swing.JTextArea textAreaInfo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateOnNextTurn(Player activePlayer) {
        CardBonusDialog cardBonusDialog=new CardBonusDialog(activePlayer);
    }

}
