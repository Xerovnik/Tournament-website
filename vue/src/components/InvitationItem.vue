<template>
  <div>
    <div v-if="invite.sender == 'Participant'">
        <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournamentId} }"> 
            {{tournamentName}}
        </router-link>
        <p>Status: {{invite.status}}</p>
        <div v-if="invite.status == 'Pending'">
            <button v-on:click="cancel" class="inviteButton">Cancel Request</button>
        </div>
    </div>

    <div v-if="invite.sender == 'Host'">
        You invited {{participantDisplayName}} to participate in
        <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournamentId} }"> 
            {{tournamentName}}
        </router-link>
        <p>Status: {{invite.status}}</p>
        <div v-if="invite.status == 'Pending'">
            <button v-on:click="cancel" class="inviteButton">Cancel Request</button>
        </div>
    </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
import invitationService from "@/services/InvitationService.js"

export default {
    name: "invitation-item",
    props: ['invite'],
    data() {
        return {
            tournamentId: Number,
            tournamentName: "",
            participantDisplayName: ""
        }
    },

    created() {
        tournamentService.getTournamentById(this.invite.tournamentId).
        then(response => {
            let tournament = response.data;
            this.tournamentId = tournament.id;
            this.tournamentName = tournament.name;
        });
        tournamentService.getUserById(this.invite.participantId).
        then(response => {
            let user = response.data;
            this.participantDisplayName = user.displayName;
        })
    },
    methods: {
        cancel() {
            let response = confirm("Are you sure you want to cancel?");
            if (response) {
                invitationService.removeInvite(this.invite.id).
                then(response => {
                    if (response.status === 200) {
                        alert("Cancel Successful");
                        this.$router.go();
                    }
                    else {
                        alert("Deletion Error");
                    }
                });
            }
        }
    }


}
</script>

<style>

</style>