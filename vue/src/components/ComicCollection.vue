<template>
  <div class="comic-collection">
    <div class="comics-container">
      <!-- Display all comics as thumbnails -->
      <div v-for="(comic, index) in comics" :key="index" @click="selectComic(index)" :class="{ 'selected': index === currentComicIndex }" class="comic-thumbnail">
        <div class="thumbnail-inner">
          <div class="front" v-if="index !== currentComicIndex">
            <img :src="comic.coverImg" :alt="comic.title" class="small-thumbnail">
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
    };
  },
  mounted() {
    this.fetchComics();
  },
  methods: {
    fetchComics() {
      ListService.getComics()
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
  },
};
</script>

<style scoped>
.comic-collection {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  border: 1px solid black;
  max-width: 800px;
}

.comics-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.comic-thumbnail {
  cursor: pointer;
  margin: 10px; /* Increase margin for better spacing */
  perspective: 1000px; /* Perspective for the 3D effect */
}

.thumbnail-inner {
  width: 150px; /* Adjust the width of the thumbnail container */
  height: 150px; /* Adjust the height of the thumbnail container */
  transform-style: preserve-3d; /* Preserve 3D transformations */
  transition: transform 0.5s; /* Add a smooth transition effect */
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
</style>
