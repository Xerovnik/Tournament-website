package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Invite;

public interface InvitationDAO {
	
	public List<Invite> getAllInvites();
	
	public List<Invite> getInvitesByTournamentId(int id);
	
	public List<Invite> getInvitesByParticipantId(int id);
	
	public List<Invite> getInvitesByHostId(int id);
	
	public void send(Invite newInvite);
	
	public void acceptInvitation(int id);
	
	public void declineInvitation(int id);
	
	public void deleteInvitation(int id);

}
