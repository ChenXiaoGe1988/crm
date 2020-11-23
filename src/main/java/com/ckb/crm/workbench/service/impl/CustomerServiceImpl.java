package com.ckb.crm.workbench.service.impl;

import com.ckb.crm.utils.SqlSessionUtil;
import com.ckb.crm.vo.PaginationVO;
import com.ckb.crm.workbench.dao.CustomerDao;
import com.ckb.crm.workbench.domain.Customer;
import com.ckb.crm.workbench.service.CustomerService;

import java.util.List;
import java.util.Map;

/**
 * @author ychen
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = SqlSessionUtil.getSqlSession().getMapper(CustomerDao.class);
    @Override
    public boolean save(Customer c) {
        boolean flag = true;
        int count = customerDao.save(c);
        if (count != 1) {
            flag = false;
        }
        return flag;
    }

    @Override
    public PaginationVO<Customer> pageList(Map<String, Object> map) {
        //取得查询的总条数 total
        int total = customerDao.getTotalByCondition(map);

        //取得客户信息列表 dataList
        List<Customer> dataList = customerDao.getCustomerListByCondition(map);

        //创建一个vo对象将total和dataList封装到vo中
        PaginationVO<Customer> vo = new PaginationVO<Customer>();
        vo.setTotal(total);
        vo.setDataList(dataList);
        return vo;
    }

    @Override
    public Customer detail(String id) {
        Customer c = customerDao.detail(id);
        return c;
    }
}
