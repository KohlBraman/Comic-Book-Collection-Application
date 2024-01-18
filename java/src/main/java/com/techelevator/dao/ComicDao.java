package com.techelevator.dao;

import com.techelevator.model.Comic;
import com.techelevator.model.QueryDto;

import javax.management.Query;

public interface ComicDao {

    Comic getComicById(int comic_id);

    Comic getComicByTitle(QueryDto queryDto);

    // Comic getComicsByUserId(int user_id);
}
