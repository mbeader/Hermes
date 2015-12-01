package com.team1ofus.hermes;
import java.util.*;

//TODO Comments1
public class SearchReadyEventObject { 
	public SearchReadyEventObject() {
	}
	
	private List<ISearchReadyListener> listeners = new ArrayList<ISearchReadyListener>();
	
	public void addListener(ISearchReadyListener toAdd){
		listeners.add(toAdd);
		}
	public void doSearchReady(Record start, Record destination){
		
		for(ISearchReadyListener UL : listeners){
			DebugManagement.writeNotificationToLog("SearchReady event fired. Listeners will be notified.");
			UL.onSearchReady(start, destination);
		}
	
	}
}