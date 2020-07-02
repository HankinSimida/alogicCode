/**
 * @author hankin
 * @date 2020/7/2 16:32
 */
public class PrintAndB {

    public static void main(String[] args) {
        Object o =new Object();
        new Thread(()->{
            synchronized (o){
                while (true){
                    try {
                        System.out.println("A");
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(()->{
            synchronized (o){
                while (true){
                    try {
                        System.out.println("B");
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

}
