package com.ckb.crm.workbench.dao;

import com.ckb.crm.workbench.domain.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerDao {
    int save(Customer c);

    int getTotalByCondition(Map<String, Object> map);

    List<Customer> getCustomerListByCondition(Map<String, Object> map);

    Customer detail(String id);
}
