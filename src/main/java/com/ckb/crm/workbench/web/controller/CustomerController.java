package com.ckb.crm.workbench.web.controller;

import com.ckb.crm.settings.domain.User;
import com.ckb.crm.settings.service.UserService;
import com.ckb.crm.settings.service.impl.UserServiceImpl;
import com.ckb.crm.utils.DateTimeUtil;
import com.ckb.crm.utils.PrintJson;
import com.ckb.crm.utils.ServiceFactory;
import com.ckb.crm.utils.UUIDUtil;
import com.ckb.crm.vo.PaginationVO;
import com.ckb.crm.workbench.domain.Customer;
import com.ckb.crm.workbench.service.CustomerService;
import com.ckb.crm.workbench.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ychen
 * 客户控制器
 */
public class CustomerController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到客户控制器");
        String path = request.getServletPath();
        
        if ("/workbench/customer/getUserList.do".equals(path)) {
            getUserList(request, response);
        } else if("/workbench/customer/save.do".equals(path)){
            save(request, response);
        } else if("/workbench/customer/pageList.do".equals(path)) {
            pageList(request, response);
        } else if("/workbench/customer/detail.do".equals(path)) {
            detail(request, response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行客户详情页跳转操作");
        String id = request.getParameter("id");
        CustomerService cs = (CustomerService) ServiceFactory.getService(new CustomerServiceImpl());
        Customer c = cs.detail(id);
        request.setAttribute("c", c);
        request.getRequestDispatcher("/workbench/customer/detail.jsp").forward(request, response);
    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到查询客户信息列表的操作(条件查询+分页查询)");
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String phone = request.getParameter("phone");
        String website = request.getParameter("website");
        String pageNoStr = request.getParameter("pageNo");
        int pageNo = Integer.valueOf(pageNoStr);
        //展现每页的记录数
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = Integer.valueOf(pageSizeStr);
        //计算出略过的记录数
        int skipCount = (pageNo - 1) * pageSize;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("phone", phone);
        map.put("website", website);
        map.put("skipCount", skipCount);
        map.put("pageSize", pageSize);

        CustomerService cs = (CustomerService) ServiceFactory.getService(new CustomerServiceImpl());

        PaginationVO<Customer> vo = cs.pageList(map);
        PrintJson.printJsonObj(response, vo);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行客户添加操作");
        //生成唯一id
        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String website = request.getParameter("website");
        String contactSummary = request.getParameter("contactSummary");
        String nextContactTime = request.getParameter("nextContactTime");
        String description = request.getParameter("description");
        String address = request.getParameter("address");

        //创建时间
        String createTime = DateTimeUtil.getSysTime();
        //创建人
        String createBy = ((User)request.getSession().getAttribute("user")).getName();

        //创建客户对象
        Customer c = new Customer();
        c.setId(id);
        c.setOwner(owner);
        c.setName(name);
        c.setPhone(phone);
        c.setWebsite(website);
        c.setContactSummary(contactSummary);
        c.setNextContactTime(nextContactTime);
        c.setDescription(description);
        c.setAddress(address);
        c.setCreateBy(createBy);
        c.setCreateTime(createTime);

        CustomerService cs = (CustomerService) ServiceFactory.getService(new CustomerServiceImpl());
        boolean flag = cs.save(c);
        PrintJson.printJsonFlag(response, flag);
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList = us.getUserList();
        PrintJson.printJsonObj(response, userList);
    }
}
