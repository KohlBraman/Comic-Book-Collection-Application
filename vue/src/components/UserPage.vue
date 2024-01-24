<!-- ParentComponent.vue -->

<template>
  <div>
    <div class="welcome-box">
      <h1>Welcome to your profile!</h1>
    </div>

    <div class="main-container">
      <div class="profile-container">
        <div class="content-box">
          <p class="comic-username">{{ this.$store.state.user.username }}</p>
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

      <ComicCollection />

      <div class="add-comic-box">
    <AddComic @add-comic="handleAddComic" />
      </div>
    </div>

    <CreateCollection />
  </div>
</template>

<script>
import ComicCollection from '../components/ComicCollection.vue';
import AddComic from '../components/AddComic.vue';
import CreateCollection from './CreateCollection.vue';

export default {
  data() {
    return {
      userName: 'USERNAME',
      selectedProfilePicture: '/deadpool.jpeg', // Default profile picture
      profilePictures: ['/superman.jpeg', '/WonderWoman.jpeg', '/deadpool.jpeg'],
      showProfileDropdown: false,
      showAddComicForm: false,
    };
  },
  methods: {
    toggleProfileDropdown() {
      this.showProfileDropdown = !this.showProfileDropdown;
    },
    toggleAddComicForm() {
      this.showAddComicForm = !this.showAddComicForm;
    },
    handleAddComic(newComic) {
      // You can add logic here to update your comic collection with the new comic
      console.log('New Comic Added:', newComic);
      // For example, you might want to add it to an array in your data
      // this.comics.push(newComic);

      // After handling the add comic action, hide the form
      this.showAddComicForm = false;
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
/* Updated styles to create a side-by-side layout */
.main-container {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
}

.profile-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 200px;
  height: 300px;
  background: url('../assets/BlueProfileBackground.jpeg') center/cover;
  margin-right: 20px;
}

.comic-username {
  font-size: 30px;
  font-weight: bold;
  font-family: 'Marvel';
  text-transform: uppercase;
  color: #0c0c0c;
}

.comic-collection {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  max-width: 800px;
  margin: 20px 0; /* Adjust the margin as needed */
}

.add-comic-box {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.add-comic-box button {
  margin-bottom: 10px;
}
</style>
