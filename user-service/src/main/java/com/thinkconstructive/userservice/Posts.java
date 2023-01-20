package com.thinkconstructive.userservice;

public class Posts {
    private String postId;
    private String description;

    public Posts() {
    }

    public Posts(String postId, String description) {
        this.postId = postId;
        this.description = description;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
