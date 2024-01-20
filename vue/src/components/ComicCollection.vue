<template>
    <div class="comic-collection">
      <div class="comics-container">
        <!-- Display all comics as thumbnails -->
        <div v-for="(comic, index) in comics" :key="index" @click="selectComic(index)" class="comic-thumbnail">
          <img :src="comic.image" :alt="comic.alt">
        </div>
      </div>
  
      <div class="current-comic">
        <!-- Display the currently selected comic with description -->
        <img :src="currentComic.image" :alt="currentComic.alt">
        <p>{{ currentComic.description }}</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        comics: [
          {
            image: "../assets/comic1.jpg",
            alt: "Comic 1",
            description: "Comic 1 Description"
          },
          {
            image: "../assets/comic2.jpg",
            alt: "Comic 2",
            description: "Comic 2 Description"
          },
          // Add more comics as needed
        ],
        currentComicIndex: 0
      };
    },
    computed: {
      currentComic() {
        return this.comics[this.currentComicIndex];
      }
    },
    methods: {
      selectComic(index) {
        this.currentComicIndex = index;
      }
    }
  };
  </script>
  
  <style scoped>
  .comic-collection {
    display: none;
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
    margin-bottom: 100%;
    
  }
  
  .comic-thumbnail {
    cursor: pointer;
    margin: 5px;
  }
  
  .current-comic {
    text-align: center;
  }
  
  img {
    max-width: 100%;
  }
  
  p {
    margin-top: 10px;
  }
  </style>
  