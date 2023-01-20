import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tictactoe game = new Tictactoe();
        String player = "O";
        //String ai = "X";
        String choice1;
        System.out.println("Would you like to play an AI or a Human?");
        choice1 = input.nextLine();
        //boolean sentinel = true;
        while(true) {
            if(choice1.equalsIgnoreCase("Human")){
                System.out.println("You have chose to play the Human.");
                System.out.println(game.printBoard());
                System.out.println("enter row for " + player + " or -1 to exit: ");
                int row = input.nextInt();
                if(row == -1)
                    break;
                System.out.println("enter column for " + player + ": ");
                int column = input.nextInt();
                game.setPlay(row,  column, player);
                if(game.checkWin()) {
                    System.out.println(game.printBoard() + "\n" + player +" wins!");
                    break;
                }
                if(player == "O") {
                    player = "X";
                }
                else {
                    player = "O";
                }
            }else if(choice1.equalsIgnoreCase("AI")){
                System.out.println("AI's turn:");
                game.bestMove();
                System.out.println(game.printBoard());
                if(game.checkWin()) {
                    System.out.println(game.printBoard() + "\nAI wins!");
                    break;
                }
                player = "O";
                System.out.println("Your turn:");
                System.out.println("enter row for " + player + " or -1 to exit: ");
                int row = input.nextInt();
                if(row == -1)
                    break;
                System.out.println("enter column for " + player + ": ");
                int column = input.nextInt();
                game.setPlay(row,  column, player);
                if(game.checkWin()) {
                    System.out.println(game.printBoard() + "\n" + player +" wins!");
                }
            }

        }
    }
}