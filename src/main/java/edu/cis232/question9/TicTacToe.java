package edu.cis232.question9;

import java.util.Random;

public class TicTacToe {

	private int[][] board = new int[3][3];

	public int[][] getBoard(){
		return board;
	}

	public void simulateBoard(){
		Random random = new Random();

		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				board[row][col] = random.nextInt(2);
			}
		}
	}

	/**
	 * Checks the current board for a winner.
	 * @return -1 if no winner, 0 if O wins, 1 if X wins
	 */
	public int getResult(){
		int winner = -1;
		//Check rows
		for(int row = 0; row < board.length; row++){
			if(board[row][0] == board[row][1] && board[row][1] == board[row][2]){
				winner = board[row][0];
			}
		}

		//Check diagonals
		if(winner < 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
			winner = board[0][0];
		}
		if(winner < 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
			winner = board[0][2];
		}

		//Check vertical
		if(winner < 0){
			for(int col = 0; col < board[0].length; col++){
				if(board[0][col] == board[1][col] && board[1][col] == board[2][col]){
					winner = board[0][col];
				}
			}
		}

		return winner;
	}

}
