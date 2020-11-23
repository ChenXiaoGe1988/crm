package com.ckb.crm.workbench.service;

import com.ckb.crm.vo.PaginationVO;
import com.ckb.crm.workbench.domain.Customer;

import java.util.Map;

/**
 * @author ychen
 */
public interface CustomerService {
    boolean save(Customer c);

    PaginationVO<Customer> pageList(Map<String, Object> map);

    Customer detail(String id);
}
