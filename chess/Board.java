////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package chess;

/*************************************************************************************************************************************** 
 * @author Ayush Munjial
 * @author Hein Min Thu
***************************************************************************************************************************************/

import java.util.ArrayList; import java.util.Arrays; import chess.ReturnPiece.PieceFile; import chess.ReturnPiece.PieceType;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Board {

	public static ArrayList<ReturnPiece> currPiecesOnBoard = new ArrayList<ReturnPiece>(); 
	public static ArrayList<Piece> currPieceObjects = new ArrayList<Piece>(); 
	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static void initializeBoard() {
		currPiecesOnBoard.clear(); currPieceObjects.clear();
        ReturnPiece WR1 = new ReturnPiece(); WR1.pieceType = PieceType.WR; WR1.pieceFile = PieceFile.a; WR1.pieceRank = 1;
		ReturnPiece WN1 = new ReturnPiece(); WN1.pieceType = PieceType.WN; WN1.pieceFile = PieceFile.b; WN1.pieceRank = 1;
		ReturnPiece WB1 = new ReturnPiece(); WB1.pieceType = PieceType.WB; WB1.pieceFile = PieceFile.c; WB1.pieceRank = 1;
		ReturnPiece WQ0 = new ReturnPiece(); WQ0.pieceType = PieceType.WQ; WQ0.pieceFile = PieceFile.d; WQ0.pieceRank = 1;
		ReturnPiece WK0 = new ReturnPiece(); WK0.pieceType = PieceType.WK; WK0.pieceFile = PieceFile.e; WK0.pieceRank = 1;
		ReturnPiece WB2 = new ReturnPiece(); WB2.pieceType = PieceType.WB; WB2.pieceFile = PieceFile.f; WB2.pieceRank = 1;
		ReturnPiece WN2 = new ReturnPiece(); WN2.pieceType = PieceType.WN; WN2.pieceFile = PieceFile.g; WN2.pieceRank = 1;
		ReturnPiece WR2 = new ReturnPiece(); WR2.pieceType = PieceType.WR; WR2.pieceFile = PieceFile.h; WR2.pieceRank = 1;
		
		ReturnPiece WP1 = new ReturnPiece(); WP1.pieceType = PieceType.WP; WP1.pieceFile = PieceFile.a; WP1.pieceRank = 2;
		ReturnPiece WP2 = new ReturnPiece(); WP2.pieceType = PieceType.WP; WP2.pieceFile = PieceFile.b; WP2.pieceRank = 2;
		ReturnPiece WP3 = new ReturnPiece(); WP3.pieceType = PieceType.WP; WP3.pieceFile = PieceFile.c; WP3.pieceRank = 2;
		ReturnPiece WP4 = new ReturnPiece(); WP4.pieceType = PieceType.WP; WP4.pieceFile = PieceFile.d; WP4.pieceRank = 2;
		ReturnPiece WP5 = new ReturnPiece(); WP5.pieceType = PieceType.WP; WP5.pieceFile = PieceFile.e; WP5.pieceRank = 2;
		ReturnPiece WP6 = new ReturnPiece(); WP6.pieceType = PieceType.WP; WP6.pieceFile = PieceFile.f; WP6.pieceRank = 2;
		ReturnPiece WP7 = new ReturnPiece(); WP7.pieceType = PieceType.WP; WP7.pieceFile = PieceFile.g; WP7.pieceRank = 2;
		ReturnPiece WP8 = new ReturnPiece(); WP8.pieceType = PieceType.WP; WP8.pieceFile = PieceFile.h; WP8.pieceRank = 2;


		ReturnPiece BP1 = new ReturnPiece(); BP1.pieceType = PieceType.BP; BP1.pieceFile = PieceFile.a; BP1.pieceRank = 7;
		ReturnPiece BP2 = new ReturnPiece(); BP2.pieceType = PieceType.BP; BP2.pieceFile = PieceFile.b; BP2.pieceRank = 7;
		ReturnPiece BP3 = new ReturnPiece(); BP3.pieceType = PieceType.BP; BP3.pieceFile = PieceFile.c; BP3.pieceRank = 7;
		ReturnPiece BP4 = new ReturnPiece(); BP4.pieceType = PieceType.BP; BP4.pieceFile = PieceFile.d; BP4.pieceRank = 7;
		ReturnPiece BP5 = new ReturnPiece(); BP5.pieceType = PieceType.BP; BP5.pieceFile = PieceFile.e; BP5.pieceRank = 7;
		ReturnPiece BP6 = new ReturnPiece(); BP6.pieceType = PieceType.BP; BP6.pieceFile = PieceFile.f; BP6.pieceRank = 7;
		ReturnPiece BP7 = new ReturnPiece(); BP7.pieceType = PieceType.BP; BP7.pieceFile = PieceFile.g; BP7.pieceRank = 7;
		ReturnPiece BP8 = new ReturnPiece(); BP8.pieceType = PieceType.BP; BP8.pieceFile = PieceFile.h; BP8.pieceRank = 7;

		ReturnPiece BR1 = new ReturnPiece(); BR1.pieceType = PieceType.BR; BR1.pieceFile = PieceFile.a; BR1.pieceRank = 8;
		ReturnPiece BN1 = new ReturnPiece(); BN1.pieceType = PieceType.BN; BN1.pieceFile = PieceFile.b; BN1.pieceRank = 8;
		ReturnPiece BB1 = new ReturnPiece(); BB1.pieceType = PieceType.BB; BB1.pieceFile = PieceFile.c; BB1.pieceRank = 8;
		ReturnPiece BQ0 = new ReturnPiece(); BQ0.pieceType = PieceType.BQ; BQ0.pieceFile = PieceFile.d; BQ0.pieceRank = 8;
		ReturnPiece BK0 = new ReturnPiece(); BK0.pieceType = PieceType.BK; BK0.pieceFile = PieceFile.e; BK0.pieceRank = 8;
		ReturnPiece BB2 = new ReturnPiece(); BB2.pieceType = PieceType.BB; BB2.pieceFile = PieceFile.f; BB2.pieceRank = 8;
		ReturnPiece BN2 = new ReturnPiece(); BN2.pieceType = PieceType.BN; BN2.pieceFile = PieceFile.g; BN2.pieceRank = 8;
		ReturnPiece BR2 = new ReturnPiece(); BR2.pieceType = PieceType.BR; BR2.pieceFile = PieceFile.h; BR2.pieceRank = 8;
		
		
		currPiecesOnBoard.addAll(Arrays.asList(WR1, WN1, WB1, WQ0, WK0, WB2, WN2, WR2, WP1, WP2, WP3, WP4, WP5, WP6, WP7, WP8));
		currPiecesOnBoard.addAll(Arrays.asList(BR1, BN1, BB1, BQ0, BK0, BB2, BN2, BR2, BP1, BP2, BP3, BP4, BP5, BP6, BP7, BP8));

		for (ReturnPiece piece : currPiecesOnBoard) { currPieceObjects.add((PieceOfType.createPiece(piece))); }
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static void syncArraysLists() { currPiecesOnBoard.clear(); // To keep currPiecesOnBoard up to date after a move is executed.
		for (Piece piece : currPieceObjects) { currPiecesOnBoard.add(piece.returnPiece); }
	}
	
	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean isSpotEmpty(int X, int Y) { // To check if there exists a ReturnPiece at the given position.
		for (Piece piece : currPieceObjects) { String f = "" + (char) (X + 96);
			if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y) { return false; }
		}
		return true;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean isWalkClear(int X1, int Y1, int X2, int Y2) {  // To check that there are no pieces in between old and new pos.
		// To check if a move from point A to point B in horizontal, vertical, or diagnol direction has no obstructions.

		int moveX, moveY; boolean isEmpty = true; moveX = Math.abs(X2 - X1); moveY = Math.abs(Y2 - Y1); int dx = 0, dy = 0;
		dx = X2 > X1 ? 1 : -1; dy = Y2 > Y1 ? 1 : -1; // Kings and knights can move to any position without obstruction.

		String[] pass = new String[]{"WN", "BN", "WK", "BK"}; for (Piece piece : currPieceObjects) { String f = "" + (char) (X1 + 96); 
			if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y1) { 
				for (String type: pass) { if (piece.getPieceType().toString().equals(type)) { return true; } }
			}
		}

		if (Y1 == Y2) { X1 = X1 + dx; for (int x = 1; x < moveX; x++) { if (!isSpotEmpty(X1, Y1)) { return false; } X1 = X1 + dx; }}
		if (X1 == X2) { Y1 = Y1 + dy; for (int y = 1; y < moveY; y++) { if (!isSpotEmpty(X1, Y1)) { return false; } Y1 = Y1 + dy; }}

		if (X1 != X2 && Y1 != Y2) { X1 = X1 + dx; Y1 = Y1 + dy; 
			for (int d = 1; d < moveY; d++) { if (!isSpotEmpty(X1, Y1)) { return false; } X1 = X1 + dx; Y1 = Y1 + dy; }}

		return isEmpty;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean is_Castling(int X1, int Y1, int X2, int Y2, Piece currReturnPiece) { // To check if move is a castling move.
		return false; 
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean isEnPassant(int X1, int Y1, int X2, int Y2) { return false; } // To check if the move is an en passant capture.

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static void promotePawn(int X2, int Y2, String command) { // To promote a pawn to another piece upon reaching the last rank.
		for (Piece piece : currPieceObjects) { String f = "" + (char) (X2 + 96);
			if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y2) { 
				if (piece.getPieceType().toString().equalsIgnoreCase("WP") && Y2 == 8) { 
					switch (command) {
						case "Q": piece.returnPiece.pieceType = ReturnPiece.PieceType.WQ;
						case "R": piece.returnPiece.pieceType = ReturnPiece.PieceType.WR;
						case "N": piece.returnPiece.pieceType = ReturnPiece.PieceType.WN;
						case "B": piece.returnPiece.pieceType = ReturnPiece.PieceType.WB;
						default: piece.returnPiece.pieceType = ReturnPiece.PieceType.WQ;
					}
				}
				else if (piece.getPieceType().toString().equalsIgnoreCase("BP") && Y2 == 8) { 
					switch (command) {
						case "Q": piece.returnPiece.pieceType = ReturnPiece.PieceType.BQ;
						case "R": piece.returnPiece.pieceType = ReturnPiece.PieceType.BR;
						case "N": piece.returnPiece.pieceType = ReturnPiece.PieceType.BN;
						case "B": piece.returnPiece.pieceType = ReturnPiece.PieceType.BB;
						default: piece.returnPiece.pieceType = ReturnPiece.PieceType.BQ;
					}
				}
			}
		}
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean identifyCheck(Chess.Player player) { // To check if the opponent player's king is in check by current player.
		int kingX = -1, kingY = -1; PieceType kingType = (player == Chess.Player.white) ? PieceType.BK : PieceType.WK; 

		for (Piece piece : currPieceObjects) { // To store the coordinates of the king of the given player.
			if (piece.getPieceType() == kingType) { 
				kingX = piece.returnPiece.pieceFile.ordinal() + 1; kingY = piece.returnPiece.pieceRank;
			}
		}

		for (Piece opponentPiece : currPieceObjects) { // To access and check if the opponent's piece can move to the king's position.
			if ((player == Chess.Player.white && opponentPiece.getPieceType().toString().startsWith("W")) ||
				(player == Chess.Player.black && opponentPiece.getPieceType().toString().startsWith("B"))) {
				int oppoX = opponentPiece.returnPiece.pieceFile.ordinal() + 1; int oppoY = opponentPiece.returnPiece.pieceRank;

				if(opponentPiece.isValidMove(oppoX, oppoY, kingX, kingY, true, player)) { 
					if (isWalkClear(oppoX, oppoY, kingX, kingY)) { return true; } // If all conditions are met, given player is in check.
				}
			}
		}
		return false;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean isInCheckmate(Chess.Player player) { return false; } // To check if the given player is in checkmate.
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////