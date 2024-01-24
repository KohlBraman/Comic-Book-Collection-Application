package com.techelevator.dao;

import com.techelevator.model.Comic;
import com.techelevator.model.QueryDto;
import com.techelevator.model.User;
import com.techelevator.model.UserCollection;

import java.util.List;

public interface UserCollectionDao {

    UserCollection getCollectionById(int collectionId);

    List<UserCollection> getCollectionByTitle(QueryDto queryDto);

    UserCollection addCollectionByUserId(UserCollection userCollection, int user_id);

    List<UserCollection> getCollectionsByUserId(int userId);
//    UserCollection addComicToCollection(int collectionId, Comic comic, String collectionName);

}
