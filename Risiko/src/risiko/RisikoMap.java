package risiko;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RisikoMap {

    private final String urlCountries = "files/territori.txt"; 
    private Map<Country, Player> countryPlayer;
    private Map<Country, List<Country>> countryNeighbors;

    public RisikoMap() throws Exception {

        this.countryPlayer = new HashMap<>();
        this.countryNeighbors = new HashMap<>();
        init();

    }

    /**
     * Inizializza la mappa leggendo il file specificato in urlCountries (in
     * countryPlayer il player è inizializzato a null)
     *
     * @throws qualche eccezione relativa alla lettura del file
     */
    private void init() throws Exception {

        buildCountryPlayer();
        buildCountryNeighbors();

    }

    /** DA FARE : P1 (1)
     * Legge il file specificato a urlCountries, di ogni riga letta prende solo
     * il primo token e builda la Country relativa e la mette in CountryPlayer
     * @throws qualche eccezione legata alla lettura del file
     */
    private void buildCountryPlayer() throws Exception {

    }

    /** DA FARE : P1 (2)
     * Legge il file specificato da urlCountries, per ogni country costruisce
     * una List di vicini, salva in CountryNeighbor il territorio e la lista di vicini.
     * @throws qualche eccezione legata alla lettura del file
     */
    private void buildCountryNeighbors() throws Exception {

    }

    /** DA FARE : P1 (3)
     * Effettua l'assegnazione iniziale dei territori ai giocatori (random).
     *
     * @param players
     */
    public void assignCountriesToPlayers(List<Player> players) {

    }
    
    /** 
     * Ritorna il giocatore a cui appartiene quel territorio
     * @param country
     * @return 
     */
    public Player getPlayerFromCountry(Country country) {
        return countryPlayer.get(country);
    }

    /** DA FARE : P1 (4)
     * Esegue la fase di rinforzo di inizio turno. Nr armate bonus =
     * ceil(nrTerritoriGiocatore/3) e le distribuisce a caso sui territori del
     * giocatore
     *
     * @param player il giocatore di turno
     */
    void reinforce(Player player) {

    }
    
    /** DA FARE : P2 (1)
     * Ritorna una lista dei territori del giocatore (per ora inutile)
     * @param player
     * @return 
     */
    
    public List<Country> getMyCountries(Player player){
        return null;
    }
    
    /** 
     * Ritorna la lista dei vicini di un territorio.
     * 
     * @param country
     */
    
    public List<Country> getNeighbors(Country country){
        return countryNeighbors.get(country);
    }

    /** DA FARE : P2 (2)
     * Controlla se il giocatore può ancora attaccare da uno dei suoi territori.
     *
     * @param activePlayer
     * @return true nel caso in cui almeno uno dei territori di ActivePlayer abbia
     * più di un'armata, false in caso contrario.
     */
    public boolean playerCanAttack(Player player) {
        return false;
    }

    /** DA FARE : P2 (3)
     * Sceglie il territorio attaccante e attaccato dal giocatore. 
     * (Idealmente : continua a tirare a caso coppie di countries (e a chiamare
     * verifyAttack per ognuna di loro, finché verify attack non restituisce true)
     * @param player il giocatore di turno.
     * @return un array di territori, Country[0] quello attaccante, Country[1]
     * quella attaccato
     */
    
    public Country[] getFightingCountries(Player player) {

        return null;
    }

    /** DA FARE : P2 (4)
     * Controlla che l'attacco sia valido. return true se Country[0] è del
     * giocatore di turno e ha di un'armata, Country[1] è di un altro giocatore, e
     * i due territori sono confinanti, false altrimenti.
     *
     * @param countries array di territori, [0] attaccante, [1] attaccato
     * @param player il giocatore di turno.
     */
    public boolean verifyAttack (Country[] countries, Player player) {
        
        return false;
    }

    /** DA FARE : P2 (5)
     * Metodo chiamato nel caso in cui un giocatore abbia conquistato un
     * territorio. Setta il nuovo proprietario del territorio appena conquistato
     * (countryPlayer) e muove tante armate quante sono quelle con cui è stato
     * eseguito l'attacco dal territorio attaccante a quello conquistato.
     *
     * @param countries array di Country (lenght:2) che ha come elemento [0] il
     * territorio attaccante, mentre l'elemento [1] è quello appena conquistato
     *
     * @param armies è il numero di armate con cui è stato sferrato l'attacco, e
     * in questa prima versione del gioco anche il numero di armate che vengono
     * spostate dal territorio attaccante a quello appena conquistato.
     */
    public void updateOnConquer(Country[] countries, int armies) {

    }

    /** DA FARE : P3 (1) continua in Player
     * Metodo chiamato nel caso in cui un giocatore abbia conquistato un
     * territorio. La mappa controlla se ha raggiunto il suo obbiettivo (in
     * questa prima versione del gioco conquistare il mondo).
     *
     * @param player il giocatore di turno
     * @return true se il giocatore ha vinto, false altrimenti.
     *
     */
    public boolean checkIfWinner(Player player) {
        return false;
    }
    
    /** 
     * Controlla se il territorio è stato conquistato
     * @return true se non ha armate 
     */
    public boolean isConquered(Country country){
        return country.isConquered();
    }
}
