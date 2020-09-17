package com.qjh.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author 231
 * @date 2020-07-04 18:38
 *
 * 网络爬虫原理
 */
public class SpiderTest01 {
    public static void main(String[] args) throws IOException {
        //获取URL
        URL url = new URL("http://www.jd.com");
        //下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg = null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理
    }
}
