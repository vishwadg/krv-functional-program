import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.FunctionUtils;
import utils.KRVData;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class FunctionUtilsTest {

    @BeforeEach

    public void setUp() {

    }

    /**
     * /*
     * Top K list of Users with maximum comments (with timeframe)
     * <p>
     * Top K Product with maximum bids in a Y year.
     * <p>
     * Each product with highest bids in Y year.
     * <p>
     * Most top K expensive biddable product added
     * <p>
     * Top K users in Fairfield city who uploaded product in Electronics category with high price
     * <p>
     * Top K users who uploaded product with maximum Y  images
     * <p>
     * Top K User whose product expired before 2022-01-10 date which is added to wishlist by other user
     * <p>
     * Total comments in particular user's product in a Y year.
     * <p>
     * Imageless product receiving most comments in a Y year.
     * <p>
     * Users who uploaded negotiable product with highest comments in a Y year.
     * <p>
     * Users Product with at least K Comments.
     * <p>
     * Top K users whose product sold in Y year
     * <p>
     * Most top K expensive biddable product added to wishlist
     * <p>
     * Top K bidders in particular category.
     */

    //  1. Top K list of Users with maximum comments (with timeframe)
    @Test
    public void test1_topKListOfUsersWithComments() {
        List<String> expectedUsers = Arrays.asList("Johnny", "Amber");
        Optional<List<User>> users = FunctionUtils.getKTopUserWithMaxComments.apply(KRVData.marketplace, 2, 2022);
        assertEquals(expectedUsers.get(0), users.get().get(0).getFirstName());
        assertEquals(expectedUsers.get(1), users.get().get(1).getFirstName());
        assertEquals(2, users.map(List::size).orElse(0));
    }

    //   2. Top K Product with maximum bids in a Y year.
    @Test
    public void test2_SingleProductWithMaximumBids() {
        List<String> expectedProduct = Arrays.asList("Leather Jacket", "Happiness Unlimited");
        Optional<List<Product>> product = FunctionUtils.getKProductWithMaximumBids.apply(KRVData.marketplace, 2, 2022);
        assertEquals(expectedProduct.get(0), product.isPresent() ? product.get().get(0).getName() : "");
        assertEquals(expectedProduct.get(1), product.isPresent() ? product.get().get(1).getName() : "");
        assertEquals(2, product.map(List::size).orElse(0));
    }

    //   3. Each product with highest bids in Y year.
    @Test
    public void test3_productsWithHighestBids() {
        Map<Product, Optional<Bid>> bidMap = FunctionUtils.productsWithHighestBids.apply(KRVData.marketplace, 2022);
        Map<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("Leather Jacket", 1210.0);
        expectedMap.put("Happiness Unlimited", 910.0);
        assertEquals(expectedMap.get("Leather Jacket"), bidMap.entrySet().stream().toList().get(0).getValue().get().getBidValue());
        assertEquals(expectedMap.get("Happiness Unlimited"), bidMap.entrySet().stream().toList().get(1).getValue().get().getBidValue());
    }

    //    4. Most top K expensive biddable product added
    @Test
    public void test4_topExpensiveBiddableProduct() {
        Optional<List<Product>> product = FunctionUtils.getKTopExpensiveBiddableProduct.apply(KRVData.marketplace, 2, 2022);
        List<Double> expectedProduct = Arrays.asList(690.0, 600.0);
        System.out.println(product);
        assertEquals(expectedProduct.get(0), product.map(products -> products.get(0).getPrice()).orElse(0.0));
        assertEquals(expectedProduct.get(1), product.map(products -> products.get(1).getPrice()).orElse(0.0));
        assertEquals(2, product.map(List::size).orElse(0));
    }

    // 5. Top K users in Fairfield city who uploaded product in Electronics category with high price
    @Test
    public void test5_getTopKUserInParticularLocationInYCatWithHighPrice() {
        Optional<List<User>> users = FunctionUtils.getTopKUserInParticularLocationInYCatWithHighPrice
                .apply(KRVData.marketplace, 2, 2022, "Fairfield", "Electronics");
        assertEquals(users.get().get(0), KRVData.user6);
        assertEquals(users.get().get(1), KRVData.user1);
    }

    //   6. Top K users who uploaded product with maximum Y  images
    @Test
    public void test6_getTopKUsersWhoUploadedProductWithMaximumImages() {
        Optional<List<User>> users = FunctionUtils.getTopKUserWhoUploadedProductWithMaximumImages
                .apply(KRVData.marketplace, 2, 2022);
        System.out.println(users);
        assertEquals(users.get().get(0), KRVData.user6);
        assertEquals(users.get().get(1), KRVData.user1);
    }

    //   7. Top K User whose product expired before 2022-01-10 date which is added to wishlist by other user
    @Test
    public void test8_getTopKUSerWhoseProductExpiredOnYDateAddedToWishList() {
        Optional<List<User>> users = FunctionUtils.getTopKUSerWhoseProductExpiredOnYDateAddedToWishList
                .apply(KRVData.marketplace, 2, LocalDate.parse("2022-02-11"));
        assertEquals(users.get().get(0), KRVData.user1);
        assertEquals(users.get().get(1), KRVData.user4);
    }

    // 8. Total comments in particular user's product in a Y year.
    @Test
    public void test__totalCommentsOnUsersProduct() {
        Map<User, List<Comment>> data = FunctionUtils.totalCommentsOnUsersProduct.apply(KRVData.marketplace, 2022);
        assertEquals(data.get(KRVData.user1).size(), 5);
        assertEquals(data.get(KRVData.user4).size(), 2);
    }

    // 9. Imageless product receiving most comments in a Y year.
    @Test
    public void test__popularImagelessProductsByComments() {
        List<Product> products = FunctionUtils.popularImagelessProductsByComments.apply(KRVData.marketplace, 2022);
        for (Product p : products) {
            assertNull(p.getImages());
        }
        assertEquals(products.get(0).getComments().size(), 2);
        assertEquals(products.get(1).getComments().size(), 1);
    }

    // 10. Users who uploaded negotiable product with highest comments in a Y year.
    @Test
    public void test__usersWithHighestComments() {
        Map<User, List<Comment>> data = FunctionUtils.usersWithHighestComments.apply(KRVData.marketplace, 2022);
        assertEquals(data.get(KRVData.user2), KRVData.user2.getComments());
        assertEquals(data.get(KRVData.user3).size(), KRVData.user3.getComments().size());
    }

    // 11. Users Product with at least K Comments.
    @Test
    public void test__usersProductsWithAtLeastKComments() {
        Map<User, List<Comment>> data = FunctionUtils.usersProductsWithAtLeastKComments.apply(KRVData.marketplace, 2022, 3);
        data.entrySet().stream().forEach(e -> {
            assertFalse(e.getValue().size() < 3);
        });
    }

    // 12. Top K users whose product sold in 2022
    @Test
    public void test__topKUsersWhoseProductIsSoldMaximum() {
        Map<User, List<Product>> data = FunctionUtils.topKUsersWhoseProductIsSoldMaximum.apply(KRVData.marketplace, 2022, 10);
        assertEquals(data.get(KRVData.user1).size(), 2);
    }

    // 13. Most top K expensive biddable product added to wishlist
    @Test
    public void test_getTopKExpensiveBiddableProductAddedToWishList() {
        Optional<List<Product>> products = FunctionUtils.getTopKExpensiveBiddableProductAddedToWishList.apply(KRVData.marketplace, 2, 2022);
        assertEquals(2, products.map(List::size).orElse(0));
    }

    // 14. Top K bidders in particular category.
    @Test
    public void test_getTopKBiddersInParticularCategoryInParticularYear() {
        Optional<List<User>> users = FunctionUtils.getTopKBiddersInParticularCategoryInParticularYear.apply(KRVData.marketplace, KRVData.category3, 2, 2022);
        assertEquals(2, users.map(List::size).orElse(0));
    }

}