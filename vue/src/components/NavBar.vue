<template>
    <div class="headerNav">
      <h1>Welcome to the Opening Page</h1>
  
      <ul class="nav-links">
        <li id="OpeningPage"><router-link v-bind:to="{ name: 'OpeningPage' }">Home</router-link></li>
        <li id="UserPage"><router-link v-bind:to="{ name: 'UserPage' }">Profile</router-link></li>
        <li id="logout" v-if="$store.state.token !== undefined && $store.state.token !== ''">
          <router-link v-bind:to="{ name: 'logout' }">Logout</router-link>
        </li>
        <li id="login" v-else>
          <router-link v-bind:to="{ name: 'login' }">Login</router-link>
        </li>
      </ul>
    </div>
  </template>



<script>
export default {

}

</script>



<style scoped>
h1{
    text-align: center;
    background-color: red;
    font-family: 'Super Comic';
    text-transform: uppercase;
    font-weight: normal;
    
}


.nav-links {
    display: flex;
    list-style: none;
    margin-top: 0px;
    padding: 0px;
    flex-shrink: 1;
}

.nav-links li {
    /* justify-content: flex-start; */
    /* text-align: center; */
    
}

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