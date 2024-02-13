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
	
	enum Player { white, black } public static Player player;

	/**---------------------------------------------------------------------------------------------------------------------------------
	 * This method plays the next move for whichever player has the turn.
	 * @param move String for next move, e.g. "a2 a3"
	 * @return A ReturnPlay instance that contains the result of the move.
	---------------------------------------------------------------------------------------------------------------------------------**/

	public static ReturnPlay play(String move) { 

		ReturnPlay.Message message = parseMove(move); // This receives an appropriate message according to the move's validity.
		if(!message.toString().equals("ILLEGAL_MOVE")) {
			if(player.toString().equals("white")) { player = Player.black; } else { player = Player.white; }
		}

		ReturnPlay playGame = new ReturnPlay(); playGame.piecesOnBoard = Board.currPiecesOnBoard; playGame.message = message;
		return playGame;
	}
	
	/**---------------------------------------------------------------------------------------------------------------------------------
	 * This method resets the game, and starts from scratch. 
	 * R:Rook, N:Knight, B:Bishop, Q:Queen, K:King, P:Pawns. 
	---------------------------------------------------------------------------------------------------------------------------------**/
	
	public static void start() { 

		System.out.flush(); player = Player.white; // A game must always start with a move by the player who is playing white.
		Board.initializeBoard();
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static ReturnPlay.Message parseMove(String move) { 
		int length = move.length(); int whiteSpaceCount = 0; move = move.strip(); move = move.toLowerCase();
		String oldPosition, newPosition, command = ""; int X1, Y1, X2, Y2; ReturnPlay.Message message = null; 
		for(int i = 0; i < length; i++) { char ch = move.charAt(i); if(ch == ' ') { whiteSpaceCount += 1; } }
		
		if(whiteSpaceCount == 0) { command = move; 
			if(command.equalsIgnoreCase("resign")) { 
					if(player.toString().equals("white")) { return ReturnPlay.Message.RESIGN_BLACK_WINS; }
					else if(player.toString().equals("black")) { return ReturnPlay.Message.RESIGN_WHITE_WINS; }
					else { return ReturnPlay.Message.ILLEGAL_MOVE; }
			}
		}

		if(whiteSpaceCount == 1 || whiteSpaceCount == 2) {
			oldPosition = move.substring(0,2); newPosition = move.substring(3, 5);
			X1 = oldPosition.charAt(0) - 96; Y1 = Integer.parseInt(String.valueOf(oldPosition.charAt(1)));
			X2 = newPosition.charAt(0) - 96; Y2 = Integer.parseInt(String.valueOf(newPosition.charAt(1)));

			if(whiteSpaceCount == 2) { command = move.substring(6); }

			Piece currReturnPiece = null; // To parse the move to get the relevant ReturnPiece from currPiecesOnBoard.
			for (Piece piece : Board.currPieceObjects) { String f = oldPosition.substring(0, 1);
				if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y1) { currReturnPiece = piece; }
				else { return ReturnPlay.Message.ILLEGAL_MOVE; }
			} 

			if ((X1 >= 1 && X1 <= 8) && (Y1 >= 1 && Y1 <= 8) && (X2 >= 1 && X2 <= 8) && (Y2 >= 1 && Y2 <= 8)) {
				return exec_Move(X1, Y1, X2, Y2, command, currReturnPiece);
			}
			else { return ReturnPlay.Message.ILLEGAL_MOVE; } // To return an illegal move whenever the move is not valid.
		}
		return message;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static ReturnPlay.Message exec_Move(int X1, int Y1, int X2, int Y2, String command, Piece currReturnPiece) { 

		ReturnPlay.Message message = null; boolean isEmpty = true;
		Piece newReturnPiece = null; // This stores the information about ReturnPiece object at the new specified position.

		if(!Board.isSpotEmpty(X2, Y2)) { // To check if the move to new position is occupied and is the piece of same color?
			for (Piece piece : Board.currPieceObjects) { String f = "" + (char) (X2 + 96); Player newReturnPieceColor = null;
			
				if(piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y2) { newReturnPiece = piece;
					if(String.valueOf(piece.returnPiece.pieceType.toString().charAt(0)).equals("W")) { 
						newReturnPieceColor = Player.white; } else { newReturnPieceColor = Player.black; }
				}
				if(newReturnPieceColor.equals(player)) { return ReturnPlay.Message.ILLEGAL_MOVE; }
			}
			isEmpty = false;
		}

		if(Board.is_Castling(X1, Y1, X2, Y2)) { return message; } // To check if the move is a castling move, if true: executes move.
		
		// Some checking for En Passant //** FILL IN CODE **//

		if(!Board.isWalkClear(X1, Y1, X2, Y2) && !currReturnPiece.isValidMove(X1, Y1, X2, Y2, isEmpty, player)) { 
			return ReturnPlay.Message.ILLEGAL_MOVE; 
			// To check that there are no pieces in between & it can implement piece-specific move logic.
		}

		/*Execute the move:

		It sets the piece at the new position on the chessboard to be the same as the piece at the old position.
		It marks the moved piece's firstMove flag as false.
		If the moved piece is a pawn and reaches the opponent's back rank, it triggers pawn promotion by calling pawnPromotion().
		It clears the old position on the chessboard by setting it to null. */

		// newReturnPiece.returnPiece.pieceFile = (f for(ReturnPiece.pieceType f ) {  "" + (char) (X2 + 96); } );
		// newReturnPiece.inSpot = false;

		// for (Piece piece : Board.currPieceObjects) { String f = oldPosition.substring(0, 1);
		// 	if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y1) { currReturnPiece = piece; }
		// 	else { return Message.ILLEGAL_MOVE; }
		// }


		
		// boolean isValid = false;
		// // To check if the new position is empty.
		// if (command.equals("")) { isValid = typeOfPiece.isValidMove(X1, Y1, X2, Y2, isEmpty, player); }

		return message;
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////