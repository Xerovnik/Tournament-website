<template>
  <div>
      <div v-if="invite.sender == 'Participant'">
          {{participantDisplayName}} requested to join 
          <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournamentId} }"> 
            {{tournamentName}}
        </router-link>
        <div v-if="invite.status == 'Pending'">
            <button v-on:click="accept" class="inviteButton">Accept</button>
            <button v-on:click="decline" class="inviteButton">Decline</button>
        </div>
        <div v-if="invite.status != 'Pending'" 
        v-bind:class="{ accepted: invite.status == 'Accepted' }">
            <p>You have {{invite.status}} this request</p>
        </div>
      </div>

      <div v-if="invite.sender == 'Host'">
          You have been invited to join 
          <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournamentId} }"> 
            {{tournamentName}}
        </router-link>
        <div v-if="invite.status == 'Pending'">
            <button v-on:click="accept" class="inviteButton">Accept</button>
            <button v-on:click="decline" class="inviteButton">Decline</button>
        </div>
        <div v-if="invite.status != 'Pending'" 
        v-bind:class="{ accepted: invite.status == 'Accepted' }">
            <p>You have {{invite.status}} this invite</p>
        </div>
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
import invitationService from "@/services/InvitationService.js"

export default {
    name: "inbox-item",
    props: ['invite'],
    data() {
        return {
            tournamentId: Number,
            tournamentName: "",
            participantDisplayName: "",
            hostDisplayName: "",
            numParticipants: Number,
            maxParticipants: Number

        }
    },

    created() {
        tournamentService.getTournamentById(this.invite.tournamentId).
        then(response => {
            let tournament = response.data;
            this.tournamentId = tournament.id;
            this.tournamentName = tournament.name;
            this.numParticipants = tournament.participants.length;
            this.maxParticipants = tournament.maxParticipants;
        });
        tournamentService.getUserById(this.invite.participantId).
        then(response => {
            let user = response.data;
            this.participantDisplayName = user.displayName
        });
    },
    methods: {
        addParticipant() {
            let webObject = {participants: [this.invite.participantId, this.tournamentId]};
            tournamentService.addParticipants(webObject).
            then(response => {
                if (response.status == 200 || response.status == 201) {
                    alert("Request Accepted");
                    return true;
                }
                else {
                    alert("Error adding participant");
                    return false;
                }
            });
        },
        accept() {
            if (this.numParticipants < this.maxParticipants) {
                let re = confirm("Are you sure you want to accept?");
                if (re) {
                    invitationService.acceptInvite(this.invite.id).
                    then(response => {
                    if (response.status === 200) {
                            
                            this.addParticipant();
                            this.$router.go();
                            
                        }
                        else {
                            alert("There was an error");
                        }
                });
            }
            }
            else {
                alert("Error: tournament is full");
            }
            
        },
        decline() {
            let re = confirm("Are you sure you want to decline?");
            if (re) {
                invitationService.declineInvite(this.invite.id).
                then(response => {
                    if (response.status === 200) {
                        alert("Request Declined");
                        this.$router.go();
                    }
                    else {
                        alert("There was an error");
                    }
                });
            }
        }
    }
}
</script>

<style>

</style>