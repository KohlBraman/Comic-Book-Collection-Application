import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:9000"

// });
export default{

    getComics(){
        return axios.get('/comics');
    },

    getUserComics(){
        return axios.get('/user/comics');
    },

    getComicsByUserId(user_id){
        return axios.get(`/user/${user_id}/comics`);
    },

    getCollectionByUserId(user_id){
        return axios.get(`/user/${user_id}/collections`)
    },

    getCollectionByByTitle(){
        return axios.get('/collections/search')
    }
}