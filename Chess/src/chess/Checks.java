
package chess;


public class Checks {
    //tarkistaa onko saman värisiä kohderuudussa
    public boolean empty(int[]locations, int x, int y) {
        for (int i = 0; i < locations.length; i++) {
            if(locations[i] == 10 * x + y) {
                return false;
            }
        }
        return true;
    }
    

    /**
     * ehkä poistuu seuravassa deadlines nämä kaksi metodia, tekee samaa kun edellinen mutta käytössä sotilan siirrossa tällä hetkellä
     */
    public boolean checkWhite(int[]whites, int x, int y) {
        for (int i = 0; i < whites.length; i++) {
                if (whites[i] == 10 * x + y) {
                    return true;
                }
        }
        return false;
    }
    
    public boolean checkBlack(int[]blacks, int x, int y) {
        for (int i = 0; i < blacks.length; i++) {
                if (blacks[i] == 10 * x + y) {
                    return true;
                }
        }
        return false;
    } 
    /**
     * tarkistaa onko kordinaatti shakkilaudalla, siistii hieman koodia muista luokista
     */    
    public boolean onBoard(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            return true;
        }
        return false;
    }
    
}
