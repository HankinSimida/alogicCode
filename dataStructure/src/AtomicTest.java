import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hankin
 * @date 2020/7/2 13:21
 */
public class AtomicTest {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void test() {
        for (int i = 0; i < 100000; i++) {
            if (atomicInteger.get() < 10000) {
                atomicInteger.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicTest atomicTest = new AtomicTest();
        List<Thread> threads =new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            Thread thread = new Thread(() -> atomicTest.test(), "t" + i);
            threads.add(thread);
        }
        for (int i = 0; i < 20; i++) {
            threads.get(i).start();
        }
        for (int i = 0; i < 20; i++) {
            threads.get(i).join();
        }

        System.out.println(atomicTest.atomicInteger);
    }
}
