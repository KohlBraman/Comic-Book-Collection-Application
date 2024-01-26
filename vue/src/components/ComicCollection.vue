<template>
  <div class="comic-collection">
    <div class="comics-container">
    <div v-if="comics.length === 0">
      <!-- // <div v-if="!comics && userComics.length === 0"> -->
      <h2>Thank You For Joining the Amazing Traders Community</h2>
      <p class="sub-heading">To add your first comic book please click the Add Comic Button</p>
    </div>
 
      <div v-for="(comic, index) in comics" :key="index" class="comic-thumbnail">
        <div @click="selectComic(index)" :class="{ 'selected': index === currentComicIndex }">
          <img :src="comic.coverImg" :alt="comic.title" class="small-thumbnail">
        </div>
      </div>
    </div>

    <div v-if="currentComicIndex !== null" class="comic-popup">
      <div class="comic-info">
 
  <h2  ><span class="material-symbols-outlined">
comic_bubble
</span>   Title: {{ comics[currentComicIndex].title }}</h2>
  <h3><span class="material-symbols-outlined">
comic_bubble
</span>  Volume: {{ comics[currentComicIndex].volume }}</h3>
  <h3><span class="material-symbols-outlined">
comic_bubble
</span>  Issue Number: {{ comics[currentComicIndex].issueNumber }}</h3>
  <h3><span class="material-symbols-outlined">
comic_bubble
</span>  Number in Your Library: {{ currentComicIndex + 1 }}</h3>

</div>
      <button v-if="!isDropdownOpen(currentComicIndex)" @click.prevent="toggleDropdown(currentComicIndex)"
        class="add-to-collection-button">Add to Collection</button>
      <div v-else>
        <select v-model="selectedCollection" class="collection-dropdown">
          <option v-for="collection in collections" :key="collection.userCollectionId"
            :value="collection.userCollectionId">{{ collection.collectionName }}</option>
        </select>
        <button @click.prevent="addToSelectedCollection(selectedCollection)" type="submit">Add to Selected
          Collection</button>
      </div>
      <button @click.prevent="closeComicPopup">Close</button>
    </div>
  </div>
</template>

<script>
import ListService from '../services/ListService.js';
import ComicService from '../services/ComicService';

export default {
  data() {
    return {
      comics: [],
      currentComicIndex: null,
      collections: [],
      selectedCollection: null,
      dropdownOpenIndex: null,
      howAddToCollectionButton: true,
      throwAwayCollection: {},
    };
  },
  mounted() {
    this.fetchUserComics();
    this.fetchUserCollections();
  },
  methods: {
    fetchUserComics() {
      ListService.getUserComics()
        .then(response => {
          this.comics = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },

    fetchUserCollections() {
      ListService.getCollectionsByUserId(this.$store.state.user.id)
        .then(response => {
          this.collections = response.data;
        })
        .catch(error => {
          console.log("Unable to retrieve user collections", error);
        })
    },
    openComicPopup(index) {
      // Open the modal and set the currentComicIndex
      this.currentComicIndex = index;
    },
    closeComicPopup() {
      // Close the modal by resetting the currentComicIndex
      this.currentComicIndex = null;
    },
    addToCollection(index) {
      // Implement logic to add the selected comic to the selected collection
      console.log(`Add comic to collection ${this.selectedCollection}`);
      // Close the modal
      this.closeComicPopup();
    },
    selectComic(index) {
      // Toggle the selected comic index
      this.currentComicIndex = this.currentComicIndex === index ? null : index;
    },
    toggleDropdown(index) {
      // Toggle the dropdown menu for the specified comic
      this.dropdownOpenIndex = this.dropdownOpenIndex === index ? null : index;
      this.showAddToCollectionButton = false;
    },
    isDropdownOpen(index) {
      // Check if the dropdown menu is open for the specified comic
      return this.dropdownOpenIndex === index;
    },
    addToSelectedCollection(collectionId) {
      ComicService.addComicToCollection(collectionId, this.comics[this.currentComicIndex].comicId)
        .then(response => {
          this.throwAwayCollection = response.data;
          this.closeComicPopup();
          this.$router.push('/user');
        })
        .catch(error => {
          console.log("Unable to add Comic to collection.", error);
        })
    },
  },
}
</script>

<style scoped>

button{
  margin:1px 15px 1px 15px;
}
.comic-collection {
  display: flex;
  flex-direction: row;
  max-width: 00px;
}

.comics-container {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin: 20px;
  border: 0px dashed black;
  box-shadow: 0 8px 8px rgba(0, 0, 0, 0.2);
}

.comic-thumbnail {
  cursor: pointer;
  margin: 20px;
  margin-right: 40px;
}

.add-to-collection-button {
  margin-top: 20px;


}

.collection-dropdown {
  margin-top: 10px;
}

.add-to-collection-button:hover .collection-dropdown {
  display: block;

}

.small-thumbnail {
  max-width: 100%;
  max-height: 100%;
  width: 120px;
  height: auto;
}

.selected .thumbnail-inner {
  transform: rotateY(180deg);
}

.add-to-collection-button {
  margin-top: 10px;
}

.comic-popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 50px;
  background-color: rgba(255, 255, 255,.75);
  border-left: 12px solid #f6ed30;;
  border-top:10px solid  #ee2a4e;
  border-right:10px solid  #17a790;
  border-bottom:12px solid  rgba(255, 0, 0, 0.781);
  border-radius: 50% ;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.825);
  z-index: 0;
  
}
.material-symbols-outlined {
  font-variation-settings:
    'FILL' 1,
    'wght' 300,
    'GRAD' 45 ,
    'opsz' 24;
}
.material-symbols-outlined {
color: #17a790;

  
  
}

.pop-out-form label {
  display: block;
  margin-bottom: 5px;
}

.pop-out-form input {
  width: 92%;
  padding: 8px;
  margin-bottom: 10px;
}

.pop-out-form button {
  width: 100%;
  padding: 10px;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.pop-out-form button:hover {
  background-color: #17a790;
}

.exit-button {
  position: fixed;
  top: 10px;
  right: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 10px;
  border: solid 1px black !important;
  cursor: pointer;
  width: 15px !important;
  height: 15px !important;
 
}

.sub-heading {
  text-align: center;
  font-weight: bold;

}


</style>
