package chess;

import boardgame.Board;
import boardgame.Position;
import chesspieces.Bishop;
import chesspieces.King;
import chesspieces.Knight;
import chesspieces.Pawn;
import chesspieces.Queen;
import chesspieces.Rook;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColumn()];
		for (int i = 0; i < board.getRow(); i++) {
			for (int j = 0; j < board.getColumn(); j++) {
				mat[i][j] = (ChessPiece)board.getPiece(i, j);
			}
		}
		return mat;
	}
	
	public void initialSetup() {
		for (int i = 0; i < board.getColumn(); i++) { board.placePiece(new Pawn(board, Color.WHITE), new Position(6, i)); }
		board.placePiece(new Rook  (board, Color.WHITE), new Position(7, 0));
		board.placePiece(new Knight(board, Color.WHITE), new Position(7, 1));
		board.placePiece(new Bishop(board, Color.WHITE), new Position(7, 2));
		board.placePiece(new Queen (board, Color.WHITE), new Position(7, 3));
		board.placePiece(new King  (board, Color.WHITE), new Position(7, 4));
		board.placePiece(new Bishop(board, Color.WHITE), new Position(7, 5));
		board.placePiece(new Knight(board, Color.WHITE), new Position(7, 6));
		board.placePiece(new Rook  (board, Color.WHITE), new Position(7, 7));
		
		
		for (int i = 0; i < board.getColumn(); i++) { board.placePiece(new Pawn(board, Color.BLACK), new Position(1, i)); }
		board.placePiece(new Rook  (board, Color.BLACK), new Position(0, 0));
		board.placePiece(new Knight(board, Color.BLACK), new Position(0, 1));
		board.placePiece(new Bishop(board, Color.BLACK), new Position(0, 2));
		board.placePiece(new Queen (board, Color.BLACK), new Position(0, 3));
		board.placePiece(new King  (board, Color.BLACK), new Position(0, 4));
		board.placePiece(new Bishop(board, Color.BLACK), new Position(0, 5));
		board.placePiece(new Knight(board, Color.BLACK), new Position(0, 6));
		board.placePiece(new Rook  (board, Color.BLACK), new Position(0, 7));
	}
}
