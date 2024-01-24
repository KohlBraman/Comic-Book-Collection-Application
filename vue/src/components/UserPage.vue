<template>
  <div class="user-page-container">
    <div class="welcome-box">
      <h1>Welcome to your profile!</h1>
    </div>

    <div class="flex-container">
      <!-- Box 1 (20%) -->
      <div class="profile-container">
        <div class="content-box">
          <p class="comic-username">{{ $store.state.user.username }}</p>
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

      <!-- Box 2 (80%) -->
      <div class="comic-collection">
        <ComicCollection />
      </div>
    </div>

    <div class="flex-container">
      <!-- Box 3 (50%) -->
      <div class="add-comic-box">
        <AddComic @add-comic="handleAddComic" />
      </div>

      <!-- Box 4 (50%) -->
      <div class="create-collection-box">
        <CreateCollection />
      </div>
    </div>
  </div>
</template>



<script>
import ComicCollection from '../components/ComicCollection.vue';
import AddComic from '../components/AddComic.vue';
import CreateCollection from './CreateCollection.vue';

export default {
  data() {
    return {
      userName: "USERNAME",
      selectedProfilePicture: "/deadpool.jpeg", // Default profile picture
      profilePictures: ["/superman.jpeg", "/WonderWoman.jpeg", "/deadpool.jpeg"],
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
    ComicCollection,
    AddComic,
    CreateCollection,
  },
};
</script>





<style scoped>
.user-page-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.main-content {
  display: flex;
  width: 80%;
  margin-top: 20px;
}

.flex-container {
  display: flex;
  justify-content: space-between;
  width: 80%;
  margin-top: 20px;
}

.flex-box-20 {
  width: 20%;
}

.flex-box-80 {
  width: 80%;
}

.profile-container {
  height: 300px;
  background: url('../assets/BlueProfileBackground.jpeg') center/cover;
  margin-right: 20px;
}

.comic-collection {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  max-width: 800px;
  margin: 0 auto;
}

.add-comic-box,
.create-collection-box {
  margin-top: 20px;
}

.comic-username {
  font-size: 30px;
  font-weight: bold;
  font-family: 'Marvel';
  text-transform: uppercase;
  color: #0c0c0c;
}

.content-box {
  display: flex;
  flex-direction: column;
  border: solid;
  align-items: center;
  width: auto;
  min-height: 400px;
  background-color: rgba(255, 255, 255, 0.7);
}

#ProfileIcon {
  width: 100%;
  height: 100%;
  border-radius: 100%;
  overflow: hidden;
}

.profile-icon img {
  width: 120px;
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

.welcome-box {
  margin-bottom: 20px;
}




</style>