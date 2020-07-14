package cn.hankin.net.pro.nio.channel;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author hankin
 * @date 2020/7/13 15:23
 */
public class NioChannelTrans {
    public static void main(String[] args) throws IOException {
        File file = new File("out.txt");
        FileOutputStream out =new FileOutputStream("out2.txt");
        FileInputStream in =new FileInputStream(file);

        FileChannel outChannel = out.getChannel();
        FileChannel inChannel = in.getChannel();

//        outChannel.transferFrom(inChannel,0,inChannel.size());

        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.close();
        inChannel.close();
        in.close();
        out.close();
    }
}
