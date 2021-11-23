package model;

public class Trade {

    private String id;
    private String orderBuyId;
    private String orderSellId;
    private double price;
    private int quantity;

    public Trade() {
    }

    public Trade(String id, String orderBuyId, String orderSellId, double price, int quantity) {
        this.id = id;
        this.orderBuyId = orderBuyId;
        this.orderSellId = orderSellId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderBuyId() {
        return orderBuyId;
    }

    public void setOrderBuyId(String orderBuyId) {
        this.orderBuyId = orderBuyId;
    }

    public String getOrderSellId() {
        return orderSellId;
    }

    public void setOrderSellId(String orderSellId) {
        this.orderSellId = orderSellId;
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
}
