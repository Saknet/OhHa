
package chess.domain;

/**
 * kaikkien nappuloiden siirrot
 */
public class Moves {
    private Checks checks;
    
    public Moves() {
        this.checks = new Checks();
    }
    
    /**
     * siirtää kuningasta
     * @param locations omien nappuloiden sijannit
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatti
     * @return palauttaa true jos siirton on mahdollinen
     */
    public boolean moveKing(int[]locations, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && checks.empty(locations, x, y) == true) {
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
     * @param blacks mustien nappuloiden sijannit
     * @param whites valkoisten nappuloiden sijannit
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatti
     * @return palauttaa true jos siirton on mahdollinen
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
        if (checks.empty(whites, x, y) == false && sy + 1 == y && (sx - 1 == x || sx + 1 == x)) {
            return true;
        }        
        return false;
    }
    
    /**
     * valkoisen sotilan siirrot
     * @param whites valkoisten nappuloiden sijannit
     * @param blacks mustien nappuloiden sijannit
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatti
     * @return palauttaa true jos siirton on mahdollinen
     */ 
    public boolean moveWhitePawn(int[]whites, int[]blacks, int sx, int sy, int x, int y) {
        if (x == sx && checks.empty(whites, x, y) == true) {
            if (sy == 6 && y == 4) {
                return true;
            }
            if (x >= 0 && sy - 1 == y) {
                return true;
            }
        }
        if (checks.empty(blacks, x, y) == false && sy - 1 == y && (sx - 1 == x || sx + 1 == x)) {
            return true;
        }        
        return false;
    }
    
    /**
     * ratsun siirrot
     * @param locations omien nappuloiden sijannit
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatti
     * @return palauttaa true jos siirton on mahdollinen
     */     
    public boolean moveKnight(int[]locations, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && y < 8 && checks.empty(locations, x, y) == true) {
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
     * @param locations omien nappuloiden sijannit
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatti
     * @return palauttaa true jos siirton on mahdollinen
     */ 
    public boolean moveRook(int[][]board, int[]locations, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && y < 8 && checks.empty(locations, x, y) == true) {
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
     * lähetin siirrot
     * @param locations omien nappuloiden sijannit
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatti
     * @return palauttaa true jos siirton on mahdollinen
     */ 
    public boolean moveBishop(int[][]board, int[]locations, int sx, int sy, int x, int y) {
        if (checks.onBoard(x, y) == true && y < 8 && checks.empty(locations, x, y) == true) {
            
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
     * kuningataren siirrot
     * @param locations omien nappuloiden sijannit
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatti
     * @return palauttaa true jos siirton on mahdollinen
     */ 
    public boolean moveQueen(int[][]board, int[]locations, int sx, int sy, int x, int y) {
        if (moveRook(board, locations, sx, sy, x, y) == true || moveBishop(board, locations, sx, sy, x, y) == true) {
            return true;
        }
        return false;
    }    
        
}
