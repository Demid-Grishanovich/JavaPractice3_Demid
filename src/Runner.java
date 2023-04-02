import task.Purchase;
import task.Purchase.WeekDay;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        File file = new File("src/in.txt");
        Scanner scanner = new Scanner(file);
        int PURCHASES_NUMBER = scanner.nextInt();
        Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

        for (int i = 0; i < PURCHASES_NUMBER; i++) {
            String productName = scanner.next();
            double price = scanner.nextDouble();
            int numberOfPurchasedUnits = scanner.nextInt();
            int discountPercent = scanner.nextInt();
            int weekDay = scanner.nextInt();
            purchases[i] = new Purchase(productName, price, numberOfPurchasedUnits, discountPercent, WeekDay.values()[weekDay]);
        }

        // Output the array content
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        // Calculate the average cost, total cost on Monday, and day with the maximum purchase cost
        double totalCost = 0;
        double mondayTotalCost = 0;
        double maxPurchaseCost = 0;
        WeekDay dayWithMaxPurchaseCost = null;

        for (Purchase purchase : purchases) {
            double cost = purchase.getCost();
            totalCost += cost;

            if (purchase.getWeekDay() == WeekDay.MONDAY) {
                mondayTotalCost += cost;
            }

            if (cost > maxPurchaseCost) {
                maxPurchaseCost = cost;
                dayWithMaxPurchaseCost = purchase.getWeekDay();
            }
        }

        double averageCost = totalCost / PURCHASES_NUMBER;
        System.out.printf("Average cost: %.3f%n", averageCost);
        System.out.printf("Total cost on Monday: %.3f%n", mondayTotalCost);
        System.out.printf("Day with the maximum purchase cost: %s%n", dayWithMaxPurchaseCost);

        // Sort the array by the number of purchased units
        Arrays.sort(purchases);

        // Output the sorted array content
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        // Find a purchase with number equalled to 5
        Purchase key = new Purchase();
        key.setNumberOfPurchasedUnits(5);
        int index = Arrays.binarySearch(purchases, key);

        if (index >= 0) {
            System.out.println("Purchase with number equalled to 5: " + purchases[index]);

        } else {
            System.out.println("No purchase with number equalled to 5 found.");
        }
    }
}