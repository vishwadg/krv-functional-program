package model;

import java.time.LocalDate;

public class Comment {
    Long id;
    private String content;
    private Product product;
    private User user;
    private LocalDate createdAt;

    public Comment() {
    }

    public Comment(Long id,String content, Product product, User user, LocalDate createdAt) {
        this.id = id;
        this.content = content;
        this.product = product;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", product=" + product +
                ", createdAt=" + createdAt +
                '}';
    }
}
