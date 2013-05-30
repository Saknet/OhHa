
package chess.domain;

/**
 * tässä luokassa on metodeja jotka tarkistavat onko jotkut asiat mahdollisia
 */

public class Checks {
    private final int over = 8;
    private final int under = 0; 
    private final int s = 10;
       
     /**
     * tarkistaa onko saman värisiä nappuloida kohderuudussa
     * @param locations omien nappuloiden sijannit
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatti
     * @return palauttaa true jos ruutu on tyhjä
     */   
    public boolean empty(int[]locations, int x, int y) {
        for (int i = 0; i < locations.length; i++) {
            if(locations[i] == s * x + y) {
                return false;
            }
        }
        return true;
    }   
    
    /**
     * tarkistaa onko koordinaatti shakkilaudalla, siistii hieman koodia muista luokista
     * @param x x - koordinaatti
     * @param y y - koordinaatti
     * @return palauttaa true jos koordinaatti on shakkilaudalla
     */    
    public boolean onBoard(int x, int y) {
        if (x >= under && x < over && y >= under && y < over) {
            return true;
        }
        return false;
    }       
    
}
