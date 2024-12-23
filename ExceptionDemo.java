public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int a[] = new int[10];
            a[1] = 10;
            System.out.println(a[1]);
            String str = "Welcome";
            System.out.println(str.charAt(10));
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println(ae);
        } catch (StringIndexOutOfBoundsException ae) {
            System.out.println(ae.toString());
        }
        System.out.println("Hello");
    }
}
