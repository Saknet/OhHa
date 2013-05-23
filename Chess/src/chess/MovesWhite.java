
package chess;

//kaikki valkoisten nappuloiden siirrot
public class MovesWhite {
    private Checks checks;
    
    public MovesWhite() {
        this.checks = new Checks();
    }
    // siirtää valkoista kuningasta
    public boolean moveWhiteKing(int[]whites, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && y < 8 && checks.empty(whites, x, y) == true) {
            if (sx - 1 == x && sy - 1 == y) {
                return true;
            }
            if (sx == x && sy - 1 == y) {
                return true;
            }
            if (sx + 1 == x && sy - 1 == y) {
                return true;
            }
            if (sx - 1 == x && sy == y) {
                return true;
            }
            if (sx + 1 == x && sy == y) {
                return true;
            }
            if (sx - 1 == x && sy + 1 == y) {
                return true;
            }
            if (sx == x && sy + 1 == y) {
                return true;
            }
            if (sx + 1 == x && sy + 1 == y) {
                return true;
            } 
        }
        return false;
        
    }
    
       
    //valkoisen sotilan siirrot    
    public boolean moveWhitePawn(int[]whites, int[]blacks, int sx, int sy, int x, int y) {
        if (x == sx && checks.empty(whites, x, y) == true) {
            if (sy == 6 && y == 4) {
                return true;
            }
            if (x >= 0 && sy - 1 == y) {
                return true;
            }
        }
        if (checks.checkBlack(blacks, x, y) == true && sy - 1 == y && (sx - 1 == x || sx + 1 == x)) {
            return true;
        }        
        return false;
    } 
 
    //valkoisen ratsun siirrot
    public boolean moveWhiteKnight(int[]whites, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && checks.empty(whites, x, y) == true) {
            if (sx - 1 == x && sy - 2 == y) {
                return true;
            }
            if (sx - 2 == x && sy - 1 == y) {
                return true;
            }           
            if (sx + 1 == x && sy - 2 == y) {
                return true;
            }
            if (sx + 2 == x && sy - 1 == y) {
                return true;
            }
            if (sx - 1 == x && sy + 2 == y) {
                return true;
            }
            if (sx - 2 == x && sy + 1 == y) {
                return true;
            }
            if (sx + 1 == x && sy + 2 == y) {
                return true;
            }
            if (sx + 2 == x && sy + 1 == y) {
                return true;
            }
            
        }
        return false;
    }
    //valkoisen tornin siirrot
    public boolean moveWhiteRook(int[][] board, int[] whites, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && checks.empty(whites, x, y) == true) {
            if (sx == x) {
                if (sy < y) {
                    for (int i = sy + 1; i < y; i++) {
                        if (board[i][sx] != 0) {
                            return false;
                        }
                    }  
                    return true;
                } else {
                    for (int i = sy - 1; i > y; i--) {
                        if (board[i][sx] != 0) {
                            return false;
                        }
                    }
                    return true;
                }            
            }
            if (sy == y) {
                if (sx < x) {
                    for (int i = sx + 1; i < x; i++) {
                        if (board[sy][i] != 0) {
                            return false;
                        }
                    }  
                    return true;
                } else {
                    for (int i = sx - 1; i > x; i--) {
                        if (board[sy][i] != 0) {
                            return false;
                        }
                    }
                    return true;
                }                        
            }
        }
        return false;
    }
    
    //valkoisen kuningataren siirrot    
    public boolean moveWhiteQueen(int[][]board, int[]whites, int sx, int sy, int x, int y) {
        if (moveWhiteRook(board, whites, sx, sy, x, y) == true || moveWhiteBishop(board, whites, sx, sy, x, y) == true) {
            return true;
        }
        return false;
    }
    //valkoisen lähetin siirrot
    public boolean moveWhiteBishop(int[][]board, int[]whites, int sx, int sy, int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && checks.empty(whites, x, y) == true) {
            
            if (sx > x && sy > y) {
                for (int i = sx - 1; i > x; i--) {
                    if (board[y + i][x + i] != 0) {
                        return false;
                    }
                }
                return true;
            }
            if (sx > x && sy < y) {
                for (int i = sx - 1; i > x; i--) {
                    if (board[y - i][x + i] != 0) {
                        return false;
                    }
                }
                return true;                
                
            }              
            if (sx < x && sy > y) {
                int k = 0;                
                for (int i = sx + 1; i < x; i++) {
                    if (board[sy - k][i] != 0) {
                        return false;
                    }
                }
                return true;                                
            }
            if (sx < x && sy < y) {
                int k = 0;
                for (int i = sx + 1; i < x; i++) {
                    k++;
                    if (board[sy + k][i] != 0) {
                        return false;
                    }
                }
                return true;      
            }             
        }         
        return false;
    }               
        
    
}
