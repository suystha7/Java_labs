public class AnonymousInnerClass {
    public static void main(String[] args) {
        Thread t1 = new Thread() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        };
        t1.start();
    }
}
