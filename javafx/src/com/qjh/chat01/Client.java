package com.qjh.chat01;

import java.io.*;
import java.net.Socket;

/**
 * @author 231
 * @date 2020-07-05 18:42
 *
 * 在线聊天室:客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        //1、建立连接: 使用Socket创建客户端 +服务的地址和端口
        Socket client =new Socket("localhost",5555);
        //2.客户端发消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String msg = console.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
        //3.获取消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        msg = dis.readUTF();
        System.out.println(msg);

        dos.close();
        dis.close();
        client.close();
    }
}
