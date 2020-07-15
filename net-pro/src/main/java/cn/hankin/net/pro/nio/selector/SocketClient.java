package cn.hankin.net.pro.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author hankin
 * @date 2020/7/15 17:13
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connect = socketChannel.connect(new InetSocketAddress("127.0.0.1", 9909));
        if (!connect){
            while (!socketChannel.finishConnect()){
                System.out.println("do other thing");
            }
        }
        String str = "hi hankin!";
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
        socketChannel.write(wrap);
        System.in.read();
    }
}
