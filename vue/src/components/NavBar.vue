<template>
    <div class="headerNav">



        <ul class="nav-links">
            <li id="home"><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
            <li id="logout"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
            </li>
        </ul>
    </div>
</template>



<script>
export default {

}

</script>



<style scoped>
#headerNav {

    justify-content: flex-start;

}

#headerNav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: red;
    width: 100%;
    height: 100px
}

.nav-links {
    display: flex;
    list-style: none;
    margin: 0;
    padding: 0;
    padding: 10px;
    flex-shrink: 1;
}

.nav-links li {
    justify-content: flex-start;
    text-align: center;
}

.nav-links a {
    color: rgb(0, 0, 0);
    text-decoration: none;
    font-size: 20px;
    font-family: fantasy;
    background-color: rgb(255, 255, 255);
    border: 2px solid;
    padding: 10px;

}
</style>