<template>
  <div class="home">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
    <h1 v-if="$store.state.token != ''"> 
      Welcome, {{$store.state.user.displayName}}!
    </h1>
    <h2>
      
        <router-link v-bind:to="{ name: 'create-tournament'}" class="myButton">Create New Tournament</router-link>
      
    </h2>
    <h1 v-if="$store.state.token == ''"> 
      Welcome!
    </h1>
    <MainFeed />
  </div>
</template>

<script>
import MainFeed from "@/components/MainFeed";

export default {
  name: "home",
  components: {
    MainFeed
  }
};
</script>

<style>
.home {
  text-align: center;
}
.home h1 {
  padding-top: 1rem;
  padding-bottom: 1.5rem;
font-family: 'Syncopate', sans-serif;
}

.myButton {
	box-shadow: 1px 1px 0px 0px rgb(112, 112, 112);
	
	background-color:#84ce61;
	border-radius:3px;
	
	display:inline-block;
	cursor:pointer;
	color:#fff;
	font-family:Arial;
	font-size:17px;
	padding:7px 25px;
	text-decoration:none;
	text-shadow:0px 1px 0px rgb(61, 61, 61);
}
.myButton:hover {
	
	background-color:#9fdf6a;
}
.myButton:active {
	position:relative;
	top:1px;
}

.welcome {
  background: radial-gradient(circle, #ecc92c 0%, #070707 100%);
  background-clip: text;
  -webkit-background-clip: text;
  color: transparent;
  animation: animatedGradient 2s infinite ease;
  animation-direction: alternate;
}

@keyframes animatedGradient {
  from {
    background-size: 100%;
  }

  to {
    background-size: 250%;
  }
}

</style>
