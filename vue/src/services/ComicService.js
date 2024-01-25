import axios from 'axios';


export default {

  addComic(user_id, comic) {
    console.log(user_id)
    console.log(user_id)
    return axios.post(`/user/${user_id}/addComic`, comic);
  },
  addCollection(user_id, collection) {
    return axios.post(`/user/${user_id}/addCollection`, collection, {
      // headers: {
      //   'Content-Type': 'application/json',
      // },
    });
  },
  addComicToCollection(collectionId, selectedComicId) {
    console.log("Hitting add to collection.")
    return axios.post(`/collections/${collectionId}/addComic/${selectedComicId}`, selectedComicId)
  }
}