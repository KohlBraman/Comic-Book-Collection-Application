<template>
  <div>
 
    <!-- Button to toggle the AddComic form -->
    <button @click="toggleAddComicForm">{{ showForm ? 'Close Form' : 'Add Comic' }}</button>

    <!-- The AddComic form (conditionally shown/hidden) -->
    <div v-show="showForm" class="pop-out-form" :style="{ 'z-index': showForm ? 1 : 0 }">
      <button @click="toggleAddComicForm" class="exit-button">X</button>
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
      userComics: [], 
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
      window.location.reload(); // Reload the page
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
.pop-out-form {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 20px;
  background-color: rgba(255, 255, 255, 0.89);
  border: 1px solid #ccc;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  z-index: 0; 
}

.pop-out-form label {
  display: block;
  margin-bottom: 5px;
}

.pop-out-form input {
  width: 92%;
  padding: 8px;
  margin-bottom: 10px;
}

.pop-out-form button {
  width: 100%;
  padding: 10px;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.pop-out-form button:hover {
  background-color: #17a790;
}
.exit-button {
  position: fixed;
  top: 10px;
  right: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 10px;
  border: solid 1px black !important;
  cursor: pointer;
  width: 15px !important; /* Adjust the size as needed */
  height: 15px !important; /* Adjust the size as needed */
}
</style>
