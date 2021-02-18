<template>
  <div id="main1">
      <div>
          {{status}}
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
  name: "status",
  props: {
      tournamentId: Number
  },
  data() {
    return {
      status: ''
    }
  },
  created() {
      tournamentService.getTournamentById(this.tournamentId)
      .then(response => {
          this.tournament = response.data;
          this.status = this.tournament.status
      });
  }

}
</script>

<style>

</style>