import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    // Task 1: Create an array with three rows of '_' characters.
    char[][] playGround = new char[3][3];
    for (int i = 0; i < playGround.length; i++) {
      for (int j = 0; j < playGround[i].length; j++) {
        playGround[i][j] = '_';
      }
    }

    // Task 2: Call the function printBoard();
    mainGame(playGround);

    /*
     * { Task 3: Loop through turns.
     * 
     * if (X) turn {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value.
     * } else {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value. Then, print it.
     * 
     * }
     * 
     * Task 6 - Call the function.
     * if return value == 3 {
     * print: X wins and break the loop
     * } else if return value == -3 {
     * print: O wins and break the loop
     * }
     * 
     * }
     */

    scan.close();
  }

  private static void mainGame(char[][] playGround) {
    printBoard(playGround);

    for (int i = 0; i < 9; i++) {
      System.out.println("\n\t     --------\n\t      TURN: " + i + "\n\t     --------");
      if (i % 2 == 0) {
        char turn = 'x';
        askUser(playGround, turn);
        // X's turn
      } else if (i % 2 == 1) {
        char turn = 'o';
        askUser(playGround, turn);

        // O's turn
      }
    }
  }

  /**
   * Task 2 - Write a function that prints the board.
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   *              Inside the function:
   *              1. print a new line.
   *              2. print the board.
   *              • separate each row by two lines.
   *              • each row precedes a tab of space
   *              • each character in the grid has one space from the other
   *              character
   */
  public static void printBoard(char[][] playGround) {
    for (int i = 0; i < playGround.length; i++) {
      System.out.println("\n");
      for (int j = 0; j < playGround.length; j++) {
        System.out.print("\t" + playGround[i][j] + " ");
      }
    }
  }

  /**
   * Task 4 - Write a function that lets the user choose a spot
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */

  public static int askUser(char[][] playGround, char turn) {
    if (turn == 'x') {
      System.out.println("----> Turn: 'x'");
    } else if (turn == 'o') {
      System.out.println("----> Turn: 'o'");
    }
    System.out.println("Pick a row and column number. E.g.(0, 1): ");
    int choosenSpotRow = scan.nextInt();
    int choosenSpotCol = scan.nextInt();

    if (choosenSpotCol > 2 || choosenSpotCol < 0 ||
        choosenSpotRow > 2 || choosenSpotRow < 0) {
      System.out.println("Type 0, 1 or 2 only...");
      askUser(playGround, turn);
    }

    for (int i = 0; i < playGround.length; i++) {

      // Once the chose spot for row is equal to 'i' aka: the current row then it
      // continues
      if (choosenSpotRow == i) {
        for (int j = 0; j < playGround[i].length; j++) {

          // Once the current element of row is equal to the chosen col then it continues
          if (choosenSpotCol == j) {
            System.out.println();
            if (playGround[i][j] == '_') {
              playGround[i][j] = turn;

              printBoard(playGround);

              // Checking if someone won or it is a tie
              checkWin(playGround, turn);

              // checkWinOrTie(playGround, turn);

              // Other way of checking win
              // int wonPointsHorizontal = wonDeciderHorizontal(playGround);
              // System.out.println("HORIZONT POINTS: " + wonPointsHorizontal);

              // if (wonPointsHorizontal == 3) {
              // System.out.println("\n\n --------'x' Won!--------\n");
              // replayOrEnd(playGround, turn);

              // }
              // else if (wonPointsHorizontal == -3){
              // System.out.println("\n\n --------'o2' Won!--------\n");
              // replayOrEnd(playGround, turn);
              // }

            } else {
              System.out.println("Occupied");
              System.out.println("Please choose an other field...");
              askUser(playGround, turn);
            }
          }
        }
      }
    }

    return 0;
  }

  private static void checkWin(char[][] playGround, char turn) {
    int count = 0;


    // These methods checks the winner by indexing
    checkHorizontal(playGround, turn, count);
    checkVertical(playGround, turn, count);
    checkDigonal_1(playGround, turn, count);
    checkDigonal_2(playGround, turn, count);

  }

  private static void checkHorizontal(char[][] playGround, char turn, int count) {
    for (int i = 0; i < playGround.length; i++) {
      for (int j = 0; j < playGround[i].length; j++) {
        if (playGround[i][j] == 'x') {
          count++;
        } else if (playGround[i][j] == 'o') {
          count--;
        }

        decideWon(playGround, turn, count);
      }
    }
  }

  private static void checkVertical(char[][] playGround, char turn, int count) {
    for (int i = 0; i < playGround.length; i++) {
      for (int j = 0; j < playGround[i].length; j++) {
        if (playGround[j][i] == 'x') {
          count++;
        } else if (playGround[j][i] == 'o') {
          count--;
        }

        decideWon(playGround, turn, count);
      }
    }
  }

  private static void checkDigonal_1(char[][] playGround, char turn, int count) {
    for (int i = 0; i < playGround.length; i++) {
      if (playGround[i][i] == 'x') {
        count++;
      } else if (playGround[i][i] == 'o') {
        count--;
      }

      decideWon(playGround, turn, count);
    }
  }

  private static void checkDigonal_2(char[][] playGround, char turn, int count) {
    for (int i = 0; i < playGround.length; i++) {
      if (playGround[i][(playGround.length - 1) - i] == 'x') {
        count++;
      } else if (playGround[i][playGround.length - i] == 'o') {
        count--;
      }
      decideWon(playGround, turn, count);
    }
  }

  private static void decideWon(char[][] playGround, char turn, int count) {
    if (count == 3) {
      System.out.println("\n\n     --------'x' Won!--------\n");
      replayOrEnd(playGround, turn);

    } else if (count == -3) {
      System.out.println("\n\n     --------'o' Won!--------\n");
      replayOrEnd(playGround, turn);
    }
  }



// OG Method for checking winner
  private static void checkWinOrTie(char[][] playGround, char turn) {
    if (playGround[0][0] == 'x' && playGround[0][1] == 'x' && playGround[0][2] == 'x' ||
        playGround[1][0] == 'x' && playGround[1][1] == 'x' && playGround[1][2] == 'x' ||
        playGround[2][0] == 'x' && playGround[2][1] == 'x' && playGround[2][2] == 'x' ||

        playGround[0][0] == 'x' && playGround[1][0] == 'x' && playGround[2][0] == 'x' ||
        playGround[0][1] == 'x' && playGround[1][1] == 'x' && playGround[2][1] == 'x' ||
        playGround[0][2] == 'x' && playGround[1][2] == 'x' && playGround[2][2] == 'x' ||

        playGround[0][0] == 'x' && playGround[1][1] == 'x' && playGround[2][2] == 'x' ||
        playGround[2][0] == 'x' && playGround[1][1] == 'x' && playGround[0][2] == 'x') {
      System.out.println("\n\n     --------'x' Won!--------\n");
      replayOrEnd(playGround, turn);
    }
    if (playGround[0][0] == 'o' && playGround[0][1] == 'o' && playGround[0][2] == 'o' ||
        playGround[1][0] == 'o' && playGround[1][1] == 'o' && playGround[1][2] == 'o' ||
        playGround[2][0] == 'o' && playGround[2][1] == 'o' && playGround[2][2] == 'o' ||

        playGround[0][0] == 'o' && playGround[1][0] == 'o' && playGround[2][0] == 'o' ||
        playGround[0][1] == 'o' && playGround[1][1] == 'o' && playGround[2][1] == 'o' ||
        playGround[0][2] == 'o' && playGround[1][2] == 'o' && playGround[2][2] == 'o' ||

        playGround[0][0] == 'o' && playGround[1][1] == 'o' && playGround[2][2] == 'o' ||
        playGround[2][0] == 'o' && playGround[1][1] == 'o' && playGround[0][2] == 'o') {
      System.out.println("\n\n     --------'o' Won!--------\n");
      replayOrEnd(playGround, turn);
    } else {
      checkTie(playGround);
    }
  }

  /**
   * Task 6 - Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */

  public static void replayOrEnd(char[][] playGround, char turn) {
    System.out.println("Would you like to play one more? ('y' or 'n')");
    String userAnswer = scan.nextLine();

    if (userAnswer.toLowerCase().equals("y")) {
      clearBoard(playGround);
      mainGame(playGround);
    } else if (userAnswer.equals("n")) {
      System.exit(0);
    } else {
      replayOrEnd(playGround, turn);
      userAnswer = scan.nextLine();
    }
  }

  public static void clearBoard(char[][] playGround) {
    for (int i = 0; i < playGround.length; i++) {
      for (int j = 0; j < playGround[i].length; j++) {
        playGround[i][j] = '_';
      }
    }
    printBoard(playGround);
  }

  public static void checkTie(char[][] playGround) {
    int fullCounter = 0;
    for (int i = 0; i < playGround.length; i++) {
      for (int j = 0; j < playGround[i].length; j++) {
        if (playGround[i][j] != '_') {
          fullCounter++;
        }
      }
    }
    if (fullCounter == 9) {
      System.out.println("\n\n\t  It is a Tie!");
    }

  }

}
