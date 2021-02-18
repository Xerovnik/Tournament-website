<template>
  <div class="createTournamentContainer">
        <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
     <h1>
         Create New Tournament
     </h1> 
     <form v-on:submit.prevent="addNewTournament">
         <div class="form-element">
             <label for="name">Tournament Name:</label>
             <input type="text" v-model="newTournament.name" required/>
             </div>
         <div class="form-element">
             <label for="Start Date">Start Date:</label>
             <input type="date" v-model="newTournament.startDate" required/>
             </div>     
        <div class="form-element">
             <label for="Participants">Number of Participants:</label>
             <select id="participants" name="participants" v-model="newTournament.maxParticipants" required>
                <option value=2>2</option>
                <option value=4>4</option>
                <option value=8>8</option>
                <option value=16>16</option>
             </select>
        </div>
             <input type="submit" value="Save" class="inviteButton"/>
             <input type="button" value="Cancel" v-on:click.prevent="resetForm" class="inviteButton"/>
    </form>
  </div>
</template>

<script>
import tournamentService from '../services/TournamentService.js'
export default {
name: "create-tournament",
data() {
    return {
        newTournament: {
            name:'',
            host_id: this.$store.state.user.id,
            startDate:'',
            participants: [],
            status: '',
            maxParticipants:''


        }
    }
},
methods: {
    formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
},
    addNewTournament(){
        let currentDate = new Date();
        currentDate = this.formatDate(currentDate)
        if(this.newTournament.startDate <= currentDate){
            window.alert('Please enter valid start date (at least one day after date of creation)')
        }
        else {
            this.newTournament.status = "Upcoming"
        tournamentService.addTournament(this.newTournament).then(
            () => {
                window.alert('Tournament added successfully');
                this.newTournament ={};
                this.$router.push({name: 'home'});
            }
        )
        }

    },
    resetForm(){
        this.newTournament = {};
    },
}
}
</script>

<style>
.createTournamentContainer {
    font-family: 'Syncopate', sans-serif;
}
div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
#participants {
    margin-bottom: 5rem;
}
</style>