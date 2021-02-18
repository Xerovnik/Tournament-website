import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getInvites() {
        return http.get('/invites')
    },

    getInvitesByTournamentId(id) {
        return http.get(`/tournaments/${id}/invites`);
    },

    getInvitesByParticipantId(id) {
        return http.get(`/participant/${id}/invites`);
    },

    getInvitesByHostId(id) {
        return http.get(`/host/${id}/invites`);
    },

    sendInvite(invite) {
        return http.post('/addInvite', invite)
    },

    acceptInvite(inviteId) {
        return http.put(`/acceptInvite/${inviteId}`)
    },

    declineInvite(inviteId) {
        return http.put(`/declineInvite/${inviteId}`)
    },

    removeInvite(inviteId) {
        return http.delete(`/deleteInvite/${inviteId}`)
    }
}