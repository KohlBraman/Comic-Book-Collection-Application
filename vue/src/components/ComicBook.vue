<!-- <template>
  <div>
    <h2>Comic Book Details</h2>
    
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
  
    const comicId = this.$route.params.id;
    
    this.fetchComicDetails(comicId);
  },
  methods: {
    fetchComicDetails(comicId) {
    
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

</style> -->