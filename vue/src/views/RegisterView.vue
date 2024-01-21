<template>
  <div id="register" class="image-container">
    <img src="../assets/thoughtTeal.jpeg" alt="Image Alt Text" class="background-image">
  
    <form v-on:submit.prevent="register" class="form-container register-form">
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
      <div class="form-input-user">
        <label for="userRole">Select User Type</label>
        <select id="userRole" v-model="user.role" required>
          <option value="user" checked>Standard User</option>
          <option value="premium">Premium User</option>
        </select>
      </div>
      <button type="submit">Create Account</button>
      <p class="register-button" ><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
    <div class="center">
    <div class="spacer"></div>
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
h1{
  margin-bottom: -3%;
  padding-bottom:3px ;
}
.image-container {
  position: relative;
  margin-top: 5%;
}

#register {
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
  width: 90%;
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
  padding: 5px 10px;
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
  padding-bottom: 5%;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
}
.form-input-group label {
  display:flex ;
  margin-right: 18px;
  padding-left: 24px;
  font-size: 15px;
  font-weight: 700;
  justify-content:center;
  /* flex-shrink: ;  */
  
}
.form-input-group {
  display: flex;
  flex-direction: column; /* Stack items vertically */
  align-items: center;
  margin-bottom: 2px; /* Adjust as needed for spacing between form-input-groups */
}

.form-input-group label {
  margin-bottom: 2px; /* Add space between label and input */
  display: flex;
  justify-content: center;
  font-size: 15px;
  font-weight: 700;
}

.form-input-group input {
  width: 60%; /* Take up full width of the container */
  height: 0%;
  padding: 4px;
  box-sizing: border-box;
  border: 1px solid #17a790;
  border-radius: 4px;
  box-shadow: 0 5px 5px rgba(0, 0, 0, 0.1);
}

.form-input-user {
  display: flex;
  flex-direction: column; /* Stack items vertically */
  align-items: center;
}

.form-input-user label {
  display: flex;
  justify-content: center;
  font-size: 15px;
  font-weight: 700;
}

select {
  width: 60%;
  padding: 4px;
  font-size: 14px;
  border: 1px solid #17a790;
  border-radius: 4px;
  box-shadow: 0 5px 5px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  color: #333; 
  cursor: pointer;
}


select::-ms-expand {
  display: none;
}

select:after {
  content: '\25BC'; /* Unicode character for down arrow */
  position: absolute;
  top: 50%;
  right: 10px;
  transform: translateY(-50%);
}

/* Style the options */
select option {
  font-size: 14px;
  background-color: #fff; /* Background color for each option */
}

/* Style the select on hover */
select:hover {
  border-color: #17a790; /* Change border color on hover */
}

.spacer {
  height: 30px;
}


@media (min-width: 1200px) {
  .background-image {
  height: auto;
  width: 97%;
 
}
}



@media (min-width: 1920px) {
  .image-container {

    max-width: 80%;
    margin: 100px auto 0; /* Center the container horizontally */
    
  } 
}


</style>
