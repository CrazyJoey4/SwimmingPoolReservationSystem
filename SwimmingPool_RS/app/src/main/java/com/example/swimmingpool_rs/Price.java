package com.example.swimmingpool_rs;

public class Price {
    private int _id;
    private String detail;
    private double amount;
    private String type;
    private int limitpax;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLimitpax() {
        return limitpax;
    }

    public void setLimitpax(int limitpax) {
        this.limitpax = limitpax;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
