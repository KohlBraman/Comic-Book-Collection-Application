<template>
  <div class="centered-container" @click="showPowMessage">
    <h2 class="centered-header">Top Comic Book</h2>
    <div class="comic-box" :style="{ transform: `rotate(${rotation}deg)` }">
      <div class="comic-content">
        <img :src="currentComic.cover" alt="Comic Cover" class="comic-cover" />
        <div class="comic-info">
<div class="info-group">
  <h3 class="main-title">{{ currentComic.title }}<span class="issue-number">  Issue {{ currentComic.issueNumber }}  </span></h3>
</div>
<p class="info-group-d">{{ currentComic.description }}</p>
<div>
  <p class="title">Published Date</p>
  <p class="info-group">{{ currentComic.publishDate }}</p>
</div>
<div >
  <p class="title">Author</p>
  <p class="info-group">{{ currentComic.Writer }}</p>
</div>
<div >
  <p class="title">Penciler</p>
  <p class="info-group">{{ currentComic.Penciler }}</p>
</div>
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
      { title: 'Amazing Fantasy', cover: this.$store.state.comicCover , description: this.$store.state.description, issueNumber:` 15`, Writer: " Stan Lee", Penciler: "Steve Ditko", publishDate: "August 01, 1962"},
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

.comic-info {
display: flex;
flex-direction: column;
align-items: left;


}
.issue-number {
margin-left: 200px; 
font-style: italic;
}
.info-group {
display: flex;
margin-bottom: 10px; 
margin-left: 10px; 
max-width: 600px;
font-weight:bolder;
}

.info-group-d {
display: flex;
margin-bottom: 10px; 
margin-left: 10px; 
max-width: 600px;
line-height: 1.3;
font-weight:bolder;
font-size:18px
}
.main-title {

font-size: 30px;
}
.title {
margin-left: 10px; 
font-size: 25px;
}


.centered-container {
position: relative;
display: flex;
flex-direction: column;
align-items: center;
justify-content: center;
height: 100vh;
padding: 3%;
color: #39200a;
}

.centered-header {
margin-bottom: 20px;
}

.comic-box {
border: 1px solid #ccc;
padding: 10px;
margin-bottom: 10px;
transition: transform 0.5s ease;
background-image: url(../assets/aBackround.jpeg);
background-size:50cap;



}

.comic-content {
display: flex;
margin: 1%;
background-color:rgba(255, 255, 255, .9);

}

.comic-cover {
width: 25%;
height: auto;
margin-right: 10px;
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