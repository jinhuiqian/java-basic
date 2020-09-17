package com.qjh.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 231
 * @date 2020-07-05 18:42
 *
 * 在线聊天室:服务端
 * 实现一个客户可以正常收发消息
 */
public class Chat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        // 1、指定端口 使用ServerSocket创建服务器
        ServerSocket server =new ServerSocket(5555);
        // 2、阻塞式等待连接 accept
        Socket client =server.accept();
        System.out.println("一个客户端建立了连接");
        //3.接收消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        //返回消息
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(datas);
        dos.flush();

        dos.close();
        dis.close();
        client.close();
    }
}
