<script>
import tournamentService from "@/services/TournamentService.js"
export default {
    name: "my-tournaments",
    data() {
        return {
            filter: {
                user_id: this.$store.state.user.id
            },
            tournaments:[],

            filteredTournaments:[],

            filteredHosted:[],

            isLoading: true
        }
    },
    created() {
        tournamentService.getTournaments().then(response => {
            this.tournaments = response.data;
            let participants = []
            let unfilteredTournaments = this.tournaments;
            unfilteredTournaments.forEach( (tournament) => {
                tournamentService.getParticipantsByTournamentId(tournament.id).then(response => {
                    this.isLoading = false
                    participants = response.data
                    participants.forEach((participant) => {
                        //console.log(participant.id)
                        //console.log(this.filter.user_id)
                        if (participant.id == this.filter.user_id){
                            this.filteredTournaments.push(tournament)
                        //console.log(tournament)
                        //console.log(filteredTournaments)
                    }
                    })
                })
            })
            
            unfilteredTournaments.forEach( (tournament) => {
               
                        if (tournament.host_id == this.filter.user_id){
                            this.filteredHosted.push(tournament)
                        
                    }
                    })
                })
    },
    methods: {
        
    },

    computed: {
       
    }

}
</script>
<template>
<div class="myTournamentsContainer">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
  <h1>My Tournaments</h1>
  <br>
        <div v-if="!this.isLoading">
  <h3> Hosting:</h3>
  <br>
  <ul class="tournaments">
      <li v-for="tournament in this.filteredHosted" v-bind:key="tournament.id" class="myTournamentsList">
          <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }" class="link-text2"> 
          {{tournament.name}}
        </router-link>
        <br>
        {{tournament.status}}
        <br>
        {{tournament.startDate}} - {{tournament.endDate}}
      </li>
  </ul>
  <h3> Participating:</h3>
  <ul class="tournaments">
      <li v-for="tournament in this.filteredTournaments" v-bind:key="tournament.id">
          <router-link v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
        <br>
        {{tournament.status}}
        <br>
        {{tournament.startDate}} - {{tournament.endDate}}
      </li>
  </ul>
    </div>
</div>
</template>


<style scoped>
.myTournamentsContainer{
    font-family: 'Syncopate', sans-serif;
}

.link-text2{
    font-family:Arial, Helvetica, sans-serif;
    font-size:14pt
}
.myTournamentsList{
    font-size:10pt
}.tournaments {
  counter-reset: gradient-counter;
  list-style: none;
  margin: 1.75rem auto;
  padding-left: 0rem;
}
.tournaments li {
    background: white;
    border-radius: 1rem;
    counter-increment: gradient-counter;
    margin-top: 0rem;
    margin-bottom: 1rem;
    min-height: 3rem;
    padding: 1rem 1rem 1rem 0rem;
    position: relative;
    max-width:20%;
    border-top: solid darkgray 1px; 
    text-align: center;   
    
}
  .link-text{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 1.5em;
    font-weight: bold;
    color:black;
    text-decoration: none;
    
  } 

  a{
    color:black;
    text-decoration:none;
  }
  a:hover{
    color:#ccc;
  }

  input {
    
    border: 0px solid;
}

input:focus {
    outline: none;
    border-color: #9ecaed;
    box-shadow: 0 0 10px #9ecaed;
}
</style>