package chess.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import chess.Alliance;
import chess.board.Board;
import chess.board.BoardUtils;
import chess.board.Move;
import chess.board.Tile;

public abstract class Knight extends Piece {
	
	private final static int [] CANTIDATE_MOVE_COORDS = {
			-17, -15, -10, -6, 6, 10, 15, 17
	};

	public Knight(final int position, final Alliance pieceAlliance) {
		super(position, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		
		
		final List<Move> legalMoves = new ArrayList<Move>();
		
		for(final int currCandOffset : CANTIDATE_MOVE_COORDS) {
			
			
			final int candidateDesCoord = this.piecePosition + currCandOffset;
			
			if(BoardUtils.isValidTileCoordinate(candidateDesCoord)) {
				
				if(isFirstColumnExclusion(this.piecePosition, currCandOffset) || isSecondColumnExclusion(this.piecePosition, currCandOffset) || 
						isSeventhColumnExclusion(this.piecePosition, currCandOffset) || isEighthColumnExclusion(this.piecePosition, currCandOffset)) {
					
					continue;
					
				}
				
				final Tile candidateDesTile = board.getTile(candidateDesCoord);
				
				if(!candidateDesTile.isTileOccupied()) {
					
					legalMoves.add(new Move());
					
				}else {
					final Piece pieceAtDes = candidateDesTile.getPiece();
					final Alliance pieceAlli = pieceAtDes.getPieceAlliance();
					
					if(this.pieceAlliance != pieceAlli) {
						legalMoves.add(new Move());
					}
				}
			}
			
		}
		
		return ImmutableList.copyOf(legalMoves);
	}
	
	private static boolean isFirstColumnExclusion(final int currPos, final int candidateOffset) {
		
		return BoardUtils.FIRST_COLUMN[currPos] && ((candidateOffset == -17 ) || (candidateOffset == -10) || (candidateOffset == 6) || (candidateOffset == 15));
		
	}
	
	private static boolean isSecondColumnExclusion(final int currPos, final int candidateOffset) {
		
		return BoardUtils.SECOND_COLUMN[currPos] && ((candidateOffset == -10) || (candidateOffset == 6));
		
	}
	
	private static boolean isSeventhColumnExclusion(final int currPos, final int candidateOffset) {
		
		return BoardUtils.SEVENTH_COLUMN[currPos] && ((candidateOffset == 10) || (candidateOffset == -6));
		
	}
	
	private static boolean isEighthColumnExclusion(final int currPos, final int candidateOffset) {
		
		return BoardUtils.EIGHTH_COLUMN[currPos] && ((candidateOffset == 17 ) || (candidateOffset == 10) || (candidateOffset == -6) || (candidateOffset == -15));
		
	}

}
