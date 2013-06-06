
package chess.domain;

/**
 * Tässä luokassa on metodeja jotka tarkistavat onko jotkut siirtyihin liittyvät
 * asiat mahdollisia.
 */

public class Checks {
    private final int over = 8;
    private final int under = 0; 
    private final int s = 10;
       
     /**
     * Tarkistaa onko saman värisiä nappuloida kohderuudussa.
     * 
     * @param locations omien nappuloiden sijannit.
     * @param x siirettävän nappulan loppu x-koordinaatti.
     * @param y siirettävän nappulan loppu y-koordinaatti.
     * @return palauttaa true jos ruutu on tyhjä.
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
     * Tarkistaa onko koordinaatti shakkilaudalla, siistii hieman koodia muista luokista.
     * 
     * @param x x - koordinaatti.
     * @param y y - koordinaatti.
     * @return palauttaa true jos koordinaatti on shakkilaudalla.
     */    
    public boolean onBoard(int x, int y) {
        if (x >= under && x < over && y >= under && y < over) {
            return true;
        }
        return false;
    } 

    /**
     * Tarkistaa voidaanko tornia siirtää alkuruudusta kohderuutuun 
     * kun ruudut ovat samalla pystysuoralla.
     * 
     * @param board shakkilauta
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param x siirettävän nappulan loppu x-koordinaatti.
     * @param y siirettävän nappulan loppu y-koordinaatti.
     * @return palauttaa true jos siirton on mahdollinen.
     */     
    public boolean rookCheckVertical(int[][]board, int sx, int sy, int x, int y) {
        if (sy < y) {
            for (int i = sy + 1; i < y; i++) {
                if (board[i][sx] != 0) {
                    return false;
                }
            }  
            return true;
        } else {
            for (int i = sy - 1; i > y; i--) {
                if (board[i][sx] != 0) {
                    return false;
                }
            }
            return true;
        }        
    }

    /**
     * Tarkistaa voidaanko tornia siirtää alkuruudusta kohderuutuun 
     * kun ruudut ovat samalla vaakasuoralla.
     * 
     * @param board shakkilauta
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param x siirettävän nappulan loppu x-koordinaatti.
     * @param y siirettävän nappulan loppu y-koordinaatti.
     * @return palauttaa true jos siirton on mahdollinen.
     */    
    public boolean rookCheckHorizontal(int[][]board, int sx, int sy, int x, int y) {
        if (sx < x) {
            for (int i = sx + 1; i < x; i++) {
                if (board[sy][i] != 0) {
                    return false;
                }
            }  
            return true;
        } else {
            for (int i = sx - 1; i > x; i--) {
                if (board[sy][i] != 0) {
                    return false;
                }
            }
            return true;
        }        
    }
    
    /**
     * Tarkistaa voidaanko lähettiä siirtää alkuruudusta kohderuutuun, kun kohde
     * ruutu on alkuruutua vasemalla ja ylempänä.
     * 
     * @param board shakkilauta
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param x siirettävän nappulan loppu x-koordinaatti.
     * @param y siirettävän nappulan loppu y-koordinaatti.
     * @return palauttaa true jos siirton on mahdollinen.
     */    
    public boolean bishopCheckNW(int[][]board, int sx, int sy, int x, int y) {
        for (int i = sx - 1; i > x; i--) {
            if (board[y + i][x + i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Tarkistaa voidaanko lähettiä siirtää alkuruudusta kohderuutuun, kun kohde
     * ruutu on alkuruutua vasemalla ja alempana.
     * 
     * @param board shakkilauta
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param x siirettävän nappulan loppu x-koordinaatti.
     * @param y siirettävän nappulan loppu y-koordinaatti.
     * @return palauttaa true jos siirton on mahdollinen.
     */     
    public boolean bishopCheckSW(int[][]board, int sx, int sy, int x, int y) {
        for (int i = sx - 1; i > x; i--) {
            if (board[y - i][x + i] != 0) {
                return false;
            }
        }
        return true; 
    }
    
    /**
     * Tarkistaa voidaanko lähettiä siirtää alkuruudusta kohderuutuun, kun kohde
     * ruutu on alkuruutua oikealla ja ylempänä.
     * 
     * @param board shakkilauta
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param x siirettävän nappulan loppu x-koordinaatti.
     * @param y siirettävän nappulan loppu y-koordinaatti.
     * @return palauttaa true jos siirton on mahdollinen.
     */     
    public boolean bishopCheckNE(int[][]board, int sx, int sy, int x, int y) {
        int k = 0;                
        for (int i = sx + 1; i < x; i++) {
            if (board[sy - k][i] != 0) {
                return false;
            }
        }
        return true;  
    }

    /**
     * Tarkistaa voidaanko lähettiä siirtää alkuruudusta kohderuutuun, kun kohde
     * ruutu on alkuruutua oikealla ja alempana.
     * 
     * @param board shakkilauta
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param x siirettävän nappulan loppu x-koordinaatti.
     * @param y siirettävän nappulan loppu y-koordinaatti.
     * @return palauttaa true jos siirton on mahdollinen.
     */     
    public boolean bishopCheckSE(int[][]board, int sx, int sy, int x, int y) {
        int k = 0;
        for (int i = sx + 1; i < x; i++) {
            k++;
            if (board[sy + k][i] != 0) {
                return false;
            }
        }
        return true; 
    }    
}
