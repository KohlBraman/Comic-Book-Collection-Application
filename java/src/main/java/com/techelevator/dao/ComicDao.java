package com.techelevator.dao;

import com.techelevator.model.Comic;

public interface ComicDao {

    Comic getComicById(int comic_id);

    Comic getComicByTitle(String comic_title);

    // Comic getComicsByUserId(int user_id);
}
