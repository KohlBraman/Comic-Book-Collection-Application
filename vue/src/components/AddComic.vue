<!-- AddComic.vue -->

<template>
  <div>
    <!-- Button to toggle the AddComic form -->
    <button @click="toggleAddComicForm">{{ showForm ? 'Close Form' : 'Add Comic' }}</button>

    <!-- The AddComic form (conditionally shown/hidden) -->
    <div v-show="showForm">
      <h2>Add Comic</h2>
      <form @submit.prevent="addComic">
        <!-- Input fields for comic details -->
        <label for="title">Title:</label>
        <input v-model="comic.title" type="text" id="title" required>
        <label for="cover-img">Cover Image:</label>
        <input v-model="comic.coverImg" type="text" id="cover-img" required>
        <label for="volume">Volume:</label>
        <input v-model="comic.volume" type="number" id="volume" required>
        <label for="issue-num">Issue Number:</label>
        <input v-model="comic.issueNumber" type="number" id="issue-num" required>
        <label for="cover-date">Cover Date:</label>
        <input v-model="comic.coverDate" type="date" id="cover-date" required>

        <label for="author">Author:</label>
        <input v-model="comic.author" type="text" id="author" required>

        <!-- Add more fields as needed -->

        <button type="submit">Add Comic</button>
      </form>
    </div>
  </div>
</template>

<script>
import comicService from '../services/ComicService';

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
    };
  },
  methods: {
    toggleAddComicForm() {
      this.showForm = !this.showForm;
    },
    addComic() {
      comicService.addComic(this.$store.state.user.id, this.comic)
        .then(response => {
          this.isLoading = false;
          this.comic = response.data;
          console.log(this.comics);
          this.$router.push('/user');
        })
        .catch(error => {
          console.log(error);
        });



  // // Perform any validation or additional logic here
        // // Once validated, emit an event or call a method to add the comic to the user's collection
        // this.$emit('add-comic', this.comic);
        
        // // Optionally, you can reset the form fields
        // this.comic = { title: '', author: '' };
  
        // // Hide the form after adding the comic
        // this.showForm = false;
      }
    }
  };
  </script>
  <style>
  button {
      background-color: rgb(199, 13, 13);
      color: black;
      padding: 5px 23px;
      margin-top: 3%;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 12px;
      font-weight: bold;
      box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
    }
  </style>
