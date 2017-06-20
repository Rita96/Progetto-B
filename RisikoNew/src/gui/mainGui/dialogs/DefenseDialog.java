package gui.mainGui.dialogs;

import exceptions.TranslationException;
import gui.DefaultColor;
import gui.PlayAudio;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.SpinnerNumberModel;
import risiko.game.GameProxy;
import services.Translator;

/**
 * JDialog that allows the defender player to introduce the number of armies
 * with which it want to defend.
 */
public class DefenseDialog extends JDialog {

    private final static String LANG = "ITA";
    private GameProxy game;

    public DefenseDialog(GameProxy game, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.game = game;
        init();
    }

    private void init() {
        try {
            this.setTitle(Translator.getInstance().translate("Defense", LANG, false));
        } catch (TranslationException ex) {
            Logger.getLogger(DefenseDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Dimension dim = getToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

    }

    public void setMaxArmies(int maxArmiesDefender) {
        defenderArmies.setModel(new SpinnerNumberModel(maxArmiesDefender, 1, maxArmiesDefender, 1));
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
        jLabel4 = new javax.swing.JLabel();
        defenderCountryName = new javax.swing.JLabel();
        attackerCountryName = new javax.swing.JLabel();
        defenderArmies = new javax.swing.JSpinner();
        confirmAttackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Armate difesa");

        jLabel4.setText("VS");

        defenderCountryName.setText("stati uniti occidentali");

        attackerCountryName.setText("stati uniti occidentali");

        confirmAttackButton.setText("Conferma attacco");
        confirmAttackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAttackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(attackerCountryName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(defenderCountryName))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(defenderArmies, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmAttackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attackerCountryName)
                    .addComponent(jLabel4)
                    .addComponent(defenderCountryName))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defenderArmies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmAttackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmAttackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAttackButtonActionPerformed
        PlayAudio.play("src/resources/sounds/tank.wav");
        //game.setDefenderArmies();
        this.setVisible(false);
        game.confirmAttack((int) this.defenderArmies.getValue());
    }//GEN-LAST:event_confirmAttackButtonActionPerformed

    public void setFightingLabels(String attackerCountryName, String attackerColor, String defenderCountryName, String defenderColor) {
        this.attackerCountryName.setText(attackerCountryName);
        this.attackerCountryName.setForeground(DefaultColor.valueOf(attackerColor.toUpperCase()).getColor());
        this.defenderCountryName.setText(defenderCountryName);
        this.defenderCountryName.setForeground(DefaultColor.valueOf(defenderColor.toUpperCase()).getColor());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attackerCountryName;
    private javax.swing.JButton confirmAttackButton;
    private javax.swing.JSpinner defenderArmies;
    private javax.swing.JLabel defenderCountryName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
