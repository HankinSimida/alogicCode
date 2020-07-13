package cn.hankin.net.pro.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hankin
 * @date 2020/7/13 13:46
 */
public class NioChannelDemo {
    public static void main(String[] args) throws IOException {
        String str ="Hello hankin";
        FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(str.getBytes().length);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();

        File file =new File("out.txt");
        FileInputStream fileInputStream =new FileInputStream(file);
        FileChannel channelByRead = fileInputStream.getChannel();
        ByteBuffer byteBufferByRead = ByteBuffer.allocate((int)file.length());
        channelByRead.read(byteBufferByRead);
        System.out.println(new String(byteBufferByRead.array()));
        fileInputStream.close();
    }
}
