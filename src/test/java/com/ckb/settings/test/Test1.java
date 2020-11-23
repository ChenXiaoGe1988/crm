package com.ckb.settings.test;


import com.ckb.crm.utils.DateTimeUtil;
import com.ckb.crm.utils.MD5Util;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //1.验证实效时间
        //实效时间
        /*String expireTime = "2020-12-12 10:42:10";
        //当前系统时间
        String currentTime = DateTimeUtil.getSysTime();
        int count = expireTime.compareTo(currentTime);
        System.out.println(count);*/

        //2.验证锁定状态
        /*String lockState = "0";
        if ("0".equals(lockState)) {
            System.out.println("账号已锁定");
        }*/

        //3.验证ip地址
        //浏览器ip地址
        /*String ip = "192.168.1.2";
        //允许访问的ip地址群
        String allowIps = "192.168.1.1,192.168.1.2";
        if (allowIps.contains(ip)) {
            System.out.println("有效的ip地址, 允许访问系统");
        } else {
            System.out.println("ip地址受限, 请联系管理员");
        }*/

        //4.MD5测试
        /*String pwd = "123";
        pwd = MD5Util.getMD5(pwd);
        System.out.println(pwd);*/
    }
}
