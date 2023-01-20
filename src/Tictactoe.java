/**
 * Tictactoe game
 * @author george
 *
 */
public class Tictactoe {
    private String[][] board;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private String regex = "\\s{3}";

    private int x = 1;
    private int o = -1;
    private int tie = 0;
    private int scores[] = {x, o, tie};

    private String empty = "   ";
    /**
     * Tictactoe constructor
     */
    public Tictactoe() {
        board = new String[ROWS][COLUMNS];
        this.initializeBoard();
//      this.winXtest();
    }

    /**
     * initializing board and fill with empty spaces
     */
    public void initializeBoard() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                board[i][j] = empty;
            }
        }
    }

    /**
     * setPlay method will set player's move
     * @param i
     * @param j
     * @param player
     */
    public void setPlay(int i, int j, String player) {
        if(board[i][j].matches(regex))
            board[i][j] = " "+player+" ";
    }

    /**
     * finding winners
     */
    public boolean checkWin() {
        //String winner = "";
        for(int i = 0; i < ROWS; i++) {
            if(!board[i][0].matches(regex) && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                //winner = board[i][0];
				return true;
            }
        }
        //checking columns

        for(int i = 0; i < COLUMNS; i++) {
            if(!board[0][i].matches(regex) && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]))
			//winner = board[0][i];
			return true;
        }
        //checking diagonals
        if(!board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
			//winner = board[0][0];
			return true;
        if(!board[0][2].matches(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])){
			//winner = board[2][0];
			return true;
		}
		return false;
	}
	
        //no body's won
		// int openSpots = 0;
		// for (int i = 0; i < 3; i++) {
		//   for (int j = 0; j < 3; j++) {
		// 	if (board[i][j] == empty) {
		// 	  openSpots++;
		// 	}
		//   }
		// }

		// if (winner == "" && openSpots == 0) {
		// 	return 0; // Tie
		//   } else if(winner == " X " && openSpots == 0){
		// 	  return 10; // X Wins
		//   }else{
		// 	return -10; // O Wins
		//   }
			
		
	

    /**
     * Print board to screen
     * @return strBoard
     */
    public String printBoard() {
        String strBoard = "";
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                if(j == COLUMNS-1)
                    strBoard += board[i][j];
                else
                    strBoard += board[i][j] + "|";
            }
            if(i != ROWS-1)
                strBoard += "\n---+---+---\n";
        }
        return strBoard;
    }

    /**
     * test unit 1st column X
     */
    public void winOtest() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                if(j == 0)
                    board[i][j] = " O ";
                else
                    board[i][j] = empty;
            }
        }
    }

	// public boolean gameStatus(){
	// 	if(checkWin() == 10 || checkWin() == -10){
	// 		return true;
	// 	}
	// 	else{
	// 		return false;
	// 	}
	// }

	public boolean isDraw(){
		for ( int i = 0; i < 3; i++){ // Check all spaces on the board
         	for ( int j = 0; j < 3; j++){
				if(board[i][j].equals(empty)){
					return false;
			}
		}
	}	
	return true;
}




// AI CODE:


    public void bestMove(){
        int bestScore = Integer.MIN_VALUE;
        int bestMoveI = 0;
        int bestMoveJ = 0;
        int i = 0;
        int j = 0;
        for ( i = 0; i < 3; i++){ // Check all spaces on the board
            for ( j = 0; j < 3; j++){
                if (board[i][j].equals(empty)){ //Is the spot available?
                    board[i][j] = "X"; //Take the spot with x
                    int score = minimax(board, 0, false ); //Give the spot a score
                    board[i][j] = empty; //Remove x from the spot
                    if (score > bestScore){
                        bestScore = score;
                        bestMoveI = i;
                        bestMoveJ = j;
                    }
                }
            }
        }
        setPlay(bestMoveI, bestMoveJ, "X");

        //board[bestMove[0]][bestMove[1]] = x;
    }




    public int minimax(String board[][], int depth, boolean isMaximizing){
        // boolean result = checkWin();
		// if(result = false){
		// 	return scores[result];
		// }

		if(checkWin()){
			if(isMaximizing){
				return -1;
			}
			else{
				return 1;
			}
		}

		if(isDraw()){
			return 0;
		}


        if(isMaximizing){
            int bestScore = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if (board[i][j] == empty){ //Is the spot available?
                        board[i][j] = "X"; //Take the spot with x
                        int score = minimax(board, depth + 1, false ); //Give the spot a score
                        board[i][j] = empty; //Remove x from the spot
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if (board[i][j] == empty){ //Is the spot available?
                        board[i][j] = " O "; //Take the spot with O
                        int score = minimax(board, depth + 1, true); //Give the spot a score
                        board[i][j] = empty; //Remove o from the spot
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}