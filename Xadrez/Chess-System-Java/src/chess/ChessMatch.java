package chess;

import java.util.ArrayList;
import java.util.List;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chesspieces.Bishop;
import chesspieces.King;
import chesspieces.Knight;
import chesspieces.Queen;
import chesspieces.Rook;

public class ChessMatch {
	 private int turn;
    private Color currentPlayer;
	private Board board;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	private void nextTurn(){
	    turn++;
	    currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePos, ChessPosition targetPos) {
		Position source = sourcePos.toPosition();
		Position target = targetPos.toPosition();
		validatePosition(source);
		validatePosition(source, target);
		Piece captured = MakeAMove(source, target);
		nextTurn();
		return (ChessPiece)captured;
	}

	private Piece MakeAMove(Position source, Position target) {
		
		Piece p = board.removePiece(source);
		Piece captured = board.removePiece(target);
		board.placePiece(p, target);
		if(captured != null) {
			piecesOnTheBoard.remove(captured);
			capturedPieces.add(captured);
		}
		return captured;
	}

	private void validatePosition(Position source) {
		if(!board.thereIsAPiece(source)) {
			throw new ChessException("There is no piece on source position!");
		}
		
		if(currentPlayer != ((ChessPiece)board.getPiece(source)).getColor()){
            throw new ChessException("This piece isn't yours!");
		}
		
		if(!board.getPiece(source).isThereAnyPossibleMoves()) {
			throw new ChessException("There is no possible move for this piece!");
		}
	}
	
	private void validatePosition(Position source, Position target) {
		if(!board.getPiece(source).possibleMove(target)) {
			throw new ChessException("The chosen piecen can't move to target position");
		}
	}

	public void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	public boolean[][] possibleMoves(ChessPosition chessPosition){
		Position position = chessPosition.toPosition();
		validatePosition(position);
		return board.getPiece(position).possibleMoves();
	}
	
	public void initialSetup() {
		//for (int i = 0; i <= board.getColumn() - 1; i++) { placeNewPiece((char)('a'+i), 2,  new Pawn(board, Color.WHITE)); }
		placeNewPiece('a', 1, new Rook  (board, Color.WHITE));
		placeNewPiece('b', 1, new Knight(board, Color.WHITE));
		placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('d', 1, new Queen (board, Color.WHITE));
		placeNewPiece('e', 1, new King  (board, Color.WHITE));
		placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('g', 1, new Knight(board, Color.WHITE));
		placeNewPiece('h', 1, new Rook  (board, Color.WHITE));
		
		
		//for (int i = 0; i <= board.getColumn() - 1; i++) { placeNewPiece((char)('a'+i), 7,  new Pawn(board, Color.BLACK)); }
		placeNewPiece('a', 8, new Rook  (board, Color.BLACK));
		placeNewPiece('b', 8, new Knight(board, Color.BLACK));
		placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
		placeNewPiece('d', 8, new Queen (board, Color.BLACK));
		placeNewPiece('e', 8, new King  (board, Color.BLACK));
		placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
		placeNewPiece('g', 8, new Knight(board, Color.BLACK));
		placeNewPiece('h', 8, new Rook  (board, Color.BLACK));
	}
	
	public int getTurn() {
		return turn;
	}
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
}
