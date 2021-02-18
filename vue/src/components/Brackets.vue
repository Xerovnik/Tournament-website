<template>
  <div>
  <div id="grid-container">
  <div id=""></div>
  <div id="line1" style="margin-left:auto; margin-right:auto;"></div>
  <div id="line2" style="margin-left:auto; margin-right:auto;"></div>
  <div id="line3" style="margin-left:auto; margin-right:auto;"></div>
  <div id="line4" style="margin-left:auto; margin-right:auto;"></div>
  <div id="line5"></div>
  <div id="line6"></div>
  <div id="line7"></div>
  <div id="line8"></div>
  <div id="line9"></div>
  <div id="line10"></div>
  <div id="line11"></div>
  <div id="line12"></div>
  <div id="line13"></div>
  <div id="line14"></div>
  
  
  </div>
  </div>
</template>

<script>
import tournamentService from "@/services/TournamentService.js";

export default {
    name: "brackets",

    props: {
      tournamentId: Number,
      winnerName: String
  },

  data() {
    return {
      participants: [],
      matches:[],
      maxParticipants: Number,
      round1:[],
      round2:[],
      round3:[],
      round4:[]
    }
  },
    methods:{
        
        slotUser(match, divNumber){
            let container = document.getElementById("grid-container");
            let setDiv = document.createElement("div");

            setDiv.setAttribute("style", "grid-area:grid"+(divNumber)+";  height:100%; vertical-align:middle;  background-color:white; border-radius:5px;  padding-top: 15px;  min-width:150px;");
                   container.appendChild(setDiv);
                 

                   let participantA = document.createElement("p");
                   let textA = document.createElement("span");
                   let participantB = document.createElement("p");
                   let textB = document.createElement("span");
                   setDiv.appendChild(participantA);
                   participantA.appendChild(textA);
                   textA.innerText = match.participant1.displayName;
                   setDiv.appendChild(participantB);
                   participantB.appendChild(textB);
                   textB.innerText = match.participant2.displayName;

                   console.log(this.finalRound);

                   if (match.winner.id == 0) {
                        participantA.setAttribute("style", "color:black");
                        textA.setAttribute("style", "color:black");

                        participantB.setAttribute("style", "color:black");
                        textB.setAttribute("style", "color:black");
                   }
                   else {
                       if (match.participant1.displayName !== match.winner.displayName){
                            participantA.setAttribute("style", "text-decoration:line-through; color:darkred;");
                            textA.setAttribute("style", "color:black;");

                        } else{
                            participantA.setAttribute("style", "color:black");
                            textA.setAttribute("style", "color:black");

                            // winner attributes
                            if (match.participant1.displayName === this.winnerName && match.round === this.finalRound) {
                                textA.setAttribute("style", "color:red;");
                            }
                        }

                        if (match.participant2.displayName !== match.winner.displayName){
                            participantB.setAttribute("style", "text-decoration:line-through; color:darkred;");
                            textB.setAttribute("style", "color:black");
                        } else{
                            participantB.setAttribute("style", "color:black");
                            textB.setAttribute("style", "color:black");

                            // winner attributes
                            if (match.participant2.displayName === this.winnerName && match.round === this.finalRound) {
                                textB.setAttribute("style", "color:red;");
                            }
                        }
                   }

                   
        }
    },
    created(){
        tournamentService.getParticipantsByTournamentId(this.tournamentId)
      .then(response => {
          this.participants = response.data;            

            
            
      });

      tournamentService.getTournamentById(this.tournamentId)
      .then(response => {
          this.maxParticipants = response.data.maxParticipants;
      });

        tournamentService.getMatchesByTournamentId(this.tournamentId)
      .then(response => {
          this.matches = response.data;


            for(let i = 0; i < this.matches.length; i++){
                if(this.matches[i].round === 1){
                    this.round1.push(this.matches[i])
                }
            if(this.maxParticipants > 2){
                

                
              if(this.matches[i].round === 2){
                    this.round2.push(this.matches[i])
                }

            }
            if(this.maxParticipants > 4){
                

                
              if(this.matches[i].round === 3){
                    this.round3.push(this.matches[i])
                }
                
            }

            if(this.maxParticipants > 8){
                  
                if(this.matches[i].round === 4){
                    this.round4.push(this.matches[i])
                    }
                
            }
            
        

        }



            if (this.maxParticipants !== 2 && this.maxParticipants !== 4 && this.maxParticipants !== 8 && this.maxParticipants !== 16) {

                let line1 = document.getElementById("line1")
                let line2 = document.getElementById("line2")
                let line3 = document.getElementById("line3")
                let line4 = document.getElementById("line4")
                let line5 = document.getElementById("line5")
                let line6 = document.getElementById("line6")
                let line7 = document.getElementById("line7")
                let line8 = document.getElementById("line8")
                let line9 = document.getElementById("line9")
                let line10 = document.getElementById("line10")
                let line11 = document.getElementById("line11")
                let line12 = document.getElementById("line12")
                let line13 = document.getElementById("line13")
                let line14 = document.getElementById("line14")
                line1.setAttribute("style", "border-width:0px; margin:0px;")
                line2.setAttribute("style", "border-width:0px; margin:0px;")
                line3.setAttribute("style", "border-width:0px; margin:0px;")
                line4.setAttribute("style", "border-width:0px; margin:0px;")

                line5.setAttribute("style", "border-width:0px;")
                line6.setAttribute("style", "border-width:0px;")
                line7.setAttribute("style", "border-width:0px;")
                line8.setAttribute("style", "border-width:0px;")

                line9.setAttribute("style", "border-width:0px;")
                line10.setAttribute("style", "border-width:0px;")
                line11.setAttribute("style", "border-width:0px;")
                line12.setAttribute("style", "border-width:0px;")
                line13.setAttribute("style", "border-width:0px;")
                line14.setAttribute("style", "border-width:0px;")


            }


            let i = 1;
            if (this.maxParticipants === 2) {

                let line1 = document.getElementById("line1")
                let line2 = document.getElementById("line2")
                let line3 = document.getElementById("line3")
                let line4 = document.getElementById("line4")
                line1.setAttribute("style", "border-width:0px; margin:0px;")
                line2.setAttribute("style", "border-width:0px; margin:0px;")
                line3.setAttribute("style", "border-width:0px; margin:0px;")
                line4.setAttribute("style", "border-width:0px; margin:0px;")
                let line5 = document.getElementById("line5")
                let line6 = document.getElementById("line6")
                let line7 = document.getElementById("line7")
                let line8 = document.getElementById("line8")
                line5.setAttribute("style", "border-width:0px;")
                line6.setAttribute("style", "border-width:0px;")
                line7.setAttribute("style", "border-width:0px;")
                line8.setAttribute("style", "border-width:0px;")
                let line9 = document.getElementById("line9")
                let line10 = document.getElementById("line10")
                let line11 = document.getElementById("line11")
                let line12 = document.getElementById("line12")
                let line13 = document.getElementById("line13")
                let line14 = document.getElementById("line14")
                line9.setAttribute("style", "border-width:0px;")
                line10.setAttribute("style", "border-width:0px;")
                line11.setAttribute("style", "border-width:0px;")
                line12.setAttribute("style", "border-width:0px;")
                line13.setAttribute("style", "border-width:0px;")
                line14.setAttribute("style", "border-width:0px;")

                this.round1.forEach( (match) => {
                    this.slotUser(match, i);
                   
                    i++;
                }); 
            }
            if(this.maxParticipants === 4){

                let line1 = document.getElementById("line1")
                let line2 = document.getElementById("line2")
                let line3 = document.getElementById("line3")
                let line4 = document.getElementById("line4")
                line1.setAttribute("style", "border-width:0px; margin:0px;")
                line2.setAttribute("style", "border-width:0px; margin:0px;")
                line3.setAttribute("style", "border-width:0px; margin:0px;")
                line4.setAttribute("style", "border-width:0px; margin:0px;")
                let line5 = document.getElementById("line5")
                let line6 = document.getElementById("line6")
                let line7 = document.getElementById("line7")
                let line8 = document.getElementById("line8")
                line5.setAttribute("style", "border-width:0px;")
                line6.setAttribute("style", "border-width:0px;")
                line7.setAttribute("style", "border-width:0px;")
                line8.setAttribute("style", "border-width:0px;")


                this.round2.forEach( (match) => {
                    this.slotUser(match, i);
                    
                    i++;
                });
                this.round1.forEach( (match) => {
                    this.slotUser(match, i);
                   
                    i++;
                }); 

            


            }

            if(this.maxParticipants === 8){

                let line1 = document.getElementById("line1")
                let line2 = document.getElementById("line2")
                let line3 = document.getElementById("line3")
                let line4 = document.getElementById("line4")

                line1.setAttribute("style", "border-width:0px; margin:0px;")
                line2.setAttribute("style", "border-width:0px; margin:0px;")
                line3.setAttribute("style", "border-width:0px; margin:0px;")
                line4.setAttribute("style", "border-width:0px; margin:0px;")



                this.round3.forEach( (match) => {
                    this.slotUser(match, i);
                    
                    i++;
                });
                this.round2.forEach( (match) => {
                    this.slotUser(match, i);
                    
                    i++;
                }); 

                this.round1.forEach( (match) => {
                    this.slotUser(match, i);
                    
                    i++;
                });

            }

            if(this.maxParticipants === 16){

                this.round4.forEach( (match) => {
                    this.slotUser(match, i);
                    
                    i++;
                });

                this.round3.forEach( (match) => {
                    this.slotUser(match, i);
                    
                    i++;
                });
                this.round2.forEach( (match) => {
                    this.slotUser(match, i);
                    
                    i++;
                }); 

                this.round1.forEach( (match) => {
                    this.slotUser(match, i);
                    
                    i++;
                });

            }

           
      });


    },
    computed: {
        finalRound() {
            if (this.maxParticipants === 2) {
                return 1;
            }
            if (this.maxParticipants === 4) {
                return 2;
            }
            if (this.maxParticipants === 8) {
                return 3
            }
            if (this.maxParticipants === 16) {
                return 4
            }
            return 0;
        }
    }

}
</script>

<style scoped>
#slot1{
    grid-area:grid1;
}
#slot2{
    grid-area:grid2;
}
#slot3{
    grid-area:grid3;
}
#slot4{
    grid-area:grid4;
}
#slot5{
    grid-area:grid5;
}
#slot6{
    grid-area:grid6;
}
#slot7{
    grid-area:grid7;
}
#slot8{
    grid-area:grid8;
}
#slot9{
    grid-area:grid9;
}
#slot10{
    grid-area:grid10;
}
#slot11{
    grid-area:grid11;
}
#slot12{
    grid-area:grid12;
}
#slot13{
    grid-area:grid13;
}
#slot14{
    grid-area:grid14;
}
#slot15{
    grid-area:grid15;
}
#slot16{
    grid-area:grid16;
}
#line1{
    grid-area:line1;
    border-radius: 5px;
    border-top: black thick solid;
    border-left: black thick solid;
    border-right: black thick solid;
     width:80%;
     margin-left:50%;
     min-width: 10px;
     height:100%;
}
#line2{
    grid-area:line2;
    border-radius: 5px;
    border-top: black thick solid;
    border-left: black thick solid;
    border-right: black thick solid;
     width:80%;
     margin-left:50%;
     min-width: 10px;
     height:100%;
}
#line3{
    grid-area:line3;
    border-radius: 5px;
    border-top: black thick solid;
    border-left: black thick solid;
    border-right: black thick solid;
     width:80%;
     margin-left:50%;
     min-width: 10px;
     height:100%;
}
#line4{
    grid-area:line4;
    border-radius: 5px;
    border-top: black thick solid;
    border-left: black thick solid;
    border-right: black thick solid;
     width:80%;
     margin-left:50%;
     min-width: 10px;
     height:100%;
     
     
}
#line5{
    grid-area:line5;
    border-top: black thick solid;
    width:100%;
    min-width: 10px;
    height:100%;
}
#line6{
    border-top: black thick solid;
    grid-area:line6;
    width:100%;
    min-width: 10px;
    height:100%;
}
#line7{
    grid-area:line7;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line8{
    grid-area:line8;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line9{
    grid-area:line9;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line10{
    grid-area:line10;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line11{
    grid-area:line11;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line12{
    grid-area:line12;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line13{
    grid-area:line13;
    border-top: black thick solid;
     width:100%;
     min-width: 10px;
    height:100%;
}
#line14{
    grid-area:line14;
    border-top: black thick solid;
    width:100%;
    min-width: 10px;
    height:100%;
}





#grid-container {
    margin:0px;
    
    font-size:15px;
    font-weight: bold;
    width:99%;
    overflow-x:auto;
    height:500px;
    padding:20px;
    padding-right:0px;
    display: grid;
    grid-gap: 0px 0px;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr 1fr 1fr;
    grid-template-areas:
            ". . . . . . . grid1 . . . . . . ."
            ". . . grid2 line9 line10 line11 . line12 line13 line14 grid3 . . ."
            ". grid4 line5 . line6 grid5 . . . grid6 line7 . line8 grid7 ."
            "line1 line1 line1 . line2 line2 line2 . line3 line3 line3 . line4 line4 line4"
            "grid8 . grid9 . grid10 . grid11 . grid12 . grid13 . grid14 . grid15";



    align-items: center;
    text-align: center;
}
/*
.card{
    height:35px;
    vertical-align:middle;
    padding:10px;
    background-color:white;
    border-radius:15px;
    box-shadow: 4px 3px 8px 1px #969696;
-webkit-box-shadow: 4px 3px 8px 1px #969696;
    
}
*/

#grid-container::-webkit-scrollbar {
 
}

/* width */
::-webkit-scrollbar {
  width: 100px;
}

/* Track */
::-webkit-scrollbar-track {
  background: #f1f1f1;
}

/* Handle */
::-webkit-scrollbar-thumb {
  background: rgb(152, 212, 12);
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: rgb(152, 212, 12);
}


</style>