package com.ngocollab.dashboard;

public class UserSocialInterest {
    private final String name;
    private final int imageResource;

    public UserSocialInterest(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}

