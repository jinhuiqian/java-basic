package com.qjh.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 231
 * @date 2020-07-04 18:46
 *
 * 网络爬虫原理 + 模拟浏览器
 */
public class SpiderTest02 {
    public static void main(String[] args) throws IOException {
        //获取URL
        URL url = new URL("http://www.baidu.com");
        //下载资源
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("cn.sxt.User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String msg = null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理
    }
}
