package com.techelevator.model;

public class Match implements Comparable<Match>{
	private Integer id;
	private int tournamentId;
	private User participant1;
	private User participant2;
	private int round;
	private User winner;
	
	public Match() {this.winner = null;}
	
	public Match(Integer id, int tournamentId, User participant1, User participant2, int round, User winner) {
		this.id = id;
		this.tournamentId = tournamentId;
		this.participant1 = participant1;
		this.participant2 = participant2;
		this.round = round;
		this.winner = winner;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	public User getParticipant1() {
		return participant1;
	}
	public void setParticipant1(User participant1) {
		this.participant1 = participant1;
	}
	public User getParticipant2() {
		return participant2;
	}
	public void setParticipant2(User participant2) {
		this.participant2 = participant2;
	}
	public int getRound() {
		return this.round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public User getWinner() {
		return this.winner;
	}
	public void setWinner(User winner) {
		this.winner = winner;
	}

	@Override
	public int compareTo(Match o) {
		return this.getId().compareTo(o.getId());
	}
	
	

}
