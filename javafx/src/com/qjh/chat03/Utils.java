package com.qjh.chat03;

import java.io.Closeable;

/**
 * @author 231
 * @date 2020-07-05 20:22
 *
 * 工具类
 */
public class Utils {
    /**
     * 释放资源
     */
    public static void close(Closeable... targets){
        for (Closeable target:targets){
            try {
                if (null!=target){
                    target.close();
                }
            }catch (Exception e){

            }
        }
    }
}
