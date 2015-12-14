package tiles;

import java.awt.Point;

import com.team1ofus.apollo.TILE_TYPE;

import tiles.Tile;

//A type of tile that represents a non-traversable tile
public class Grass extends Tile implements TileInterface {
	
	private static final long serialVersionUID = 1L;

	public Grass(String cellName,Point tilePoint){
		this.cellName = cellName;
		this.tilePoint = tilePoint;
		this.tileType = TILE_TYPE.GRASS; 
	}
	
	//------------------------------------------------------------------------------
	
	public int getTraverseCost() {
		return 6;
	}
}