package cn.hankin.net.pro.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @author hankin
 * @date 2020/7/14 13:26
 */
public class ReadOnlyBufferDemo {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(10);

        for (int i = 0; i < 10; i++) {
            allocate.put((byte)i);
        }
        allocate.flip();

        ByteBuffer byteBuffer = allocate.asReadOnlyBuffer();
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
//        不可写
//        byteBuffer.put((byte)4);
    }
}
