<template>
  <div id="login" class="image-container" >
    
      <img src="../assets/thoughtTeal.jpeg" alt="Image Alt Text" class="background-image">

      <form v-on:submit.prevent="login" class="form-container login-form" >
        <h1>Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">Invalid username and password!</div>
        <!-- <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div> -->
        <div class="form-input-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <button type="submit">Sign in</button>
        <p class="register-button"><router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
      </form>

    <div class="center">
      <div class="spacer"></div>
  </div>
</div>
</template>

<script>
import authService from "../services/AuthService";

export default {
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
            this.$router.push({ name: "UserPage" });
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

<style scoped>

h1{
  margin-bottom: -3%;
  padding-bottom:5px ;
}
.image-container {
  position: relative;
  margin-top: 5%;
}
#login {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  /* height: 100vh; */
  position: relative;
}
.background-image {
  max-width: 97%;
  height: auto;
  width: 80%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: -2;
  box-shadow: 0 8px 8px rgba(0, 0, 0, 0.1);
}


.form-container {
  position: relative;
  z-index: 1;
  text-align: center;
  padding: 10% 10%;
  border-radius: 8px;
  margin: 5% auto;
}

button {
  background-color: rgba(255, 0, 0, 0.6);
  color: black;
  padding: 5px 23px;
  margin-top: 3%;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 15px;
  font-weight: bold;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
}

button:hover {
  background-color: #17a790;
}
.register-button {
  color: #0b0a0a;
  margin-top:1% ;
  padding-bottom: 10%;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
}

.form-input-group label {
  display:flex ;
  font-size: 30px;
  font-weight: 700;
  justify-content:center;
  
  
}
.form-input-group {
  display: flex;
  flex-direction: column; /* Stack items vertically */
  align-items: center;
  margin-bottom: 10px; /* Adjust as needed for spacing between form-input-groups */
}

.form-input-group label {
  margin-bottom: 2px; /* Add space between label and input */
  display: flex;
  justify-content: center;
  font-size: 20px;
  font-weight: 700;
}

.form-input-group input {
  width: 50%; 
  padding: 5px;
  box-sizing: border-box;
  border: 1px solid #17a790;
  border-radius: 4px;
  box-shadow: 0 5px 5px rgba(0, 0, 0, 0.1);
}


/* @media (min-width: 1200px) {
  .background-image {
  height: auto;
  width: 97%;
 
}
} */


@media (min-width: 1920px) {
  .image-container {

    max-width: 80%;
    margin: 100px auto 0; /* Center the container horizontally */
    
  } 
}


</style>
