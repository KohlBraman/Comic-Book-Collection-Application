import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:9000"

// });
export default{

    addComic(user_id, comic){
        console.log(user_id)
        console.log(user_id)
        return axios.post(`/user/${user_id}/addComic`, comic);
    }
}