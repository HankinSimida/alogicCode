package cn.hankin.net.pro.nio;

import java.nio.IntBuffer;

/**
 * @author hankin
 * @date 2020/7/12 14:54
 */
public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer =IntBuffer.allocate(5);
        intBuffer.put(12);
        intBuffer.put(13);
        intBuffer.put(14);
        intBuffer.put(15);
        intBuffer.put(12);

        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
//        不会清除数据，仅仅是把各个标记恢复到初始状态
        intBuffer.clear();
        intBuffer.position(2);
        System.out.println(intBuffer.get());
    }
}
