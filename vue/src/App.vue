<template>
  <div id="capstone-app">
    <div class="nave-bar">
      <nav-bar></nav-bar>
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
    <router-view />
    <Footer />
  </div>
</template>
<script>
import NavBar from './components/NavBar.vue'
import Footer from "./components/Footer.vue";

export default {
  components:{
    NavBar,
    Footer
  }

};
</script>