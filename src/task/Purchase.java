package task;

public class Purchase implements Comparable<Purchase> {
        public final static String NAME = "Android";
   public final static int PRICE = 70099;
    private int numberOfPurchasedUnits;
    private double discountPercent;
    private WeekDay weekDay;



    public Purchase() {
    }

    public Purchase(int numberOfPurchasedUnits, double discountPercent, WeekDay weekDay) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
        this.discountPercent = discountPercent;
        this.weekDay = weekDay;
    }
    public Purchase(int numberOfPurchasedUnits, double discountPercent, int  weekDay) {
        this(numberOfPurchasedUnits,discountPercent, WeekDay.values()[weekDay]);
    }

    public String getNAME() {
        return NAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }
    public void setNumberOfPurchasedUnits(int numberOfPurchasedUnits) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public double getDiscountPercent() {
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

    public int getCost() {
        double cost = PRICE * numberOfPurchasedUnits * (100 - discountPercent) / 100;
        cost =  Math.round(cost/100);
        return (int) cost*100;

    }

    @Override
    public String toString() {
        return String.format("%d; %.2f; %s %s", numberOfPurchasedUnits ,discountPercent , weekDay , ConversionToEuro.conversionToEuro( getCost()));
    }

    public String convertToEuro(int value) {
        return String.format("%d.%02d", value / 100, value % 100);
    }
    @Override
    public int compareTo(Purchase purchase){
        return numberOfPurchasedUnits - purchase.numberOfPurchasedUnits;
    }
}