package com.techelevator.controller;

import com.techelevator.dao.UserCollectionDao;
import com.techelevator.model.Comic;
import com.techelevator.model.QueryDto;
import com.techelevator.model.UserCollection;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCollectionController {

    private UserCollectionDao userCollectionDao;

    public UserCollectionController(UserCollectionDao userCollectionDao) {
        this.userCollectionDao = userCollectionDao;
    }
    @RequestMapping(path = "/collections/{collectionId}", method = RequestMethod.GET)
    public UserCollection getUserCollectionById(@PathVariable int collectionId) {
        UserCollection userCollection = userCollectionDao.getCollectionById(collectionId);
        return userCollection;
    }

    @RequestMapping(path="/collections/search", method = RequestMethod.GET)
    public List<UserCollection> getCollectionByTitle(@RequestBody QueryDto queryDto) {
        List<UserCollection> collectionList = userCollectionDao.getCollectionByTitle(queryDto);
        return collectionList;
    }

}
