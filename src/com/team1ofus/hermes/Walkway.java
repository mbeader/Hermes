package com.team1ofus.hermes;

import java.awt.Point;

public class Walkway extends Tile implements TileInterface {

	private static final long serialVersionUID = 1L;

	public Walkway(String cellName,Point tilePoint){
		Tile.cellName = cellName;
		Tile.tilePoint = tilePoint;
		Tile.tileType = 0; // 0 means walkway
	}

	public int getTraverseCost() {
		return 5;
	}
	
}