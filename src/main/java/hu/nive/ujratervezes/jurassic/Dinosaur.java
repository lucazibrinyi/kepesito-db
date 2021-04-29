package hu.nive.ujratervezes.jurassic;

public class Dinosaur {
    private final String name;
    private int expected;
    private int actual;

    public Dinosaur(String name, int expected, int actual) {
        this.name = name;
        this.expected = expected;
        this.actual = actual;
    }

    public String getName() {
        return name;
    }

    public int getExpected() {
        return expected;
    }

    public int getActual() {
        return actual;
    }
}
