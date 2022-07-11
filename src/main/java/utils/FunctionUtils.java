package utils;

import model.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class FunctionUtils {
    //    1. Top K list of Users with maximum comments
    public static TriFunction<Marketplace, Integer, Integer, Optional<List<User>>> getKTopUserWithMaxComments = (market, k, year) ->
            Optional.of(Stream.of(market)
                    .flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
                    .flatMap(p -> p.getComments() != null ? p.getComments().stream() : Stream.empty())
                    .flatMap(co -> co.getUser().getComments().stream())
                    .filter(com -> com.getCreatedAt().getYear() == year)
                    .collect(Collectors.groupingBy(comm -> comm.getUser()))
                    .entrySet()
                    .stream().sorted((c1, c2) -> (int) (c2.getValue().stream().count() - c1.getValue().stream().count()))
                    .limit(k)
                    .map(u -> u.getKey())
                    .collect(Collectors.toList()));


    //  2. Top K Product with maximum bids in a Y year.
    public static TriFunction<Marketplace, Integer, Integer, Optional<List<Product>>> getKProductWithMaximumBids = (market, k, year) ->
            Optional.of(Stream.of(market).flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
                    .flatMap(b -> b.getBids() != null ? b.getBids().stream() : Stream.empty())
                    .filter(c -> c.getCreatedAt().getYear() == year)
                    .collect(Collectors.groupingBy(p -> p.getProduct()))
                    .entrySet()
                    .stream()
                    .sorted((p1, p2) -> p1.getKey().getBids() != null && p2.getKey().getBids() != null ?
                            (int) (p2.getKey().getBids().stream().count() - p1.getKey().getBids().stream().count()) : 0)
                    .limit(k)
                    .map(p -> p.getKey())
                    .collect(Collectors.toList()));


    //    =====================================================================================================
    //    3. Each product with highest bids in Y year.
    static BiFunction<Product, Integer, Optional<Bid>> getHighestBid = (product, year) ->
            Stream.of(product)
                    .flatMap(p -> p.getBids() != null ? p.getBids().stream() : Stream.empty())
                    .sorted((b1, b2) -> b2.getBidValue() != 0.0 && b1.getBidValue() != 0.0 ? (int) (b2.getBidValue() - b1.getBidValue()) : 0)
                    .findFirst();


    public static BiFunction<Marketplace, Integer, Map<Product, Optional<Bid>>> productsWithHighestBids = (marketplace, year) ->
            Stream.of(marketplace)
                    .flatMap(m -> m.getProducts().stream())
                    .filter(p -> getHighestBid.apply(p, year).isPresent())
                    .collect(Collectors.toMap(product -> product, product -> getHighestBid.apply(product, year)));


    //    =====================================================================================================

    //  4. Most top K expensive biddable product added
    public static TriFunction<Marketplace, Integer, Integer, Optional<List<Product>>> getKTopExpensiveBiddableProduct = (market, k, year) ->
            Optional.of(Stream.of(market)
                    .flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
                    .filter(p -> p.getAddedDate().getYear() == year)
                    .filter(p -> p.isBiddable()).toList()
                    .stream().sorted((p1, p2) -> (int) (p2.getPrice() - p1.getPrice()))
                    .limit(k)
                    .collect(Collectors.toList())
            );


    //  5. Top K users in Fairfield city who uploaded product in Electronics category with high price
    public static HexaFunction<Marketplace, Integer, Integer, String, String, Optional<List<User>>>
            getTopKUserInParticularLocationInYCatWithHighPrice = (market, k, year, loc, cat) ->
            Optional.of(Stream.of(market)
                    .flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
                    .sorted((p1, p2) -> (int) (p2.getPrice() - p1.getPrice()))
                    .filter(p -> p.getAddedDate().getYear() == year)
                    .filter(p -> p.getCategory().getName().equals(cat))
                    .map(Product::getUser).toList()
                    .stream().filter(u -> u.getCity().equals(loc))
                    .limit(k)
                    .collect(toList()));


    //  6. Top K users who uploaded product with maximum Y  images
    public static TriFunction<Marketplace, Integer, Integer, Optional<List<User>>> getTopKUserWhoUploadedProductWithMaximumImages
            = (market, k, year) -> Optional.of(Stream.of(market)
            .flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
            .filter(p -> p.getAddedDate().getYear() == year && p.getImages() != null)
            .sorted((p1, p2) ->
                    (int) (p2.getImages().stream().count() - p1.getImages().stream().count()))
            .map(p -> p.getUser()).toList()
            .stream().limit(2)
            .collect(toList())
    );

    //  7. Top K User whose product expired before 2022-01-10 date which is added to wishlist by other user
    public static TriFunction<Marketplace, Integer, LocalDate, Optional<List<User>>> getTopKUSerWhoseProductExpiredOnYDateAddedToWishList
            = (market, k, localDate) -> Optional.of(Stream.of(market)
            .flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
            .filter(p -> localDate.isAfter(p.getExpiryDate()))
            .flatMap(p -> p.getWishLists() != null ? p.getWishLists().stream() : Stream.empty())
            .map(w -> w.getProduct())
            .map(p -> p.getUser())
            .distinct()
            .limit(2)
            .collect(toList()));

    // 8. Total comments in particular user's product in a Y year.
    public static BiFunction<Marketplace, Integer, Map<User, List<Comment>>> totalCommentsOnUsersProduct = (marketplace, year) ->
            Stream.of(marketplace)
                    .flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
                    .flatMap(p -> p.getComments() != null ? p.getComments().stream() : Stream.empty())
                    .collect(Collectors.groupingBy(c -> c.getProduct().getUser()))
                    .entrySet().stream()
                    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));


    // 9. Imageless product receiving most comments in a Y year.
    public static BiFunction<Marketplace, Integer, List<Product>> popularImagelessProductsByComments = (marketplace, year) ->
            Stream.of(marketplace)
                    .flatMap(m -> m.getProducts().stream())
                    .filter(p -> p.getImages() == null)
                    .flatMap(p -> p.getComments() != null ? p.getComments().stream() : Stream.empty())
                    .collect(Collectors.groupingBy(c -> c.getProduct()))
                    .entrySet().stream()
                    .sorted((e1, e2) -> (int) (e2.getValue().stream().count() - e1.getValue().stream().count()))
                    .limit(10)
                    .map(e -> e.getKey())
                    .collect(Collectors.toList());

    // 10. Users who uploaded negotiable product with highest comments in a Y year.
    public static BiFunction<Marketplace, Integer, Map<User, List<Comment>>> usersWithHighestComments = (marketplace, year) ->
            Stream.of(marketplace)
                    .flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
                    .filter(p -> p.isNegotiable())
                    .flatMap(p -> p.getComments() != null ? p.getComments().stream() : Stream.empty())
                    .collect(Collectors.groupingBy(c -> c.getUser()))
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> (int) (e2.getValue().stream().count() - e1.getValue().stream().count()))
                    .collect(Collectors.toMap(a -> a.getKey(), b -> b.getValue()));


    // 11. Users Product with at least K Comments.
    public static TriFunction<Marketplace, Integer, Integer, Map<User, List<Comment>>> usersProductsWithAtLeastKComments = (marketplace, year, minCommentCount) ->
            FunctionUtils.totalCommentsOnUsersProduct.apply(marketplace, year)
                    .entrySet().stream()
                    .filter(e -> e.getValue().stream().count() >= minCommentCount)
                    .collect(Collectors.toMap(e1 -> e1.getKey(), e2 -> e2.getValue()));

    // 12. Top K users whose product sold in 2022
    public static TriFunction<Marketplace, Integer, Integer, Map<User, List<Product>>> topKUsersWhoseProductIsSoldMaximum = (marketplace, year, limit) ->
            Stream.of(marketplace)
                    .flatMap(m -> m.getProducts() != null ? m.getProducts().stream() : Stream.empty())
                    .filter(p -> p.getProductStatus().equals(ProductStatus.SOLD))
                    .collect(Collectors.groupingBy(p -> p.getUser()))
                    .entrySet().stream()
                    .sorted((c1, c2) -> (int) (c2.getValue().stream().count() - c1.getValue().stream().count()))
                    .limit(limit)
                    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

//    13. Most top K expensive biddable product added to wishlist
    public static TriFunction<Marketplace, Integer, Integer, Optional<List<Product>>> getTopKExpensiveBiddableProductAddedToWishList = (marketplace, k, year) ->
            Optional.of(Stream.of(marketplace)
                    .flatMap(m->m.getProducts().stream())
                    .filter(y -> y.getAddedDate().getYear() == year)
                    .filter(p -> p.isBiddable() == true)
                    .flatMap(w->w.getWishLists() != null ? w.getWishLists().stream() : Stream.empty())
                    .map(w->w.getProduct())
                    .collect(Collectors.groupingBy(p -> p))
                    .entrySet()
                    .stream().map(e -> e.getKey())
                    .sorted((p1, p2) -> (int) (p2.getPrice() - p1.getPrice()))
                    .limit(k)
                    .collect(Collectors.toList()));

//   14. Top K bidders in particular category.
    public static QuadFunction<Marketplace, Category, Integer, Integer, Optional<List<User>>> getTopKBiddersInParticularCategoryInParticularYear = (marketplace, category, k, year) ->
            Optional.of(Stream.of(marketplace)
                    .flatMap(p->p.getProducts().stream())
                    .filter(c->c.getCategory() == category)
                    .flatMap(p->p.getBids() != null ? p.getBids().stream(): Stream.empty())
                    .filter(b->b.getCreatedAt().getYear() == year)
                    .sorted((b1, b2) -> (int) (b2.getBidValue()- b1.getBidValue()))
                    .limit(k)
                    .map(b->b.getUser())
                    .collect(Collectors.toList()));


}
