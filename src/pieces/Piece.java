package pieces;

import java.util.List;

import Alliance;
import board.Board;
import board.Move;

public abstract class Piece {
	
	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	
	public Piece(final int position, final Alliance pieceAlliance) {
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = position;
	}

	public abstract List<Move> calculateLegalMoves (final Board board);
	
}
