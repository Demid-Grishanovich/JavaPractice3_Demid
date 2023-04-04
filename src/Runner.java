import task.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader("src/in.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        scanner.useLocale(Locale.ENGLISH);
        final int PURCHASES_NUMBER = scanner.nextInt();
        if (PURCHASES_NUMBER == 0) {
            System.out.println("Purchases count is zero.");
            return;
        }
        Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
        for (int i = 0; i < purchases.length; i++) {
            int number = scanner.nextInt();
            double discount = scanner.nextDouble();
            WeekDay day = WeekDay.values()[scanner.nextInt()];
            purchases[i] = new Purchase(number, discount, day);
        }
        scanner.close();
        printArray(purchases);
        int totalCost = 0;
        int totalCostMonday = 0;
        double averageCost = 0.0;
        WeekDay weekDay = null;
        double currentDiscount = 100;
        for (Purchase purchase : purchases) {
            double cost = purchase.getCost();
            totalCost += cost;
            if (purchase.getWeekDay() == WeekDay.MONDAY) {
                totalCostMonday += cost;
            }
            if (purchase.getDiscountPercent() < currentDiscount) {
                currentDiscount = purchase.getDiscountPercent();
                weekDay = purchase.getWeekDay();
            }
        }
        if (purchases.length > 0) {
            averageCost = ((double) totalCost / purchases.length) / 100;
        }
        System.out.printf("The average cost of all purchases:%.3f", averageCost);
        System.out.println("\nThe total cost of all purchases on Monday:" + ConversionToEuro.conversionToEuro(totalCostMonday));
        System.out.println("The day with maximum purchase cost:" + weekDay);
        Arrays.sort(purchases);
        printArray(purchases);
        Purchase dummyPurchase = new Purchase(5, 0, WeekDay.SUNDAY);
        int index = Arrays.binarySearch(purchases, dummyPurchase);
        if (index >= 0) {
            System.out.println("Purchase with number equalled to 5: " + purchases[index]);
        } else {
            System.out.println("Purchase with 5 units not found");
        }
    }

    private static void printArray(Purchase[] purchases) {
        System.out.println(Purchase.NAME + " " + ConversionToEuro.conversionToEuro(Purchase.PRICE));
        for (Purchase purchase : purchases) {
            if (purchase != null) {
                System.out.println(purchase);
            }
        }
    }
}