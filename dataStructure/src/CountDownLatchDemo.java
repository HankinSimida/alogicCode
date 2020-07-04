import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hankin
 * @date 2020/7/4 21:18
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch =new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            final int d = i;
            executorService.submit(()->{
                System.out.println(Thread.currentThread()+" start");
                countDownLatch.countDown();
                System.out.println(d);
            });
        }
        countDownLatch.await();
        System.out.println("finished");
        executorService.shutdown();
    }
}
