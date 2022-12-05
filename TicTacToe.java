import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char [][] character = {{'_','_','_'},{'_','_','_'},{'_','_','_'},};
            //print the board
            printBoard(character);
            // player's turn
             for (int i = 0; i < 9; i++) {

                if (i % 2 == 0) {
                  System.out.println("Turn : X");
                  int[] spot = askUser(character); // user input function 
                  character[spot[0]][spot[1]] = 'X'; // spot[0] and spot[1] are from user's input in the array {0,0}
                } else {
                  System.out.println("Turn : O");
                  int[] spot = askUser(character);
                  character[spot[0]][spot[1]] = 'O';
                }
                printBoard(character);
                int count = checkWin(character);
                if (count == 3) {
                  System.out.println("X Win!");
                  break;
                } else if (count == -3) {
                  System.out.println("O Win!");
                  break;
                } if (i == 8) {
                  System.out.println("It's a tie");
                  break;
                }
                
             }
              
            scan.close();
        }

        //functions
        //printBoard function
        public static void printBoard (char[][] board) {
          for (int i = 0; i < board.length ; i++) {
            System.out.print("\t"); 

            for (int j = 0; j < board[i].length; j++) {
              System.out.print(board[i][j] + " ");
            }
            System.out.println(""); 

          }
        }
        // user input function
     public static int[] askUser (char[][] character) {
        System.out.print(" pick a row and column number: ");
        int row = scan.nextInt();
        int column = scan.nextInt();
        while (character[row][column] != '_') {
          System.out.print("Spot taken, try again: ");
          row = scan.nextInt();
          column = scan.nextInt();
        }
        return new int[] {row,column};
     }
      //check logic and who's the winner function
     public static int checkWin(char[][] board) {
      int count = 0;
      // this is for checking row 
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 'X') {
            count++;
          } else if (board[i][j] == 'O') {
            count--;
          }
        }
        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0;
        }
      // this is for checking column 

        for (int k = 0; k < board[i].length; k++) {
          if (board[k][i] == 'X') {
            count++;
          } else if (board[k][i] == 'O') {
            count--;
          }
        }

        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0;
        }

        // Checking the left diagonal
        for (int l = 0; l < board[i].length; l++) {
          if (board[l][l] == 'X') {
            count++;
          } else if (board[l][l] == 'O') {
            count--;
          }
        }

        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0;
        }
        // Checking the right diagonal
        for (int m = 0; m < board[i].length; m++) {
          if (board[2-m][m] == 'X') {
            count++;
          } else if (board[2-m][m] == 'O') {
            count--;
          }
        }
        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0;
        }
      }
      return count;
    }
  }
