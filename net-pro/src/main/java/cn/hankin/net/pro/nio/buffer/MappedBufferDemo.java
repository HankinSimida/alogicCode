package cn.hankin.net.pro.nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer -> 文件直接在堆外内存修改，os无需再copy一次
 *
 * @author hankin
 * @date 2020/7/14 13:33
 */
public class MappedBufferDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile =new RandomAccessFile("out.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();

//        0,10 10->大小
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
        map.put(0,(byte)'8');
        map.put(1,(byte)'8');
        randomAccessFile.close();
    }
}
