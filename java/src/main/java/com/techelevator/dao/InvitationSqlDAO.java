package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Invite;
import com.techelevator.model.Match;
import com.techelevator.model.User;

@Component
public class InvitationSqlDAO implements InvitationDAO {
	
	private JdbcTemplate template;
	
	public InvitationSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Invite> getAllInvites() {
		String sql = "select * from invites";
		List<Invite> invites = new ArrayList<Invite>();
		
		SqlRowSet results = template.queryForRowSet(sql);
		
		while(results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
        }
		
		return invites;
	}

	@Override
	public List<Invite> getInvitesByTournamentId(int id) {
		String sql = "select * from invites where tournament_id = ?";
		List<Invite> invites = new ArrayList<Invite>();
		
		SqlRowSet results = template.queryForRowSet(sql, id); 
		
		while(results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
            
            
        }
		
		return invites;
	}

	@Override
	public List<Invite> getInvitesByParticipantId(int id) {
		String sql = "select * from invites where participant_id = ?";
		List<Invite> invites = new ArrayList<Invite>();
		
		SqlRowSet results = template.queryForRowSet(sql, id); 
		
		while(results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
            
            
        }
		
		return invites;
	}

	@Override
	public List<Invite> getInvitesByHostId(int id) {
		String sql = "select * " +
				"from invites " +
				"join tournaments on invites.tournament_id = tournaments.tournament_id " +
				"where tournaments.host_id = ?";
		List<Invite> invites = new ArrayList<Invite>();
		SqlRowSet results = template.queryForRowSet(sql, id);

		while(results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
            
        }
		
		return invites;
	}

	@Override
	public void send(Invite newInvite) {
		int tournamenId = newInvite.gettournamentId();
		int participantId = newInvite.getparticipantId();
		String sender = newInvite.getSender();
		
		String sql = "insert into invites (tournament_id, participant_id, sender) values (?,?,?)";
		template.update(sql, tournamenId, participantId, sender);
	}

	@Override
	public void acceptInvitation(int id) {
		String sql = "update invites set status = ? where invite_id = ?";
		template.update(sql, "Accepted", id);
		
	}

	@Override
	public void declineInvitation(int id) {
		String sql = "update invites set status = ? where invite_id = ?";
		template.update(sql, "Declined", id);
		
	}
	
	@Override
	public void deleteInvitation(int id) {
		String sql = "delete from invites where invite_id = ?";
		template.update(sql, id);
	}
	
	private Invite mapRowToInvite(SqlRowSet rs) {
        Invite invite = new Invite();
        invite.setId(rs.getInt("invite_id"));
        invite.settournamentId(rs.getInt("tournament_id"));
        invite.setparticipantId(rs.getInt("participant_id"));
        invite.setSender(rs.getString("sender"));
        invite.setStatus(rs.getString("status"));
        invite.setRead(rs.getBoolean("read"));

        return invite;
    }

}
