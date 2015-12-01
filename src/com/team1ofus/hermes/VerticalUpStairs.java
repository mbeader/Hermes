package com.team1ofus.hermes;

import java.awt.Point;

import com.team1ofus.apollo.TILE_TYPE;
import com.team1ofus.hermes.Tile;
import com.team1ofus.hermes.TileInterface;

//A type of tile that represents a non-traversable tile
public class VerticalUpStairs extends Tile implements TileInterface {
	
	private static final long serialVersionUID = 1L;

	public VerticalUpStairs(String cellName,Point tilePoint){
		this.cellName = cellName;
		this.tilePoint = tilePoint;
		this.tileType = TILE_TYPE.VERTICAL_UP_STAIRS; 
	}
	
	//------------------------------------------------------------------------------
	
	public int getTraverseCost() {
		return 5;
	}
}