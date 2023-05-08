package task;

public class ConversionToEuro {
    public static String conversionToEuro(int value){
        return String.format("%d.%02d", value / 100, value % 100);
    }
}
