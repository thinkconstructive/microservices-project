package com.thinkconstructive.userservice;

public class Notifications {
    private String notificationId;
    private String description;

    public Notifications() {
    }

    public Notifications(String notificationId, String description) {
        this.notificationId = notificationId;
        this.description = description;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
