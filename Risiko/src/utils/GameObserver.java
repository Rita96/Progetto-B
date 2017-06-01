
package utils;

import java.awt.Color;
import risiko.players.Player;

/**
 * A class can implement the <code>Observer</code> interface when it
 * wants to be informed of changes in observable objects.
 *
 * @author  Chris Warth
 * @see     java.util.Observable
 * @since   JDK1.0
 */
public interface GameObserver extends BasicGameObserver {

    /**
     * Metodo chiamato dopo la fase di rinforzo
     * @param countryName
     * @param bonusArmies 
     */
    public void updateOnReinforce(String countryName, int bonusArmies);

    /**
     * Metodo chiamato al cambiamento della fase di gioco
     * @param player
     * @param phase 
     */
    public void updateOnPhaseChange(String player, String phase, String color);

    /**
     * Metodo chiamato quando viene settato l'attaccante
     * @param countryName 
     */
    public void updateOnSetAttacker(String countryName);

    
    /**
     * Metodo chiamato dopo l'assegnazione delle country
     * @param countries
     * @param armies
     * @param colors 
     */
    public void updateOnCountryAssignment(String[] countries, int[] armies, String[] colors);
    
    /**
     * Metodo chiamato dopo uno spostamento di armate
     * @param country
     * @param armies
     * @param color 
     */
    public void updateOnArmiesChange(String country, int armies, String color);    
    
    public void updateOnNextTurn();

    public void updateOnSetFromCountry(String countryName);

    public void updateOnDrawnCard(String cardName);
}