<template>
  <div>
    <h2>Create A Collection</h2>
    <form @submit.prevent="createCollection">
      <label for="collection-name">Name:</label>
      <input v-model="collection.collectionName" type="text" id="collection-name" required>
      <button class="center-button" type="submit">Create Collection</button>
    </form>

  
   
  </div>
</template>

<script>

import ComicService from '../services/ComicService';
import ListService from '../services/ListService';

export default {
  components: {
   
  },
  data() {
    return {
      collection: {
        collectionName: '',
      },
      newComics: {}, // Use an object to store new comics for each collection
      userCollections: [],
    };
  },
  methods: {
    createCollection() {
    
      ComicService.addCollection(this.$store.state.user.id, this.collection)
        .then(response => {
          console.log('Collection created:', response.data);
          this.userCollections.push(response.data); // Add the new collection to userCollections
          this.collection.collectionName = ''; // Clear the input field
        })
        .catch(error => {
          console.error('Error creating collection:', error);
        });
        this.$router.go('/user');
    },

    fetchUserCollections() {
      ListService.getCollectionsByUserId(this.$store.state.user.id)
        .then(response => {
          this.userCollections = response.data;
          console.log('User collections:', this.userCollections);
        })
        .catch(error => {
          console.error('Error fetching user collections:', error);
        });
    },
  },
  mounted() {
    this.fetchUserCollections();
  },
};
</script>
  
  <style scoped>

  .comic-thumbnail {
    max-width: 100px; /* Adjust the desired maximum width */
    max-height: 150px; /* Adjust the desired maximum height */
  }
  h2{
  text-align: center;
  font-family: "acme";
  font-size: 16px;
}
  .center-button {
    display: block;
    margin: 0 auto;
    margin-top: 20px; /* Adjust the margin as needed */
    margin-bottom: 10px;
  } 
  #collection-name {
    width: 70%; /* Adjust the width as needed */
    padding: 4px; /* Add padding for better appearance */
  }
   
  
</style>


