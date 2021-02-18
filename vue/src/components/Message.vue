<template>
  <div>
      <div v-if="invite.participantId == $store.state.user.id && invite.status != 'Pending'">
        Your request to join {{tournamentName}} was {{invite.status}}
      </div>
      <div v-if="invite.hostId == $store.state.user.id && invite.status != 'Pending'">
          {{participantDisplayName}} {{invite.status}} your invitation to join {{tournamentName}}
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"

export default {
    name: "inbox-item",
    props: ['invite'],
    data() {
        return {
            tournamentId: Number,
            tournamentName: "",
            participantDisplayName: "",
            hostDisplayName: "",
            hostId: Number
        }
    },

    created() {
        tournamentService.getTournamentById(this.invite.tournamentId).
        then(response => {
            let tournament = response.data;
            this.tournamentId = tournament.id;
            this.tournamentName = tournament.name;
            this.hostId = tournament.host_id;
        });
        tournamentService.getUserById(this.invite.participantId).
        then(response => {
            let user = response.data;
            this.participantDisplayName = user.displayName
        });
        // tournamentService.getUserById(this.hostId).
        // then(response => {
        //     let user = response.data;
        //     this.hostDisplayName = user.displayName
        // });
    }
}
</script>

<style>

</style>