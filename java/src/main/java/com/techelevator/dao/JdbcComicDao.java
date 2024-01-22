package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Comic;
import com.techelevator.model.QueryDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.w3c.dom.DOMException;

import java.security.Principal;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcComicDao implements ComicDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Comic getComicById(int comicId) {
        Comic comic = null;
        String sql = "SELECT comic_id, title, cover_img, volume, issue_number, cover_date, " +
                "writer_id, artist_id, colorist_id, editor_id, inker_id, letterer_id " +
                "FROM comics WHERE comic_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, comicId);
            if (results.next()) {
                comic = mapRowToComic(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return comic;
    }

    public Comic getComicByTitle(QueryDto queryDto) {
        Comic comic = null;
        String sql = "SELECT comic_id, title, cover_img, volume, issue_number, cover_date, " +
                "writer_id, artist_id, colorist_id, editor_id, inker_id, letterer_id " +
                "FROM comics WHERE title = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, queryDto.getComicTitle());

            if (results.next()) {
                comic = mapRowToComic(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return comic;
    }

    public List<Comic> listAllComics() {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            while (results.next()) {
                comicList.add(mapRowToComic(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return comicList;
    }

    public Comic addComicByUserId(Comic comic, int user_id) {
        Comic newComic = null;
        String sql = "INSERT INTO comics (comic_id, title, cover_img, volume, issue_number, cover_date) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING comic_id";

        String userComicSql = "INSERT INTO user_comic (user_id, comic_id) VALUES (?, ?)";


        try {
            Integer newComicId = jdbcTemplate.queryForObject(sql, Integer.class, comic.getTitle(), comic.getCoverImg(),
                    comic.getVolume(), comic.getIssueNumber(), comic.getCoverDate());

            comic = getComicById(newComicId);

            jdbcTemplate.update(userComicSql, user_id, newComicId);

        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return comic;
    }

    //TODO add more methods to get by partial title, artists, user, collection, etc which return a List of comics.

    private Comic mapRowToComic(SqlRowSet rs) {
        Comic comic = new Comic();
        comic.setComicId(rs.getInt("comic_id"));
        comic.setTitle(rs.getString("title"));
        comic.setCoverImg(rs.getString("cover_img"));
        comic.setVolume(rs.getString("volume"));
        comic.setIssueNumber(rs.getInt("issue_number"));
        comic.setCoverDate(rs.getDate("cover_date"));
        comic.setWriterId(rs.getInt("writer_id"));
        comic.setArtistId(rs.getInt("artist_id"));
        comic.setColoristId(rs.getInt("colorist_id"));
        comic.setEditorId(rs.getInt("editor_id"));
        comic.setInkerId(rs.getInt("inker_id"));
        comic.setLettererId(rs.getInt("letterer_id"));
        return comic;
    }
}
