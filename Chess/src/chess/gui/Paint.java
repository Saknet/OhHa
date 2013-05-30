
package chess.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/** 
 * piirtoalusta, pahasti kesken
 */ 
public class Paint extends JPanel {
    
    public Paint() {
        super.setBackground(Color.GREEN);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(350, 100, 327, 327);
        graphics.setColor(Color.BLACK);  
        graphics.fillRect(391, 100, 1, 327);   
        graphics.fillRect(432, 100, 1, 327); 
        graphics.fillRect(473, 100, 1, 327); 
        graphics.fillRect(514, 100, 1, 327); 
        graphics.fillRect(514, 100, 1, 327);    
        graphics.fillRect(555, 100, 1, 327);   
        graphics.fillRect(596, 100, 1, 327);   
        graphics.fillRect(637, 100, 1, 327);  
        graphics.fillRect(350, 141, 327, 1); 
        graphics.fillRect(350, 182, 327, 1);
        graphics.fillRect(350, 223, 327, 1);
        graphics.fillRect(350, 264, 327, 1);
        graphics.fillRect(350, 305, 327, 1);
        graphics.fillRect(350, 346, 327, 1);
        graphics.fillRect(350, 387, 327, 1);
        
    }
                           
    
}
