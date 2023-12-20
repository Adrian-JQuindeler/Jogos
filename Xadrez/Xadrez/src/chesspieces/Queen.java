package chesspieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		if(this.getColor() == Color.WHITE) {
			return "♕";
		}
		else if(this.getColor() == Color.BLACK) {
			return "♛";
		}
		return "Q";	
	}
}
