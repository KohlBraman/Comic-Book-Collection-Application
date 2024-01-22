<!-- AddComic.vue -->

<template>
    <div>
      <!-- Button to open the AddComic form -->
      <button @click="showAddComicForm">Add Comic</button>
  
      <!-- The AddComic form (initially hidden) -->
      <div v-show="showForm">
        <h2>Add Comic</h2>
        <form @submit.prevent="addComic">
          <!-- Input fields for comic details -->
          <label for="title">Title:</label>
          <input v-model="comic.title" type="text" id="title" required>
  
          <label for="author">Author:</label>
          <input v-model="comic.author" type="text" id="author" required>
  
          <!-- Add more fields as needed -->
  
          <button type="submit">Add Comic</button>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        showForm: false,
        comic: {
          title: '',
          coverImg:'',
          volume:'',
          issueNumber:'',
          coverDate:'',
          writer: '',
          artist:'',
          colorist:'',
          editor:'',
          inker:'',
          letterer:''
          
        }
      };
    },
    methods: {
      showAddComicForm() {
        this.showForm = true;
      },
      addComic() {
        // Perform any validation or additional logic here
        // Once validated, emit an event or call a method to add the comic to the user's collection
        this.$emit('add-comic', this.comic);
        
        // Optionally, you can reset the form fields
        this.comic = { title: '', author: '' };
  
        // Hide the form after adding the comic
        this.showForm = false;
      }
    }
  };
  </script>
  