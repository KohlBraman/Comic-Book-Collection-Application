<!-- <template>
    <div>
      <h2>Login</h2>
      <form @submit.prevent="loginUser">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="username" required>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required>
        <button type="submit">Login</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        username: '',
        password: ''
      };
    },
    methods: {
      loginUser() {
        this.$store.dispatch('auth/login', { username: this.username, password: this.password })
          .then(() => {
           
            this.$router.push('/');
          })
          .catch(error => {
            console.error('Login failed:', error);
            
          });
      }
    }
  };
  </script>
  
  <style scoped>
 
  </style> -->