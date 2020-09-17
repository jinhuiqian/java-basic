package com.qjh.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * @author 231
 * @date 2020-07-04 22:15
 */
public class UdpObjServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = ois.readUTF();
        int age = ois.readInt();
        boolean flag = ois.readBoolean();
        char ch = ois.readChar();
        System.out.println(flag);

        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();

        if(str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if(date instanceof Date){
            Date dateObj = (Date) date;
            System.out.println(dateObj);
        }
        if(employee instanceof Employee){
            Employee empObj = (Employee) employee;
            System.out.println(empObj.getName()+","+empObj.getAge());
        }
        // 释放资源
        server.close();
    }
}
