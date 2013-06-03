
package chess.gui;


import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class modifyComponent {
    
    
    public void modifyJButton(JButton button, int xLocation, int yLocation, int xSize, int ySize, int fontsize, Container container) {
        button.setLocation(xLocation, yLocation);
        button.setSize(xSize, ySize);
        button.setFont(new Font("Serif", Font.BOLD, fontsize));
        container.add(button);
    }   
    
    public void modifyJLabel(JLabel label, int xLocation, int yLocation, int xSize, int ySize, int fontsize, Container container) {
        label.setLocation(xLocation, yLocation);
        label.setSize(xSize, ySize);
        label.setFont(new Font("Serif", Font.BOLD, fontsize));
        container.add(label);
    }

    public void modifyJTextField(JTextField field, int xLocation, int yLocation, int xSize, int ySize, int fontsize, Container container) {
        field.setLocation(xLocation, yLocation);
        field.setSize(xSize, ySize);
        field.setFont(new Font("Serif", Font.BOLD, fontsize));
        container.add(field);
    }    
    
}
