<template>
 
  <div id="capstone-app">
    <div class="nave-bar">
      <nav-bar></nav-bar> 
    </div>
    <router-view />
    
    <Footer />
  </div>
</template>
<script>
import NavBar from './components/NavBar.vue'
import Footer from "./components/Footer.vue"
export default {
  components:{
    NavBar,
    Footer
  }
  

};
</script>

<style>
h1 {
  font-family: 'Mouse Memoirs';
  font-size: 40px;
  letter-spacing: 3px;
  text-transform: uppercase;
}

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
  z-index: -2; /* Set a lower z-index value than the other elements */

}
button {
   background-color: rgb(199, 13, 13, .71);
   color: black;
   padding: 5px 23px;
   margin-top: 3%;
   border: none;
   border-radius: 5px;
   cursor: pointer;
   font-size: 13px;
   box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
   font-family: "acme";
   text-transform:capitalize;
 }

</style>