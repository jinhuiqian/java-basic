package com.qjh.udp;

import java.net.SocketException;

/**
 * @author 231
 * @date 2020-07-05 15:18
 */
public class TalkTeacher {
    public static void main(String[] args) throws SocketException {
        new Thread(new TalkReceive(9999,"学生")).start(); //接收

        new Thread(new TalkSend(5555,"localhost",8888)).start(); //发送
    }
}
