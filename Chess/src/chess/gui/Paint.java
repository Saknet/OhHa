
package chess.gui;

import chess.game.Chessboard;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/** 
 * piirtoalusta, pahasti kesken
 */ 
public class Paint extends JPanel {
    private Chessboard board;
    
    public Paint() {
        super.setBackground(Color.GREEN);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(350, 100, 367, 367);
        graphics.setColor(Color.BLACK);  
        graphics.fillRect(396, 100, 1, 367);   
        graphics.fillRect(442, 100, 1, 367); 
        graphics.fillRect(488, 100, 1, 367); 
        graphics.fillRect(534, 100, 1, 367); 
        graphics.fillRect(580, 100, 1, 367);    
        graphics.fillRect(626, 100, 1, 367);   
        graphics.fillRect(672, 100, 1, 367);   
        graphics.fillRect(350, 146, 367, 1); 
        graphics.fillRect(350, 192, 367, 1);
        graphics.fillRect(350, 238, 367, 1);
        graphics.fillRect(350, 284, 367, 1);
        graphics.fillRect(350, 330, 367, 1);
        graphics.fillRect(350, 376, 367, 1);
        graphics.fillRect(350, 422, 367, 1);
        
    }
                           
    
}
