package com.dnp.sieta.object;

/**
 * Created by dimasnurpanca on 2/15/2018.
 */

public class ItemObject {

    private String content;
    private String imageResource;

    public ItemObject(String content, String imageResource) {
        this.content = content;
        this.imageResource = imageResource;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }
}