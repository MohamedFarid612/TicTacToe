package MOHAMED_ADEL;

public class Game {
//private in order to obligate user to use the methods
//added 4 rows and 4 columns 2 on each side to help in winning condition 6+2+2 // 7+2+2
    private char [][] board=new char[10][11];

    public Game() {
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <11 ; j++) {
                board[i][j]=' ';
            }
        }
    }
    //sets x in a certain square
    public void setElementX(int row,int column){board[row][column]='X';}
    //sets o in a certain square
    public void setElementO(int row,int column){board[row][column]='O';}
    //checks the condition of winning
    public boolean isWon(int row, int column){
// checks right horizontal
if((board[row][column]=='X' && board[row][column+1]=='X' &&board[row][column+2]=='X')||(board[row][column]=='O' && board[row][column+1]=='O'&&board[row][column+2]=='O')) return true;
//checks left horizontal
else if((board[row][column]=='X' && board[row][column-1]=='X'&&board[row][column-2]=='X')||(board[row][column]=='O' && board[row][column-1]=='O'&&board[row][column-2]=='O')) return true;
//checks up
else if((board[row][column]=='X' && board[row+1][column]=='X'&&board[row+2][column]=='X')||(board[row][column]=='O' && board[row+1][column]=='O'&&board[row+2][column]=='O')) return true;
//checks down
 else if((board[row][column]=='X' && board[row-1][column]=='X'&&board[row-2][column]=='X')||(board[row][column]=='O' && board[row-1][column]=='O'&&board[row-2][column]=='O')) return true;
//checks right up diagonal
 else if((board[row][column]=='X' && board[row-1][column+1]=='X'&&board[row-2][column+2]=='X')||(board[row][column]=='O' && board[row-1][column+1]=='O'&&board[row-2][column+2]=='O')) return true;
//checks left up diagonal
 else if((board[row][column]=='X' && board[row-1][column-1]=='X'&&board[row-2][column-2]=='X')||(board[row][column]=='O' && board[row-1][column-1]=='O'&&board[row-2][column-2]=='O')) return true;
//checks left down diagonal
else if((board[row][column]=='X' && board[row+1][column-1]=='X'&&board[row+2][column-2]=='X')||(board[row][column]=='O' && board[row+1][column-1]=='O'&&board[row+2][column-2]=='O')) return true;
//checks right down diagonal;
else if((board[row][column]=='X' && board[row+1][column+1]=='X'&&board[row+2][column+2]=='X')||(board[row][column]=='O' && board[row+1][column+1]=='O'&&board[row+2][column+2]=='O')) return true;
// checks right left
else if((board[row][column]=='X' && board[row][column+1]=='X' &&board[row][column-1]=='X')||(board[row][column]=='O' && board[row][column+1]=='O'&&board[row][column-1]=='O'))return true;
//checks up down
else if((board[row][column]=='X' && board[row+1][column]=='X' &&board[row-1][column]=='X')||(board[row][column]=='O' && board[row+1][column]=='O'&&board[row-1][column]=='O'))return true;
//checks right diagonal
else if((board[row][column]=='X' && board[row-1][column+1]=='X' &&board[row+1][column-1]=='X')||(board[row][column]=='O' && board[row-1][column+1]=='O'&&board[row+1][column-1]=='O'))return true;
//checks left diagonal
else if((board[row][column]=='X' && board[row-1][column-1]=='X' &&board[row+1][column+1]=='X')||(board[row][column]=='O' && board[row-1][column-1]=='O'&&board[row+1][column+1]=='O'))return true;
//if is not won yet
        else return false;

    }
    //checks if the game ended with a draw
    public boolean  isDraw(int count, int row ,int  column){
        if (count==42 && isWon(row,column)==false) return true;
        else return false;
    }
    //checks if the selected square already used or not
    public boolean isOccupied(int row,int column){
        if( board[row][column]=='X' ||board[row][column]=='O') return true;
        else  return false;
    }
    //prints the board in an easy way for the eye ,each element in a cell
    public  void  printBoard(){
        System.out.println("-----------------------------");
        for (int i = 2; i <8 ; i++) {
            for (int j = 2; j <9 ; j++) {

                System.out.print("| "+board[i][j]+" ");
                if (j == 8) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.println("-----------------------------");
        }




    }

}
