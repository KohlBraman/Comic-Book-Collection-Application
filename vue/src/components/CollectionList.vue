<!-- CollectionList.vue -->

<template>
  <div>
    <h3>User Collections:</h3>
    <ul>
      <li v-for="(collection, index) in userCollections" :key="index">
        <div class="collection-box">
          <p>{{ collection.collectionName }}</p>

          <!-- Display thumbnail of the first comic and name -->
          <div v-if="collection.comics && collection.comics.length > 0">
            <img :src="collection.comics[0].coverImg" alt="First Comic Thumbnail" class="comic-thumbnail">
            <p>{{ collection.comics[0].title }}</p>
          </div>

          <!-- Add a form for adding comics to this collection -->
          <form @submit.prevent="addComicToCollection(collection.userCollectionId)">
            <label for="comic-title">Comic Title:</label>
            <div class="comic-input">
              <input v-model="comicTitle" type="text" id="comic-title" required>
            </div>
            <!-- Add more fields as needed -->
            <button class="center-button" type="submit">Add Comic</button>
          </form>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    userCollections: Array,
  },
  data() {
    return {
      comicTitle: '', // Local data for the input field
    };
  },
  methods: {
    handleAddComicToCollection(collectionId) {
    if (this.comicTitle) {
      this.$emit('add-comic-to-collection', { collectionId, comicTitle: this.comicTitle });
      this.comicTitle = ''; // Clear the input field
    }
    },
  },
};
</script>

<style scoped>
/* Add styling as needed */
</style>

