package com.team1ofus.hermes;

import java.util.ArrayList;
import java.awt.Point;

public class AStarMain {
	
	//maps which tiles have been added
	ArrayList<Cell> accessedCells = new ArrayList<Cell>(); 
	
	// Nodes that need to be explored
	ArrayList<Tile> frontier = new ArrayList<Tile>(); 
	
	// Nodes that have already been explored
	ArrayList<Tile> explored = new ArrayList<Tile>();
	
	
	/*
	 * Takes a start Cell "map", start point (the exact tile within a Cell, and the 
	 * end Cell and point.
	 * Returns the fastest path between two points as an ordered list of Tiles
	 */
	public ArrayList<Tile> getPath(Cell startCell, Point startIndex, Cell endCell, Point endIndex){
		Cell currentCell = startCell; //What cell do we start in
		Tile currentTile = getTile(currentCell, startIndex); //The exact tile we start at
		Tile endTile = getTile(endCell, endIndex); // the tile we want to get to
		int costSoFar = 0; //the cost of the best known path so far (not complete until 
						   //A* returns
		int tentativeCSF = 0; //combines the cost so far and the cost to enter a tile
							  //that is being explored
//		int estTotalCost = getHeuristic(currentTile);//the expected path cost from start
													 //to finish based on the best known 
													 //path so far. Starts as just the 
													 //heuristic from start to finish
	
		
		this.frontier.add(currentTile); //the only thing in the frontier to start is the 
										//start node
		
		while(!frontier.isEmpty()){ //so long as the frontier is not empty
			currentTile = frontier.get(0); //the tile we want to explore is the tile with 
										   //the lowest expected path cost
										   //For now its BFS so order doesn't matter
			
			if(currentTile == endTile){ //if we are at the end: 
				return buildPath(endTile); //return the path
			}
			
			if(!(explored.contains(currentTile))){ //if the currentTile isnt already explored
				explored.add(currentTile); // add to explored
			}
			frontier.remove(currentTile); // remove from frontier
			
			 
			for(Tile aNeighbor: currentTile.getNeighbors()){
				if(explored.contains(aNeighbor)){
					continue;
				}
				tentativeCSF = costSoFar + aNeighbor.getTraverseCost();
				if(!frontier.contains(aNeighbor)){
					frontier.add(aNeighbor);
				}
				else if(tentativeCSF >= aNeighbor.getCSF()){
					continue;
				}
			
			aNeighbor.setParent(currentTile);
			aNeighbor.setCSF(tentativeCSF);
			aNeighbor.setETC(tentativeCSF+ getHeuristic(aNeighbor));
			}
		}
		System.out.println("No Path Found");
		return null;
	
	}

	private int getHeuristic(Tile currentTile) {
		return 0;
	}

	private ArrayList<Tile> buildPath(Tile endTile) {
		//maps which tiles have been added
		ArrayList<Tile> path = new ArrayList<Tile>(); 
		
		Tile currentTile = endTile;
		
		while(currentTile.getParent() != null){
			path.add(0, currentTile);
			currentTile = currentTile.getParent();
		}
		return path;
	}

	private Tile getTile(Cell aCell, Point aIndex) {
		return null;
		
		//return startCell.2dArray(startIndex);
	}




}
