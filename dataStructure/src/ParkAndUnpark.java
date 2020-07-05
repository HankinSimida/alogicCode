import java.util.concurrent.locks.LockSupport;

/**
 * @author hankin
 * @date 2020/7/5 16:12
 */
public class ParkAndUnpark {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                ()->{
                    System.out.println("AAA");
                    LockSupport.park();
                    System.out.println("BBB");
                }
        );
        t1.start();

        Thread.sleep(5000);
        System.out.println("MAIN DONE");
        LockSupport.unpark(t1);

    }
}
