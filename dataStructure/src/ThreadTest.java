/**
 * @author hankin
 * @date 2020/7/2 11:29
 */
public class ThreadTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        Thread thread1 =new Thread(
                ()->{
                    synchronized (s1){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("aa");
                    }
                }
        );
        Thread thread2 =new Thread(
                ()->{
                    synchronized (s2){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("bb");
                    }
                }
        );
        thread1.start();
        thread2.start();
    }


}
