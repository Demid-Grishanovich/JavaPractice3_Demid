import task.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestRunner {
    @Test
    public void TestConstructorsVoid() {
        Purchase purchaseDefault = new Purchase();
        assertEquals(0, purchaseDefault.getNumberOfPurchasedUnits());
        assertEquals(0, purchaseDefault.getDiscountPercent());
        assertNull(purchaseDefault.getWeekDay());

    }


    @Test
    public void TestConstructors() {
        Purchase purchase = new Purchase(15, 30, WeekDay.MONDAY);
        assertEquals("Android", Purchase.NAME);
        assertEquals(70099, Purchase.PRICE);
        assertEquals(15, purchase.getNumberOfPurchasedUnits());
        assertEquals(30, purchase.getDiscountPercent());
        assertEquals(WeekDay.MONDAY, purchase.getWeekDay());
    }

    @Test
    public void TestConstructorsWithIntDay() {
        Purchase purchase1 = new Purchase(15, 30, 1);
        assertEquals("Android", Purchase.NAME);
        assertEquals(70099, Purchase.PRICE);
        assertEquals(15, purchase1.getNumberOfPurchasedUnits());
        assertEquals(30, purchase1.getDiscountPercent());
        assertEquals(WeekDay.MONDAY, purchase1.getWeekDay());
    }


    @Test
    public void testFirstGetCost() {
        Purchase purchase1 = new Purchase(6, 20, WeekDay.TUESDAY);
        assertEquals(336500, purchase1.getCost());
    }

    @Test
    public void testSecondGetCost() {
        Purchase purchase2 = new Purchase(10, 15.5, 1);
        assertEquals(592300, purchase2.getCost());
    }

    @Test
    public void testThirdGetCost() {
        Purchase purchase3 = new Purchase(3, 20, WeekDay.SUNDAY);
        assertEquals(168200, purchase3.getCost());
    }

    @Test
    public void testFourthGetCost() {
        Purchase purchase4 = new Purchase(3, 10, 3);
        assertEquals(189300, purchase4.getCost());
    }

    @Test
    public void testConversionToEuro1() {
        assertEquals(ConversionToEuro.conversionToEuro(120053), "1200.53");
    }
    @Test
    public void testConversionToEuro2() {
        assertEquals(ConversionToEuro.conversionToEuro(350), "3.50");
    }
    @Test
    public void testConversionToEuro3() {
        assertEquals(ConversionToEuro.conversionToEuro(305), "3.05");

    }
    @Test
    public void testConversionToEuro4() {
        assertEquals(ConversionToEuro.conversionToEuro(300), "3.00");
    }
    @Test
    public void testConversionToEuro5() {
        assertEquals(ConversionToEuro.conversionToEuro(5), "0.05");
    }
    @Test
    public void testConversionToEuro6() {
        assertEquals(ConversionToEuro.conversionToEuro(0), "0.00");
    }
    @Test
    public void testConversionToEuro7() {
        assertEquals(ConversionToEuro.conversionToEuro(100500), "1005.00");
    }
}

