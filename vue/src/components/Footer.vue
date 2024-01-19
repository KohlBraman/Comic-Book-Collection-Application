<template>
  <v-footer class="footer-container">
    <div class="header">
      <strong class="strong">Get connected with us on social networks!</strong>

      <v-spacer></v-spacer>


    </div>

    <div class="translucent-cover"></div>

    <div class="footer-text text-center">
      <div class="centered-text">
        {{ new Date().getFullYear() }} — <strong>Vuetify</strong>
      </div>
    </div>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: [],
  }),
};
</script>

<style scoped>
.footer-container {
position: relative;



}

.translucent-cover {
  position: absolute;
  top: 90px;
  right: 0;
  bottom: 0;
  left: 0;
  background-color: rgba(0, 0, 0, 0.3);
  z-index: 0;
}

.footer-text {
  position: relative;
  color: black;
  z-index: 1;
  padding: 8px;
  line-height: 1.5;
}

.centered-text {
  display: flex;
  justify-content: center;
  align-items: center;
}
.strong{
  display: flex;
  justify-content: center;
  align-items: center;
  line-height: 1.5;
  padding-bottom: 10px;
  padding-top:100px ;
}
</style>

