public class Board {
	private static BoardTile[][] Board;

	public Board(int size) {
		Board = new BoardTile[size][size];
	}

	// Initialize BoardTile Objects within an array of arrays
	// Able to adjust this method to generate random maps or possible use Kirils
	// text file maps to generate an underlying grid
	public static void populateEmptyBoard(Board board) {
		for (int i = 0; i < board.Board.length; i++) {
			for (int j = 0; j < board.Board[i].length; j++) {
				board.Board[i][j] = new BoardTile(1);
			}
			// New BoardTile(1) sets the value of the tile to an int --- 1
			// Was just using 1 to represent empty at the moment
			// But we can change the int to a field or whatever we want within
			// the BoardTile class
		}
	}

	public static void printBoard(Board board) {
		for (int i = 0; i < board.Board.length; i++) {
			for (int j = 0; j < board.Board[i].length; j++) {
				BoardTile.printTileContent(Board[i][j]);
			}
			System.out.println();
		}
	}

	// Below were experimental but I'm saving them at the moment

	// public static void assignTile(BoardTile boardTile, int x, int y, int
	// contentInput){
	// boardTile.assignTileContent(Board[x][y], contentInput);
	// }

	// public static int getTileContent(Board newBoard, int x, int y){
	// return newBoards[x][y].tileContent;
	// }
	//
	// public static void setTileAs(Board newBoard, int x, int y, int
	// newContent){
	// newBoards[x][y].tileContent = newContent;
	// }

}