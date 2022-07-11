import model.*;
import utils.FunctionUtils;
import utils.KRVData;

import java.time.LocalDate;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        String check = "Y";

        while (!check.equals("N")) {
            System.out.println("\n\nPlease enter your choices. If you want to exit Enter 'N' \n\n" +
                    "1.\tTop K list of Users with maximum comments\n" +
                    "2.\tTop K Product with maximum bids in a Y year\n" +
                    "3.\tEach product with highest bids in a Y year\n" +
                    "4.\tMost top K expensive biddable product added\n" +
                    "5.\tTop K users in Fairfield city who uploaded product in Electronics category with high price\n" +
                    "6.\tTop K users who uploaded product with maximum images\n" +
                    "7.\tTop K User whose product expired before 2022-01-10 date which is added to wishlist by other user\n" +
                    "8.\tTotal comments in particular users product in a Y year\n" +
                    "9.\tImage less product receiving most comments in a Y year\n" +
                    "10.\tUsers who uploaded negotiable product with highest comments in a Y year\n" +
                    "11.\tUsers Product with at least K Comments\n" +
                    "12.\tTop K users whose product sold in 2022\n" +
                    "13.\tMost top K expensive biddable product added to wishlist\n" +
                    "14.\tTop K bidders in particular category\n\n");

            Scanner myScan = new Scanner(System.in);
            check = myScan.nextLine();
            Scanner uScan = new Scanner(System.in);
            int uTopInput, uYearInt;
            switch (check) {
                case "1":
                    System.out.println("Please enter K value");
                    uTopInput = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Optional<List<User>> users = FunctionUtils.getKTopUserWithMaxComments.apply(KRVData.marketplace, uTopInput, 2022);
                        for (User us : users.get()) {
                            System.out.println(us);
                        }
                    }
                    break;

                case "2":
                    System.out.println("Please enter K value");
                    uTopInput = uScan.nextInt();
                    System.out.println("Please enter Y year value(eg.2022)");
                    uYearInt = uScan.nextInt();
                    if (uTopInput < 1 || uYearInt < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Optional<List<Product>> products = FunctionUtils.getKProductWithMaximumBids.apply(KRVData.marketplace, uTopInput, uYearInt);
                        for (Product product : products.get()) {
                            System.out.println(product);
                        }
                    }
                    break;

                case "3":
                    System.out.println("Please enter Y year value(eg.2022)");
                    uYearInt = uScan.nextInt();
                    if (uYearInt < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Map<Product, Optional<Bid>> bids = FunctionUtils.productsWithHighestBids.apply(KRVData.marketplace, uYearInt);
                        System.out.println(bids);
                    }
                    break;

                case "4":
                    System.out.println("Please enter top value");
                    uTopInput = uScan.nextInt();
                    System.out.println("Please enter year value(eg.2022)");
                    uYearInt = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Optional<List<Product>> products1 = FunctionUtils.getKTopExpensiveBiddableProduct.apply(KRVData.marketplace, uTopInput, uYearInt);
                        for (Product product : products1.get()) {
                            System.out.println(product);
                        }
                    }
                    break;

                case "5":
                    System.out.println("Please enter top value");
                    uTopInput = uScan.nextInt();
                    System.out.println("Please enter year value(eg.2022)");
                    uYearInt = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Optional<List<User>> users1 = FunctionUtils.getTopKUserInParticularLocationInYCatWithHighPrice.apply(KRVData.marketplace, uTopInput, uYearInt, "Fairfield", "Electronics");
                        for (User user : users1.get()) {
                            System.out.println(user);
                        }
                    }
                    break;

                case "6":
                    System.out.println("Please enter top value");
                    uTopInput = uScan.nextInt();
                    System.out.println("Please enter year value(eg.2022)");
                    uYearInt = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Optional<List<User>> users2 = FunctionUtils.getTopKUserWhoUploadedProductWithMaximumImages.apply(KRVData.marketplace, uTopInput, uYearInt);
                        for (User user : users2.get()) {
                            System.out.println(user);
                        }
                    }
                    break;

                case "7":
                    System.out.println("Please enter top value");
                    uTopInput = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Optional<List<User>> users3 = FunctionUtils.getTopKUSerWhoseProductExpiredOnYDateAddedToWishList.apply(KRVData.marketplace, uTopInput, LocalDate.parse("2022-01-10"));
                        for (User user : users3.get()) {
                            System.out.println(user);
                        }
                    }
                    break;

                case "8":
                    System.out.println("Please enter Y year(eg.2022)");
                    uYearInt = uScan.nextInt();
                    if (uYearInt < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Map<User, List<Comment>> comments = FunctionUtils.totalCommentsOnUsersProduct.apply(KRVData.marketplace, uYearInt);
                        System.out.println(comments);
                    }
                    break;

                case "9":
                    System.out.println("Please enter Y year(eg.2022)");
                    uYearInt = uScan.nextInt();
                    if (uYearInt < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        List<Product> products2 = FunctionUtils.popularImagelessProductsByComments.apply(KRVData.marketplace, uYearInt);
                        System.out.println(products2);
                    }
                    break;

                case "10":
                    System.out.println("Please enter Y year(eg.2022)");
                    uYearInt = uScan.nextInt();
                    if (uYearInt < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Map<User, List<Comment>> comments1 = FunctionUtils.usersWithHighestComments.apply(KRVData.marketplace, uYearInt);
                        System.out.println(comments1);
                    }
                    break;

                case "11":
                    System.out.println("Please enter K value");
                    uTopInput = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Map<User, List<Comment>> comments2 = FunctionUtils.usersProductsWithAtLeastKComments.apply(KRVData.marketplace, 2022, uTopInput);
                        System.out.println(comments2);
                    }
                    break;

                case "12":
                    System.out.println("Please enter K value");
                    uTopInput = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Map<User, List<Product>> userProduct = FunctionUtils.topKUsersWhoseProductIsSoldMaximum.apply(KRVData.marketplace, 2022, uTopInput);
                        System.out.println(userProduct);
                    }
                    break;

                case "13":
                    System.out.println("Please enter K value");
                    uTopInput = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Optional<List<Product>> products3 = FunctionUtils.getTopKExpensiveBiddableProductAddedToWishList.apply(KRVData.marketplace, uTopInput, 2022);
                        System.out.println(products3);
                    }
                    break;

                case "14":
                    System.out.println("Please enter K value");
                    uTopInput = uScan.nextInt();
                    if (uTopInput < 1) {
                        System.out.println("Input is not valid");
                    } else {
                        Optional<List<User>> users4 = FunctionUtils.getTopKBiddersInParticularCategoryInParticularYear.apply(KRVData.marketplace, KRVData.category1, uTopInput, 2022);
                        System.out.println(users4);
                    }
                    break;
            }
        }
    }
}
