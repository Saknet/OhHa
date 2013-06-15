
package chess.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JMenuItem;

/**
 * Tämä luokka kuuntelee, mitä käyttöliittymän nappeja painetaan.
 */

public class ButtonActions implements ActionListener  {
    private Gui ui;
    
    
    /**
     * Luokan konstruktori.
     *
     * @param ui Olio, jota kuunellaan.
     */    
    public ButtonActions(Gui ui) {
        this.ui = ui;
    }

    /**
     * Tämä metodi kertoo mitä tehdä, kun jotain nappia painetaan.
     *
     * @param ae Napinpainallus.
     */    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = ((JButton) ae.getSource());
        if (button.getText().equals("Exit")) {
            System.exit(0);
        } 
        if (button.getText().equals("Start new game")) {
            ui.startGame();
        }
        if (button.getText().equals("Give up")) {
            ui.endGame();
        }                  
    }
    
}
