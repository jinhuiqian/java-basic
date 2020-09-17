package com.qjh.chat02;

import java.io.*;
import java.net.Socket;

/**
 * @author 231
 * @date 2020-07-05 18:42
 *
 * 在线聊天室:客户端
 */
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        //1、建立连接: 使用Socket创建客户端 +服务的地址和端口
        Socket client =new Socket("localhost",4444);
        //2.客户端发消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());

        boolean isRunning = true;
        while (isRunning){
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();
            //3.获取消息
            msg = dis.readUTF();
            System.out.println(msg);
        }

        dos.close();
        dis.close();
        client.close();
    }
}
