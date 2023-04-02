import org.junit.Test;
import static org.junit.Assert.*;
import task.Purchase;
import task.Purchase.WeekDay;

public class TestRunner {
    @Test
    public void testConstructors() {
        Purchase purchase1 = new Purchase();
        assertNotNull(purchase1);

        Purchase purchase2 = new Purchase("Laptop", 1000.00, 2, 10, WeekDay.TUESDAY);
        assertNotNull(purchase2);
        assertEquals("Laptop", purchase2.getProductName());
        assertEquals(1000.00, purchase2.getPrice(), 0.01);
        assertEquals(2, purchase2.getNumberOfPurchasedUnits());
        assertEquals(10, purchase2.getDiscountPercent());
        assertEquals(WeekDay.TUESDAY, purchase2.getWeekDay());
    }

    @Test
    public void testGetCost() {
        Purchase purchase = new Purchase("Laptop", 1000.00, 2, 10, WeekDay.TUESDAY);
        assertEquals(1800.00, purchase.getCost(), 0.01);
    }

    @Test
    public void testToString() {
        Purchase purchase = new Purchase("Laptop", 1000.00, 2, 10, WeekDay.TUESDAY);
        String expected = "Laptop;1000.0;2;10;TUESDAY;1800.0";
        assertEquals(expected, purchase.toString());
    }
}
