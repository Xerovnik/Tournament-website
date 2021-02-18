<template>
  <div id="app">
    <nav id="nav">
      <h3 v-if="$store.state.token != ''">Logged in as {{$store.state.user.username}} </h3>
      <router-link class= "nav-item" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="nav-item" v-bind:to="{ name: 'my-tournaments' }" v-if="$store.state.token != ''">My Tournaments</router-link>&nbsp;|&nbsp;
      <router-link class="nav-item" v-bind:to="{ name: 'mailbox' }" v-if="$store.state.token != ''">Mailbox</router-link>&nbsp;|&nbsp;
      <router-link class= "nav-item" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link class= "nav-item" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
    </nav>
    <router-view />
    <div id="background"></div>
  </div>
</template>
