
package chess.gui;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Tässä luokassa voidaan muokata pelissä käytettyjä komponentteja.
 */

public class ModifyComponent {
    
    /**
     *  Tämän metodin avulla lisätään halutut ominaisuudet JButtoniin.
     *  @param button Nappula, jota muokataan.
     *  @param xLocation Nappulan sijainti x-tasossa.
     *  @param yLocation Nappulan sijainti y-tasossa.
     *  @param xSize Nappulan leveys.
     *  @param ySize Nappulan korkeus.viä.
     *  @param fontSize Nappulan fontin koko.
     *  @param container Container johon nappula lisätään.
     */    
    public void modifyJButton(JButton button, int xLocation, int yLocation, int xSize, int ySize, int fontSize, Container container) {
        button.setLocation(xLocation, yLocation);
        button.setSize(xSize, ySize);
        button.setFont(new Font("Serif", Font.BOLD, fontSize));
        container.add(button);
    } 
    
    /**
     *  Tämän metodin avulla lisätään halutut ominaisuudet JButtoniin.
     *  @param label JLabel, jota muokataan.
     *  @param xLocation JLabelin sijainti x-tasossa.
     *  @param yLocation JLabelin sijainti y-tasossa.
     *  @param xSize JLabelin leveys.
     *  @param ySize JLabelin korkeus.viä.
     *  @param fontSize JLabelin fontin koko.
     *  @param container Container johon JLabel lisätään.
     */      
    public void modifyJLabel(JLabel label, int xLocation, int yLocation, int xSize, int ySize, int fontSize, Container container) {
        label.setLocation(xLocation, yLocation);
        label.setSize(xSize, ySize);
        label.setFont(new Font("Serif", Font.BOLD, fontSize));
        container.add(label);
    }

    /**
     *  Tämän metodin avulla lisätään halutut ominaisuudet JButtoniin.
     *  @param field Tekstikenttä, jota muokataan.
     *  @param xLocation Tekstikenttä sijainti x-tasossa.
     *  @param yLocation Tekstikenttä sijainti y-tasossa.
     *  @param xSize Tekstikenttä leveys.
     *  @param ySize Tekstikenttä korkeus.viä.
     *  @param fontSize Tekstikenttä fontin koko.
     *  @param container Container johon tekstikenttä lisätään.
     */      
    public void modifyJTextField(JTextField field, int xLocation, int yLocation, int xSize, int ySize, int fontSize, Container container) {
        field.setLocation(xLocation, yLocation);
        field.setSize(xSize, ySize);
        field.setFont(new Font("Serif", Font.BOLD, fontSize));
        container.add(field);
    }      
    
}
