package cn.hankin.net.pro.nio.groupchat;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;


/**
 * @author hankin
 * @date 2020/7/20 13:29
 */
public class GroupChatServer {

    private Logger log = LoggerFactory.getLogger(GroupChatServer.class);

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    public GroupChatServer() {
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {

        }
    }


    public void listen() {
        try {
            while (true) {
                int count = selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            log.info(sc.getRemoteAddress() + " online...");

                        }
                        if (key.isReadable()) {
                            readData(key);
                        }

                        iterator.remove();
                    }
                } else {
                    log.info("wait...");
                }
            }
        } catch (Exception e) {

        } finally {

        }

    }

    private void readData(SelectionKey key) {
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if (count > 0) {
                String s = new String(buffer.array());
                log.info("from client " + channel.getRemoteAddress() + " : " + s);

//                转发消息去其他客户端
                sendInfoToOtherClient(s,channel);
            }
        } catch (IOException e) {
            try {
                log.info("client " + channel.getRemoteAddress() + " : offline...");
                key.cancel();
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void sendInfoToOtherClient(String s,SocketChannel self) throws IOException {
        log.info("send info to other...");
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel!=self){
                ByteBuffer wrap = ByteBuffer.wrap(s.getBytes());
                ((SocketChannel)targetChannel).write(wrap);
            }
        }
    }

    public static void main(String[] args) {
        GroupChatServer groupChatServer =new GroupChatServer();
        groupChatServer.listen();

    }


}
