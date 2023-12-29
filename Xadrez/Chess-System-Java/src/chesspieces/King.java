package chesspieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	public King(Board board, Color color) {
		super(board, color);
	}
	
	private boolean canMove(Position position){
	    ChessPiece p = (ChessPiece)getBoard().getPiece(position);
	    return p == null || p.getColor() != this.getColor();
	}
	
	@Override
	public String toString() {
		return "O";	
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		Position p = new Position(0,0);
		
		//Up
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()] = true; }

		//Up - Right
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()] = true; }

		//Up - Left
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()] = true; }

		//Right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()] = true; }

		//Left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()] = true; }
		
		//Down - Right
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()] = true; }
		
		//Down
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()] = true; }
		
		//Down - Left
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()] = true; }
		
		return mat;
	}
}