package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Comic;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.w3c.dom.DOMException;

@Component
public class JdbcComicDao implements ComicDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Comic getComicById(int comicId){
        Comic comic = nil;
        String sql = "SELECT comic_id, title, cover_img, volume, issue_number, cover_date, " +
                "writer_id, artist_id, colorist_id, editor_id, inker_id, letter_id " +
                "FROM comics WHERE comic_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet((sql, comicId));
            if(results.next()) {
                comic = mapRowToComic(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return comic;
    }

    public Comic getComicByTitle(String comicTitle){
        Comic comic = nil;
        String sql = "SELECT comic_id, title, cover_img, volume, issue_number, cover_date, " +
                "writer_id, artist_id, colorist_id, editor_id, inker_id, letter_id " +
                "FROM comics WHERE title = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, comicTitle);
            if(results.next()) {
                comic = mapRowToComic(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return comic;
    }

    //TODO add more methods to get by partial title, artists, user, collection, etc which return a List of comics.

    private Comic mapRowToComic(SqlRowSet rs){
        Comic comic = new Comic();
        comic.setComic_id(rs.getInt("comic_id"));
        comic.setComic_title(rs.getString("title"));
        comic.setComic_cover(rs.getString("cover_img"));
        comic.setComic_volume(rs.getString("volume"));
        comic.setComic_issueNumber(rs.getInt("issue_number"));
        comic.setComic_coverDate(rs.getDate("cover_date"));
        comic.setComic_writerId(rs.getInt("writer_id"));
        comic.setComic_artistId(rs.getInt("artist_id"));
        comic.setComic_coloristtId(rs.getInt("colorist_id"));
        comic.setComic_editorId(rs.getInt("editor_id"));
        comic.setComic_inkerId(rs.getInt("inker_id"));
        comic.setComic_lettererId(rs.getInt("letterer_id"));
        return comic;
    }

}
