public class ThrowsDemo {
    void divide(int x, int y) throws ArithmeticException {
        int r = x / y;
        System.out.println("Quotient: " + r);
    }

    public static void main(String[] args) {
        ThrowsDemo t = new ThrowsDemo();
        try {
            t.divide(25, 5);
            t.divide(25, 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
