package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Match;
import com.techelevator.model.Tournament;
import com.techelevator.model.User;

public interface TournamentDAO {
	
	public List<User> getUsersByTournamentId(int tournamentId);
	
	public List<Match> getMatchesByTournamentId(int tournamentId);
	
	public List<Tournament> getAllTournaments();
	
	public Tournament getTournamentById(int id);
	
	//possibly implement later:
	//public Tournament getTournamentByName(String name);
	
	public void createTournament(Tournament newTournament);
	
	public void editTournament(Tournament tournamentToEdit);
	
	public void deleteTournament(int id);
	
	public void addParticipant(long participantId, int tournamentId);
	
	public void removeParticipant(long participantId, int tournamentId);
}
