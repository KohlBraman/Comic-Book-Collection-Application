<template>
  <div class="headerNav">
    <h1>Amazing Traders</h1>

    <ul class="nav-links">
      <li id="OpeningPage"><router-link v-bind:to="{ name: 'OpeningPage' }">Home</router-link></li>
      <li id="UserPage"><router-link v-bind:to="{ name: 'UserPage' }">Profile</router-link></li>
      <li id="logout" v-if="$store.state.token !== undefined && $store.state.token !== ''">
        <router-link v-bind:to="{ name: 'logout' }">Logout</router-link>
      </li>
      <li id="login" v-else>
        <router-link v-bind:to="{ name: 'login' }">Login</router-link>
      </li>
      <!-- <li id="icon">
        <img src="../assets/superman.jpeg" alt="Image Alt Text" class="icon-image">
      </li> -->
      

    </ul>
  </div>
</template>



<script>
export default {

}

</script>


<style scoped>

h1 {
text-align: center;
background-color: rgba(255, 0, 0, 0.7);
font-family: 'Super Comic';
text-transform: uppercase;
font-weight: normal;
height: 80px;
display: flex;

justify-content: center; /* Center the text vertically */
align-items: center; /* Center the text horizontally */
box-shadow: 0 8px 8px rgba(0, 0, 0, 0.1); 
}


.nav-links {
  display: flex;
  list-style: none;
  margin-top: 0px;
  padding: 0px;
  flex-shrink: 1;
}

/* .nav-links li {
  /* justify-content: flex-start; */
  /* text-align: center; */
  


.nav-links a {
  color: rgb(0, 0, 0);
  text-decoration: none;
  text-transform: uppercase;
  font-size: 20px;
  font-family: 'Super Comic';
  background-color: rgb(255, 255, 255);
  border: 2px solid;
  padding: 10px;
}

</style>





