<template>
  <div>
    <h2>Comic Book Details</h2>
    <!-- Display basic information about a comic book -->
  </div>
</template>

<script>
export default {
    data() {
    return {
      comic: {} 
    };
  },
  created() {
    // Fetch comic data using an API call or other methods
    const comicId = this.$route.params.id;
    
    this.fetchComicDetails(comicId);
  },
  methods: {
    fetchComicDetails(comicId) {
      // Make an API call to fetch comic details
      this.$store.dispatch('comics/fetchComicDetails', comicId)
        .then(comic => {
          this.comic = comic;
          
        })
        .catch(error => {
          console.error('Error fetching comic details:', error);
        });
    }
  }
};
</script>

<style scoped>

</style>