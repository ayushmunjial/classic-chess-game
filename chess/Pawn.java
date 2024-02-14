////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package chess;

/*************************************************************************************************************************************** 
 * @author Ayush Munjial
 * @author Hein Min Thu
***************************************************************************************************************************************/

public class Pawn extends Piece { public Pawn(ReturnPiece returnPiece) { super(returnPiece); }

    /**---------------------------------------------------------------------------------------------------------------------------------
	 * This method implements pawn-specific move validation logic.
	 * @return A boolean instance that has the result of the move.
	---------------------------------------------------------------------------------------------------------------------------------**/

    public boolean isValidMove(int X1, int Y1, int X2, int Y2, boolean isEmpty, Chess.Player player) { 
        
        int moveX, moveY; boolean isValid = false; moveX = Math.abs(X2 - X1);
		
		if (this.getPieceType().toString().equalsIgnoreCase("WP")) { moveY = Y2 - Y1; }
        else { moveY = Y1 - Y2; } // The direction of movement based on whether the pawn is white or not. 
		
		if (moveX == 0 && moveY == 1 && isEmpty == true) { isValid = true; } 
        else if (moveX == 1 && moveY == 1 && isEmpty == false) { isValid  = true; } // A capture move.
        else if (this.inSpot == true && moveX == 0 && moveY == 2 && isEmpty == true){ isValid = true; }
		
		return isValid;
    } 
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////