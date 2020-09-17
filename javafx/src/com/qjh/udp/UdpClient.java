package com.qjh.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author 231
 * @date 2020-07-04 20:37
 *
 * 发送端
 * 1.使用DatagramSocket 指定端口 创建发送端
 * 2.准备数据 一定要转成字节数组
 * 3.封装成DatagramPacket包裹 需要指定目的地
 * 4.发送包裹send（DatagramPacket p）
 * 5.释放资源
 */
public class UdpClient {
    public static void main(String[] args) throws Exception{
        System.out.println("发送方启动中。。。");
        //使用DatagramSocket 指定端口 创建发送端
        DatagramSocket cilent = new DatagramSocket(8888);
        // 准备数据 一定要转成字节数组
        String data ="钱锦辉";
        byte[] dates = data.getBytes();
        // 封装成DatagramPacket包裹 需要指定目的地
        DatagramPacket packet = new DatagramPacket(dates,0,dates.length,
                new InetSocketAddress("localhost",6666));
        // 发送包裹send（DatagramPacket p）
        cilent.send(packet);
        // 释放资源
        cilent.close();
    }
}
