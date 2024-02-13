////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package chess;

/*************************************************************************************************************************************** 
 * @author Ayush Munjial
 * @author Hein Min Thu
***************************************************************************************************************************************/

public abstract class Piece {
    protected ReturnPiece returnPiece; public boolean inSpot; // To track whether the piece is at initial spot. 
    public Piece(ReturnPiece returnPiece) { this.returnPiece = returnPiece;  this.inSpot = true; }
    public ReturnPiece.PieceType getPieceType() { return returnPiece.pieceType; }

    // To validate if the move is legal for this piece.
    public abstract boolean isValidMove(int X1, int Y1, int X2, int Y2, boolean isEmpty, Chess.Player player); 
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class PieceOfType {
    public static Piece createPiece(ReturnPiece returnPiece) {
        switch (returnPiece.pieceType) {
            case WP:
            case BP: 
                return new Pawn(returnPiece);
            case WR:
            case BR: 
                return new Rook(returnPiece);
            case WN:
            case BN:
                return new Knight(returnPiece);
            case WB:
            case BB:
                return new Bishop(returnPiece);
            case WQ:
            case BQ:
                return new Queen(returnPiece);
            case WK:
            case BK:
                return new King(returnPiece);
            
            default: throw new IllegalArgumentException("");
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////