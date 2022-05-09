
public class BoardTile {
	private int tileContent;

	public BoardTile(int tileContent){
		this.tileContent = tileContent;
	}
	
	public static int getTileContent(BoardTile tile){
		return tile.tileContent;
	}
	
	public static void printTileContent(BoardTile tile){
		System.out.print(tile.tileContent);
	}
	
	public void assignTileContent(BoardTile tile, int x){
		tile.tileContent = x;
	}
}