package board;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import pieces.Piece;

public abstract class Tile {

	protected final int tileCoords;
	
	private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPosibleEmptyTiles();
	
	private Tile(int tileCoords) {
		this.tileCoords = tileCoords;
	}
	
	public static Tile createTile(final int tileCoords, final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoords, piece) : EMPTY_TILES.get(tileCoords);
	}
	
	private static Map<Integer, EmptyTile> createAllPosibleEmptyTiles() {
		
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<Integer, Tile.EmptyTile>();
		
		for(int i =0; i< 64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		
		return ImmutableMap.copyOf(emptyTileMap);
	}

	public abstract boolean isTileOccupied();
	
	public abstract Piece getPiece();
	
	public static final class EmptyTile extends Tile {

		public EmptyTile(final int tileCoords) {
			super(tileCoords);
		}

		@Override
		public boolean isTileOccupied() {
			return false;
		}

		@Override
		public Piece getPiece() {
			return null;
		}

	}
	
	public static final class OccupiedTile extends Tile {
		
		private final Piece pieceOnTile;

		public OccupiedTile(int tileCoords, Piece piece) {
			super(tileCoords);
			this.pieceOnTile = piece;
		}

		@Override
		public boolean isTileOccupied() {
			
			return true;
			
		}

		@Override
		public Piece getPiece() {
			
			return pieceOnTile;
		
		}

	}
	
}
