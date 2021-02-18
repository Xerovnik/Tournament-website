import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getTournaments() {
        return http.get('/allTournaments')
    },

    getParticipantsByTournamentId(id) {
        return http.get(`/user/tournament/${id}`);
    },

    getUserById(id) {
        return http.get(`/user/${id}`);
    },

    getTournamentById(id){
        return http.get(`/tournaments/${id}`)
    },

    addDisplayName(username, user) {
        return http.put(`/user/displayName/${username}`, user.displayName)
    },

    getMatchesByTournamentId(id) {
        return http.get(`/tournament/${id}/matches`);
    },

    removeParticipant(userId, tournamentId) {
        return http.delete(`/tournament/${tournamentId}/${userId}`);
    },

    getAllUsers(){
        return http.get('/user/all')
    },
    
    addTournament(tournament){
        return http.post('/addTournament', tournament);
    },

    // see tournamentController for proper usage of webObject
    addParticipants(webObject) {
        return http.post('tournament/add', webObject);
    },

    addMatch(match){
        return http.post('/match/add', match)
    },

    editMatch(match){
        return http.put('/match/edit', match)
    },

    deleteMatch(id){
        return http.delete(`/match/${id}`)
    },

    editTournament(tournament){
        return http.put('/editTournament', tournament)
    }

}