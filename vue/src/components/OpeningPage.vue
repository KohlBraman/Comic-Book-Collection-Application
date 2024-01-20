
<template>
    <div>
        <h1>Welcome to the Opening Page</h1>
        <TopTenComics />
    </div>
</template>
  
<script>
import TopTenComics from '../components/TopTenComics.vue';

export default {
    components: {
        TopTenComics,
    },
};
</script>
  
<style scoped>
h1{
    text-align: center;
    margin-top: 50px;
}
</style>
  