<template>
  <div id="main1">
      <div>
          {{tournamentTime}}
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
  name: "tournamentTime",
  props: {
      tournamentId: Number
  },
  data() {
    return {
      tournamentTime: ''
    }
  },
  created() {
      tournamentService.getTournamentById(this.tournamentId)
      .then(response => {
          this.tournament = response.data;
          this.tournamentTime = this.tournament.time
      });
  }

}
</script>

<style>

</style>