package com.qjh.chat02;

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
 *
 * 使用多线程实现多个客户可以正常收发多条消息
 * 问题:其他客户必须等待之前的客户退出，才能排队
 */
public class TMultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        // 1、指定端口 使用ServerSocket创建服务器
        ServerSocket server =new ServerSocket(4444);
        // 2、阻塞式等待连接 accept
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(()->{
                DataInputStream dis=null;
                DataOutputStream dos=null;
                //3.接收消息
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                    boolean isRunning = true;
                    while (isRunning) {
                        String datas = dis.readUTF();
                        //返回消息
                        dos.writeUTF(datas);
                        dos.flush();
                    }
                    try {
                        if(null==dos) {
                            dos.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if(null==dis) {
                            dis.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if(null==client) {
                            client.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        isRunning = false;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
