////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package chess;

/*************************************************************************************************************************************** 
 * @author Ayush Munjial
 * @author Hein Min Thu
***************************************************************************************************************************************/

import java.util.ArrayList; import java.util.Arrays; import chess.ReturnPiece.PieceFile; import chess.ReturnPiece.PieceType;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Board {

	public static ArrayList<ReturnPiece> currPiecesOnBoard = new ArrayList<ReturnPiece>(); // This is the list to be returned in end.
	public static ArrayList<Piece> currPieceObjects = new ArrayList<Piece>(); public static int wkCheck = 0, bkCheck = 0;

	public static boolean canEnPassant; public static int toCapturePawnX, toCapturePawnY; // To store pawn's X & Y that is captured.
	public static int posAterCaptureX, posAterCaptureY; // To store the X and Y of the enemy pawn that should be after the capture.
	public static int[] capturingPawns = new int[4]; // To store all enemy pawns left or right to the pawn that needs to be captured.
	
	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static void initializeBoard() {
		currPiecesOnBoard.clear(); currPieceObjects.clear(); canEnPassant = false;
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
		dx = X2 > X1 ? 1 : -1; dy = Y2 > Y1 ? 1 : -1; // Knights can move to any position without obstruction.

		String[] pass = new String[]{"WN", "BN"}; for (Piece piece : currPieceObjects) { String f = "" + (char) (X1 + 96); 
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

	public static boolean is_Castling(int X1, int Y1, int X2, int Y2, Piece currReturnPiece) {  // To check if move is a castling move.
		int moveX; moveX = X2 - X1; String pieceTypeName = currReturnPiece.getPieceType().toString(); 
		Piece rook = null; Piece newKingPiece = null; Piece newRookPiece = null; int rX2 = 0, rY2 = 0;
		
		if (currReturnPiece.inSpot == true && Math.abs(moveX) == 2) { 
			if (pieceTypeName.equals("WK")) { for (Piece piece : currPieceObjects) {
					if (moveX == 2) { 
						if (piece.returnPiece.pieceFile.toString().equals("h") && piece.returnPiece.pieceRank == 1) { 
							if (piece.getPieceType().toString().equals("WR")) { rook = piece; rX2 = 6; rY2 = 1; } 
						}
					}
					else { 
						if (piece.returnPiece.pieceFile.toString().equals("a") && piece.returnPiece.pieceRank == 1) { 
							if (piece.getPieceType().toString().equals("WR")) { rook = piece; rX2 = 4; rY2 = 1; } 
						}
					}		
				}
			}

			else if (pieceTypeName.equals("BK")) { for (Piece piece : currPieceObjects) {
					if (moveX == 2) { 
						if (piece.returnPiece.pieceFile.toString().equals("h") && piece.returnPiece.pieceRank == 8) { 
							if (piece.getPieceType().toString().equals("BR")) { rook = piece; rX2 = 6; rY2 = 8; } 
						}
					}
					else { 
						if (piece.returnPiece.pieceFile.toString().equals("a") && piece.returnPiece.pieceRank == 8) { 
							if (piece.getPieceType().toString().equals("BR")) { rook = piece; rX2 = 4; rY2 = 8; } 
						}
					}			
				}
			}
			else { return false; } // To return false, in case, the current Piece is neither a white king nor a black king.
		} 
		else { return false; } 

		if (rook == null) { return false; } // To check if the rook is found or has value null.

		if (isWalkClear(X1, Y1, X2, Y2)) {
			ReturnPiece newKingData = new ReturnPiece(); newKingData.pieceFile = ReturnPiece.PieceFile.valueOf("" + (char) (X2 + 96));
			newKingData.pieceRank = Y2; newKingData.pieceType = currReturnPiece.getPieceType(); 
			newKingPiece = PieceOfType.createPiece(newKingData); newKingPiece.inSpot = false;  // To assign new king object.

			Piece oldKingRemove = null; 
			for (Piece piece : Board.currPieceObjects) {  // To delete king at the old position since it is no longer needed or used.
				if (piece.returnPiece.equals(currReturnPiece.returnPiece)) { oldKingRemove = piece; }
			} 
			if (oldKingRemove != null) { Board.currPieceObjects.remove(oldKingRemove); }
			
			ReturnPiece newRookData = new ReturnPiece(); newRookData.pieceFile = ReturnPiece.PieceFile.valueOf("" + (char) (rX2 + 96));
			newRookData.pieceRank = rY2; if (pieceTypeName.startsWith("W")) { newRookData.pieceType = PieceType.WR; } 
			else { newRookData.pieceType = PieceType.BR; }
			newRookPiece = PieceOfType.createPiece(newRookData); newRookPiece.inSpot = false;  // To assign new rook object.

			Piece oldRookRemove = null; 
			for (Piece piece : Board.currPieceObjects) {  // To delete rook at the old position since it is no longer needed or used.
				if (piece.returnPiece.equals(rook.returnPiece)) { oldRookRemove = piece; }
			} 
			if (oldRookRemove != null) { Board.currPieceObjects.remove(oldRookRemove); } 
			
			currPieceObjects.add(newKingPiece); currPieceObjects.add(newRookPiece); return true; // To add the new piece information.
		}

		return false;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean doEnPassant(int X1, int Y1, int X2, int Y2) { // To check if move can make an en passant capture & execute it.
		if ((X1 == capturingPawns[0] && Y1 == capturingPawns[1]) || (X1 == capturingPawns[2] && Y1 == capturingPawns[3])) {
			if (X2 == posAterCaptureX && Y2 == posAterCaptureY) { 
				
				Piece pieceToRemove = null; for (Piece piece : currPieceObjects) { String f = "" + (char) (toCapturePawnX + 96);
					if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == toCapturePawnY) { 
						pieceToRemove = piece; // To delete the piece at old position since it is no longer needed or used.
					}
				} 
				if (pieceToRemove != null) { Board.currPieceObjects.remove(pieceToRemove); }

				for (Piece piece : currPieceObjects) { String f1 = "" + (char) (X1 + 96); String f2 = "" + (char) (X2 + 96);
					if (piece.returnPiece.pieceFile.toString().equals(f1) && piece.returnPiece.pieceRank == Y1) { 
						piece.returnPiece.pieceFile = ReturnPiece.PieceFile.valueOf(f2);  piece.returnPiece.pieceRank = Y2; piece.inSpot = false;
					}
				}
				return true;
			}
		}
		
		return false; 
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean isEnPassant(int X1, int Y1, int X2, int Y2) { // To check if the move is an en passant capture oppurtunity.
		int moveY; moveY = Math.abs(Y2 - Y1); toCapturePawnX = X2; toCapturePawnY = Y2; if (moveY != 2) { return false; }

		if ((X2 + 1) <= 8) { capturingPawns[0] = X2 + 1; capturingPawns[1] = Y2; // To check the right side for the enemy's pawn.
			Piece capturer = null; for (Piece piece : currPieceObjects) { String f = "" + (char) ((X2 + 1) + 96);
				if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y2) { capturer = piece; }
			}
			if (capturer != null) { 
				if (Chess.player.equals(Chess.Player.white) && capturer.getPieceType().toString().equals("BP")) {
					posAterCaptureX = X2; posAterCaptureY = 3; return true;
				}
				else if (Chess.player.equals(Chess.Player.black) && capturer.getPieceType().toString().equals("WP")) {
					posAterCaptureX = X2; posAterCaptureY = 6; return true;
				}
			}
		}
		if ((X2 - 1) >= 1) { capturingPawns[2] = X2 - 1; capturingPawns[3] = Y2; // To check the left side for the enemy's pawn.
			Piece capturer = null; for (Piece piece : currPieceObjects) { String f = "" + (char) ((X2 - 1) + 96);
				if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y2) { capturer = piece; }
			}
			if (capturer != null) { 
				if (Chess.player.equals(Chess.Player.white) && capturer.getPieceType().toString().equals("BP")) {
					posAterCaptureX = X2; posAterCaptureY = 3; return true;
				}
				else if (Chess.player.equals(Chess.Player.black) && capturer.getPieceType().toString().equals("WP")) {
					posAterCaptureX = X2; posAterCaptureY = 6; return true;
				}
			}
		}
		return false; 
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static void promotePawn(int X2, int Y2, String command) { // To promote a pawn to another piece upon reaching the last rank.
		for (Piece piece : currPieceObjects) { String f = "" + (char) (X2 + 96);
			if (piece.returnPiece.pieceFile.toString().equals(f) && piece.returnPiece.pieceRank == Y2) { 
				if (piece.getPieceType().toString().equalsIgnoreCase("WP") && Y2 == 8) { 
					switch (command.toUpperCase()) {
						case "Q": piece.returnPiece.pieceType = ReturnPiece.PieceType.WQ; break;
						case "R": piece.returnPiece.pieceType = ReturnPiece.PieceType.WR; break;
						case "N": piece.returnPiece.pieceType = ReturnPiece.PieceType.WN; break;
						case "B": piece.returnPiece.pieceType = ReturnPiece.PieceType.WB; break;
						default: piece.returnPiece.pieceType = ReturnPiece.PieceType.WQ; break;
					}
				}
				else if (piece.getPieceType().toString().equalsIgnoreCase("BP") && Y2 == 8) { 
					switch (command.toUpperCase()) {
						case "Q": piece.returnPiece.pieceType = ReturnPiece.PieceType.BQ; break;
						case "R": piece.returnPiece.pieceType = ReturnPiece.PieceType.BR; break;
						case "N": piece.returnPiece.pieceType = ReturnPiece.PieceType.BN; break;
						case "B": piece.returnPiece.pieceType = ReturnPiece.PieceType.BB; break;
						default: piece.returnPiece.pieceType = ReturnPiece.PieceType.BQ; break;
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

				if(opponentPiece.isValidMove(oppoX, oppoY, kingX, kingY, false, player)) { 
					if (isWalkClear(oppoX, oppoY, kingX, kingY)) { return true; } // If all conditions are met, given player is in check.
				}
			}
		}
		return false;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	public static boolean isInCheckmate(Chess.Player player) { // To check if opponent player's king is in checkmate by current player.
		if (!identifyCheck(player)) { return false; } if (canKingEscape(player)) { return false; }
		if (canCaptureCheckingPiece(player)) { return false; } if (canBlockCheck(player)) { return false; } return true;
	}
	
	/**------------------------------------------------------------------------------------------------------------------------------**/

	private static boolean canKingEscape(Chess.Player player) { // To check if the king can escape the checking piece to be safe.
		int kingX = -1, kingY = -1; Piece kingPiece = findKingPiece(player);
		kingX = kingPiece.returnPiece.pieceFile.ordinal() + 1; kingY = kingPiece.returnPiece.pieceRank;

		for (int dx = -1 ; dx <= 1; dx++) { for (int dy = -1 ; dy<= 1; dy++) { int newX = kingX + dx; int newY = kingY + dy;
			// To check all possible moves for the king (8 surrounding moves)

				if (newX >= 1 && newX <= 8 && newY >= 1 && newY <= 8 && isSpotEmpty(newX, newY)) {
					if (kingPiece.isValidMove(kingX, kingY, newX, newY,true, player)) {
						
						ReturnPiece.PieceFile oldFile = kingPiece.returnPiece.pieceFile; int oldRank = kingPiece.returnPiece.pieceRank;
						ReturnPiece.PieceFile newPieceFile = PieceFile.valueOf("" + (char)(newX + 96));
						kingPiece.returnPiece.pieceFile = newPieceFile; kingPiece.returnPiece.pieceRank = newY;

						if (identifyCheck(player) == false) { // To move the king back to its original position and return true/false.
							kingPiece.returnPiece.pieceFile = oldFile; kingPiece.returnPiece.pieceRank = oldRank; return true;
						}
						kingPiece.returnPiece.pieceFile = oldFile; kingPiece.returnPiece.pieceRank = oldRank;
					}
				}
			}
		}
		return false;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/
	
	public static boolean canCaptureCheckingPiece(Chess.Player player) { // To check if any piece can capture the checking piece.
		Chess.Player opponent = (player == Chess.Player.white) ? Chess.Player.black : Chess.Player.white;
		Piece kingPiece = findKingPiece(player); 
		int kingX = kingPiece.returnPiece.pieceFile.ordinal() + 1; int kingY = kingPiece.returnPiece.pieceRank;

		// To identify all pieces of the current player that are putting the opponent's king in check.
		ArrayList<Piece> checkingPieces = new ArrayList<>();
		for (Piece currentPiece : currPieceObjects) {
			if ((player == Chess.Player.white && currentPiece.getPieceType().toString().startsWith("W")) ||
				(player == Chess.Player.black && currentPiece.getPieceType().toString().startsWith("B"))) {

				int currentX = currentPiece.returnPiece.pieceFile.ordinal() + 1; int currentY = currentPiece.returnPiece.pieceRank;
				
				if (currentPiece.isValidMove(currentX, currentY, kingX, kingY, false, opponent)) {
					if (isWalkClear(currentX, currentY, kingX, kingY)) { checkingPieces.add(currentPiece); }
				}
			}
		}

		if (checkingPieces.size() > 1){ return false; }
		else { Piece checkingPiece = checkingPieces.get(0); for (Piece opponentPiece : new ArrayList<>(currPieceObjects)) { 
			// To check if any opponent's pieces can capture the checking piece.

				if ((opponent == Chess.Player.white && opponentPiece.getPieceType().toString().startsWith("W")) ||
					(opponent == Chess.Player.black && opponentPiece.getPieceType().toString().startsWith("B"))) {
							
					int checkX = checkingPiece.returnPiece.pieceFile.ordinal() + 1; int checkY = checkingPiece.returnPiece.pieceRank;
					int enemyX = opponentPiece.returnPiece.pieceFile.ordinal() + 1; int enemyY = opponentPiece.returnPiece.pieceRank;
	
					if (opponentPiece.isValidMove(enemyX, enemyY, checkX, checkY, false, opponent)) {
						if (isWalkClear(enemyX, enemyY, checkX, checkY)) {

							ReturnPiece checkingCopy = new ReturnPiece(); checkingCopy.pieceFile = checkingPiece.returnPiece.pieceFile;
							checkingCopy.pieceRank = checkingPiece.returnPiece.pieceRank; 
							checkingCopy.pieceType = checkingPiece.getPieceType(); 
							Piece capturedPiece = PieceOfType.createPiece(checkingCopy); capturedPiece.inSpot = capturedPiece.inSpot;

							currPieceObjects.remove(checkingPiece); PieceFile originalFile = opponentPiece.returnPiece.pieceFile;
							int originalRank = opponentPiece.returnPiece.pieceRank;
							ReturnPiece.PieceFile newPieceFile = PieceFile.valueOf("" + (char)(checkX + 96));
							opponentPiece.returnPiece.pieceFile = newPieceFile; opponentPiece.returnPiece.pieceRank = checkY;

							if ((identifyCheck(player)==true)) { // To check if the king is still in check after the capture.
								opponentPiece.returnPiece.pieceFile = originalFile; opponentPiece.returnPiece.pieceRank = originalRank;
								currPieceObjects.add(capturedPiece); return false;
								
							}
							opponentPiece.returnPiece.pieceFile = originalFile; opponentPiece.returnPiece.pieceRank = originalRank;
							currPieceObjects.add(capturedPiece); // To restore the captured piece.
						}
					}	
				}
			}
		}			
		return true;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	private static boolean canBlockCheck(Chess.Player player) { // To check if other pieces of oppenent can block checking piece.
		Chess.Player opponent = (player == Chess.Player.white) ? Chess.Player.black : Chess.Player.white;
		Piece kingPiece = findKingPiece(player);
		int kingX = kingPiece.returnPiece.pieceFile.ordinal() + 1; int kingY = kingPiece.returnPiece.pieceRank;
	
		// To identify all pieces of the current player that are putting the opponent's king in check.
		ArrayList<Piece> checkingPieces = new ArrayList<>();
		for (Piece currentPiece : currPieceObjects) {
			if ((player == Chess.Player.white && currentPiece.getPieceType().toString().startsWith("W")) ||
				(player == Chess.Player.black && currentPiece.getPieceType().toString().startsWith("B"))) {
	
				int currentX = currentPiece.returnPiece.pieceFile.ordinal() + 1; int currentY = currentPiece.returnPiece.pieceRank;
				
				if (currentPiece.isValidMove(currentX, currentY, kingX, kingY, false, opponent)) {
					if (isWalkClear(currentX, currentY, kingX, kingY)) { checkingPieces.add(currentPiece); }
				}
			}
		}

		if (checkingPieces.size() > 1) { return false; }
		else { Piece checkingPiece = checkingPieces.get(0); ArrayList<int[]> pathToKing = getPathToKing(checkingPiece, kingX, kingY);
			for(int[] square :pathToKing) { for (Piece piece : currPieceObjects) { // To skip all opponent's pieces and both the kings.
					
					if ((player == Chess.Player.white && piece.getPieceType().toString().startsWith("W")) ||
						(player == Chess.Player.black && piece.getPieceType().toString().startsWith("B")) ||
						piece.getPieceType().toString().equals("WK") || piece.getPieceType().toString().equals("BK")) {
						continue;
					}
					int pieceX = piece.returnPiece.pieceFile.ordinal() + 1; int pieceY = piece.returnPiece.pieceRank;
					if (piece.isValidMove(pieceX, pieceY, square[0], square[1], true, player)) {
						if (isWalkClear(pieceX, pieceY, square[0], square[1])) { return true; }
            		}
				}
			}	
		}
		return false;
	}
	
	/**------------------------------------------------------------------------------------------------------------------------------**/

	private static Piece findKingPiece(Chess.Player player) { // To find the king piece of the opponent given the current player.
		ReturnPiece.PieceType kingType = (player == Chess.Player.white) ? ReturnPiece.PieceType.BK : ReturnPiece.PieceType.WK;
		for (Piece piece : currPieceObjects) { if (piece.getPieceType() == kingType) { return piece; }} return null;
	}

	/**------------------------------------------------------------------------------------------------------------------------------**/

	private static ArrayList<int[]> getPathToKing(Piece checkingPiece, int kingX, int kingY) { // To store the path to given king.
		int pieceX = checkingPiece.returnPiece.pieceFile.ordinal() + 1; int pieceY = checkingPiece.returnPiece.pieceRank;
		ArrayList<int[]> path = new ArrayList<>(); 
		
		int deltaX = Integer.compare(kingX, pieceX); // 0 if same file, 1 if king is right, -1 if left
		int deltaY = Integer.compare(kingY, pieceY); // 0 if same rank, 1 if king is up, -1 if down
	
		pieceX += deltaX; pieceY += deltaY; // Move to the first square in the path
		if (pieceX < 1 || pieceX > 8 || pieceY < 1 || pieceY > 8) { return path; }
	
		while (!(pieceX == kingX && pieceY == kingY)) { path.add(new int[]{pieceX, pieceY}); pieceX += deltaX; pieceY += deltaY;
			if (pieceX < 1 || pieceX > 8 || pieceY < 1 || pieceY > 8) { break; } // To check bounds within the loop as well.
		}
		return path;		
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////