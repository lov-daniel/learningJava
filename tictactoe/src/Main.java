
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var turnPlayer = 1;
        var keyboard = new Scanner(System.in);
        var numberOfTurns = 0;

        ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
        var board = new String[17];

        var loopCount = 1;
        for (int i = 0; i < board.length; i++) {
            if (loopCount % 2 == 1) {
                board[i] = String.valueOf(((i / 2) + 1));
            } else {
                board[i] = "|";
            }
            loopCount += 1;
        }

        while (numberOfTurns < 9) {
            printBoard(board, turnPlayer);
            System.out.println("Choose a spot!");
            var chosenSpot = keyboard.nextInt();
            var validCheck = checkUsage(chosenSpot, usedNumbers);
            if (validCheck == true) {
                switch (chosenSpot) {
                    case 1 -> {
                        if (turnPlayer == 1) {
                            board[0] = "x";
                        } else {
                            board[0] = "o";
                        }
                    }

                    case 2 -> {
                        if (turnPlayer == 1) {
                            board[2] = "x";
                        } else {
                            board[2] = "o";
                        }
                    }

                    case 3 -> {
                        if (turnPlayer == 1) {
                            board[4] = "x";
                        } else {
                            board[4] = "o";
                        }
                    }

                    case 4 -> {
                        if (turnPlayer == 1) {
                            board[6] = "x";
                        } else {
                            board[6] = "o";
                        }
                    }

                    case 5 -> {
                        if (turnPlayer == 1) {
                            board[8] = "x";
                        } else {
                            board[8] = "o";
                        }
                    }

                    case 6 -> {
                        if (turnPlayer == 1) {
                            board[10] = "x";
                        } else {
                            board[10] = "o";
                        }
                    }

                    case 7 -> {
                        if (turnPlayer == 1) {
                            board[12] = "x";
                        } else {
                            board[12] = "o";
                        }
                    }

                    case 8 -> {
                        if (turnPlayer == 1) {
                            board[14] = "x";
                        } else {
                            board[14] = "o";
                        }
                    }

                    case 9 -> {
                        if (turnPlayer == 1) {
                            board[16] = "x";
                        } else {
                            board[16] = "o";
                        }
                    }
                }
            } else {
                System.out.println("");
                System.out.println("Please choose a valid spot.");
                continue;
            }

            if (checkGameState(board) == true) {
                numberOfTurns = 9;
                System.out.println("Player " + turnPlayer + " won!");
                printBoard(board, turnPlayer);
                continue;
            } else {
                numberOfTurns += 1;
            }

            turnPlayer += 1;

            if (turnPlayer > 2) {
                turnPlayer = 1;
            }
            usedNumbers.add(chosenSpot);
        }
    }

    public static void printBoard(String[] board, int turnPlayer) {
        System.out.println("Player " + turnPlayer);
        System.out.println("---------");

        for (int i = 0; i <= 4; i++) {
            System.out.print(board[i] + " ");
        }

        System.out.println();
        System.out.println("---------");

        for (int i = 6; i <= 10; i++) {
            System.out.print(board[i] + " ");
        }

        System.out.println();
        System.out.println("---------");

        for (int i = 12; i <= 16; i++) {
            System.out.print(board[i] + " ");
        }
        System.out.println();
        System.out.println("---------");
    }

    public static boolean checkUsage(int num, ArrayList<Integer> usedNumbers) {


        System.out.println(usedNumbers.size());
        for (int i = 0; i < usedNumbers.size(); i++) {
            if (usedNumbers.get(i) == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkGameState(String[] board) {

        if (

            //Horizontal Wins
                (board[0] == board[2] && board[2] == board[4]) ||
                        (board[6] == board[8] && board[8] == board[10]) ||
                        (board[12] == board[14] && board[14] == board[16]) ||

                        //Vertical Wins
                        (board[0] == board[6] && board[6] == board[12]) ||
                        (board[2] == board[8] && board[8] == board[14]) ||
                        (board[4] == board[10] && board[10] == board[16]) ||

                        //Diagonal Wins
                        (board[0] == board[8] && board[8] == board[16]) ||
                        (board[4] == board[8] && board[8] == board[12])

        ) {
            return true;

        }

        return false;
    }
}
