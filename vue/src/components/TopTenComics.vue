<!-- TopTenList.vue -->
<template>
    <div class="centered-container" @click="showPowMessage">
      <h2 class="centered-header">Top Comic Book</h2>
      <div class="comic-box" :style="{ transform: `rotate(${rotation}deg)` }">
        <div class="comic-content">
          <img :src="currentComic.cover" alt="Comic Cover" class="comic-cover" />
          <div class="comic-info">
            <h3>{{ currentComic.title }}</h3>
            <p>{{ currentComic.description }}</p>
            <!-- Add more info as needed -->
          </div>
        </div>
      </div>
      <div class="navigation">
        <button @click="prevItem" :disabled="currentIndex === 0">Previous</button>
        <span>{{ currentComic.title }}</span>
        <button @click="nextItem" :disabled="currentIndex === comics.length - 1">Next</button>
      </div>
      <div v-if="showPow" class="pow-bubble" :style="{ top: powTop, left: powLeft }"><span class="pow-text">POW!</span></div>
    </div>
  </template>
  
  
  <script>
  export default {
    data() {
      return {
        comics: [
        { title: 'Comic 1', cover: 'url_to_comic1_cover.jpg', description: 'Description for Comic 1' },
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
          this.rotation += 360; // Rotate by 360 degrees for a full rotation
        }
      },
      prevItem() {
        if (this.currentIndex > 0) {
          this.currentIndex--;
          this.rotation -= 360; // Rotate by -360 degrees for a full rotation in the opposite direction
        }
      },
      showPowMessage(event) {
        this.showPow = true;
        this.powTop = event.clientY - 100 + 'px';
        this.powLeft = event.clientX - 100 +'px';
        setTimeout(() => {
          this.showPow = false;
        }, 1000); // Hide after 1 second (adjust as needed)
      },
    },
  };
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

  .pow-bubble {
  position: absolute;
  background: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/electric.svg);
  background-color: red;
  background-size: cover;
  color: black;
  padding: 2% 2% 2% 2%;
  font-size: 2.1vw;
  font-style: italic;
  font-weight: bold;
  border-radius: 10px;
  display: inline-block;
  text-align: center;
}
.pow-text {
    font-size: 35px;
    font-weight: bold;
    text-align: left;
    margin-right:40px
  
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
    width: 100%; 
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
  
  