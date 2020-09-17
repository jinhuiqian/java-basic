package com.qjh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 231
 * @date 2020-07-04 20:33
 *
 * 接收端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacket 包裹
 * 3.阻塞式接受包裹receive（DatagramPacket p）
 * 4.分析数据
 *   byte getDate()
 *        getLength()
 * 5.释放资源
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中。。。");
        //使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        // 准备容器 封装成DatagramPacket 包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        // 阻塞式接受包裹receive（DatagramPacket p）
        server.receive(packet);
        //分析数据
        byte[] datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas,0,len));
        // 释放资源
        server.close();
    }
}
