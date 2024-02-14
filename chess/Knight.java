////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package chess;

/*************************************************************************************************************************************** 
 * @author Ayush Munjial
 * @author Hein Min Thu
***************************************************************************************************************************************/

public class Knight extends Piece { public Knight(ReturnPiece returnPiece) { super(returnPiece); }
    
    /**---------------------------------------------------------------------------------------------------------------------------------
	 * This method implements knight-specific move validation logic.
	 * @return A boolean instance that has the result of the move.
	---------------------------------------------------------------------------------------------------------------------------------**/

    public boolean isValidMove(int X1, int Y1, int X2, int Y2, boolean isEmpty, Chess.Player player) { 

        int moveX, moveY; boolean isValid = false; moveX = Math.abs(X2 - X1); moveY = Math.abs(Y2 - Y1);
		if ((moveX == 2 && moveY == 1) || (moveX == 1 && moveY == 2)) { isValid = true; }

		return isValid;  
    }  
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////