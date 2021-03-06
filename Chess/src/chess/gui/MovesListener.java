
package chess.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Tämä luokka kuuntelee move piece nappia.
 */
public class MovesListener implements ActionListener {
    private Gui gui;
    private JTextField startx;
    private JTextField starty;
    private JTextField endx;
    private JTextField endy;
    private int turn;
        
    /**
     * Luokan konstruktori.
     *
     * @param gui luokka, jota kuunellaan.
     * @param startx X - alkukoordinaatin tekstikentän sisältö.
     * @param starty Y - alkukoordinaatin tekstikentän sisältö.
     * @param endx X - loppukoordinaatin tekstikentän sisältö.
     * @param endy Y - loppukoordinaatin tekstikentän sisältö.
     * @param turn vuoro, jotta tiedetään kumman vuoro on kyseessä.
     */     
    public MovesListener(Gui gui, JTextField startx, JTextField starty, JTextField endx, JTextField endy, int turn) {
        this.gui = gui;
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.turn = turn;
    }

    /**
     * Tämä metodi muuttaa JTextFieldin sisällöt sopivaksi nappulan siirtoa 
     * varten kun move piece nappia painetaan.
     *
     * @param ae Napinpainallus.
     */     
    @Override
    public void actionPerformed(ActionEvent ae) {
        setStartX();
        setStartY();
        setEndX();
        setEndY();
        
        if (turn % 2 == 0) {
            gui.moveBlack();
        } else {
        gui.moveWhite();       
        }

    }
    
    /**
     * Tämä metodi muuttaa startx teksikentän sisällön x alkukoordinaatiksi.
     */    
    private void setStartX() {
        String text = startx.getText();
        int sx = 99;
        
        if (text.endsWith("a") || text.endsWith("A")) {
            sx = 0;
        }
        
        if (text.endsWith("b") || text.endsWith("B")) {
            sx = 1;
        }   
        
        if (text.endsWith("c") || text.endsWith("C")) {
            sx = 2;
        }  
        
        if (text.endsWith("d") || text.endsWith("D")) {
            sx = 3;
        }  
        
        if (text.endsWith("e") || text.endsWith("E")) {
            sx = 4;
        }
        
        if (text.endsWith("f") || text.endsWith("F")) {
            sx = 5;
        } 
        
        if (text.endsWith("g") || text.endsWith("G")) {
            sx = 6;
        }  
        
        if (text.endsWith("h") || text.endsWith("H")) {
            sx = 7;
        } 
        
        if (sx < 0 || sx > 7) {
            gui.turns();
        } 
        
        gui.setSX(sx);                
    }
  
    /**
     * Tämä metodi muuttaa starty teksikentän sisällön y alkukoordinaatiksi.
     */     
    private void setStartY() {
        String text = starty.getText(); 
        int sy = 99;
        
        if (isValidNumber(text)) {
            sy = Integer.parseInt(text); 
        }
        
        if (sy < 1 || sy > 8) {
            gui.turns();
        } 
        
        gui.setSY(8 - sy);             
    }
    
    /**
     * Tämä metodi muuttaa endx teksikentän sisällön x loppukoordinaatiksi.
     */     
    private void setEndX() {
        String text = endx.getText();        
        int ex = 99;  
        
        if (text.endsWith("a") || text.endsWith("A")) {
            ex = 0;
        }
        
        if (text.endsWith("b") || text.endsWith("B")) {
            ex = 1;
        }   
        
        if (text.endsWith("c") || text.endsWith("C")) {
            ex = 2;
        }  
        
        if (text.endsWith("d") || text.endsWith("D")) {
            ex = 3;
        }  
        
        if (text.endsWith("e") || text.endsWith("E")) {
            ex = 4;
        }
        
        if (text.endsWith("f") || text.endsWith("F")) {
            ex = 5;
        }  
        
        if (text.endsWith("g") || text.endsWith("G")) {
            ex = 6;
        } 
        
        if (text.endsWith("h") || text.endsWith("H")) {
            ex = 7;
        } 
               
               
        gui.setEX(ex);        
    }
    
     /**
     * Tämä metodi muuttaa endy teksikentän sisällön y loppukoordinaatiksi.
     */   
    private void setEndY() {
        String text = endy.getText(); 
        int ey = 99;
        
        if (isValidNumber(text)) {
            ey = Integer.parseInt(text); 
        }
        gui.setEY(8 - ey);
    }
    
     /**
     * Tämä metodi tarkistaa onko y - koordinaatti numero.
     * 
     * @param text teksikentän sisältö
     * @return palauttaa true jos koordinaatti on sopiva numero
     */    
    private boolean isValidNumber(String text) {
        if (text.endsWith("1") || text.endsWith("2") || text.endsWith("3") || text.endsWith("4") ||
                text.endsWith("5") || text.endsWith("6") || text.endsWith("7") || text.endsWith("8")) {
            return true;
        } else {
            return false;
        }
    }
    
}
