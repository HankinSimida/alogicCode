import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author hankin
 * @date 2020/7/4 13:56
 */
public class DemoExecutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Integer integer=0;
        final List<Future<Integer>> futureTaskList =new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<Integer> aa = executorService.submit(() -> {
                System.out.println("aa");
                return 1;
            });
            futureTaskList.add(aa);
        }

        for (int i = 0; i < 5; i++) {
            integer+=futureTaskList.get(i).get();
            System.out.println(integer);
        }
        System.out.println(integer);
    }

}
