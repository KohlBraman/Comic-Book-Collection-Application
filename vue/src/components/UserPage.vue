<template>
    <div class="welcome-box">
        <h1>Welcome to your profile!</h1>
    </div>
    <div class="comic-collection">
        <ComicCollection/>
    </div>
    <div class="main-container">

        <div class="profile-container">

            <div class="content-box">

                <div class="icon-choice-box">
                    <div id="ProfileIcon">
                        <img src="../assets/superman.jpeg" alt="profile picture placeholder">
                    </div>
                    <div id="ProfilePrompt">
                        <p>Which mask do you wear?</p>
                    </div>
                </div>


                <div class="update-profile-box">
                    <button @click="toggleDropdown">Update Profile</button>
                    <div v-show="showDropdown" class="dropdown-content">
                        <UpdateProfile />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
  
<script>
import UpdateProfile from '../components/UpdateProfile.vue';
import ComicCollection from '../components/ComicCollection.vue';

export default {
    data() {
        return {
            showDropdown: false
        };
    },
    methods: {
        toggleDropdown() {
            this.showDropdown = !this.showDropdown;
        }
    },
    components: {
        UpdateProfile,
        ComicCollection
    },
}
</script>
  
<style scoped>

.comic-collection {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    /* border: solid black; */
    max-width: 800px;
   margin: 0 auto;
    
  }
  .main-container {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    margin-top: -300px;
    

}


.profile-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    
    margin-bottom: 100px;
}

#profileIcon {
    align-items: center;
    
}

.welcome-box {
    margin-bottom: 20px;
}

.content-box {
    display: flex;
    flex-direction: column;

    align-items: flex-start;
    width: 100%;
}

.dropdown-content {
    max-width: 200px;
    max-height: 200px;
    margin-top: 10px;

}

.icon-choice-box {
    margin-bottom: 20px;

}

.update-profile-box {
    flex: 1;
    margin-top: 10px;

}

h1 {
    text-align: center;
}
</style>