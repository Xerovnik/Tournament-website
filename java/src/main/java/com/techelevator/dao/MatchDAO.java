package com.techelevator.dao;

import com.techelevator.model.Match;

public interface MatchDAO {
	
	public void createMatch(Match newMatch);
	
	public void deleteMatch(int id);
	
	public void editMatch(Match matchToEdit);
}
