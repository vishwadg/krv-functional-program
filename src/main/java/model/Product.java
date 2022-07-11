package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean isNegotiable;
    private boolean isBiddable;
    private LocalDate addedDate;
    private LocalDate expiryDate;
    private ProductStatus productStatus;
    private Integer views;
    private double latitude;
    private double longitude;
    private Category category;
    private List<Image> images;
    private List<Bid> bids;
    private List<WishList> wishLists;
    private List<Comment> comments;
    private User user;

    public Product() {
    }

    public Product(Long id, String name, String description, double price, boolean isNegotiable, boolean isBiddable,
                   LocalDate addedDate, LocalDate expiryDate, ProductStatus productStatus, Integer views, double latitude,
                   double longitude, Category category, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isNegotiable = isNegotiable;
        this.isBiddable = isBiddable;
        this.addedDate = addedDate;
        this.expiryDate = expiryDate;
        this.productStatus = productStatus;
        this.views = views;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNegotiable() {
        return isNegotiable;
    }

    public void setNegotiable(boolean negotiable) {
        isNegotiable = negotiable;
    }

    public boolean isBiddable() {
        return isBiddable;
    }

    public void setBiddable(boolean biddable) {
        isBiddable = biddable;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isNegotiable=" + isNegotiable +
                ", isBiddable=" + isBiddable +
                ", addedDate=" + addedDate +
                ", expiryDate=" + expiryDate +
                ", productStatus=" + productStatus +
                ", views=" + views +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
