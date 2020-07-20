package cn.hankin.net.pro.nio.groupchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author hankin
 * @date 2020/7/20 14:12
 */
public class ClientGroupChat {

    private Logger log = LoggerFactory.getLogger(ClientGroupChat.class);
    private final String HOST = "127.0.0.1";
    private final int PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public ClientGroupChat() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        username = socketChannel.getLocalAddress().toString().substring(1);
        log.info(username + " is ok...");
    }

    public void sendInfo(String info) {
        info = username + " say: " + info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public void readInfo(){
        try {
            int readChannels = selector.select();
            if (readChannels>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel)key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        sc.read(buffer);
                        String msg = new String(buffer.array());
                        log.info(msg.trim());
                    }
                }
            }else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ClientGroupChat clientGroupChat =new ClientGroupChat();
        new Thread(
                ()->{
                    while (true){
                        clientGroupChat.readInfo();
                        try {
                            Thread.currentThread().sleep(3000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            clientGroupChat.sendInfo(s);
        }
    }

}
