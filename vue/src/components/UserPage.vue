<template>
  <div class="welcome-box">
      <h1>Welcome to your profile!</h1>
  </div>
  <div class="comic-collection">
      <ComicCollection/>
  </div>
  <div class="main-container">
      <div class="profile-container">
          <div class="content-box">
              <div class="icon-choice-box">
                  <div id="ProfileIcon" class="profile-icon">
                      <p class="comic-username">{{ userName }}</p>
                      <img src="../assets/superman.jpeg" alt="profile picture placeholder">
                  </div>
                  <div id="ProfilePrompt">
                      <p>{{ profilePrompt }}</p>
                   <button v-show="!showUpdatePrompt" @click="toggleUpdatePrompt">Update Prompt</button>
                   <div v-show="showUpdatePrompt" class="update-prompt-content">
                   <input v-model="newProfilePrompt" type="text" placeholder="Type a new prompt">
                   <button @click="updateProfilePrompt">Update Prompt</button>
                  <button @click="cancelUpdatePrompt">Cancel</button>
            </div>
              </div>
              </div>
              <div class="update-profile-box">
                  <button @click="toggleDropdown" v-show="!showDropdown">Update Profile</button>
          <div v-show="showDropdown" class="dropdown-content">
                      <UpdateProfile />
                      <button @click="cancelUpdate" v-show="showDropdown">Cancel</button>
                  </div>
              </div>
          </div>
      </div>
  </div>
</template>
<script>
import UpdateProfile from '../components/UpdateProfile.vue';
import ComicCollection from '../components/ComicCollection.vue';
export default {
  data() {
  return {
    showDropdown: false,
    showUpdatePrompt: false,
    newProfilePrompt: '',
    profilePrompt: "Which mask do you wear?",
    userName: "USER",
    newUserName: '',
    showUpdateUserName: false,
  };
},
methods: {
  toggleDropdown() {
    this.showDropdown = !this.showDropdown;
  },
  toggleUpdatePrompt() {
    this.showUpdatePrompt = !this.showUpdatePrompt;
  },
  cancelUpdate() {
    this.showDropdown = false;
  },
  cancelUpdatePrompt() {
    this.showUpdatePrompt = false;
  },
  updateProfilePrompt() {
    if (this.newProfilePrompt) {
      this.profilePrompt = this.newProfilePrompt;
      this.newProfilePrompt = '';
      this.showUpdatePrompt = false;
    }
  }
},
components: {
  UpdateProfile,
  ComicCollection
},
}
</script>
<style scoped>
.comic-collection {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  /* border: solid black; */
  max-width: 800px;
 margin: 0 auto;
}
.main-container {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  margin-top: -300px;
}
.comic-username {
font-size: 30px;
font-weight: bold;
font-family: 'Comic Sans MS', cursive;
color: #0C0C0C;
}
.profile-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 100px;
}
#profileIcon {
  width: 300px;
height: 300px;
border-radius: 100%;
overflow: hidden;
}
.profile-icon img {
width: 300px; /* Adjust the width */
height: 250px; /* Adjust the height */
}
#ProfilePrompt {
font-size: 25px;
font-weight: bold;
text-align: left;
margin-bottom: 20px;
}
button {
background-color: rgba(255, 0, 0, 0.6);
color: black;
padding: 5px 23px;
margin-top: 3%;
border: none;
border-radius: 5px;
cursor: pointer;
font-size: 12px;
font-weight: bold;
box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
}
.welcome-box {
  margin-bottom: 20px;
}
.content-box {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 100%;
}
.dropdown-content {
  max-width: 200px;
  max-height: 200px;
  margin-top: 10px;
}
.icon-choice-box {
  margin-bottom: 20px;
}
.update-profile-box {
  flex: 1;
  margin-top: 10px;
}
h1 {
  text-align: center;
}
</style>







