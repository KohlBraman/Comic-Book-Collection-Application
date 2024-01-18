package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Comic;
import com.techelevator.model.QueryDto;
import com.techelevator.model.UserCollection;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserCollectionDao implements UserCollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public  JdbcUserCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserCollection getCollectionById(int collectionId){
        UserCollection userCollection = null;
        String sql = "SELECT * FROM user_collection WHERE collection_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
            if(results.next()) {
                userCollection = mapRowToUserCollection(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return userCollection;
    }

    public List<UserCollection> getCollectionByTitle (QueryDto queryDto){
        List<UserCollection> collectionList = new ArrayList<>();
        String sql = "SELECT * FROM user_collection WHERE collection_name = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, queryDto.getCollectionTitle());

            while(results.next()) {
                collectionList.add(mapRowToUserCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return collectionList;
    }

    private UserCollection mapRowToUserCollection(SqlRowSet rs) {
        UserCollection userCollection = new UserCollection();
        userCollection.setUserCollectionId(rs.getInt("userCollectionId"));
        userCollection.setCollectionName(rs.getString("collectionName"));
        userCollection.setUserId(rs.getInt("user_id"));

        return userCollection;
    }
}
