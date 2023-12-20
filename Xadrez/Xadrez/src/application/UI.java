package application;

import chess.ChessPiece;

public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print("\n" + (8 - i) + " ");
			
			for (int j = 0; j < pieces.length; j++) {
				
				if (i % 2 == 0 && j % 2 == 0) { printWhiteSquare(pieces[i][j]); }
				
				else if (i % 2 == 1 && j % 2 == 1) { printWhiteSquare(pieces[i][j]); }
				
				else { printBlackSquare(pieces[i][j]);}
				
			}
			System.out.println("");
		}
		System.out.println("  A\tB\tC\tD\tE\tF\tG\tH");
	}
	
	private static void printWhiteSquare(ChessPiece piece) {
		if (piece == null) {
			System.out.print("░░\t");
		}
		else {
			System.out.print(piece+"\t");
		}
	}
	private static void printBlackSquare(ChessPiece piece) {
		if (piece == null) {
			System.out.print("██\t");
		}
		else {
			System.out.print(piece+"\t");
		}
	}
}
