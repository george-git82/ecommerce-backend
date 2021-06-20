package com.abhishek.productslist.products;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private String category;
    private String description;
    private float price;
    private String image_title;
    private String image;
    private int qty;

    public Product() {
    }

    public Product(String id, String name, String category, String description, float price, String image_title,
            String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.image_title = image_title;
        this.image = image;

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage_title() {
        return this.image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", category='" + getCategory() + "'"
                + ", description='" + getDescription() + "'" + ", price='" + getPrice() + "'" + ", image_title='"
                + getImage_title() + "'" + ", image='" + getImage() + "'" + ", qty='" + getQty() + "'" + "}";
    }

}
