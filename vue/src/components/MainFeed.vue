<template>
  <div id="main-container1">
     <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
    <div id="item-wraper">
    <div>
      <input class="search" type="text" placeholder="Search Tournaments" v-model="filter.name">
    </div>
    <ul class="tournaments">
      <div id = "selector">
        <div class="checkbox">
          <label><input type ="checkbox" v-model="upcomingChecked">Hide Upcoming</label>
          <label><input type ="checkbox" v-model="ongoingChecked">Hide Ongoing</label>
          <label><input type ="checkbox" v-model="closedChecked">Hide Closed</label>
        </div>
      </div>
        <div v-if="!upcomingChecked">
      <li v-for="tournament in upcomingFiltered" v-bind:key="tournament.id">
        <router-link class="link-text" v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
        <br>
        {{tournament.status}}
        <br>
        {{tournament.startDate}} - {{tournament.endDate}}
      </li>
        </div>
        <div v-if="!ongoingChecked">
      <li v-for="tournament in ongoingFiltered" v-bind:key="tournament.id">
        <router-link class="link-text" v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
        <br>
        {{tournament.status}}
        <br>
        {{tournament.startDate}} - {{tournament.endDate}}
      </li>
        </div>
        <div v-if="!closedChecked">
      <li v-for="tournament in closedFiltered" v-bind:key="tournament.id">
        <router-link class="link-text" v-bind:to="{ name: 'tournament-details', params: {id: tournament.id} }"> 
          {{tournament.name}}
        </router-link>
        <br>
        {{tournament.status}}
        <br>
        {{tournament.startDate}} - {{tournament.endDate}}
      </li>
        </div>
    </ul>
  </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
  name: "main-feed",
  data() {
    return {
      filter: {
        name: ""
      },
      tournaments: [],
      upcomingChecked: false,
      ongoingChecked: false,
      closedChecked: false
    }
  },
  created() {
    tournamentService.getTournaments().then(response => {
      this.tournaments = response.data;
    });
  },
  methods: {
    
  },

  computed: {
    filteredList() {
      let filteredTournaments = this.tournaments;
      if (this.filter.name != '') {
        filteredTournaments = filteredTournaments.filter((tournament) =>
        tournament.name.toLowerCase()
        .includes(this.filter.name.toLowerCase()));
      }
      return filteredTournaments;
    },
    upcomingFiltered() {
      let allTournaments = this.tournaments
      let upcomingTournaments= allTournaments.filter((tournament) => {
      if(tournament.status.toLowerCase() == "upcoming"){
        return tournament
      }
     })
     if (this.filter.name != '') {
        upcomingTournaments = upcomingTournaments.filter((tournament) =>
        tournament.name.toLowerCase()
        .includes(this.filter.name.toLowerCase()));
      }
      return upcomingTournaments
    },
    ongoingFiltered() {
      let allTournaments = this.tournaments
      let ongoingTournaments= allTournaments.filter((tournament) => {
      if(tournament.status.toLowerCase() == "ongoing"){
        return tournament
      }
     })
     if (this.filter.name != '') {
        ongoingTournaments = ongoingTournaments.filter((tournament) =>
        tournament.name.toLowerCase()
        .includes(this.filter.name.toLowerCase()));
      }
      return ongoingTournaments
    },
    closedFiltered() {
      let allTournaments = this.tournaments
      let closedTournaments= allTournaments.filter((tournament) => {
      if(tournament.status.toLowerCase() == "closed"){
        return tournament
      }
     })
     if (this.filter.name != '') {
        closedTournaments = closedTournaments.filter((tournament) =>
        tournament.name.toLowerCase()
        .includes(this.filter.name.toLowerCase()));
      }
      return closedTournaments
    }
  },



}
</script>

<style>
#main-container1{
width:100%;  
font-family: 'Syncopate', sans-serif;
}

#item-wraper{
width: 600px;
justify-content: center;
padding-left:2%;
margin-left:auto;
margin-right:auto
}

.search {
  margin:auto;
  width:100%;
  min-height:50px;
  border-radius:10px;
  border-width:1px;
  border-color:#ccc;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 2em;
}
.tournaments {
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
    max-width:100%;
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