<template>
  <div class="centered-container" @click="showPowMessage">
    <h2 class="centered-header">Top Comic Book</h2>
    <div class="comic-box" :style="{ transform: `rotate(${rotation}deg)` }">
      <div class="comic-content">
        <img :src= "currentComic.coverImg" alt="Comic Cover" class="comic-cover" />
        
        <div class="comic-info">
          <div class="info-group">
            <h3 class="main-title">{{ currentComic.title }}<span class="issue-number"> Issue {{ currentComic.issueNumber
            }} </span></h3>
          </div>
          <p class="info-group-d">{{ currentComic.volume }}</p>
          <div>
            <p class="title">Description</p>
            <p class="info-group">{{ currentComic.synopsis }}</p>
          </div>
          <div>
            <p class="title">Published Date</p>
            <p class="info-group">{{ currentComic.coverDate }}</p>
          </div>
        </div>
      </div>
    </div>
    <div class="navigation" ref="nextButton">
      <button @click="prevItem" :disabled="currentIndex === 0">Previous</button>
      <span>{{ currentComic.title }}</span>
      <button @click="nextItem" :disabled="currentIndex === comics.length - 1">Next</button>
    </div>
    <pow-bubble v-if="showPow" :showPow="showPow" :powTop="powTop" :powLeft="powLeft" @close="handlePowClose" />

  </div>
</template>


<script>
import PowBubble from "../components/PowBubble.vue";
import ListService from "../services/ListService"
export default {
  components: {
    PowBubble,
  },

  data() {
    return {
      comics: [

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
  
      return this.comics[this.currentIndex] || {};
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


  },
  created() {
    ListService.getComics()
      .then(response => {
        this.isLoading = false;
        this.comics = response.data
        console.log(this.comics); 
      })
      .catch(error => {
        console.log(error);
      })

  },
}

</script>
<style scoped>




@media (min-width: 768px) {
  .centered-container {
    padding: 5% 10% 2%; 
   
  }
}


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
  font-weight: bolder;
 
}

.info-group-d {
  display: flex;
  margin-bottom: 10px;
  margin-left: 10px;
  max-width: 600px;
  line-height: 1.3;
  font-weight: bolder;
  font-size: 18px
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
  height: 40em;
  padding: 5%;
  margin-top: -30px;
  color: #39200a;
  box-shadow: 0 8px 8px rgba(0, 0, 0, 0.2);
  
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

  background-size: 50cap;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);

}

.comic-content {
  display: flex;
  margin: 1%;
  background-color: rgba(255, 255, 255, .9);
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);

}



.comic-cover {
  width: 25%;
  height: auto;
  margin-right: 10px;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
}

.navigation {
  display: flex;
  justify-content: space-between;
}

button {
  margin: 5px;
  cursor: pointer;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
}
</style>