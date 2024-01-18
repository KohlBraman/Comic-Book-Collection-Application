package com.techelevator.dao;

import com.techelevator.model.QueryDto;
import com.techelevator.model.UserCollection;

import java.util.List;

public interface UserCollectionDao {

    UserCollection getCollectionById(int collectionId);

    List<UserCollection> getCollectionByTitle(QueryDto queryDto);
}
