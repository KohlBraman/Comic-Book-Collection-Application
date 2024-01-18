package com.techelevator.model;

public class QueryDto {

    private String comicTitle;
    private String superHero;

    public String getSuperHero() {
        return superHero;
    }

    public void setSuperHero(String superHero) {
        this.superHero = superHero;
    }

    public String getComicTitle() {
        return comicTitle;
    }

    public void setComicTitle(String comicTitle) {
        this.comicTitle = comicTitle;
    }

}
