package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Comic;
import com.techelevator.model.QueryDto;
import com.techelevator.model.UserCollection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserCollectionDao implements UserCollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserCollection getCollectionById(int collectionId) {
        UserCollection userCollection = null;
        String sql = "SELECT * FROM user_collections WHERE user_collection_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
            if (results.next()) {
                userCollection = mapRowToUserCollection(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return userCollection;
    }

    public List<UserCollection> getCollectionByTitle(QueryDto queryDto) {
        List<UserCollection> collectionList = new ArrayList<>();
        String sql = "SELECT * FROM user_collections WHERE collection_name = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, queryDto.getCollectionTitle());

            while (results.next()) {
                collectionList.add(mapRowToUserCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return collectionList;
    }
    public UserCollection addCollectionByUserId(UserCollection userCollection, int user_id) {
        UserCollection newCollection = null;
        String sql = "INSERT INTO user_collections (user_collection_id, collection_name, user_id) " +
                "VALUES (DEFAULT, ?, ?) RETURNING user_collection_id";

        try {
            Integer newUserCollectionId = jdbcTemplate.queryForObject(sql, Integer.class,
                    userCollection.getCollectionName(), user_id);

            userCollection = getCollectionById(newUserCollectionId);

        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return userCollection;
    }

    @Override
    public List<UserCollection> getCollectionsByUserId(int userId) {
        List<UserCollection> collectionList = new ArrayList<>();
        String sql = "SELECT * FROM user_collections WHERE user_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

            while (results.next()) {
                collectionList.add(mapRowToUserCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return collectionList;
    }

//    @Override
//    public UserCollection addComicToCollection(int collectionId, Comic comic, String collectionName) {
//        try {
//            String insertSql = "INSERT INTO comic_user_collection (comic_id, user_collection_id) " +
//                    "SELECT ?, user_collection_id " +
//                    "FROM user_collections " +
//                    "WHERE collection_name = ? " +
//                    "  AND EXISTS (SELECT 1 FROM comics WHERE comic_id = ?)";
//
//            jdbcTemplate.update(insertSql, comic.getComicId(), collectionName, comic.getComicId());
//
//            List<UserCollection> matchingCollections = getCollectionByTitle(new QueryDto(collectionName));
//            if (!matchingCollections.isEmpty()) {
//                return matchingCollections.get(0); // Assuming unique collection names
//            } else {
//                throw new DaoException("Collection not found: " + collectionName);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            // Handle exceptions as needed
//            throw new DaoException("Unable to connect to the server or database.", e);
//        } catch (BadSqlGrammarException e) {
//            throw new DaoException("SQL syntax error", e);
//        }
//    }

    public UserCollection addCollectionByUserId(UserCollection userCollection, int user_id) {
        UserCollection newCollection = null;
        String sql = "INSERT INTO user_collections (user_collection_id, collection_name, user_id) " +
                "VALUES (DEFAULT, ?, ?) RETURNING user_collection_id";

        try {
            Integer newUserCollectionId = jdbcTemplate.queryForObject(sql, Integer.class,
                    userCollection.getCollectionName(), user_id);

            userCollection = getCollectionById(newUserCollectionId);

        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return userCollection;
    }

    private UserCollection mapRowToUserCollection(SqlRowSet rs) {
        UserCollection userCollection = new UserCollection();
        userCollection.setUserCollectionId(rs.getInt("user_collection_id"));
        userCollection.setCollectionName(rs.getString("collection_name"));
        userCollection.setUserId(rs.getInt("user_id"));

        return userCollection;
    }
}
