<template>
    <div v-if="showPow" class="pow-bubble" :style="{ top: powTop, left: powLeft }">
      <span class="pow-text">POW!</span>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      showPow: Boolean,
    },
    data() {
      return {
        powTop: 0,
        powLeft: 0,
      };
    },
    watch: {
      showPow(newVal) {
        if (newVal) {
          this.generateRandomPosition();
          setTimeout(() => {
            this.$emit('close'); // Emit the 'close' event to notify parent component to hide the POW bubble
          }, 1000); // Hide after 1 second (adjust as needed)
        }
      },
    },
    methods: {
        generateRandomPosition() {
      // Adjust the calculation to consider the bubble's size
      const bubbleSize = 100; // adjust this based on your actual bubble size
      const randomTop = Math.floor(Math.random() * (window.innerHeight - bubbleSize)) + 'px';
      const randomLeft = Math.floor(Math.random() * (window.innerWidth - bubbleSize)) + 'px';
      this.powTop = randomTop;
      this.powLeft = randomLeft;
    },
    },
  };
  </script>
  
  <style scoped>
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
    margin-right: 40px;
  }
  </style>
  