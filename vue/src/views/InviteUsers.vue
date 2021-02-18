<template>
<div class="inviteContainer">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
  <h1>Invite Users To {{tournament.name}}</h1>
    <ul>
        <li v-for="user in uninvitedList" v-bind:key="user.id">
            {{user.displayName}} 
            <span v-if="participantIds.includes(user.id)"> (Already a participant) </span>
            <button v-if="!participantIds.includes(user.id) && tournament.host_id != user.id" v-on:click="sendInvite(user)" class="inviteButton">Invite</button>
        </li>
    </ul>
    <h3 v-if="participants.length != 0">Already Participants: </h3>
    <ul>
        <li v-for="participant in participants" v-bind:key="participant.id">
            {{participant.displayName}} 
        </li>
    </ul>
    <h3 v-if="invitedList.length != 0">Already Invited: </h3>
    <ul>
        <li v-for="user in invitedList" v-bind:key="user.id">
            {{user.displayName}} 
        </li>
    </ul>
    <h3 v-if="requestedList.length != 0">Requested to Join (View Inbox to Accept/Decline): </h3>
    <ul>
        <li v-for="user in requestedList" v-bind:key="user.id">
            {{user.displayName}} 
        </li>
    </ul>
</div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js"
import invitationService from "@/services/InvitationService.js"
export default {
    name: "invite-users",
    data() {
        return{

            tournament: [],
            users: [],
            participants: [],
            status: "",
            participantIds: [],
            invites: [],
            usersWithoutHost:[]
        }
    },
    created(){
        tournamentService.getTournamentById(this.$route.params.id).then(response =>{
            this.tournament = response.data;
            this.participants = this.tournament.participants;
            this.status = this.tournament.status
            this.participants.forEach((participant) =>{
                this.participantIds.push(participant.id)
            })
        }),

        tournamentService.getAllUsers().then(response =>{
            this.users = response.data;
            this.usersWithoutHost = this.users.filter((user) => {
                if (user.id != this.$store.state.user.id){
                    return user
                }
            })
        }),
        invitationService.getInvitesByTournamentId(parseInt(this.$route.params.id)).then(
        response => {
            this.invites = response.data;
        }
         );
    },
    computed: {
        canInvite() {
            let bool = true; 
      if (this.tournament.status != "upcoming") {
          bool = false
          }

      return bool;
        },
        invitedList() {
            let invitedList = [];
            // for (let i = 0; i < this.users.length; i++) {
            //    this.invites.forEach((invite) => {
            //         if (invite.participantId === this.user[i].id) {
            //             if (invite.status === "Pending" && invite.sender === "Host") {
            //                 invitedList.push(this.user[i]);
            //             }
            //         }
            //     }) 
            // }
            this.usersWithoutHost.forEach((user) => {
                this.invites.forEach((invite) => {
                    if (invite.participantId === user.id) {
                        if (invite.status === "Pending" && invite.sender === "Host") {
                            invitedList.push(user);
                        }
                    }
                })
            }) 
            return invitedList;
        },
        requestedList() {
            let requestedList = [];
            this.usersWithoutHost.forEach((user) => {
                this.invites.forEach((invite) => {
                    if (invite.participantId === user.id) {
                        if (invite.status === "Pending" && invite.sender === "Participant") {
                            requestedList.push(user);
                        }
                    }
                })
            }) 
            return requestedList;

        },
        uninvitedList() {
            let uninvitedList = [];
            this.usersWithoutHost.forEach((user) => {
                let canInvite = true;
                this.invites.forEach((invite) => {
                    if (invite.participantId === user.id) {
                        canInvite = false;
                    }
                })
                this.participants.forEach((participant) => {
                    if (participant.id === user.id) {
                        canInvite = false;
                    }
                })
                if (canInvite) uninvitedList.push(user);
            }) 
            return uninvitedList;
        }
    },
    methods:{

        sendInvite(user) {
            
          let request = {tournamentId:this.$route.params.id, participantId: user.id, sender: "Host"};
          invitationService.sendInvite(request).then(response => {
            if (response.status == 200 || response.status == 201) {
                alert("Request Sent");
                this.$router.go();
              }
              
          })
          .catch(error => {
              console.error(error);
          });
        }
    }
}
</script>

<style>
.inviteContainer {
    font-family: 'Syncopate', sans-serif;
}

.inviteButton {
	box-shadow: 3px 4px 0px 0px #899599;
	background:linear-gradient(to bottom, #ededed 5%, #bab1ba 100%);
	background-color:#ededed;
	border-radius:15px;
	border:1px solid #d6bcd6;
	display:inline-block;
	cursor:pointer;
	color:#3a8a9e;
	font-family:Arial;
	font-size:17px;
	padding:3px 8px;
	text-decoration:none;
	text-shadow:0px 1px 0px #e1e2ed;
    margin-bottom:0.5rem
}
.inviteButton:hover {
	background:linear-gradient(to bottom, #bab1ba 5%, #ededed 100%);
	background-color:#bab1ba;
}
.inviteButton:active {
	position:relative;
	top:1px;
}

</style>