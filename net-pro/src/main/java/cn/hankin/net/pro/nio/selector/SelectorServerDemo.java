package cn.hankin.net.pro.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hankin
 * @date 2020/7/15 16:01
 */
public class SelectorServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9909));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            if(selector.select(1000)==0){
                System.out.println("wait 1s.");
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                }
                if (key.isReadable()){
                    SocketChannel channel =(SocketChannel) key.channel();
                    ByteBuffer buffer =(ByteBuffer) key.attach(channel);
                    channel.read(buffer);
                    System.out.println("from client msg :"+new String(buffer.array()));
                }
                keyIterator.remove();
            }
        }

    }
}
