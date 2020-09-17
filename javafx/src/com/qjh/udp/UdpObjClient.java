package com.qjh.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * @author 231
 * @date 2020-07-04 22:15
 */
public class UdpObjClient {

    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。");
        //使用DatagramSocket 指定端口 创建发送端
        DatagramSocket cilent = new DatagramSocket(8888);
        // 准备数据 一定要转成字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.writeUTF("编码辛酸泪");
        oos.writeInt(18);
        oos.writeBoolean(false);
        oos.writeChar('a');

        oos.writeObject("谁解其中味");
        oos.writeObject(new Date());
        Employee emp = new Employee("张三",22);
        oos.writeObject(emp);
        oos.flush();
        byte[] datas = baos.toByteArray();
        // 封装成DatagramPacket包裹 需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));
        // 发送包裹send（DatagramPacket p）
        cilent.send(packet);
        // 释放资源
        cilent.close();
    }
}
