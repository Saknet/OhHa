
package chess;

/**
 * kaikki mustien nappuloiden siirrot
 */
public class MovesBlack {
    private Checks checks;
    
    public MovesBlack() {
        this.checks = new Checks();
    }
    
    /**
     * siirtää mustaa kuningasta
     */
    public boolean moveBlackKing(int[]blacks, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && y < 8 && checks.empty(blacks, x, y) == true) {
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
    
    /**
     * mustan sotilan siirrot
     */
    public boolean moveBlackPawn(int[]blacks, int[]whites, int sx, int sy, int x, int y) {
        if (x == sx && checks.empty(blacks, x, y) == true) {        
            if (sy == 1 && y == 3) {
                return true;
            }
            if (x < 8 && sy + 1 == y) {
                return true;
            }
        }
        if (checks.checkWhite(whites, x, y) == true && sy + 1 == y && (sx - 1 == x || sx + 1 == x)) {
            return true;
        }        
        return false;
    }
    
    /**
     * musta ratsun siirrot
     */ 
    public boolean moveBlackKnight(int[]blacks, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && y < 8 && checks.empty(blacks, x, y) == true) {
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
    
    /**
     * mustan tornin siirrot
     */ 
    public boolean moveBlackRook(int[][] board, int[] blacks, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && y < 8 && checks.empty(blacks, x, y) == true) {
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
    
    /**
     * musta lähetin siirrot
     */ 
    public boolean moveBlackBishop(int[][]board, int[]blacks, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && y < 8 && checks.empty(blacks, x, y) == true) {
            
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
     
    /**
     * mustan kuningataren siirrot
     */ 
    public boolean moveBlackQueen(int[][]board, int[]blacks, int sx, int sy, int x, int y) {
        if (moveBlackRook(board, blacks, sx, sy, x, y) == true || moveBlackBishop(board, blacks, sx, sy, x, y) == true) {
            return true;
        }
        return false;
    }    
        
}
