<template>
  <div class="comic-collection">
    <div class="comics-container">
      <!-- Display all comics as thumbnails -->
      <div v-for="(comic, index) in comics" :key="index" class="comic-thumbnail">
        <div class="thumbnail-inner" @click="selectComic(index)" :class="{ 'selected': index === currentComicIndex }">
          <div class="front" v-if="index !== currentComicIndex">
            <img :src="comic.coverImg" :alt="comic.title" class="small-thumbnail">
            <!-- Add button to add to collection -->
            <button @click.stop="toggleDropdown(index)" class="add-to-collection-button">Add to Collection</button>
            <!-- Dropdown menu -->
            <div v-if="isDropdownOpen(index)" @click.stop>
              <select v-model="selectedCollection" class="collection-dropdown">
                <option v-for="collection in collections" :key="collection.id" :value="collection.id">{{ collection.name }}</option>
              </select>
              <button @click.stop="addToSelectedCollection(index)">Add to Selected Collection</button>
            </div>
          </div>
          <div class="back" v-if="index === currentComicIndex">
            <!-- Display additional info when the comic is selected -->
            <p>{{ comic.title }}, {{ comic.volume }}, {{ comic.issueNumber }}</p>
            <!-- Add other info as needed -->
          </div>
        </div>
      </div>
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
        // Add more collections as needed
      ],
      selectedCollection: null,
      dropdownOpenIndex: null,
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
    selectComic(index) {
      // Toggle the selected comic index
      this.currentComicIndex = this.currentComicIndex === index ? null : index;
    },
    toggleDropdown(index) {
      // Toggle the dropdown menu for the specified comic
      this.dropdownOpenIndex = this.dropdownOpenIndex === index ? null : index;
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
      this.dropdownOpenIndex = null;
    },
  },
};
</script>

<style scoped>

.comic-collection {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 1px solid black;
  max-width: 800px;
  margin: 0 auto; /* Center the entire component */
}

.comics-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-top: 20px; /* Add space between the comics */
}

.comic-thumbnail {
  cursor: pointer;
  margin: 20px; /* Increase margin for better spacing */
  perspective: 1000px; /* Perspective for the 3D effect */
}

.add-to-collection-button {
  margin-top: 20px; /* Center the button and add space */
}

.collection-dropdown {
  margin-top: 10px;
}

.thumbnail-inner {
  width: 150px;
  height: 150px;
  transform-style: preserve-3d;
  transition: transform 0.5s;
}

.front,
.back {
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden; /* Hide the backface of the elements */
}

.front {
  /* Styles for the front face (small thumbnail) */
}

.back {
  /* Styles for the back face (expanded info) */
  transform: rotateY(180deg); /* Rotate 180 degrees initially (hidden) */
}

.small-thumbnail {
  max-width: 100%; /* Adjust the desired maximum width */
  max-height: 100%; /* Adjust the desired maximum height */
  width: auto;
  height: auto;
}

.selected .thumbnail-inner {
  transform: rotateY(180deg); /* Rotate 180 degrees when selected */
}

.add-to-collection-button {
  margin-top: 10px;
}

.collection-dropdown {
  margin-top: 10px;
}

.add-to-collection-button {
  margin-top: 10px;
}

.collection-dropdown {
  margin-top: 10px;
}


.thumbnail-inner:not(.selected) .back {
  display: none;
}
/* Add your styles here */
.add-to-collection-button {
  margin-top: 10px;
}

.collection-dropdown {
  margin-top: 10px;
}

/* Hide dropdown when not open */
.thumbnail-inner:not(.selected) .back {
  display: none;
}

</style>
