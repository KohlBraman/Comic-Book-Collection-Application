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

<style>
#capstone-app {
  /* You can also use background-image with a URL to add a background image */
  background-image: url('./assets/footer.jpeg');
  position: relative;
  z-index: 0;
  /* Adjust other background properties as needed */
  /* background-repeat: repeat; */
  /* background-position: center center; */
  /* background-attachment: fixed; */
  /* background-size: cover; */
}
#capstone-app::before {
  content: "";
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-color: rgba(240, 240, 240, 0.6); /* Adjust the alpha value for translucency */
  /* Set your desired background color */
  z-index: -2; /* Set a lower z-index value than the other elements */
  /* You can also use background-image with a URL to add a background image */
  /* background-image: url('path-to-your-image.jpg'); */
  /* Adjust other background properties as needed */
  /* background-repeat: repeat; */
  /* background-position: center center; */
  /* background-attachment: fixed; */
  /* background-size: cover; */
}

</style>