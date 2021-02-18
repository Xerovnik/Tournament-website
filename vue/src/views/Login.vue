<template>
  <div id="login" class="text-center">
     <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Syncopate&display=swap" rel="stylesheet">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div id="loginBox">
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <button type="submit" class="inviteButton">Sign in</button>
      <br>
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <br>
      <router-link v-bind:to="{ name: 'home'}">Browse as guest</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
body{
  margin:0px;
  font-family:Arial, Helvetica, sans-serif;
 
  
  font-family: 'Syncopate', sans-serif;
  background-color:#504B4B;

  background-image:url(../images/c67e47d858c786d336d98ae6862a2776.jpg);
  background-repeat: repeat-y;
  background-size: 100%;
  background-color:rgb(168, 221, 88);
  background-blend-mode: screen;
   overflow-x: hidden;
}

#app{
  padding-left:0px;
 /* background-color:rgb(168, 221, 88);
  background: linear-gradient(180deg, rgb(168, 221, 88) 0%, rgb(174, 235, 139) 35%, rgb(168, 221, 88) 80%);
  */
}
#loginBox{
  width:275px;
  
 
}
#nav{
  padding-left:15px;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  color: white;
  
}
#nav h3{
  display:inline;
  background-color: #4CAF50;
  color: white;
  text-align: center;
  padding: 14px 16px;
  
  
}
.nav-item {
  color: white;
  padding-left: 0.5rem;
  padding-right: 0.5rem;
  font-size: 17px;
}
h1{
  margin-top:10px;
  margin-bottom:10px;
}
.form-signin{
  padding-left:15px;
}
textarea{
  border-radius:25px;
}
/*
.home{

  width:100%;
  height:100%;
  background-image:url(../images/c67e47d858c786d336d98ae6862a2776.jpg);
  background-repeat: repeat-y;
  background-size: 100%;
  background-color:rgb(168, 221, 88);
  background-blend-mode: screen;
  background-position: local;
  margin:0px;
  padding:0px;
  z-index:-1;
}
*/
#main-container1{
  
  height:100%;
  margin:0px;
  padding-bottom:0px;
  

}


::-webkit-scrollbar {
  width: 15px;
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