<template>
  <div id="register" class="text-center">
    <div class="image-container">
      <img src="https://www.looper.com/img/gallery/iron-mans-future-was-just-permanently-changed-by-a-new-villain/l-intro-1682530622.jpg" alt="Left Image" class="left-image" />
    <form v-on:submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div class="form-input-group">
        <label for="userRole">Select User Type</label>
        <select id="userRole" v-model="user.role" required>
          <option value="user" checked>Standard User</option>
          <option value="premium">Premium User</option>
        </select>
      </div>
      <button type="submit">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
    <img src="https://cdn.marvel.com/content/1x/061ult_com_mas_mob_03.jpg" alt="Right Image" class="right-image" />
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
#register {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50vh;
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
  height: 35vh;
}

.left-image {
  left: 0;
}

.right-image {
  right: 0;
}

.register-form {
  width: 300px;
  text-align: center;
}

.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}
</style>
