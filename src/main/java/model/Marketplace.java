package model;

import java.util.List;

public class Marketplace {
    private String name;
    private String address;
    private String registrationId;
    private List<Product> products;

    public Marketplace() {
    }

    public Marketplace(String name, String address, String registrationId) {
        this.name = name;
        this.address = address;
        this.registrationId = registrationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Marketplace{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", products=" + products +
                '}';
    }
}
