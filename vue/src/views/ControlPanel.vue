<template>
  <div class="controlPanel">
      <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
    
    <router-link v-bind:to="{ name: 'tournament-details', params: {id: parseInt($route.params.id)}}">
        <button class="myButton">
            Back to Tournament
        </button>
    </router-link>

      <h2 v-if="round4List.length > 0">Round 4</h2>
      <div v-for="match in round4List" v-bind:key="match.id">
          <MatchItem v-bind:match="match" v-bind:maxParticipants="maxParticipants" />
      </div>

      <h2 v-if="round3List.length > 0">Round 3</h2>
      <div v-for="match in round3List" v-bind:key="match.id">
          <MatchItem v-bind:match="match" v-bind:maxParticipants="maxParticipants" />
      </div>

      <h2 v-if="round2List.length > 0">Round 2</h2>
      <div v-for="match in round2List" v-bind:key="match.id">
          <MatchItem v-bind:match="match" v-bind:maxParticipants="maxParticipants" />
      </div>

      <h2 v-if="round1List.length > 0">Round 1</h2>
      <div v-for="match in round1List" v-bind:key="match.id">
          <MatchItem v-bind:match="match" v-bind:maxParticipants="maxParticipants" />
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";
import MatchItem from "@/components/MatchItem.vue";

export default {
    name: "control-panel",
    components: {
        MatchItem
    },
    data() {
        return {
            matches: [],
            maxParticipants: Number,
        }
    },
    computed: {
        round1List() {
            let round1 = this.matches.filter((match) => {
                if (match.round == 1) return match;
            });

            return round1;
        },
        round2List() {
            if (this.round1List.length === 0 || !this.roundDone(this.round1List)) return [];
            let round2 = this.matches.filter((match) => {
                if (match.round == 2) return match;
            });
            if (round2.length != 0 && round2[0].participant1.id === 0) {
                this.newRound(1);
            }

            return round2;
        },
        round3List() {
            if (this.round2List.length === 0 || !this.roundDone(this.round2List)) return [];
            let round3 = this.matches.filter((match) => {
                if (match.round == 3) return match;
            });
            if (round3.length != 0 && round3[0].participant1.id === 0) {
                this.newRound(2);
            }

            return round3;
        },
        round4List() {
            if (this.round3List.length === 0 || !this.roundDone(this.round3List)) return [];
            let round4 = this.matches.filter((match) => {
                if (match.round == 4) return match;
            });
            if (round4.length != 0 && round4[0].participant1.id === 0) {
                this.newRound(3);
            }

            return round4;
        }
    },
    created() {
        tournamentService.getMatchesByTournamentId(parseInt(this.$route.params.id))
        .then(response => {
            this.matches = response.data;
            this.matches.forEach((match) => {
                console.log(match.round);
            })
            
        });

        tournamentService.getTournamentById(parseInt(this.$route.params.id))
      .then(response => {
          let tournament = response.data;
          this.maxParticipants = tournament.maxParticipants
      });


        // if (this.roundDone(this.round1List) && this.round2List[0].participant1.id === 0) {
        //     this.newRound(1);
        // }
        
    },
    methods: {
        roundDone(roundList) {
            let bool = true;
            roundList.forEach((match) => {
                if (match.winner.id == 0) bool = false; 
            });

            return bool;
        },
        newRound(prevRound) {
            let oldRound = this.matches.filter( (match) => {
                if (match.round === prevRound) {
                    return match;
                }
            });
            let newRound = this.matches.filter( (match) => {
                if (match.round === prevRound + 1) {
                    return match;
                }
            });

            let i = 0;
            newRound.forEach( (newMatch) => {
                let par1 = oldRound[i].winner.id;
                let par2 = oldRound[i + 1].winner.id;
                newMatch.participant1 = {id: par1};
                newMatch.participant2 = {id: par2};
                newMatch.winner = {id: 0}
                i=i+2;

                tournamentService.editMatch(newMatch).then(response => {
                    if (response.status != 200 && response.status != 201) {
                        alert("There was an error");
                    }
                })
                .catch (error => {
                if (error.response) console.log(error.response);
                else if (error.request) console.log(error.request);
                });
            });

            this.$router.go();

            
        }
    }

}

// computed match lists by round

// create a method that creates a new match

</script>




<style>

.controlPanel{
    font-family: 'Syncopate', sans-serif;
}

</style>