
package chess.domain;

import java.io.*;
import java.util.Scanner;

/** 
 * tämä luokka saattaa poistua kokonaan jos aika ei riitä, tarkoitus olisi tänne 
 * tehdä siirron peruutus ja pelitilanteen talletus mutta vasta kun kaikki muu 
 * on valmista
 */ 
public class Menu {
    
    
    public Menu() {

    }    
 
   /** 
    * ehkä pois nämä jos ei aika riitä
    */  

    
    public void save(int[][] board, int turns, int info) throws  IOException {      
        FileWriter writer = new FileWriter("src/images/savedgame.txt");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                writer.write(board[i][j]+" ");
            }
        }
        writer.close();
        saveTurns(turns);
        saveInfo(info);
    }
    
    public void saveTurns(int turns) throws IOException {
        FileWriter writer = new FileWriter("src/images/turns.txt");
        writer.write(turns+"");
        writer.close();
    }
    
    public int loadTurns() throws FileNotFoundException {
        int turns = 0;
        File file = new File("src/images/turns.txt");
        Scanner scanner = new Scanner(file);  
        while (scanner.hasNext()) {
            String text = scanner.next();
            turns = Integer.parseInt(text); 
        }
        scanner.close();
        return turns;
    }
    
    public void saveInfo(int info) throws IOException {
        FileWriter writer = new FileWriter("src/images/info.txt");
        writer.write(info+"");
        writer.close();
    }
    
    public int loadInfo() throws FileNotFoundException {
        int info = 0;
        File file = new File("src/images/info.txt");
        Scanner scanner = new Scanner(file);  
        while (scanner.hasNext()) {
            String text = scanner.next();
            info = Integer.parseInt(text); 
        }
        scanner.close();
        return info;
    }    
    
    public int[][] load() throws FileNotFoundException {
        int[][] board = new int[8][8];
        File file = new File("src/images/savedgame.txt");
        Scanner scanner = new Scanner(file);
        int i = 0;
        int j = 0;
        while (scanner.hasNext()) {
            if (j == 8) {
                i++;
                j = 0;
            }
            String text = scanner.next();
            int number = Integer.parseInt(text); 
            board[i][j] = number;
            j++;            
        }
        scanner.close();
        System.out.println(board[4][6]);
        return board;
    }
}
