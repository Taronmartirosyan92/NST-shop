package com.example.armen.mynoutbook.models;

import com.example.armen.mynoutbook.CategoryEnum.Category;


public class ProductModel {
    private String title;
    private Enum<Category> category;
    private String description;
    private String[] imageUrl;
    private String price;
    private boolean favorite;
    private boolean cardBy;
    private String videoUrl;
    private float rating;

    public ProductModel(String[] imageUrl, String videoUrl, String title, Enum<Category> category, String price, String description, boolean favorite, boolean cardBy, float rating) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.favorite = favorite;
        this.cardBy = cardBy;
        this.videoUrl = videoUrl;
        this.rating =rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getPrice() {
        return price;
    }

    public boolean isCardBy() {
        return cardBy;
    }

    public void setCardBy(boolean cardBy) {
        this.cardBy = cardBy;
    }

    public String[] getImageUrl() {
        return imageUrl;
    }

    public Enum<Category> getCategory() {
        return category;
    }

}
