package aics209;
import java.util.Scanner;
/**
 *
 * @author Lucas Villanueva
 */
public class AICS209 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Insert trial of array
        int player = 0;
        int boardx = 5, boardy = 6;
        int[][] board = new int[boardx][boardy];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j <board[i].length; j++){
                if(j == 0){
                    board[i][j] = 0;
                }
                else{
                    board[i][j] = i*10 + 8;
                }
                
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println("");
        }
        
        System.out.println("End of the line!");
        AICS209.printBoard(board);
        int location = 99;
        Scanner sc = new Scanner(System.in);
        while(location != 0){
            System.out.println("Show me what you've got");
            location = sc.nextInt();
            if(location <= boardx){
                player = AICS209.insertMove(location, player, boardx, boardy, board);
            }
        }
        
    }
    
    static public void printBoard(int[][] board){
        for(int i = board[0].length-1; i>=0; i--){ ////until 6
            for(int j = 0; j<board.length; j++){ //until 5
                System.out.print("["+ board[j][i] + "]");
            }
            System.out.println("");
        }
    }
    
    static public int insertMove(int location, int player, int boardx, int boardy, int[][] board){ //5
        ++player;
        if(board[location-1][0]>=boardy-1){
            System.out.println("Location is already full " + board[location][0]);
            --player;
        }
        else{
            board[location-1][board[location-1][0]+1] = player;
            board[location-1][0]++;
        }
        
        
        printBoard(board);
        return player%2;
        
    }
    
}
