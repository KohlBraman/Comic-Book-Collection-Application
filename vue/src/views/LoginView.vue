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

    <div class="center">
      <p class="register-button">
        <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link>
      </p>
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
  margin-top: 100px
}

.background-image {
  max-width: 90%;
  height: auto;
  width: 80%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: -2;
  box-shadow: 0 8px 8px rgba(0, 0, 0, 0.1);
}

@media (min-width: 1300px) {
  .background-image {
  max-width: 70%; /* Adjust max-width for larger screens */
  }
  .image-container {
  position: relative;
  margin-top: 100px
}
}
.form-container {
  position: relative;
  z-index: 1;
  text-align: center;
  padding: 10% 5%;
  border-radius: 8px;
  margin: 5% auto;
}

button {
  background-color: rgba(255, 0, 0, 0.6);
  color: black;
  padding: 9px 20px;
  margin-top: .5%;
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

.form-input-group label {
  margin-right: 18px;
  padding-left: 24px;
  font-size: 19px;
  font-weight: 700;
}

.form-input-group input {
  width: 180px; /* You can adjust the percentage or use a fixed value like width: 200px; */
  padding: 7px;
  margin: 9px 0;
  box-sizing: border-box;
  border: 1px solid #17a790;
  border-radius: 4px;
  box-shadow: 0 5px 5px rgba(0, 0, 0, 0.1);
}

.register-button {
  background-color: rgba(255, 0, 0, 0.6);
  color: #0b0a0a;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  font-weight: bold;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
  margin-top: .8%;

}

.register-button:hover {
  background-color: #17a790;
}

.center {
  text-align: center;
}

@media (max-width: 1300px) {

  .register-button {
    color: #ffffff;
  }
  button {
    background-color: rgba(255, 0, 0, 0.8);
  }

  .form-input-group label {
    font-size: 15px;
  }

  .form-input-group input {
    width: 100%;
  }

  .form-container {
    padding: 10% 10%;
  }
  .form-input-group input {
    width: 20%; 
  }
}
@media (min-width: 1920px) {
  .image-container {
  margin-top: 200px
}
}


</style>
