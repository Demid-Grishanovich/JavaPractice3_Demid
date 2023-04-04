import task.Purchase;
import task.WeekDay;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Runner {
    public Runner() {
    }
    public static void main(String[] args)  {
        File file = new File("src/in.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(file));
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
        scanner.nextLine();

        for (int i = 0; i < purchases.length; i++) {
            String[] fileData = scanner.nextLine().split(" ");
            int number = Integer.parseInt(fileData[0]);
            int discount = Integer.parseInt(fileData[1]);
            WeekDay day = WeekDay.values()[Integer.parseInt(fileData[2])];
            Purchase purchaseTemp = new Purchase(number, discount, day);
            purchases[i] = purchaseTemp;;
        }
        scanner.close();


        // Output the array
        System.out.println(Purchase.NAME + " " +Purchase.PRICE );
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
        int averageCost = 0;
        int totalCost = 0;
        WeekDay weekDay = null;
        int currentDiscount = 100;
        for (Purchase purchase : purchases) {
            int cost = purchase.getCost();
            averageCost += cost;
            if (purchase.getWeekDay() == WeekDay.Monday){
                totalCost += cost;
            }
            if (purchase.getDiscountPercent() < currentDiscount){
                currentDiscount = purchase.getDiscountPercent();
                weekDay = purchase.getWeekDay();
            }
        }
        System.out.printf("The average cost of all purchases:%.3f\n", (averageCost / (double)purchases.length) / 100);
        System.out.printf("The total cost of all purchases on Monday:%d.%d", totalCost/100, totalCost%100);
        System.out.println();
        System.out.println("The day with maximum purchase cost:" + weekDay);
        Arrays.sort(purchases);
        printArray(purchases);
        int[] numbers = new int[PURCHASES_NUMBER];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = purchases[i].getNumberOfPurchasedUnits();
        }
        System.out.println("purchase with number equalled to 5:" + purchases[Arrays.binarySearch(numbers, 5)]);
    }
    public static void printArray(Purchase[] purchases) {
        Purchase purchase1 = new Purchase();
        System.out.println(purchase1.getNAME() + " " + purchase1.getPRICE());
        for (Purchase purchase : purchases) {
            if (purchase != null) {
                System.out.println(purchase);
            }
        }
    }
}