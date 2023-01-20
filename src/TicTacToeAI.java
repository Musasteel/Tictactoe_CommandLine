// //Code Inspired by: https://www.youtube.com/watch?v=trKjYdBASyQ&t=619s

// public class TicTacToeAI {

//     Tictactoe move = new Tictactoe();
//     char board[][] = new char[3][3];

//     char X;
//     int x = 10;
//     int o = -10;
//     int tie = 0;
//     int scores[] = {x, o, tie};


//     public void bestMove(){
//         int bestScore = Integer.MIN_VALUE; 
//         int bestMove[] = new int [2];
//         for (int i = 0; i < 3; i++){ // Check all spaces on the board
//             for (int j = 0; j < 3; j++){
//                 if (board[i][j] == ' '){ //Is the spot available?
//                     board[i][j] = 'X'; //Take the spot with x
//                     int score = minimax(board, 0, false ); //Give the spot a score
//                     board[i][j] = ' '; //Remove x from the spot
//                     if (score > bestScore){
//                         bestScore = score;
//                         bestMove[0] = i;
//                         bestMove[1] = j;
//                     }
//                 }
//             }
//         }
//         move.setPlay(bestMove[0], bestMove[1], "X");
//         //board[bestMove[0]][bestMove[1]] = x;
//     }




//     public int minimax(char board[][], int depth, boolean isMaximizing){
//         Tictactoe over = new Tictactoe();
//             boolean result = over.checkWin();
//             int val = (result) ? x : x;
//             int vall = (result) ? x : o;
//             int valll = (result) ? x : tie;
//             if (result != false) {
//                 if(val == x){
//                     return x;
//                 }
//                 if(vall == o){
//                     return o;
//                 }
//                 if(valll == tie){
//                     return tie;
//                 }
//             }

        

//         if(isMaximizing){
//             int bestScore = Integer.MIN_VALUE;
//             for(int i = 0; i < 3; i++){
//                 for(int j = 0; j < 3; j++){
//                     if (board[i][j] == ' '){ //Is the spot available?
//                         board[i][j] = X; //Take the spot with x
//                         int score = minimax(board, depth + 1, false ); //Give the spot a score
//                         board[i][j] = ' '; //Remove x from the spot
//                         bestScore = Math.max(score, bestScore);
//                 }
//             }
//         }
//         return bestScore;
//     } else {
//         int bestScore = Integer.MAX_VALUE;
//         for(int i = 0; i < 3; i++){
//             for(int j = 0; j < 3; j++){
//                 if (board[i][j] == ' '){ //Is the spot available?
//                     board[i][j] = 'O'; //Take the spot with O
//                     int score = minimax(board, depth + 1, true); //Give the spot a score
//                     board[i][j] = ' '; //Remove x from the spot
//                     bestScore = Math.min(score, bestScore);
//             }
//         }
//     }
//     return bestScore;
//         }
//     }
// }