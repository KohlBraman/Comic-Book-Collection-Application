package com.techelevator.controller;

import com.techelevator.dao.UserCollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Comic;
import com.techelevator.model.QueryDto;
import com.techelevator.model.UserCollection;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
public class UserCollectionController {

    private UserCollectionDao userCollectionDao;
    private UserDao userDao;

    public UserCollectionController(UserCollectionDao userCollectionDao, UserDao userDao) {
        this.userCollectionDao = userCollectionDao;
        this.userDao = userDao;
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
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "user/{user_id}/addCollection", method = RequestMethod.POST)
    public UserCollection addCollectionByUserId(@RequestBody UserCollection userCollection, @PathVariable String user_id, Principal principal) {

        int userId = Integer.parseInt(user_id);
        int loggedInUser = userDao.getUserByUsername(principal.getName()).getId();
        if (loggedInUser == userId) {
            return userCollectionDao.addCollectionByUserId(userCollection, userId);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User Action");
        }
    }
    @RequestMapping(path = "user/{user_id}/collections", method = RequestMethod.GET)
    public List<UserCollection> getCollectionByUserId(@PathVariable String user_id, Principal principal) {
        int userId = Integer.parseInt(user_id);
        int loggedInUser = userDao.getUserByUsername(principal.getName()).getId();

        if (loggedInUser == userId) {
            return userCollectionDao.getCollectionsByUserId(userId);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User Action");
        }
    }

//    @PreAuthorize("isAuthenticated()")
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/collections/{collectionId}/addComic/{collectionName}", method = RequestMethod.POST)
//    public UserCollection addComicToCollection(
//            @PathVariable int collectionId,
//            @PathVariable String collectionName,
//            @RequestBody Comic comic,
//            Principal principal) {
//
//        // Authenticate user
//        int loggedInUserId = userDao.getUserByUsername(principal.getName()).getId();
//
//        // Ensure the collection belongs to the logged-in user
//        UserCollection userCollection = userCollectionDao.getCollectionById(collectionId);
//
//        if (userCollection != null && userCollection.getUserId() == loggedInUserId) {
//            // Add the comic to the collection
//            userCollectionDao.addComicToCollection(collectionId, comic, collectionName);
//            return userCollectionDao.getCollectionById(collectionId);
//        } else {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User Action");
//        }
//    }

}
