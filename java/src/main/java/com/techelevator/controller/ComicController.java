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

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ComicController {

    private ComicDao comicDao;

    private UserDao userDao;

    public ComicController(ComicDao comicDao, UserDao userDao) {
        this.comicDao = comicDao;
        this.userDao = userDao;
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

    @RequestMapping(path = "/comics", method = RequestMethod.GET)
    public List<Comic> listAllComics() {
        List<Comic> comicList = comicDao.listAllComics();
        return comicList;
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/user/{user_id}/addComic", method = RequestMethod.POST)
    public int addComicByUserId (@RequestBody Comic comic, @PathVariable String user_id, Principal principal) {

        int userId = Integer.parseInt(user_id);
        int loggedInUser = userDao.getUserByUsername(principal.getName()).getId();
        if(loggedInUser == userId) {
            return comicDao.addComicByUserId(comic, userId);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User Action");
        }
    }
}
