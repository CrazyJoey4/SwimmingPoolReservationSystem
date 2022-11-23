package com.example.swimmingpool_rs;

import java.time.LocalDateTime;

public class Announcement {
    private int announcementId;
    private String title;
    private String content;
    private String datetime;

    public Announcement(){
        this.announcementId = 0;
        this.title = "";
        this.content = "";
        this.datetime = null;
    }

    public Announcement(int announcementId, String title, String content, String datetime){
        this.announcementId = announcementId;
        this.title = title;
        this.content = content;
        this.datetime = datetime;
    }

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
