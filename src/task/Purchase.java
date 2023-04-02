package task;

public class Purchase implements Comparable<Purchase> {
    private String productName;
    private double price;
    private int numberOfPurchasedUnits;
    private int discountPercent;
    private WeekDay weekDay;

    public enum WeekDay {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public Purchase() {
    }

    public Purchase(String productName, double price, int numberOfPurchasedUnits, int discountPercent, WeekDay weekDay) {
        this.productName = productName;
        this.price = price;
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
        this.discountPercent = discountPercent;
        this.weekDay = weekDay;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }

    public void setNumberOfPurchasedUnits(int numberOfPurchasedUnits) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent
                = discountPercent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public double getCost() {
        return Math.round(price * numberOfPurchasedUnits * (100 - discountPercent) / 100.0);
    }

    @Override
    public String toString() {
        return productName + ";" + price + ";" + numberOfPurchasedUnits + ";" + discountPercent + ";" + weekDay + ";" + getCost();
    }

    @Override
    public int compareTo(Purchase purchase) {
        return Integer.compare(this.numberOfPurchasedUnits, purchase.numberOfPurchasedUnits);
    }
}