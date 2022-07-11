package model;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String state;
    private String city;
    private Integer zip;
    private Double userLat;
    private Double userLong;
    private List<Comment> comments;

    private List<WishList> wishLists;

    private List<Product> products;
    public User() {
    }

    public User(Long id,String firstName, String lastName, String email, String country, String state, String city, Integer zip,
                Double userLat, Double userLong) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.userLat = userLat;
        this.userLong = userLong;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Double getUserLat() {
        return userLat;
    }

    public void setUserLat(Double userLat) {
        this.userLat = userLat;
    }

    public Double getUserLong() {
        return userLong;
    }

    public void setUserLong(Double userLong) {
        this.userLong = userLong;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", userLat=" + userLat +
                ", userLong=" + userLong +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getCity().equals(user.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity());
    }
}
