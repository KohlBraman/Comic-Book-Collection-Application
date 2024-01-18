package com.techelevator.model;

public class UserCollection {
    private int userCollectionId;
    private String collectionName;
    private int userId;

    public UserCollection(int userCollectionId, String collectionName, int userId) {
        this.userCollectionId = userCollectionId;
        this.collectionName = collectionName;
        this.userId = userId;
    }

    public UserCollection() {}

    public int getUserCollectionId() {
        return userCollectionId;
    }

    public void setUserCollectionId(int userCollectionId) {
        this.userCollectionId = userCollectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
