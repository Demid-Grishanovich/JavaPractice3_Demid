import task.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRunner {
    @Test
    public void TestConstructors() {
        Purchase purchaseDefault = new Purchase();
        assertEquals(0, purchaseDefault.getNumberOfPurchasedUnits());
        assertEquals(0, purchaseDefault.getDiscountPercent());
        assertNull(purchaseDefault.getWeekDay());
        Purchase purchase = new Purchase(15, 30, WeekDay.MONDAY);
        Purchase purchase1 = new Purchase(15, 30, 1);
        assertEquals("Android", Purchase.NAME);
        assertEquals(70099, Purchase.PRICE);
        assertEquals(15, purchase.getNumberOfPurchasedUnits());
        assertEquals(15, purchase1.getNumberOfPurchasedUnits());
        assertEquals(30, purchase.getDiscountPercent());
        assertEquals(30, purchase1.getDiscountPercent());
        assertEquals(WeekDay.MONDAY, purchase.getWeekDay());
        assertEquals(WeekDay.MONDAY, purchase1.getWeekDay());
    }

    @Test
    public void testGetCost() {
        Purchase purchase1 = new Purchase(6, 20, WeekDay.TUESDAY);
        assertEquals(336500, purchase1.getCost());
        Purchase purchase2 = new Purchase(10, 15.5, 1);
        assertEquals(592300, purchase2.getCost());
        Purchase purchase3 = new Purchase(3, 20, WeekDay.SUNDAY);
        assertEquals(168200, purchase3.getCost());
        Purchase purchase4 = new Purchase(3, 10, 3);
        assertEquals(189300, purchase4.getCost());
    }

    @Test
    public void testConversionToEuro() {
        assertEquals(ConversionToEuro.conversionToEuro(120053), "1200.53");
        assertEquals(ConversionToEuro.conversionToEuro(350), "3.50");
        assertEquals(ConversionToEuro.conversionToEuro(305), "3.05");
        assertEquals(ConversionToEuro.conversionToEuro(300), "3.00");
        assertEquals(ConversionToEuro.conversionToEuro(5), "0.05");
        assertEquals(ConversionToEuro.conversionToEuro(0), "0.00");
        assertEquals(ConversionToEuro.conversionToEuro(100500), "1005.00");
    }
}