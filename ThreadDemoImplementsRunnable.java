public class ThreadDemoImplementsRunnable {
    public static void main(String[] args) {
        AA aa = new AA();
        Thread t1 = new Thread(aa);
        t1.start();
        Thread t2 = new Thread(new BB());
        t2.start();
        Thread t3 = new Thread(new CC());
        t3.start();
        Thread t4 = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        t4.start();
    }
}

class AA implements Runnable {
    @Override
    public void run() {
        System.out.println("Starting Threaad A.......");
        for (int i = 0; i < 2; i++) {
            System.out.println("Thread A : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        System.out.println("Thread A finished !!!");
    }
}

class BB implements Runnable {
    @Override
    public void run() {
        System.out.println("Starting Threaad B.......");
        for (int i = 0; i < 4; i++) {
            System.out.println("Thread B : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        System.out.println("Thread B finished !!!");
    }
}

class CC implements Runnable {
    @Override
    public void run() {
        System.out.println("Starting Threaad C.......");
        for (int i = 0; i < 6; i++) {
            System.out.println("Thread C : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        System.out.println("Thread C finished !!!");
    }
}