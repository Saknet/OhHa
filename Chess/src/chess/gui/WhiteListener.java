
package chess.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Tämä luokka kuuntelee move piece nappia jos on valkoisen vuoro siirtää nappuloita.
 */
public class WhiteListener implements ActionListener {
    private Gui gui;
    private JTextField startx;
    private JTextField starty;
    private JTextField endx;
    private JTextField endy;
        
    /**
     * Luokan konstruktori.
     *
     * @param gui olio, jota kuunellaan.
     * @param startx X - alkukoordinaatin tekstikentän sisältö.
     * @param starty Y - alkukoordinaatin tekstikentän sisältö.
     * @param endx X - loppukoordinaatin tekstikentän sisältö.
     * @param endy Y - loppukoordinaatin tekstikentän sisältö.
     */     
    public WhiteListener(Gui gui, JTextField startx, JTextField starty, JTextField endx, JTextField endy) {
        this.gui = gui;
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
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
        int sx = Integer.parseInt(text); 
        gui.setSX(sx);
        String text2 = starty.getText();        
        int sy = Integer.parseInt(text2); 
        gui.setSY(sy);
        String text3 = endx.getText();        
        int ex = Integer.parseInt(text3);
        gui.setEX(ex);
        String text4 = endy.getText();          
        int ey = Integer.parseInt(text4); 
        gui.setEY(ey);
        gui.moveWhite();

    }
    
}
