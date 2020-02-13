package chess.pieces;

import java.util.Collection;
import java.util.List;

import chess.Alliance;
import chess.board.Board;
import chess.board.Move;

public abstract class Piece {
	
	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	
	public Piece(final int position, final Alliance pieceAlliance) {
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = position;
	}
	

	public Alliance getPieceAlliance() {
		return pieceAlliance;
	}


	public abstract Collection<Move> calculateLegalMoves (final Board board);
	
}
