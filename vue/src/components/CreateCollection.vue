<template>
    <div>
      <h2>Create Collection</h2>
      <form @submit.prevent="createCollection">
        <label for="collection-name">Collection Name:</label>
        <input v-model="collection.collectionName" type="text" id="collection-name" required>
        <button type="submit">Create Collection</button>
      </form>
  
      <!-- Display user's collections -->
      <div v-if="userCollections.length > 0">
        <h3>User Collections:</h3>
        <ul>
          <li v-for="(collection, index) in userCollections" :key="index">
            {{ collection.collectionName }}
            <!-- Add a form for adding comics to this collection -->
            <form @submit.prevent="addComicToCollection(collection.userCollectionId)">
              <label for="comic-title">Comic Title:</label>
              <input v-model="newComics[collection.userCollectionId]" type="text" id="comic-title" required>
              <!-- Add more fields as needed -->
              <button type="submit">Add Comic</button>
            </form>
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  import ComicService from '../services/ComicService';
  import ListService from '../services/ListService';
  
  export default {
    data() {
      return {
        collection: {
          collectionName: ''
        },
        newComics: {}, // Use an object to store new comics for each collection
        userCollections: []
      };
    },
    methods: {
      createCollection() {
        const collectionData = JSON.parse(JSON.stringify(this.collection));
  
        ComicService.addCollection(this.$store.state.user.id, collectionData)
          .then(response => {
            console.log('Collection created:', response.data);
            this.fetchUserCollections();
            this.$router.push('/user');
          })
          .catch(error => {
            console.error('Error creating collection:', error);
          });
      },
  
      fetchUserCollections() {
        ListService.getCollectionByUserId(this.$store.state.user.id)
          .then(response => {
            this.userCollections = response.data;
            console.log('User collections:', this.userCollections);
          })
          .catch(error => {
            console.error('Error fetching user collections:', error);
          });
      },
  
      addComicToCollection(collectionId) {
        const comicTitle = this.newComics[collectionId];
        if (comicTitle) {
          const comicData = { title: comicTitle }; // Adjust as needed
  
          ComicService.addComicToCollection(collectionId, comicData)
            .then(response => {
              console.log('Comic added to collection:', response.data);
              // Optionally, update the userCollections after adding the comic
              this.fetchUserCollections();
            })
            .catch(error => {
              console.error('Error adding comic to collection:', error);
            });
  
          // Clear the input after adding the comic
          this.newComics[collectionId] = '';
        }
      },
    },
    mounted() {
      this.fetchUserCollections();
    },
  };
  </script>
  