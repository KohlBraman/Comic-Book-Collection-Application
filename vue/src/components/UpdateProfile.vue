<template>
    <div>
        <form @submit.prevent="updateProfile">
            <label for="username">Username:</label>
            <input type="text" id="username" v-model="profile.username" required>

            

            <!-- <label for="bio">Bio:</label>
            <textarea id="bio" v-model="profile.bio"></textarea> -->

            <button type="submit">Update Profile</button>
            <div>
            
            <p><strong>Username:</strong> {{ profile.username }}</p>
            <!-- <p><strong>Bio:</strong> {{ profile.bio }}</p> -->
        </div>
        </form>
       
    </div>
</template>
<script>
export default {
    data() {
        return {
            profile: {
                username: ''
                // bio: ''
            }
        };
    },
    methods: {
        updateProfile() {
            console.log('Profile updated:', this.profile);
        }
    }
};

</script>