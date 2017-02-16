package board;

/**
 *
 * @author Sphere
 */
public class Board {
    int[][] board;
    int xsize, ysize;
    
    public Board(int xsize,int ysize){
        this.xsize = xsize;
        this.ysize = ysize+1;
        
        board = new int[xsize][this.ysize];
    }
    
    public void printBoard(){
        for(int i = board[0].length-1; i>=0; i--){ ////until 6
            for(int j = 0; j<board.length; j++){ //until 5
                System.out.print("["+ board[j][i] + "]");
            }
            System.out.println("");
        }
    }
    
    public int insertMove(int location, int player) throws ArrayIndexOutOfBoundsException{ 
        ++player;
        int valid = isValid(location);
        if(valid == -1) {
            System.out.println("Input out of game size");
            player--;
        } 
        else if(valid == 1) {
            System.out.println("Location is already full");
            player--;
        }
        
        else{
            board[location-1][board[location-1][0]+1] = player;
            board[location-1][0]++;
        }
        
        
        printBoard();
        return player%2;   
    }
    
    public int isValid(int location){
        if(location >xsize) return -1;
        else if(board[location-1][0] >= ysize-1) return 1;
        else
            return 0;
    }
    
    public void gameMaster(){
        for(int i = 0; i<xsize-1; i++){
            inloop:
            for(int j=1; j<ysize-1; j++){
                //skip checks
                if(board[i][j] == 0)continue inloop;
                //x check
                if(j<xsize-3 && board[i][0] >= 4){
                    if(board[i][j] == board[i][j+3]){
                        if(board[i][j+1] == board[i][j] && board[i][j]== board[i][j+2]){
                            System.out.println("On board x=" + i + "y=" +j + " on y route");
                            System.out.println("Player " + board[i][j] + " has won!\nExitting...");
                            System.exit(0);
                        }
                    }
                }
                
                //ycheck
                if(i < ysize-4){
                    if(board[i][j] == board[i+3][j])
                    {
                        if(board[i+1][j]== board[i][j] &&  board[i+2][j] == board[i][j]){
                            System.out.println("On board x=" + i + "y=" +j + " x route");
                            System.out.println("Player " + board[i][j] + " has won!\nExitting...");
                            System.exit(0);
                        }
                    }
                }
                
                //lech check
                ///rech check
            }
        }
    }
}


