package nl.spijkerman.ivo.calculator;

public class Calculator {

    private int value;

    Calculator(int value) {
        this.value = value;
    }

    void add(int input) {
        value += input;
    }

    void mulitply(int input) {
        value *= input;
    }

    void factorial() {
        if (value < 0)
            throw new IllegalStateException("value must be higher or equal than 0");

        int result = value;
        for (int i = value; i > 1; i--) {
            result = result * (i - 1);
        }
        value = result;
    }

    int read() {
        return value;
    }
}
