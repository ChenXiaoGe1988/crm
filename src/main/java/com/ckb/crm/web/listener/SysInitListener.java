package com.ckb.crm.web.listener;

import com.ckb.crm.settings.domain.DicValue;
import com.ckb.crm.settings.service.DicService;
import com.ckb.crm.settings.service.impl.DicServiceImpl;
import com.ckb.crm.utils.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ychen
 */
public class SysInitListener implements ServletContextListener {
    /**
     * 该方法是用来监听上下文域对象的方法,当服务器启动,上下文域对象创建对象创建完毕后,马上执行该方法
     *
     * @param event 该参数能够取得监听的对象
     *              监听的是什么对象,就可以通过该参数取得什么对象
     *              例如我们监听的是上下文域对象,通过该参数就可以取得上下文域对象
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        //System.out.println("上下文域对象创建了");
        System.out.println("服务器缓存处理数据字典开始");

        ServletContext application = event.getServletContext();

        DicService ds = (DicService) ServiceFactory.getService(new DicServiceImpl());

        Map<String, List<DicValue>> map = ds.getAll();

        //将map解析为上下文域对象中保存的键值对

        Set<String> set = map.keySet();
        for (String key : set) {
            application.setAttribute(key, map.get(key));
        }
        System.out.println("服务器缓存处理数据字典结束");
    }
}