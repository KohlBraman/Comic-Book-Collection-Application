<template>
  <div class="user-page-container">
    <div class="welcome-box">
      <h1>Welcome to your profile!</h1>
    </div>

    <div class="flex-container">
      <!-- Box 1 (Profile Box) -->

      <div class="profile-container">

        <div class="content-box">


          <!-- Clickable Profile Icon --><h2 class="icon-head">Which mask do you wear?<br> Choose Below </h2>
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
          
          <section></section>
          <!-- Username -->
          <p class="comic-username">{{ $store.state.user.username }}</p>
          <section></section>
          <!-- About Me Input Box -->
          <h2 class="about-you">A Little About You!</h2>
          <textarea v-model="aboutMe" @input="handleAboutMeChange" @focus="handleAboutMeFocus" @blur="handleAboutMeBlur"
            placeholder="Ex.Whats your favorite Super Hero? " class="about-me-input"
            :class="{ 'focused': isAboutMeFocused }"
            :style="{ backgroundColor: isAboutMeFocused ? '#fff' : 'rgba(255, 255, 255, 0.7)' }"></textarea>

          <!-- Save Button for About Me -->
          <button v-show="showSaveButton" @click="saveAboutMe">Save</button>
          <section></section>
          <!-- Add Comic Component -->
          <h2 class="space-above-below"> Add a New Comic </h2>
          <AddComic @add-comic="handleAddComic" />
          <div class="space-above-below"></div>
          <section></section>
          <!-- Create Collection Component -->
          <CreateCollection @create-collection="handleCreateCollection" />
        </div>
      </div>

      <!-- Box 2 (Comic Collection) -->
      <div class="comic-collection">
        <ComicCollection />
        <CollectionList :userCollections="userCollections" @add-comic="handleAddComic" />
      </div>
     
    </div>
  </div>
</template>

<script>
import ComicCollection from '../components/ComicCollection.vue';
import AddComic from '../components/AddComic.vue';
import CreateCollection from '../components/CreateCollection.vue';
import CollectionList from '../components/CollectionList.vue'; 
import listService from '../services/ListService';
export default {
  data() {
    return {
      userName: "USERNAME",
      selectedProfilePicture: "/deadpool.jpeg", // Default profile picture
      profilePictures: ["/superman.jpeg", "/WonderWoman.jpeg", "/deadpool.jpeg"],
      showProfileDropdown: false,
      aboutMe: "", // New data property for About Me input
      showSaveButton: false, // New data property for Save button visibility
      isAboutMeFocused: false, // New data property to track focus state
      userCollections: [], // Your existing data properties
      newComics: {}, // Your existing data properties
    };
  },
  mounted() {
    this.fetchUserCollections();
  },
  methods: {
    fetchUserCollections(){
      listService.getCollectionsByUserId(this.$store.state.user.id)
      .then(response => {
        this.userCollections = response.data;
      })
      .catch(error => {
        console.log("Unable to get user collections.", error);
      })
    },
    toggleProfileDropdown() {
      this.showProfileDropdown = !this.showProfileDropdown;
    },
    handleAboutMeChange() {
      // Toggle the save button when the About Me content changes
      this.showSaveButton = true;
    },
    handleAboutMeFocus() {
      // Update the focus state when the input is focused
      this.isAboutMeFocused = true;
    },
    handleAboutMeBlur() {
      // Update the focus state when the input is blurred
      this.isAboutMeFocused = false;
    },
    saveAboutMe() {
      // Implement the logic to save About Me content
      console.log('About Me content saved:', this.aboutMe);
      this.showSaveButton = false; // Hide the save button after saving
    },
    handleAddComic(newComic) {
      // Handle Add Comic logic
      console.log('Add Comic:', newComic);
    },
    handleCreateCollection(newCollection) {
      // Handle Create Collection logic
      console.log('Create Collection:', newCollection);
    },
    handleAddComicToCollection({ collectionId, comicTitle }) {
      // Update the newComics data in the parent component
      this.$set(this.newComics, collectionId, comicTitle);
    },
  },
  components: {
    ComicCollection,
    AddComic,
    CreateCollection,
    CollectionList,
  },
};
</script>

<style scoped>
.user-page-container {
  display: flex;
  flex-direction: column;
}

.about-me-input {
  width: 80%;
  padding: 10px;
  resize: vertical;
  /* Allows vertical resizing for textarea */
  transition: background-color 0.3s ease;
  /* Add transition for smooth effect */
  background-color: rgba(255, 0, 0, 0.5);
  margin-bottom: 12px;
}

.about-me-input.focused {
  background-color: #fff;
  /* Solid white background when focused */
}

.flex-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 20px;
}

.profile-container {
  display: flex;
  background: url('../assets/aBackround.jpeg');
  margin-left: 5%;
  flex-basis: 18%;
  background-size: 100%;
  justify-content: center;
  /* Center content horizontally */
  align-items: center;
  /* Center content vertically */
  padding: 1%;

}
.space-above-below {
  margin: 10px 0;
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
  margin-top: 10px;
  margin-bottom: 10px;
}

.content-box {
  display: flex;
  flex-direction: column;
  border: solid;
  align-items: center;
  justify-content: center;
  background-color: rgba(255, 255, 255, 0.88);
}


section {
  border: 1px dashed #000;
  /* 1px solid black border around the section */
  width: 90%;
  margin-top:5px ;
}

.profile-icon img {
  width: 100%;
  margin-top: 15px;
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
h2{
  text-align: center;
  font-family: "acme";
  font-size: 16px;
}
p{
  text-align: center;
  font-family: "acme";
};
.welcome-box {
  margin-bottom: 20px;
}

.comic-collection {
  display: flex;
  justify-content: center;
  align-items: flex-start;
  flex-wrap: wrap;
  max-width: 600px;
  margin: 0 auto;
  flex-basis:80%;
  flex-grow: 2;
  width: 100%;
  box-sizing: border-box; 
}
</style>
