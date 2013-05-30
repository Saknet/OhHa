
package chess.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/** 
 * graafinen käyttöliittymä, ei toimi mikään, kesken pahasti
 * ainostaan exit nappi toimii
 */ 

public class Interface  {
    private JFrame frame;
    private Paint paint;      
    private JButton start;
    private JButton exit;
    private JButton giveUp;
    private Container container;


    public void run() {
        frame = new JFrame("Chess"); 
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        createComponents(frame.getContentPane());  
        frame.pack();
        frame.setVisible(true);        

    }
    
    /** 
     * teen oman luokka nappien yms muokkaukseen seuravaan deadlineen..
     */     
    private void createComponents(Container container) {
        this.paint = new Paint();       
        start = new JButton("Start new game"); 
        start.setLocation(50, 50);
        start.setSize(150, 50);
        start.setFont(new Font("Serif", Font.BOLD, 12));
        container.add(start);
        giveUp = new JButton("Give up");
        giveUp.setLocation(50, 150);
        giveUp.setSize(150, 50);
        giveUp.setFont(new Font("Serif", Font.BOLD, 12));    
        container.add(giveUp);
        exit = new JButton("Exit");        
        exit.setLocation(50, 250);
        exit.setSize(150, 50);
        exit.setFont(new Font("Serif", Font.BOLD, 12)); 
        container.add(exit);
        exit.addActionListener(new Actions());        
        
        JLabel startx = new JLabel("start X: ");
        startx.setLocation(25, 350);
        startx.setSize(70, 50);  
        
        JTextField startxField = new JTextField();
        startxField.setLocation(100, 350);  
        startxField.setSize(50, 40);
        
        JLabel starty = new JLabel("start Y: ");
        starty.setLocation(25, 400);
        starty.setSize(70, 50); 
        
        JTextField startyField = new JTextField();
        startyField.setLocation(100, 400);        
        startyField.setSize(50, 40); 
        
        JLabel endx = new JLabel("end X: ");
        endx.setLocation(175, 350);
        endx.setSize(70, 50);  
        
        JTextField endxField = new JTextField();
        endxField.setLocation(250, 350);  
        endxField.setSize(50, 40);   
        
        JLabel endy = new JLabel("end Y: ");
        endy.setLocation(175, 400);
        endy.setSize(70, 50);  
        
        JTextField endyField = new JTextField(); 
        endyField.setLocation(250, 400);  
        endyField.setSize(50, 40); 
        
        JButton moves = new JButton("Move piece");
        moves.setLocation(200, 450);
        moves.setSize(100, 50);        
        
        container.add(startx);
        container.add(startxField);
        container.add(starty);
        container.add(startyField);
        container.add(endx);
        container.add(endxField);
        container.add(endy);
        container.add(endyField);        
        container.add(moves);        

        container.add(paint);         
            
    }
    
}
