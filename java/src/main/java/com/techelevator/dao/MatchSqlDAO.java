package com.techelevator.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.Match;
import com.techelevator.model.User;

@Component
public class MatchSqlDAO implements MatchDAO {

	private JdbcTemplate template;
	
	public MatchSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	@Override
	public void createMatch(Match newMatch) {
		int tournamentId = newMatch.getTournamentId();
		int user1 = newMatch.getParticipant1().getId().intValue();
		int user2 = newMatch.getParticipant2().getId().intValue();
		int round = newMatch.getRound();
		
		String sql = "insert into matches (tournament_id, user1, user2, round, winner) values (?,?,?,?,?)";
		template.update(sql, tournamentId, user1, user2, round, null);
	}

	@Override
	public void deleteMatch(int id) {
		String sql = "DELETE from matches WHERE match_id = ?";
		template.update(sql, id);
		
	}

	@Override
	public void editMatch(Match matchToEdit) {
		String sql = "update matches set tournament_id = ?, user1 = ?, user2 = ?, round = ?, winner = ? where match_id = ?";
		template.update(sql, matchToEdit.getTournamentId(), matchToEdit.getParticipant1().getId(), matchToEdit.getParticipant2().getId(), matchToEdit.getRound(), matchToEdit.getWinner().getId(), matchToEdit.getId());
	}

}
