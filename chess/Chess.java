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
	
	enum Player { white, black } public static Player player; public static int movePlay; 

	/**---------------------------------------------------------------------------------------------------------------------------------
	 * This method plays the next move for whichever player has the turn.
	 * @param move String for next move, e.g. "a2 a3"
	 * @return A ReturnPlay instance that contains the result of the move.
	---------------------------------------------------------------------------------------------------------------------------------**/

	public static ReturnPlay play(String move) { 

		ReturnPlay.Message message = parseMove(move); // This receives an appropriate message for the given move's validity.
		ReturnPlay playGame = new ReturnPlay(); playGame.piecesOnBoard = Board.currPiecesOnBoard; playGame.message = message;
		return playGame;
	}
	
	/**---------------------------------------------------------------------------------------------------------------------------------
	 * This method resets the game, and starts from scratch. 
	 * R:Rook, N:Knight, B:Bishop, Q:Queen, K:King, P:Pawns. 
	---------------------------------------------------------------------------------------------------------------------------------**/
	
	public static void start() { 
		System.out.flush(); player = Player.white; // A game must always start with a move by the player who is playing white.
		Board.initializeBoard(); movePlay = 0; // Here, 0 represents player playing white, 1 represents player playing black.
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static ReturnPlay.Message parseMove(String move) { 
		int length = move.length(); int whiteSpaceCount = 0; String oldPosition, newPosition, command = ""; int X1, Y1, X2, Y2;
		ReturnPlay.Message message = null;
		for(int i = 0; i < length; i++) { char ch = move.charAt(i); if(ch == ' ') { whiteSpaceCount += 1; } }
		
		if(whiteSpaceCount == 0) { command = move; }

		if(whiteSpaceCount==1 || whiteSpaceCount==2) {
			oldPosition = move.substring(0,2); newPosition=move.substring(3, 5);
			X1 = oldPosition.charAt(0) - 96; Y1 = Integer.parseInt(String.valueOf(oldPosition.charAt(1)));
			X2 = newPosition.charAt(0) - 96; Y2 = Integer.parseInt(String.valueOf(newPosition.charAt(1)));

			if(whiteSpaceCount==2) { command=move.substring(6); }

			ReturnPiece currReturnPiece = null; // To parse the move to get the relevant ReturnPiece from currPiecesOnBoard.
			for (ReturnPiece piece : Board.currPiecesOnBoard) { String f = oldPosition.substring(0, 1);
				if (piece.pieceFile.toString().equals(f) && piece.pieceRank == Y1) { currReturnPiece = piece; }
			} 
			exec_Move(X1, Y1, X2, Y2, command, currReturnPiece);
		}

		return message;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static void exec_Move(int X1, int Y1, int X2, int Y2, String command, ReturnPiece currReturnPiece) { 

		Piece typeOfPiece = PieceOfType.createPiece(currReturnPiece); 
		boolean isEmpty = false; boolean isValid = false;

		// To check if the new position is empty.
		if (command.equals("")) { isValid = typeOfPiece.isValidMove(X1, Y1, X2, Y2, isEmpty, player); }
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////