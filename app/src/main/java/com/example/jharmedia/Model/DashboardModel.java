package com.example.jharmedia.Model;


public class DashboardModel {
    int profile_image, postImg, saveImg;
    String userName,about, like, comment, share;

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public int getPostImg() {
        return postImg;
    }

    public void setPostImg(int postImg) {
        this.postImg = postImg;
    }

    public int getSaveImg() {
        return saveImg;
    }

    public void setSaveImg(int saveImg) {
        this.saveImg = saveImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public DashboardModel(int profile_image, int postImg, int saveImg, String userName, String about, String like, String comment, String share) {
        this.profile_image = profile_image;
        this.postImg = postImg;
        this.saveImg = saveImg;
        this.userName = userName;
        this.about = about;
        this.like = like;
        this.comment = comment;
        this.share = share;
    }
}