package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private int id;
	private List<User> participants = new ArrayList<User>();
	private int host_id;
	private String status;
	private int maxParticipants;
	
	public Tournament(String name, LocalDate startDate, LocalDate endDate, int id, int host_id, String status, List<User> participants,
				int maxParticipants) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.id = id;
		this.host_id = host_id;
		this.status = status;
		this.participants = participants;
		this.maxParticipants = maxParticipants;
	}

	public List<User> getParticipants() {
		return participants;
	}
	
	
	public void setListOfUsers(List<User> participants) {
		this.participants = participants;
	}

	public Tournament() {
	}


	public int getHost_id() {
		return host_id;
	}


	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}


	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	};
	
	
	
	
	
}

