package cn.hankin.net.pro.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hankin
 * @date 2020/7/13 14:34
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        File file =new File("花晋Resume.pdf");
        FileInputStream in =new FileInputStream(file);
        FileChannel readChannel = in.getChannel();

        FileOutputStream out =new FileOutputStream("back.pdf");
        FileChannel channel1 = out.getChannel();
        ByteBuffer readAndWriteBuffer = ByteBuffer.allocate(1024*1024);
        while (true){
            readAndWriteBuffer.clear();
            int read = readChannel.read(readAndWriteBuffer);
            System.out.println(read);
            if (read==-1){
                break;
            }
            readAndWriteBuffer.flip();
            channel1.write(readAndWriteBuffer);

        }

        in.close();
        out.close();
    }
}
