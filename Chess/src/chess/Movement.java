
package chess;

// tarkoitus olisi tähän luokkaan tehdä kaikkien nappuloiden mahdolliset siirrot, viikonloppuna tai ensi viikolla, kun AATUsta selvitty
public class Movement {
    
    public Movement() {
        
    }
    // siirtää mustaa kuningasta, tällä hetkellä tämä metodi siirtää kaikkia mustia nappuloita
    public boolean moveBlackKing( int[]blacks, int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && empty(blacks, x, y) == true) {
            return true;
        }
        return false;
        
    }
    
    // siirtää valkoista kuningasta, tällä hetkellä tämä metodi siirtää kaikkia valkoisia nappuloita    
    public boolean moveWhiteKing(int[] whites, int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && empty(whites, x, y) == true) {
            return true;
        }
        return false;
        
    }
    
    //tarkistaa onko saman värisiä kohderuudussa
    public boolean empty(int[]locations, int x, int y) {
        for (int i = 0; i < locations.length; i++) {
            if(locations[i] == 10 * x + y) {
                return false;
            }
        }
        return true;
    }
    
    //tarkistaa onko nappulaa lähtöruudussa
    public boolean checkStart(int[]locations, int x, int y) {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] == 10 * x + y) {
                return true;
            }
        }
        return false;
    }    
    
}
