package com.example.immadisairaj.shopcart;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sales {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("invoiceNumber")
    @Expose
    private String invoiceNumber;

    public Sales() {
    }

    public Sales(String username, Integer quantity, String model, String invoiceNumber) {
        super();
        this.username = username;
        this.quantity = quantity;
        this.model = model;
        this.invoiceNumber = invoiceNumber;
    }

    public String getUsername() {
        return username;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getModel() {
        return model;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

}

