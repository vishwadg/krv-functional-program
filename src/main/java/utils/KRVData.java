package utils;

import model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public  class KRVData {
    public static Marketplace marketplace;
    public static User user1, user2, user3, user4, user5, user6;
    public static Product product1, product2, product3, product4, product5, product6, product7;

    public static Category category1, category2, category3, category4, category5, category6;
    static {
        marketplace = new Marketplace("KRV MarketPlace", "Fairfield", "12345");
        user1 = new User(1l, "Jhon", "Doe", "jhondoe@gmail.com", "USA", "IA", "Fairfield", 52557, 32.123, 12.098);
        user2 = new User(2L, "Johnny", "Depp", "johnnydepp@gmail.com", "USA", "LA", "Fairfield", 52558, 32.345, 12.089);
        user3 = new User(3L, "Amber", "Heard", "amberheard@gmail.com", "USA", "CA", "Fairfield", 52559, 32.654, 12.183);
        user4 = new User(4L, "Jimmy", "Fallon", "jimmy@gmail.com", "USA", "TX", "Fairfield", 52550, 32.543, 12.103);
        user5 = new User(5L, "Balie", "Haddin", "balie@gmail.com", "USA", "NY", "Fairfield", 52552, 32.189, 12.143);
        user6 = new User(6L, "Roy", "Heard", "roy@gmail.com", "USA", "NJ", "Fairfield", 52553, 32.187, 12.093);

        Image image1 = new Image("product1/path1/image1.jpg");
        Image image2 = new Image("product1/path2/image2.jpg");
        Image image3 = new Image("product1/path3/image3.jpg");
        Image image4 = new Image("product1/path4/image4.jpg");
        Image image5 = new Image("product2/path5/image5.jpg");
        Image image6 = new Image("product2/path6/image6.jpg");
        Image image7 = new Image("product2/path7/image5.jpg");
        Image image8 = new Image("product3/path8/image6.jpg");
        Image image9 = new Image("product7/path8/image6.jpg");
        Image image10 = new Image("product7/path9/image8.jpg");
        Image image11 = new Image("product7/path9/image8.jpg");
        Image image12 = new Image("product7/path9/image8.jpg");
        Image image13 = new Image("product7/path9/image8.jpg");


        category1 = new Category(1L, "Electronics", "This is Electronics");
        category2 = new Category(2L, "Furniture", "This is Furniture");
        category3 = new Category(3L, "Fashion", "This is Fashion");
        category4 = new Category(4L, "Books", "This is Books");
        category5 = new Category(5L, "Digital Books", "This is digital books");
        category6 = new Category(6L, "Handmade", "This is handmade");

        product1 = new Product(1L, "Iphone1", "Iphone1 Description ", 200, true, false,LocalDate.parse("2022-01-01"),
                LocalDate.parse("2022-01-10"), ProductStatus.SOLD, 20, 20.123, 23.123, category1, user1);

        product2 = new Product(2L, "Samsung S20", "Samsung Description ", 600, true, true, LocalDate.parse("2022-05-01"),
                LocalDate.parse("2022-05-10"), ProductStatus.SOLD, 20, 20.123, 23.123, category1, user1);

        product3 = new Product(3L, "Leather Jacket", "First Class Leather Jacket Description ", 40, true, true, LocalDate.parse("2022-03-01"),
                LocalDate.parse("2022-03-20"), ProductStatus.NEW, 50, 20.123, 23.123, category3, user3);

        product4 = new Product(4L, "Happiness Unlimited", "Happiness Unlimited Book Description ", 277, false, true, LocalDate.parse("2022-02-01"),
                LocalDate.parse("2022-02-10"), ProductStatus.NEW, 870, 32.988, 21.123, category4, user4);

        product5 = new Product(5L, "UML Basics", "UML Basics Digital Books Description ", 210, true, true, LocalDate.parse("2022-02-15"),
                LocalDate.parse("2022-02-25"), ProductStatus.NEW, 300, 34.123, 56.123, category5, user5);

        product6 = new Product(6L, "Handmade Cushion", "Handmade Cushion Description ", 90, true, true, LocalDate.parse("2022-03-12"),
                LocalDate.parse("2022-03-28"), ProductStatus.NEW, 90, 19.123, 89.123, category6, user6);

        product7 = new Product(7L, "Motorola Razer", "Samsung Description ", 690, true, true, LocalDate.parse("2022-05-04"),
                LocalDate.parse("2022-05-19"), ProductStatus.NEW, 20, 20.123, 23.123, category1, user6);


        Bid bid1 = new Bid(1L, 1210, user2, product3, LocalDate.parse("2022-01-05"));
        Bid bid2 = new Bid(2L, 650, user3, product3, LocalDate.parse("2022-01-05"));
        Bid bid3 = new Bid(3L, 60, user4, product3, LocalDate.parse("2022-01-05"));
        Bid bid4 = new Bid(4L, 910, user5, product4, LocalDate.parse("2022-02-05"));
        Bid bid5 = new Bid(5L, 400, user6, product4, LocalDate.parse("2022-02-19"));
        Bid bid6 = new Bid(6L, 120, user4, product6, LocalDate.parse("2022-03-13"));
        Bid bid7 = new Bid(6L, 140, user5, product6, LocalDate.parse("2022-03-14"));
        Bid bid8 = new Bid(8L, 700, user5, product6, LocalDate.parse("2022-05-14"));

        Comment comment1 = new Comment(1L, "This is comment for Product 1 by user 2", product1, user2, LocalDate.parse("2022-01-07"));
        Comment comment2 = new Comment(2L, "This is comment for Product 1 by user 2", product1, user2, LocalDate.parse("2022-05-07"));
        Comment comment3 = new Comment(3L, "This is comment for Product 1 by user 2", product1, user2, LocalDate.parse("2022-03-07"));
        Comment comment4 = new Comment(4L, "This is comment for Product 2 by user 3", product2, user3, LocalDate.parse("2022-02-06"));
        Comment comment5 = new Comment(5L, "This is comment for Product 2 by user 3", product2, user3, LocalDate.parse("2022-02-20"));
        Comment comment6 = new Comment(6L, "This is comment for Product 4 by user 4", product4, user4, LocalDate.parse("2022-03-14"));
        Comment comment7 = new Comment(7L, "This is comment for Product 7 by user 4", product4, user4, LocalDate.parse("2022-03-15"));

        List<Bid> bids1 = Arrays.asList(bid1, bid2, bid3);
        List<Bid> bids2 = Arrays.asList(bid4, bid5);
        List<Bid> bids3 = Arrays.asList(bid6, bid7);
        List<Bid> bids4 = Arrays.asList(bid8);

        List<Image> images1 = Arrays.asList(image1, image2, image3, image4);
        List<Image> images2 = Arrays.asList(image5, image6, image7);
        List<Image> images3 = Arrays.asList(image9, image10, image11, image12, image13);

        List<Comment> comments1 = Arrays.asList(comment1, comment2, comment3);
        List<Comment> comments2 = Arrays.asList(comment4, comment5);
        List<Comment> comments3 = Arrays.asList(comment6);
        List<Comment> comments4 = Arrays.asList(comment7);

        user2.setComments(Arrays.asList(comment1, comment2, comment3));
        user3.setComments(Arrays.asList(comment4, comment5));
        user4.setComments(Arrays.asList(comment6, comment7));

        WishList wish1 = new WishList(1L, product1, user2, LocalDate.parse("2022-01-11"));
        WishList wish2 = new WishList(2L, product4, user3, LocalDate.parse("2022-02-11"));
        WishList wish3 = new WishList(3L, product6, user2, LocalDate.parse("2022-03-29"));
        WishList wish4 = new WishList(4L, product1, user3, LocalDate.parse("2022-03-30"));


        user2.setWishLists(Arrays.asList(wish1, wish3));
        user3.setWishLists(Arrays.asList(wish2, wish4));

        product3.setBids(bids1);

        product1.setImages(images1);
        product1.setComments(comments1);
        product1.setWishLists(Arrays.asList(wish1, wish4));

        product4.setBids(bids2);

//        product2.setImages(images2);
        product2.setComments(comments2);

        product4.setComments(comments3);
        product4.setWishLists(Arrays.asList(wish2));

        product6.setBids(bids3);
        product6.setWishLists(Arrays.asList(wish3));

        product7.setBids(bids4);
        product7.setImages(images3);
        product7.setComments(comments4);

        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5, product6, product7);
        marketplace.setProducts(products);
    }








}
