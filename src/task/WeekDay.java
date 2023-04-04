package task;

public enum WeekDay {
    Sunday(0),
    Monday(1),
    Tuesday(2),
    Wednesday(3),
    Thursday(4),
    Friday(5),
    Saturday(6);

    private int value;

    private WeekDay(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}