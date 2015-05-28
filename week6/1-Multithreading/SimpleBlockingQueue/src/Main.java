public class Main {

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Integer> bq = new BlockingQueue<>(10);

        Thread pollThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    System.out.println(bq.poll() + " Polled...!");
                }
            }
        });

        Thread offerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    System.out.println(i + " Offered...!");
                    bq.offer(i);
                }
            }
        });

        pollThread.start();
        offerThread.start();
        
        pollThread.join();
        offerThread.join();
    }

}