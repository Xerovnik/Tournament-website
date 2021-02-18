<template>
  <div id="main1">
      <div>
          {{date}}
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
  name: "date",
  props: {
      tournamentId: Number
  },
  data() {
    return {
      date: ''
    }
  },
  created() {
      tournamentService.getTournamentById(this.tournamentId)
      .then(response => {
          this.tournament = response.data;
          this.date = this.tournament.startDate
      });
  }

}
</script>

<style>

</style>