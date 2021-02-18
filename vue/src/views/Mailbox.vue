<template>
  <div class="mailboxContainer">
       <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
    <div class="btn-group">
        <button v-on:click="switchToInbox" v-bind:class="{ selected: inbox }">Inbox</button>
        <button v-on:click="switchToSent" v-bind:class="{ selected: !inbox }">Sent</button>
    </div>
    <div v-if="inbox">
        <h1>Inbox</h1>
        <ul>
            <h3> Invitations/Requests: </h3>
            <li v-for="request in requestsReceivedAsHost" v-bind:key="request.id">
                <InboxItem v-bind:invite="request"/>
            </li>
            <li v-for="request in invitesReceivedAsParticipant" v-bind:key="request.id">
                <InboxItem v-bind:invite="request"/>
            </li>
            <h3> Responses from other users: </h3>
            <!-- Messages -->
            <li v-for="request in requestsSentAsParticipant" v-bind:key="request.id">
                <Message v-bind:invite="request"/>
            </li>
            <li v-for="request in invitesSentAsHost" v-bind:key="request.id">
                <Message v-bind:invite="request"/>
            </li>
         </ul>
    </div>
    <div v-if="!inbox" >
        <h1>Sent</h1>
        <ul>
            <h3> Joins Requested:</h3>
            <li v-for="request in requestsSentAsParticipant" v-bind:key="request.id">
                <InvitationItem v-bind:invite="request"/>
            </li>
            <h3> Invitations Sent:</h3> 
            <li v-for="request in invitesSentAsHost" v-bind:key="request.id">
                <InvitationItem v-bind:invite="request"/>
            </li>
         </ul>
         
    </div>
    
      
  </div>
</template>

<script>
import invitationService from '../services/InvitationService'
import InvitationItem from '../components/InvitationItem.vue'
import InboxItem from '../components/InboxItem.vue'
import Message from '../components/Message.vue'

export default {
    name: "my-tournaments",
    data() {
        return {
            inbox: true,

            // user requests to join a tournament
            requestsSentAsParticipant: [],
            // requests from other users to join hosted tournament
            requestsReceivedAsHost: [],
            // invites recieved from other hosts
            invitesReceivedAsParticipant: [],
            // invites sent as host
            invitesSentAsHost: []
        }
    },
    components:{
        InvitationItem,
        InboxItem,
        Message
    },
    created() {
      invitationService.getInvitesByParticipantId(this.$store.state.user.id).
      then(response => {
        response.data.forEach( (invite) => {
            if (invite.sender === "Participant") {
                this.requestsSentAsParticipant.push(invite);
            }
            else if (invite.sender === "Host") {
                this.invitesReceivedAsParticipant.push(invite);
            }
        });
      });
      invitationService.getInvitesByHostId(this.$store.state.user.id).
      then(response => {
        response.data.forEach( (invite) => {
            if (invite.sender === "Participant") {
                this.requestsReceivedAsHost.push(invite);
            }
            else if (invite.sender === "Host") {
                this.invitesSentAsHost.push(invite);
            }
        });
      });
    },
    methods: {
        switchToInbox() {
            this.inbox = true;
        },
        switchToSent() {
            this.inbox = false;
        }
    }
}
</script>

<style>
.btn-group button {
background-color: #4CAF50; /* Green background */
border: 1px solid green; /* Green border */
color: white; /* White text */
padding: 10px 24px; /* Some padding */
cursor: pointer; /* Pointer/hand icon */
    /* Float the buttons side by side */
display: inline-block;
margin-top: 1rem;
}

/* Clear floats (clearfix hack) */
.btn-group:after {
  content: "";
  clear: both;
  display: table;
}


/* Add a background color on hover */
.btn-group button:hover {
  background-color: #3e8e41;
}

.btn-group .selected {
    font-weight: bold;
    background-color: #3e8e41;;
    border-width: 2px;
    border-color: black;
    border-radius: 3px;
}

.mailboxContainer{
    font-family: 'Syncopate', sans-serif;
    font-size:14px
}

.mailboxContainer h3{
    font-family:Arial, Helvetica, sans-serif;
    font-weight: bold;
    font-size:22px
}

</style>