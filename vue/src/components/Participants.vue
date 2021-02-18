<template>
<div id="main1">
<ul class="numbered">
<li v-for="participant in participants" v-bind:key="participant.id">
{{participant.displayName}}
</li>
</ul>
</div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
name: "participants",
props: {
tournamentId: Number
},
data() {
return {
participants: []
}
},
created() {
tournamentService.getParticipantsByTournamentId(this.tournamentId)
.then(response => {
this.participants = response.data;
});
}

}
</script>

<style>
.numbered {
list-style-type: decimal;
}

</style>