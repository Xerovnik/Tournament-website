package com.techelevator.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.MatchDAO;
import com.techelevator.dao.TournamentDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Match;
import com.techelevator.model.ParticipantsWebObject;
import com.techelevator.model.Tournament;
import com.techelevator.model.User;

@RestController
@CrossOrigin
public class TournamentController {
	
	@Autowired
	TournamentDAO tournamentDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	MatchDAO matchDAO;
	
	@RequestMapping(path="/allTournaments", method=RequestMethod.GET)
	public List<Tournament> getAllTournaments(){
		List<Tournament> allTournaments = tournamentDAO.getAllTournaments();
		return allTournaments;
	};
	
	@RequestMapping(path="/tournaments/{id}", method=RequestMethod.GET)
	public Tournament returnTournamentById(@PathVariable int id) {
		Tournament tournament = tournamentDAO.getTournamentById(id);
		return tournament;
	};
	
	@RequestMapping(path="/editTournament", method=RequestMethod.PUT)
	public void editTournament (@Valid @RequestBody Tournament tournament) {
		tournamentDAO.editTournament(tournament);
	};
	
	@RequestMapping(path="/addTournament", method=RequestMethod.POST)
	public void addTournament (@Valid @RequestBody Tournament tournamentToAdd) {
		tournamentDAO.createTournament(tournamentToAdd);
	};
	
	@RequestMapping(path="/tournament/{id}", method = RequestMethod.DELETE)
	public void deleteTournament (@PathVariable int id) {
		tournamentDAO.deleteTournament(id);
	};
	
	@RequestMapping(path="/user/tournament/{id}", method=RequestMethod.GET)
	public List<User> getUserByTournamentId(@PathVariable int id) {
		return tournamentDAO.getUsersByTournamentId(id);
	};
	
	@RequestMapping(path="/tournament/add", method=RequestMethod.POST)
	public void addParticipants(@Valid @RequestBody ParticipantsWebObject x) {
		// needs an object with an array called "participants" that 
		// holds userId and then tournamentId
		tournamentDAO.addParticipant(x.getParticipants()[0], x.getParticipants()[1]);
		//System.out.println(Arrays.toString(x.getParticipants()));
	};
	
	@RequestMapping(path="/user/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable long id) {
		return userDAO.getUserById(id);
	};
	
	@RequestMapping(path="/user/displayName/{username}", method=RequestMethod.PUT)
	public void addDisplayName (@PathVariable String username, @Valid @RequestBody String displayName) {
		userDAO.addDisplayName(username, displayName);
	};
	
	@RequestMapping(path="tournament/{id}/matches", method=RequestMethod.GET)
	public List<Match> getMatchesByTournamentId(@PathVariable int id) {
		return tournamentDAO.getMatchesByTournamentId(id);
	};
	

	@RequestMapping(path="/tournament/{tournamentId}/{userId}", method = RequestMethod.DELETE)
	public void removeParticipant (@PathVariable int tournamentId, @PathVariable int userId) {
		tournamentDAO.removeParticipant(userId, tournamentId);
	};

	@RequestMapping(path="/user/all")
	public List<User> getAllUsers(){
		return userDAO.findAll();
	};
	
	@RequestMapping(path="/match/add", method=RequestMethod.POST)
	public void addMatch(@Valid @RequestBody Match match) {
		matchDAO.createMatch(match);
	};
	
	@RequestMapping(path="/match/edit", method=RequestMethod.PUT)
	public void editMatch(@Valid @RequestBody Match match) {
		matchDAO.editMatch(match);
	};
	
	@RequestMapping(path="/match/{id}", method = RequestMethod.DELETE)
	public void deleteMatch(@PathVariable int id) {
		matchDAO.deleteMatch(id);
	}
}
