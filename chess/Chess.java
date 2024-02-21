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
public class Chess { enum Player { white, black } public static Player player;

	/**---------------------------------------------------------------------------------------------------------------------------------
	 * This method plays the next move for whichever player has the turn.
	 * @param move String for next move, e.g. "a2 a3"
	 * @return A ReturnPlay instance that contains the result of the move.
	---------------------------------------------------------------------------------------------------------------------------------**/

	public static ReturnPlay play(String move) { 
		ReturnPlay.Message message = parseMove(move); // This receives an appropriate message according to the move's validity.
		if (message == null || !message.toString().equals("ILLEGAL_MOVE")) {
			if (player.toString().equals("white")) { player = Player.black; } else { player = Player.white; }
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
		int length = move.length(); int whiteSpaceCount = 0; move = move.strip(); move = move.toLowerCase(); // To make move standard.
		String oldPosition, newPosition, command = ""; int X1, Y1, X2, Y2; ReturnPlay.Message message = null; 
		for (int i = 0; i < length; i++) { char ch = move.charAt(i); if (ch == ' ') { whiteSpaceCount += 1; }}
		
		if (whiteSpaceCount == 0) { command = move; 
			if (command.equalsIgnoreCase("resign")) { 
					if (player.toString().equals("white")) { return ReturnPlay.Message.RESIGN_BLACK_WINS; }
					else if (player.toString().equals("black")) { return ReturnPlay.Message.RESIGN_WHITE_WINS; }
			} 
			else { return ReturnPlay.Message.ILLEGAL_MOVE; }
		}

		if (whiteSpaceCount == 1 || whiteSpaceCount == 2) {
			oldPosition = move.substring(0,2); newPosition = move.substring(3, 5);
			X1 = oldPosition.charAt(0) - 96; Y1 = Integer.parseInt(String.valueOf(oldPosition.charAt(1)));
			X2 = newPosition.charAt(0) - 96; Y2 = Integer.parseInt(String.valueOf(newPosition.charAt(1)));

			if (whiteSpaceCount == 2) { command = move.substring(6); }

			Piece currReturnPiece = null; // To parse the move to get the relevant ReturnPiece from currPiecesOnBoard.
			for(Piece piece : Board.currPieceObjects) { String f = oldPosition.substring(0, 1);
				if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y1) { currReturnPiece = piece; }
			} 
			
			if (currReturnPiece == null) { return ReturnPlay.Message.ILLEGAL_MOVE; }
			String[] validCommands = {"draw?", "", "Q", "R", "N", "B"};

			if ((X1 >= 1 && X1 <= 8) && (Y1 >= 1 && Y1 <= 8) && (X2 >= 1 && X2 <= 8) && (Y2 >= 1 && Y2 <= 8)) {
				for (String c : validCommands) { if(command.equalsIgnoreCase(c)) {
					return exec_Move(X1, Y1, X2, Y2, command, currReturnPiece); }
				}
			}
			else { return ReturnPlay.Message.ILLEGAL_MOVE; } // To return an illegal move whenever the move is not valid in any manner.
		}
		return message;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static ReturnPlay.Message exec_Move(int X1, int Y1, int X2, int Y2, String command, Piece currReturnPiece) { 
		ReturnPlay.Message message = null; boolean isEmpty = true; Piece newReturnPiece = null; // To store the Piece at new position.

		Player currReturnPieceColor = null;
		if (String.valueOf(currReturnPiece.returnPiece.pieceType.toString().charAt(0)).equals("W")) { 
				currReturnPieceColor = Player.white; } else { currReturnPieceColor = Player.black; }

		if (!currReturnPieceColor.equals(player)) { return ReturnPlay.Message.ILLEGAL_MOVE; } // To check if wrong player made a move.

		if (Board.isSpotEmpty(X2, Y2) == false) { // To check if the move to new position is occupied and is the piece of same color?
			for (Piece piece : Board.currPieceObjects) { String f = "" + (char) (X2 + 96); 
			
				if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y2) {
					
					Player newReturnPieceColor = null;
					if (String.valueOf(piece.returnPiece.pieceType.toString().charAt(0)).equals("W")) { 
						newReturnPieceColor = Player.white; } else { newReturnPieceColor = Player.black; }
						
					if (newReturnPieceColor !=null && newReturnPieceColor.equals(currReturnPieceColor)) { return ReturnPlay.Message.ILLEGAL_MOVE; }
				}
			}
			isEmpty = false;
		}

		if (!Board.identifyCheck(player)) { // To check if move is a castling move & execute it. Cannot use castling if under CHECK.
			if (Board.is_Castling(X1, Y1, X2, Y2, currReturnPiece)) { Board.syncArraysLists(); 
				if (command.equalsIgnoreCase("draw?")) { return ReturnPlay.Message.DRAW; } else { return message; } } 
		} 
		else { return ReturnPlay.Message.ILLEGAL_MOVE; }
		

		//////
		// Some checking for En Passant //** FILL IN CODE **//
		//////
		

		if (!Board.isWalkClear(X1, Y1, X2, Y2)) { return ReturnPlay.Message.ILLEGAL_MOVE; } // To check that there are no pieces in between.
		// To check if it implements piece-specific move validation logic.
		if (!currReturnPiece.isValidMove(X1, Y1, X2, Y2, isEmpty, player)) { return ReturnPlay.Message.ILLEGAL_MOVE; }

		/** This part executes the move. It sets the piece at the new position on the chessboard by deleting piece at old position. **/

		ReturnPiece newPieceData = new ReturnPiece(); newPieceData.pieceFile = ReturnPiece.PieceFile.valueOf("" + (char) (X2 + 96));
		newPieceData.pieceRank = Y2; newPieceData.pieceType = currReturnPiece.getPieceType(); 
		newReturnPiece = PieceOfType.createPiece(newPieceData); newReturnPiece.inSpot = false;  // To assign new object.
		
		Piece pieceToRemove = null; 
		for (Piece piece : Board.currPieceObjects) {  // To delete the piece at the old position since it is no longer needed or used.
			if (piece.returnPiece.equals(currReturnPiece.returnPiece)) { pieceToRemove = piece; }
		} 
		if (pieceToRemove != null) { Board.currPieceObjects.remove(pieceToRemove); }

		Piece newPosOldOPiece = null;
		if (!isEmpty) { for (Piece piece : Board.currPieceObjects) { String f = "" + (char) (X2 + 96); 
				if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y2) { newPosOldOPiece = piece; } 
				// To remove piece at the new position in case the spot is not empty. We have already checked the case for same color.
			}
		}
		Board.currPieceObjects.remove(newPosOldOPiece); Board.currPieceObjects.add(newReturnPiece); // To add the new piece information.

		String pType = newReturnPiece.getPieceType().toString(); 
		if (pType.equals("WP") || pType.equals("BP")) { Board.promotePawn(X2, Y2, command); } // To promote pawn.


		//////
		// Some detecting for En Passant //** FILL IN CODE **//
		//////
		

		Board.syncArraysLists(); //  To sync lists in the end for up-to-date data in the global lists in the Board class.
		if (Board.identifyCheck(player)) { return ReturnPlay.Message.CHECK; }
		if (command.equalsIgnoreCase("draw?")) { return ReturnPlay.Message.DRAW; } else { return message; } 
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////