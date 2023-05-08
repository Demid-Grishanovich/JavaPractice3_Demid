package task;

public enum WeekDay {
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6);

    private int value;

    private WeekDay(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}