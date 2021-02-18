package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.InvitationSqlDAO;
import com.techelevator.model.Invite;

@RestController
@CrossOrigin
public class InvitationController {
	
	@Autowired
	InvitationSqlDAO invitationDAO;
	
	@RequestMapping(path="/invites", method=RequestMethod.GET)
	public List<Invite> getAllInvites() {
		List<Invite> invites = invitationDAO.getAllInvites();
		return invites;
	}
	
	@RequestMapping(path="/addInvite", method = RequestMethod.POST)
	public void addInvite (@Valid @RequestBody Invite inviteToAdd) {
		invitationDAO.send(inviteToAdd);
	}
	
	@RequestMapping(path="/tournaments/{id}/invites", method=RequestMethod.GET)
	public List<Invite> getInvitesByTournamentId(@PathVariable int id) {
		List<Invite> invites = invitationDAO.getInvitesByTournamentId(id);
		return invites;
	}
	
	@RequestMapping(path="/participant/{id}/invites", method=RequestMethod.GET)
	public List<Invite> getInvitesByParticipantId(@PathVariable int id) {
		List<Invite> invites = invitationDAO.getInvitesByParticipantId(id);
		return invites;
	}
	
	@RequestMapping(path="/host/{id}/invites", method=RequestMethod.GET)
	public List<Invite> getInvitesByHostId(@PathVariable int id) {
		List<Invite> invites = invitationDAO.getInvitesByHostId(id);
		return invites;
	}
	
	@RequestMapping(path="/acceptInvite/{id}", method=RequestMethod.PUT)
	public void acceptInvite(@PathVariable int id) {
		invitationDAO.acceptInvitation(id);
	}
	
	@RequestMapping(path="/declineInvite/{id}", method=RequestMethod.PUT)
	public void declineInvite(@PathVariable int id) {
		invitationDAO.declineInvitation(id);
	}
	
	@RequestMapping(path="/deleteInvite/{id}", method=RequestMethod.DELETE)
	public void deletInvite(@PathVariable int id) {
		invitationDAO.deleteInvitation(id);
	}

}
