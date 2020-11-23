package com.ckb.crm.settings.dao;

import com.ckb.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author ychen
 *
 */
public interface UserDao {
    public User login(Map<String, String> map);
    List<User> getUserList();
}
