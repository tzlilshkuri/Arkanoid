package background;

/**
 * * @tzlil shkuri 314706300
 */
public class Counter {
    private int value;

    /**
     * This is a constructor function.
     *
     * @param value -the counter value;
     */
    public Counter(int value) {
        this.value = value;
    }

    /**
     * increase- increase number from current count.
     *
     * @param number the number we want to add.
     */
    public void increase(int number) {
        this.value = this.value + number;
    }

    /**
     * subtract- subtract number from current count.
     *
     * @param number the value we want to remove from our number..
     */
    public void decrease(int number) {
        this.value = this.value - number;
    }

    /**
     * @param value the x value of the point that we want to update.
     *              setValue function- update the value.
     */
    public void setValue(int value) {
        this.value = value;
    }


    /**
     * getValue function- return the value.
     *
     * @return value -return the value.
     */
    public int getValue() {
        return this.value;
    }
}