package com.example.supple_online.model;

public class Notification {
    String titleNoti, contentNoti, expirationDateNoti;

    public Notification(String titleNoti, String contentNoti, String expirationDateNoti) {
        this.titleNoti = titleNoti;
        this.contentNoti = contentNoti;
        this.expirationDateNoti = expirationDateNoti;
    }

    public String getTitleNoti() {
        return titleNoti;
    }

    public void setTitleNoti(String titleNoti) {
        this.titleNoti = titleNoti;
    }

    public String getContentNoti() {
        return contentNoti;
    }

    public void setContentNoti(String contentNoti) {
        this.contentNoti = contentNoti;
    }

    public String getExpirationDateNoti() {
        return expirationDateNoti;
    }

    public void setExpirationDateNoti(String expirationDateNoti) {
        this.expirationDateNoti = expirationDateNoti;
    }
}
