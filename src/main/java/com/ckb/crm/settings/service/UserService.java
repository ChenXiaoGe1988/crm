package com.ckb.crm.settings.service;

import com.ckb.crm.exception.LoginException;
import com.ckb.crm.settings.domain.User;

import java.util.List;

/**
 * @author ychen
 */
public interface UserService {
    /**
     * 用户登录方法
     * @param loginAct
     * @param loginPwd
     * @param ip
     * @return
     * @throws LoginException
     */
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();
}
