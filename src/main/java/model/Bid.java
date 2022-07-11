package model;

import java.time.LocalDate;

public class Bid {
    Long id;
    private double bidValue;
    private User user;
    private Product product;
    private LocalDate createdAt;

    public Bid() {
    }

    public Bid(Long id, double bidValue, User user, Product product, LocalDate createdAt) {
        this.id = id;
        this.bidValue = bidValue;
        this.user = user;
        this.product = product;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public double getBidValue() {
        return bidValue;
    }

    public void setBidValue(double bidValue) {
        this.bidValue = bidValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Bid getCurrent() {
        return this;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", bidValue=" + bidValue +
                ", user=" + user +
                ", product=" + product +
                ", createdAt=" + createdAt +
                '}';
    }
}
