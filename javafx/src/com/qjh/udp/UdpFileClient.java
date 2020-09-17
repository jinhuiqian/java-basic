package com.qjh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author 231
 * @date 2020-07-05 11:33
 */
public class UdpFileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。");
        //使用DatagramSocket 指定端口 创建发送端
        DatagramSocket cilent = new DatagramSocket(8888);
        // 准备数据 一定要转成字节数组
        byte datas[] = IOUtils.fileToByteArray("src/Picture/0.png");
        // 封装成DatagramPacket包裹 需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));
        // 发送包裹send（DatagramPacket p）
        cilent.send(packet);
        // 释放资源
        cilent.close();
    }
}
