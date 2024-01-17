<template>
  <div id="login">
    <div class="image-container">
      <img src="https://i.pinimg.com/736x/9c/9b/e7/9c9be78eb0e51b298f06dddf0dbd1223.jpg" 
      alt="Left Image" class="left-image" />
    <form v-on:submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
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
      <p>
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
    <img src="https://cdnb.artstation.com/p/assets/images/images/020/334/885/large/emmanuel-andrade-batmanlaughs-f.jpg?1567382890" alt="Right Image" class="right-image" />
      <img src="https://darkknightnews.com/wp-content/uploads/2018/11/Gotham-1024x517.jpg" alt="Bottom Image" class="bottom-image" />
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
#login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 45vh; 
}

.image-container {
  position: relative;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.left-image,
.right-image {
  position: absolute;
  top: 0;
  height: 215%;
}

.left-image {
  left: 0;
}

.right-image {
  right: 0;
}

.bottom-image {
  position: absolute;
  bottom: 0;
  width: 50%;
  margin-bottom: -400px; 
}

.login-container {
  width: 100%; 
}

.login-form {
  width: 300px; 
}

.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}
</style>