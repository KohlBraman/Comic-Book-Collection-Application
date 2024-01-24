package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;

public class Comic {
    private int comicId;
    private String title;
    private String coverImg;
    private String synopsis;
    private String volume;

    private int issueNumber;
    private Date coverDate;
    private int writerId;
    private int artistId;
    private int coloristId;
    private int editorId;
    private int inkerId;
    private int lettererId;


    public Comic(){}
    public Comic(int comicId, String title, String coverImg, String synopsis, String volume, int issueNumber, Date coverDate,
                 int writerId, int artistId, int coloristId, int editorId, int inkerId, int lettererId) {
        this.comicId = comicId;
        this.title = title;
        this.coverImg = coverImg;
        this.synopsis = synopsis;
        this.volume = volume;
        this.issueNumber = issueNumber;
        this.coverDate = coverDate;
        this.writerId = writerId;
        this.artistId = artistId;
        this.coloristId = coloristId;
        this.editorId = editorId;
        this.inkerId = inkerId;
        this.lettererId = lettererId;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Date getCoverDate() {
        return coverDate;
    }

    public void setCoverDate(Date coverDate) {
        this.coverDate = coverDate;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getColoristId() {
        return coloristId;
    }

    public void setColoristId(int coloristId) {
        this.coloristId = coloristId;
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public int getInkerId() {
        return inkerId;
    }

    public void setInkerId(int inkerId) {
        this.inkerId = inkerId;
    }

    public int getLettererId() {
        return lettererId;
    }

    public void setLettererId(int lettererId) {
        this.lettererId = lettererId;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
