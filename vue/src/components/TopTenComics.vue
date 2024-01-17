<template>
    <div class="centered-container" @click="showPowMessage">
      <h2 class="centered-header">Top Comic Book</h2>
      <div class="comic-box" :style="{ transform: `rotate(${rotation}deg)` }">
        <div class="comic-content">
          <img :src="currentComic.cover" alt="Comic Cover" class="comic-cover" />
          <div class="comic-info">
            <h3>{{ currentComic.title }}</h3>
            <p>{{ currentComic.description }}</p>
            <!-- Add more info here -->
          </div>
        </div>
      </div>
      <div class="navigation" ref="nextButton">
      <button @click="prevItem" :disabled="currentIndex === 0">Previous</button>
      <span>{{ currentComic.title }}</span>
      <button @click="nextItem" :disabled="currentIndex === comics.length - 1">Next</button>
    </div>
    <pow-bubble
      v-if="showPow"
      :showPow="showPow"
      :powTop="powTop"
      :powLeft="powLeft"
      @close="handlePowClose"
    />
  </div>
</template>
  
  
  <script>
  import PowBubble from "../components/PowBubble.vue";
  export default {
    components: {
    PowBubble,
  },
    data() {
      return {
        comics: [
        { title: 'Amazing Fantasy', cover: this.$store.state.comicCover , description: 'Description for Comic 1' },
        { title: 'Comic 2', cover: 'url_to_comic2_cover.jpg', description: 'Description for Comic 2' },
        { title: 'Comic 3', cover: 'url_to_comic3_cover.jpg', description: 'Description for Comic 3' },
        { title: 'Comic 4', cover: 'url_to_comic4_cover.jpg', description: 'Description for Comic 4' },
        { title: 'Comic 5', cover: 'url_to_comic5_cover.jpg', description: 'Description for Comic 5' },
        { title: 'Comic 6', cover: 'url_to_comic6_cover.jpg', description: 'Description for Comic 6' },
        { title: 'Comic 7', cover: 'url_to_comic7_cover.jpg', description: 'Description for Comic 7' },
        { title: 'Comic 8', cover: 'url_to_comic8_cover.jpg', description: 'Description for Comic 8' },
        { title: 'Comic 9', cover: 'url_to_comic9_cover.jpg', description: 'Description for Comic 9' },
        { title: 'Comic 10', cover: 'url_to_comic10_cover.jpg', description: 'Description for Comic 10' }
        
        ],
        currentIndex: 0,
      rotation: 0,
      showPow: false,  
      powTop: 0,
      powLeft: 0,
      };
    },
    computed: {
      currentComic() {
        return this.comics[this.currentIndex];
      },
    },
    methods: {
      nextItem() {
        if (this.currentIndex < this.comics.length - 1) {
      this.currentIndex++;
      this.rotation += 720;
      this.showPow = true;

    
      setTimeout(() => {
        this.showPow = false;
      }, 1000); // Hide after 1 second (adjust as needed)
    }
    
  },
  prevItem() {
      if (this.currentIndex > 0) {
        this.currentIndex--;
        this.rotation -= 720;
        this.showPow = true;

        setTimeout(() => {
          this.showPow = false;
        }, 1000); // Hide after 1 second (adjust as needed)
      }
    },
  handlePowClose() {
      // Handle the 'close' event from PowBubble component
      this.showPow = false;
    },
  
}
}

</script>
  
  <style scoped>
  /* Add your component styles here */
  
  .centered-container {
    position: relative; /* Required for positioning the pow bubble */
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh; 
  }

  .centered-header {
    margin-bottom: 20px;
  }
  
  .comic-box {
    border: 1px solid #ccc;
    padding: 10px;
    margin-bottom: 10px;
    transition: transform 0.5s ease; /* CSS transition for rotation effect */
  }
  
  .comic-content {
    display: flex;
  }
  
  .comic-cover {
    width: 25%; 
    height: auto; 
    margin-right: 10px;
  }
  
  .comic-info {
    flex-grow: 1;
  }
  
  .navigation {
    display: flex;
    justify-content: space-between;
  }
  
  button {
    margin: 5px;
    cursor: pointer;
  }
  
  </style>
  
  