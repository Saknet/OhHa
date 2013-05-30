
package chess.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Tämä luokka kuuntelee, mitä valikkoikkunan nappeja painetaan
 * Kesken
 */

public class Actions implements ActionListener  {

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = ((JButton) ae.getSource());
        if (button.getText().equals("Exit")) {
            System.exit(0);
        }        
    }
    
}
