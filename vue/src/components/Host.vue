<template>
<div>
  {{displayName}}
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
export default {
 name: "host",
  props: {
      tournamentId: Number
  },
  data() {
    return {
      displayName: "Test",
      hostId: Number
    }
  },
  created() {
      tournamentService.getTournamentById(this.tournamentId)
      .then(response => {
          let tournament = response.data;
          this.hostId = tournament.host_id;

          tournamentService.getUserById(this.hostId)
          .then(response => {
            let host = response.data;
            this.displayName = host.displayName;
          });
      });
  }
}
</script>

<style>

</style>