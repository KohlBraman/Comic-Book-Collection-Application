<template>
  <div class="comic-collection">
    <div class="comics-container">
      <div v-for="(comic, index) in comics" :key="index" class="comic-thumbnail">
        <div @click="selectComic(index)" :class="{ 'selected': index === currentComicIndex }">
          <img :src="comic.coverImg" :alt="comic.title" class="small-thumbnail">
        </div>
      </div>
    </div>

    <div v-if="currentComicIndex !== null" class="comic-popup">
      <div class="comic-info">
  <h2>{{ comics[currentComicIndex].title }}</h2>
  <p>Volume: {{ comics[currentComicIndex].volume }}</p>
  <p>Issue Number: {{ comics[currentComicIndex].issueNumber }}</p>
</div>
      <button v-if="!isDropdownOpen(currentComicIndex)" @click.stop="toggleDropdown(currentComicIndex)" class="add-to-collection-button">Add to Collection</button>
      <div v-else @click.stop>
        <select v-model="selectedCollection" class="collection-dropdown">
          <option v-for="collection in collections" :key="collection.id" :value="collection.id">{{ collection.name }}</option>
        </select>
        <button @click.stop="addToSelectedCollection(currentComicIndex)">Add to Selected Collection</button>
      </div>
      <button @click.stop="closeComicPopup">Close</button>
    </div>
  </div>
</template>

<script>
import ListService from '../services/ListService.js';

export default {
  data() {
    return {
      comics: [],
      currentComicIndex: null,
      collections: [
        { id: 1, name: 'Collection 1' },
        { id: 2, name: 'Collection 2' },
      ],
      selectedCollection: null,
      dropdownOpenIndex: null,
      howAddToCollectionButton: true,
    };
  },
  mounted() {
    this.fetchUserComics();
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
    addToSelectedCollection(index) {
      // Implement logic to add the selected comic to the selected collection
      // You can show a success message or perform any other action here
      console.log(`Add comic to collection ${this.selectedCollection}`);
      // Close the dropdown menu
      this.closeComicPopup();
    },
  },}
</script>

<style scoped>
.comic-collection {
  display: flex;
  flex-direction: row;
  border: 1px solid black;
  max-width: 200px;
}

.comics-container {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin-top: 20px;
  /* Add space between the comics */
}

.comic-thumbnail {
  cursor: pointer;
  margin: 20px; /* Increase margin for better spacing */
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
  /* Adjust the desired maximum width */
  max-height: 100%;
  /* Adjust the desired maximum height */
  width: 120px;
  height: auto;
}

.selected .thumbnail-inner {
  transform: rotateY(180deg);
  /* Rotate 180 degrees when selected */
}

.add-to-collection-button {
  margin-top: 10px;
}

.comic-popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  padding: 60px;
  z-index: 1000;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  text-align: center;
}
.pop-out-form {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 20px;
  background-color: rgba(255, 255, 255, 0.89);
  border: 1px solid #ccc;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  z-index: 0; 
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
  width: 15px !important; /* Adjust the size as needed */
  height: 15px !important; /* Adjust the size as needed */
}

</style>
