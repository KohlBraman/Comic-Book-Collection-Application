<!-- CollectionList.vue -->

<template>
  <div>
    <h2>User Collections</h2>
    <section></section>
    <ul class="list">
      <li v-for="(collection, index) in userCollections" :key="index">
        <div class="collection-box">
          <div class="title-container">
          <p class="on-page-title"><span class="material-symbols-outlined">
              top_panel_open
            </span> {{ collection.collectionName }}</p>
            
          </div>

          <div v-if="collection.comics && collection.comics.length > 0" class="comics-container">
            
            <img :src="collection.comics[0].coverImg" alt="First Comic Thumbnail" class="comic-thumbnail">
        
            <p>{{ collection.comics[0].title }} </p>


          </div>

          <!-- Add a form for adding comics to this collection -->
          <form @submit.prevent="addComicToCollection(collection.userCollectionId)">

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
h2{
  text-align: center;
  font-family: "acme";
  font-size: 35px;
}
.on-page-title {
  
  font-family: 'bangers';
  font-size: 25px;
  color: white; /* Set the text color */
  padding: 1%; 
  transform: rotate(-90deg);
  text-align: center; /* Center the text */
  
  
}

.title-container{
  background-image: linear-gradient(
    to bottom,
    rgba(23, 167, 144, 0.4),
    rgba(255, 0, 34, 0.3)
    ), url("../assets/footer.jpeg");
/* background-image: url("../assets/footer.jpeg"); */
transform: rotate(90deg); /* Rotate the background image by 90 degrees */
background-size:300%;
border-radius: 5px; /* Add border-radius for rounded corners */
height:150px;
width:200px;
display: flex;
align-items: center;

  
}
section {
  border: 1px dashed #000;
  /* 1px solid black border around the section */
  width: 100%;
  margin-top:-5% ;
}

.list {
  list-style-type: none;
  display: inline-block;
  display: flex;
  margin-top: 50px;
}

.comics-container {
  display: flex;
  align-items: center;
}
.material-symbols-outlined {
  font-variation-settings:
    'FILL' 1,
    'wght' 400,
    'GRAD' 0,
    'opsz' 24;

  color: #17a790;
}
</style>

