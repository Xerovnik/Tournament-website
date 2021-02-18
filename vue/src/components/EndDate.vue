<template>
  <div id="main1">
      <div>
          {{endDate}}
      </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
  name: "endDate",
  props: {
      tournamentId: Number
  },
  data() {
    return {
      endDate: ''
    }
  },
  created() {
      tournamentService.getTournamentById(this.tournamentId)
      .then(response => {
          this.tournament = response.data;
          this.endDate = this.tournament.endDate
      });
  }

}
</script>

<style>

</style>