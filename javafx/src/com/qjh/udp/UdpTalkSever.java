package com.qjh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 231
 * @date 2020-07-05 11:33
 */
public class UdpTalkSever {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("接收方启动中。。。");
        //使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        // 准备容器 封装成DatagramPacket 包裹
        while (true){
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            // 阻塞式接受包裹receive（DatagramPacket p）
            server.receive(packet);
            //分析数据
            byte[] datas = packet.getData();
            int len = packet.getLength();
            String data = new String(datas,0,len);
            System.out.println(data);
            if (data.equals("bye")){
                break;
            }
        }
        // 释放资源
        server.close();
    }
}
