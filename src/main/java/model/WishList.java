package model;

import java.time.LocalDate;

public class WishList {
    private Long id;
    private Product product;
    private User user;
    private LocalDate createdAt;

    public WishList() {
    }

    public WishList(Long id,Product product, User user, LocalDate createdAt) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                ", createdAt=" + createdAt +
                '}';
    }
}
