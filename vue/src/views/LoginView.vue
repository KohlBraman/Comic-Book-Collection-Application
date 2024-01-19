<template>
  <div id="login">
    <div class="image-container">
      <!-- Set the background image for the container -->
      <img src="../assets/thoughtTeal.jpeg" alt="Image Alt Text" class="background-image">

      <form v-on:submit.prevent="login" class="form-container">
        <h1>Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">Invalid username and password!</div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <button type="submit">Sign in</button>
       
      </form>
      
    </div>
  </div>
  <div>
    <p class="register-button"><router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
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

<style scoped>
.image-container {
  position: relative;
  
}

.background-image {
  max-width: 59%; /* Adjust the max-width as needed */
  max-height: 100dvh; /* Adjust the max-height as needed */
  width: 100%;
  height: 100%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: -2;
  box-shadow: 0 8px 8px rgba(0, 0, 0, 0.1); /* Add a subtle box shadow */
}

.form-container {
  position: relative;
  z-index: 1;
  text-align: center;
  padding: 200px;
  border-radius: 8px;
  margin: 50px auto; 
  top: -10px; 
  
  
}


button {
  background-color: rgba(255, 0, 0, 0.8); 
  color:black;
  padding: 10px 20px; /* Padding inside the button */
  margin-top: 20px;
  border: none; /* No border */
  border-radius: 5px; /* Rounded corners */
  cursor: pointer; /* Cursor style on hover */
  font-size: 16px; /* Font size */
  font-weight: bold;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1); 
}

button:hover {
  background-color: #17a790; /* Darker green color on hover */
}

/* Customize text box styles */
.form-input-group label {
  margin-right: 18px; /* Add margin between label and text box */
  padding-left: 24px ;
  font-size: 19px;
  font-weight: 700;
  
}
.form-input-group input {
  width: 9%;
  padding: 7px;
  margin: 9px 0;
  box-sizing: border-box;
  border: 1px solid #17a790;
  border-radius: 4px;
  box-shadow: 0 5px 5px rgba(0, 0, 0, 0.1); 
  
  
}
.register-button {
  background-color: rgba(255, 0, 0, 0.7); 
  color: #0b0a0a; /* Set the text color */
  padding: 10px 20px; /* Padding inside the button */
  border: none; /* No border */
  border-radius: 5px; /* Rounded corners */
  cursor: pointer; /* Cursor style on hover */
  text-decoration: none; /* Remove underline for router-link */
  display: inline-block; /* Make it inline-block for proper styling */
  font-size: 16px; /* Font size */
  font-weight: bold;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
  margin-left:600px;
  margin-top:-10px;
  
}
.register-button:hover {
  background-color: #17a790;;
}

@media (max-width: 1400px) {

  .register-button {
  color: #ffffff; /* Set the text color */
  padding: 10px 20px; /* Padding inside the button */
  border: none; /* No border */
  border-radius: 5px; /* Rounded corners */
  cursor: pointer; /* Cursor style on hover */
  text-decoration: none; /* Remove underline for router-link */
  display: inline-block; /* Make it inline-block for proper styling */
  font-size: 16px; /* Font size */
  font-weight: bold;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
  margin-left:500px;
  margin-top:-10px;
  
}

  button {
  background-color: rgba(255, 0, 0, 0.8); 
  color: black; 
  padding: 10px 20px; /* Padding inside the button */
  margin-top: 20px;
  border: none; /* No border */
  border-radius: 5px; /* Rounded corners */
  cursor: pointer; /* Cursor style on hover */
  font-size: 16px; /* Font size */
  font-weight: bold;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1); 
}

.form-input-group label {
  margin-right: 18px; /* Add margin between label and text box */
  padding-left: 24px ;
  font-size: 15px;
  font-weight: 700;
  
}
.form-input-group input {
  width: 9%;
  padding: 7px;
  margin: 9px 0;
  box-sizing: border-box;
  border: 1px solid #17a790;
  border-radius: 4px;
  box-shadow: 0 5px 5px rgba(0, 0, 0, 0.1); 
  
}
.form-container {
  position: relative;
  z-index: 1;
  text-align: center;
  padding: 200px;
  border-radius: 8px;
  margin: 50px auto; 
  top: 10px; 
  
}

}




</style>