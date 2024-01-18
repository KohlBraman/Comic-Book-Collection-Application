package com.techelevator.controller;

import javax.validation.Valid;
import com.techelevator.dao.ComicDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ComicController {

    private ComicDao comicDao;

    public ComicController(ComicDao comicDao) {
        this.comicDao = comicDao;
    }

    @RequestMapping(path = "/comics/{comicId}", method = RequestMethod.GET)
    public Comic getComicById(@PathVariable int comicId) {
        Comic comic = comicDao.getComicById(comicId);
        return comic;
    }

    @RequestMapping(path="/comics/search", method = RequestMethod.GET)
    public Comic getComicByTitle(@RequestBody QueryDto queryDto) {
        Comic comic = comicDao.getComicByTitle(queryDto);
        return comic;
    }

}
