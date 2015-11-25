package com.team1ofus.hermes;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class AStarTest {

	
	@Test // should return the 1 cell.(start and end are the same)
	public void test1() { 
		System.out.println("Test1: should return a path with 1 tile (2,2)");
		PathCell testCell = new PathCell("a",5,5,16, TILE_TYPE.WALL);
		ArrayList<PathCell> testCellList = new ArrayList<PathCell>();
		testCellList.add(testCell);
		AStar test = new AStar(testCellList);
		ArrayList<CellPoint> AStarOut = test.getPath(new CellPoint("a", new Point(2,2)), new CellPoint("a", new Point(2,2)));
		if(AStarOut != null){
			for(CellPoint each:AStarOut){
				System.out.println(each.getPoint());
			}
			fail("shouldnt return a path because the start is a wall");
		}
		else{
			System.out.println("path start is wall");
		}
	}
	
	
	@Test
	public void test2() { // should return path not found, all walls
		System.out.println("test2: should return path from (50,50) to (55,40)");
		PathCell testCell = new PathCell("b",100,100,16, TILE_TYPE.PEDESTRIAN_WALKWAY);
		ArrayList<PathCell> testCellList = new ArrayList<PathCell>();
		testCellList.add(testCell);
		AStar test = new AStar(testCellList);
		System.out.println("Path:");
		ArrayList<CellPoint> AStarOut = test.getPath(new CellPoint("b",new Point(50,50)), new CellPoint("b", new Point(55,40)));
		System.out.println("getPath didnt break");
		if((AStarOut != null) || (AStarOut.size() == 0)){
			for(CellPoint each:AStarOut){
				System.out.println(each.getPoint());
			}
		}
		else{
			fail("A* returned null when it should not have");
		}
	}
	
	
	@Test
	public void test3() { // should return path not found, all walls
		System.out.println("Test 3: should return no path found");
		PathCell testCell = new PathCell("bag'o'schwifty",5,5,32, TILE_TYPE.WALL);
		ArrayList<PathCell> testCellList = new ArrayList<PathCell>();
		testCellList.add(testCell);
		AStar test = new AStar(testCellList);
		ArrayList<CellPoint> AStarOut = test.getPath(new CellPoint("c", new Point(2,2)), new CellPoint("c",new Point(2,3)));
		assertEquals(AStarOut,null);
	}

}