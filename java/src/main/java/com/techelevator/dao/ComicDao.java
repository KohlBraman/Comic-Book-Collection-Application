package com.techelevator.dao;

import com.techelevator.model.Comic;
import com.techelevator.model.QueryDto;

import javax.management.Query;
import java.security.Principal;
import java.util.List;

public interface ComicDao {

    Comic getComicById(int comic_id);

    Comic getComicByTitle(QueryDto queryDto);

    List<Comic> listAllComics();

    Comic addComicByUserId(Comic comic, int user_id);


    // Comic getComicsByUserId(int user_id);
}
