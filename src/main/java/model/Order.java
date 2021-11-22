package model;

import lombok.Builder;

@Builder
public class Order {

    private boolean fulfilled;
    private String id;
    private double price;
    private int quantity;
    private String securityId;
    private String userId;
    private String type;

    public Order() {
    }

    public Order(boolean fulfilled, String id, double price, int quantity, String securityId, String userId, String type) {
        this.fulfilled = fulfilled;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.securityId = securityId;
        this.userId = userId;
        this.type = type;
    }

    public Order(boolean fulfilled, double price, int quantity, String securityId, String userId, String type) {
        this.fulfilled = fulfilled;
        this.price = price;
        this.quantity = quantity;
        this.securityId = securityId;
        this.userId = userId;
        this.type = type;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
