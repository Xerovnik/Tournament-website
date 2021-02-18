package com.techelevator.model;

public class Invite {
	private int id;
	private int tournamentId;
	private int participantId;
	private String sender;
	private String status;
	private boolean read;
	
	
	public Invite() {};
	
	public Invite(int tournamentId, int participantId, String sender) {
		this.tournamentId = tournamentId;
		this.participantId = participantId;
		this.sender = sender;
	}
	
	public Invite(int id, int tournamentId, int participantId, String sender, String status, boolean read) {
		this.id = id;
		this.tournamentId = tournamentId;
		this.participantId = participantId;
		this.sender = sender;
		this.status = status;
		this.read = read;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int gettournamentId() {
		return tournamentId;
	}

	public void settournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}

	public int getparticipantId() {
		return participantId;
	}

	public void setparticipantId(int participantId) {
		this.participantId = participantId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
	
	

}
