package com.example.jharmedia.Model;

public class NotificationModel {
    int profile;
    String notificationText,notificationTime;

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public NotificationModel(int profile, String notificationText, String notificationTime) {
        this.profile = profile;
        this.notificationText = notificationText;
        this.notificationTime = notificationTime;
    }
}
