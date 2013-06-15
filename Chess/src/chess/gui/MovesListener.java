
package chess.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Tämä luokka kuuntelee move piece nappia jos on valkoisen vuoro siirtää nappuloita.
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
     * @param gui olio, jota kuunellaan.
     * @param startx X - alkukoordinaatin tekstikentän sisältö.
     * @param starty Y - alkukoordinaatin tekstikentän sisältö.
     * @param endx X - loppukoordinaatin tekstikentän sisältö.
     * @param endy Y - loppukoordinaatin tekstikentän sisältö.
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
     * Tämä metodi muuttaa JTextFieldin sisällöt sopivaksi mustan nappulan siirtoa 
     * varten kun move piece nappia painetaan.
     *
     * @param ae Napinpainallus.
     */     
    @Override
    public void actionPerformed(ActionEvent ae) {
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
        gui.setSX(sx);
        String text2 = starty.getText();        
        int sy = Integer.parseInt(text2); 
        gui.setSY(8 - sy);
        String text3 = endx.getText();        
        int ex = 99;
        if (text3.endsWith("a") || text3.endsWith("A")) {
            ex = 0;
        }
        if (text3.endsWith("b") || text3.endsWith("B")) {
            ex = 1;
        }   
        if (text3.endsWith("c") || text3.endsWith("C")) {
            ex = 2;
        }  
        if (text3.endsWith("d") || text3.endsWith("D")) {
            ex = 3;
        }  
        if (text3.endsWith("e") || text3.endsWith("E")) {
            ex = 4;
        }
        if (text3.endsWith("f") || text3.endsWith("F")) {
            ex = 5;
        }   
        if (text3.endsWith("g") || text3.endsWith("G")) {
            ex = 6;
        }  
        if (text3.endsWith("h") || text3.endsWith("H")) {
            ex = 7;
        }                  
        gui.setEX(ex);
        String text4 = endy.getText();          
        int ey = Integer.parseInt(text4); 
        gui.setEY(8 - ey);
        if (sx < 0 || sx > 7 || sy < 0 || sy > 7) {
            gui.turns();
        }
        if (turn % 2 == 0) {
            gui.moveBlack();
        } else {
        gui.moveWhite();
        }

    }
    
}
