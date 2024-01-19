<template>
    <div class="welcome-box">
        <h1>Welcome to your profile!</h1>
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
import UpdateProfile from '../components/UpdateProfile.vue'

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
        UpdateProfile
    },
}
</script>
  
<style scoped>
.main-container {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;

}

.profile-container {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 20px;
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