package chess.board;

public class BoardUtils {
	
	public static final boolean[] FIRST_COLUMN = null;
	public static final boolean[] SECOND_COLUMN = null;
	public static final boolean[] SEVENTH_COLUMN = null;
	public static final boolean[] EIGHTH_COLUMN = null;

	private BoardUtils() {
		throw new RuntimeException("You cannot insitiolize me!");
	}

	public static boolean isValidTileCoordinate(int coord) {
		
		return coord >= 0 && coord < 64;
	}

}
