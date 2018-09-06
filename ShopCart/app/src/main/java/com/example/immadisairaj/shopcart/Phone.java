package com.example.immadisairaj.shopcart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phone {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("image")
    @Expose
    private String image;

    public Phone() {
    }
    public Phone(Integer id, String model, String manufacturer, Integer price, Integer quantity, String image) {
        super();
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

}