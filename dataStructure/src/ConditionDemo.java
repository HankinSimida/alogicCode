import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hankin
 * @date 2020/7/5 13:31
 */
public class ConditionDemo {


    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock =new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();
        AtomicInteger i = new AtomicInteger();
        Thread a =new Thread(
                ()->{
                    try{
                        reentrantLock.lock();
                        while (true){
                            if (i.get()==100)
                                break;
                            i.getAndIncrement();
                            System.out.println(Thread.currentThread()+": "+i.get());
                            conditionB.signal();
                            conditionA.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();

                    }
                }
        );
        a.start();
        Thread b =new Thread(
                ()->{
                    try{
                        reentrantLock.lock();
                        while (true){
                            if (i.get()==100)
                                break;
                            i.getAndIncrement();
                            System.out.println(Thread.currentThread()+": "+i.get());
                            conditionC.signal();
                            conditionB.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();

                    }
                }
        );
        b.start();

        Thread c =new Thread(
                ()->{
                    try{
                        reentrantLock.lock();
                        while (true){
                            if (i.get()==100)
                                break;
                            i.getAndIncrement();
                            System.out.println(Thread.currentThread()+": "+i.get());
                            conditionA.signal();
                            conditionC.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();

                    }
                }
        );
       c.start();

       Thread.sleep(1000);
    }
}
