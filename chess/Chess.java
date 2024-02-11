////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package chess;

/*************************************************************************************************************************************** 
 * @author Ayush Munjial
 * @author Hein Min Thu
***************************************************************************************************************************************/

import java.util.ArrayList;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class ReturnPiece {
	static enum PieceType {WP, WR, WN, WB, WQ, WK, BP, BR, BN, BB, BK, BQ};
	static enum PieceFile {a, b, c, d, e, f, g, h};
	
	PieceType pieceType; PieceFile pieceFile; int pieceRank;  // 1 to 8
	
    public String toString() { return ""+pieceFile+pieceRank+":"+pieceType; }

	public boolean equals(Object other) {
		if (other == null || !(other instanceof ReturnPiece)) { return false; }

		ReturnPiece otherPiece = (ReturnPiece)other;
		return pieceType == otherPiece.pieceType && pieceFile == otherPiece.pieceFile && pieceRank == otherPiece.pieceRank;
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class ReturnPlay {
	enum Message {ILLEGAL_MOVE, DRAW, RESIGN_BLACK_WINS, RESIGN_WHITE_WINS, CHECK, CHECKMATE_BLACK_WINS, CHECKMATE_WHITE_WINS, STALEMATE};
	
	ArrayList<ReturnPiece> piecesOnBoard; Message message;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// To apply object-oriented design ideas to design and implement a 2-Player Chess game.
public class Chess {
	
	enum Player { white, black }
	public static Player turn;
	
	/**---------------------------------------------------------------------------------------------------------------------------------
	 * This method plays the next move for whichever player has the turn.
	 * 
	 * @param move String for next move, e.g. "a2 a3"
	 * 
	 * @return A ReturnPlay instance that contains the result of the move.
	---------------------------------------------------------------------------------------------------------------------------------**/

	public static ReturnPlay play(String move) { /* FILL IN THIS METHOD */	
		return null;
	}
	
	/**---------------------------------------------------------------------------------------------------------------------------------
	 * This method resets the game, and starts from scratch.
	 * R:Rook, N:Knight, B:Bishop, Q:Queen, K:King, P:Pawns. 
	---------------------------------------------------------------------------------------------------------------------------------**/
	
	public static void start() {
		System.out.flush(); turn = Player.white; // A game must always start with a move by the player who is playing white.
		Board.init_play();

	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static void parseMove(String move) { /* FILL IN THIS METHOD */ }
	public static void checkMove() { /* FILL IN THIS METHOD */ }
	public static void exec_Move() { /* FILL IN THIS METHOD */ }

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
