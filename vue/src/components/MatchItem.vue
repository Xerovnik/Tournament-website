<template>
  <div class="matchItem">
      <h3>{{match.participant1.displayName}} vs. {{match.participant2.displayName}}</h3>
      <div v-if="match.winner.id == 0">
          <h3>Who Won?</h3>
          <button v-on:click="declareWinner(match.participant1)" class="inviteButton">{{match.participant1.displayName}}</button>
          <button v-on:click="declareWinner(match.participant2)" class="inviteButton">{{match.participant2.displayName}}</button>
      </div>
      <div v-else>
          <p v-if="!isWinner">Winner: {{match.winner.displayName}}</p>
          <h4 class="winningUser" v-if="isWinner">Winner of the Tournament: {{match.winner.displayName}}</h4>
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
    name: "match-item",
    props: ['match', 'maxParticipants'],
    data() {
        return {
            tournament: []
        }
    },
    computed: {
        isWinner() {
            if (this.maxParticipants == 2 && this.match.round === 1) {
                return true;
            }
            else if (this.maxParticipants == 4 && this.match.round === 2) {
                return true;
            }
            else if (this.maxParticipants == 8 && this.match.round === 3) {
                return true;
            }
            else if (this.maxParticipants == 16 && this.match.round === 4) {
                return true;
            }
            return false;
        }
        
    },
    methods: {
        declareWinner(participant) {
            let editedMatch = this.match;
            let par1 = this.match.participant1.id;
            let par2 = this.match.participant2.id;
            let winnerId = participant.id;
            editedMatch.participant1 = {id: par1};
            editedMatch.participant2 = {id: par2};
            editedMatch.winner = {id: winnerId};

            tournamentService.editMatch(editedMatch).then(response => {
                if (response.status != 200 && response.status != 201) {
                    alert("There was an error");
                }
                else {
                    if (this.isWinner) {
                        alert(participant.displayName + " wins the tournament!");
                        this.closeTournament();
                    }
                }
            })
            .catch (error => {
            if (error.response) console.log(error.response);
            else if (error.request) console.log(error.request);
            })
        
        },
        closeTournament() {
            tournamentService.getTournamentById(parseInt(this.$route.params.id))
            .then(response => {
                let tournament = response.data;

                let newTournament = tournament;
                newTournament.status = "Closed";
                newTournament.participants = [];
                tournamentService.editTournament(newTournament).then(response => {
                    if (response.status != 200 && response.status != 201) {
                        alert("There was an error");
                    }
                    else {
                        this.$router.go();
                    }
                })
                .catch (error => {
                if (error.response) console.log(error.response);
                else if (error.request) console.log(error.request);
                });
            });
            
        }
    }

}

</script>

<style>
.matchItem {

}

.winningUser {
    font-weight: bolder;
}

</style>