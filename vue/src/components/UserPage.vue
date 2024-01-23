<template>
  <div class="welcome-box">
    <h1>Welcome to your profile!</h1>
  </div>
  <div class="comic-collection">
    <ComicCollection />
  </div>

  <div class="main-container">

    <div class="profile-container">

      <div class="content-box">
        <p class="comic-username">{{this.$store.state.user.username}}</p>
        <!-- Clickable Profile Icon -->
        <div class="icon-choice-box" @click="toggleProfileDropdown">
          <div id="ProfileIcon" class="profile-icon">
            <img :src="selectedProfilePicture" alt="profile picture placeholder">
          </div>
          <!-- Dropdown for Profile Pictures -->
          <div v-show="showProfileDropdown" class="profile-dropdown">
            <select v-model="selectedProfilePicture" @click.stop>
              <option v-for="picture in profilePictures" :key="picture" :value="picture">
                {{ picture }}
              </option>
            </select>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- AddComic component placement -->
  <div class="add-comic-box">
    <AddComic @add-comic="handleAddComic" />
  </div>
</template>
  
<script>
// import UpdateProfile from '../components/UpdateProfile.vue';
import ComicCollection from '../components/ComicCollection.vue';
import AddComic from '../components/AddComic.vue';

export default {
  data() {
    return {

      userName: "USERNAME",
      selectedProfilePicture: "../assets/deadpool.jpeg", // Default profile picture
      profilePictures: [
        "../assets/superman.jpeg",
        "../assets/WonderWoman.jpeg",
        "../assets/deadpool.jpeg",
        
      ],
      showProfileDropdown: false,
    };
  },
  methods: {
    toggleProfileDropdown() {
      this.showProfileDropdown = !this.showProfileDropdown;
    },
    handleAddComic(newComic) {
      // You can add logic here to update your comic collection with the new comic
      console.log('New Comic Added:', newComic);
      // For example, you might want to add it to an array in your data
      // this.comics.push(newComic);
    },

  },
  components: {
    // UpdateProfile,
    ComicCollection,
    AddComic,
  },
}
</script>
  
<style scoped>
.add-comic-box {
  display: flex;
  justify-content: center;
  margin-top: -200px;
}
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
  font-family: 'Marvel';
  text-transform: uppercase;
  color: #0c0c0c;
}

.profile-container {
  display: flex;
  flex-direction: column;
  background-position-x: center;
  margin-bottom: 200px;
  width: auto;
  align-self: flex-start;
  min-height: 400px;
  background-image: url(../assets/BlueProfileBackground.jpeg);
  background-size: 22cap;
  margin-top: -100px;
}
.content-box {
  display: flex;
  flex-direction: column;
  border: solid;
  align-items: center;
  width: auto;
  align-self: flex-start;
  min-height: 400px;
  background-color: rgba(255, 255, 255, 0.7);
}

#profileIcon {
  width: 100%;
  height: 100%;
  border-radius: 100%;
  overflow: hidden;

}

.profile-icon img {
  width: 120px;

}





.welcome-box {
  margin-bottom: 20px;
  font-family: '';
}



.dropdown-content {
  max-width: 200px;
  max-height: 200px;
  margin-top: 10px;

}

.icon-choice-box {
  margin-bottom: 20px;
  cursor: pointer;
}

.profile-dropdown {
  position: absolute;
  padding: 5px;

}

h1 {
  text-align: center;
}
</style>