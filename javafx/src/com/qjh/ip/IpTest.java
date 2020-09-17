package com.qjh.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 231
 * @date 2020-07-04 18:01
 *
 * 1.getLocalHost:本机
 * 2.getByName:根据域名DNS | IP地址 得到IP
 *
 * 两个成员方法:
 * 1.getHostAddress
 * 2.getHostName
 */
public class IpTest {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());//返回本机id
        System.out.println(addr.getHostName());//输出计算机名

        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress());//返回163服务器的ip
        System.out.println(addr.getHostName());//输出www.163.com

        //根据ip得到InetAddress对象
        addr = InetAddress.getByName("223.111.156.227");
        System.out.println(addr.getHostAddress());//返回163服务器的ip
        System.out.println(addr.getHostName());//输出ip而不是域名，没权利
    }
}
