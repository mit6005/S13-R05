public class CountMain {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[8000];
        for (int ii = 0; ii < threads.length; ii++) {
            final int id = ii;
            threads[ii] = new Thread(new Runnable() {
                public void run() {
                    new Account(0, id);
                    System.out.println("Now " + Account.getCount() + " accounts");
                }
            });
            threads[ii].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Finally " + Account.getCount() + " accounts");
    }
}
