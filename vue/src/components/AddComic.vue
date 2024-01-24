<template>
  <div>
    <div v-if="!hasComics && userComics.length === 0">
      <p>Please add comics before using this form.</p>
      <button @click="redirectToCreateComic">Add Comics</button>
    </div>
    <!-- Button to toggle the AddComic form -->
    <button @click="toggleAddComicForm">{{ showForm ? 'Close Form' : 'Add Comic' }}</button>

    <!-- The AddComic form (conditionally shown/hidden) -->
    <div v-show="showForm">
      <h2>Add Comic</h2>
      <form @submit.prevent="addComic">
        <label for="title">Title:</label>
        <input v-model="comic.title" type="text" id="title" required>
        <label for="cover-img">Cover Image:</label>
        <input v-model="comic.coverImg" type="text" id="cover-img" required>
        <label for="volume">Volume:</label>
        <input v-model="comic.volume" type="text" id="volume" required>
        <label for="issue-num">Issue Number:</label>
        <input v-model="comic.issueNumber" type="number" id="issue-num" required>
        <label for="cover-date">Cover Date:</label>
        <input v-model="comic.coverDate" type="date" id="cover-date" required>

        <label for="author">Author:</label>
        <input v-model="comic.author" type="text" id="author" required>

        <button type="submit">Add Comic</button>
      </form>
    </div>
  </div>
</template>

<script>
import comicService from '../services/ComicService';
import ListService from '../services/ListService';

export default {
  data() {
    return {
      showForm: false,
      comic: {
        title: '',
        coverImg: '',
        volume: '',
        issueNumber: '',
        coverDate: '',
        writer: '',
        artist: '',
        colorist: '',
        editor: '',
        inker: '',
        letterer: ''
      },
      hasComics: false,
      userComics: [], // Initialize userComics array
    };
  },
  methods: {
    toggleAddComicForm() {
      this.showForm = !this.showForm;
    },
    addComic() {
      comicService.addComic(this.$store.state.user.id, this.comic)
        .then(response => {
          // Handle success logic
          this.isLoading = false;
          this.comic = response.data;
          console.log(this.comics);
          this.$router.push('/user');
        })
        .catch(error => {
          console.log(error);
        });
    },
    fetchUserComics() {
      ListService.getComicsByUserId(this.$store.state.user.id)
        .then(response => {
          this.userComics = response.data;
          this.hasComics = this.userComics.length > 0; // Update hasComics based on the length of userComics
        })
        .catch(error => {
          console.log(error);
        });
    },
  },
  mounted() {
    this.fetchUserComics(); // Fetch user's comics when the component is mounted
  },
};
</script>

<style scoped>
  /* ... (your existing styles) */
</style>
