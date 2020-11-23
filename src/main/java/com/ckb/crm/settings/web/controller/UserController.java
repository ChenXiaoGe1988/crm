package com.ckb.crm.settings.web.controller;

import com.ckb.crm.settings.domain.User;
import com.ckb.crm.settings.service.UserService;
import com.ckb.crm.settings.service.impl.UserServiceImpl;
import com.ckb.crm.utils.MD5Util;
import com.ckb.crm.utils.PrintJson;
import com.ckb.crm.utils.ServiceFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ychen
 */
public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");
        String path = request.getServletPath();
        String loginPath = "/settings/user/login.do";
        String xxxPath = "/settings/user/xxx.do";

        if (loginPath.equals(path)) {
            login(request, response);
        }else if (xxxPath.equals(path)) {
            //xxx(request,response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到验证登录操作");
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        //进行md5加密
        loginPwd = MD5Util.getMD5(loginPwd);
        //接受浏览器的ip地址
        String ip = request.getRemoteAddr();
        System.out.println("----->ip: " + ip);

        //未来业务层开发,统一使用代理类形态的接口对象
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try{
            User user = us.login(loginAct, loginPwd, ip);
            request.getSession().setAttribute("user", user);
            //如果执行到此处,说明业务层没有抛出任何异常
            //表示登录成功
            //{"success":true}
            PrintJson.printJsonFlag(response,true);
        }catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            //(1)打包成map,将map解析为json串
            //(2)创建一个Vo(大量使用信息的情况下)
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", false);
            map.put("msg", msg);
            PrintJson.printJsonObj(response, map);
        }
    }
}
