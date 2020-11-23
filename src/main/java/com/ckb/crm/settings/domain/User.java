package com.ckb.crm.settings.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ychen
 */

@Getter
@Setter
@ToString
public class User {
    /*
        关于登录:
            验证账号和密码
            select * from tbl_user where loginAct=? and loginPwd=?
            执行语句返回一个user对象,
            1.如果为null,说明账号密码错误
            2.不为null,说明账号密码准确
                需要继续验证
                从user中get到
                expireTime 验证实效时间
                lockState 验证锁定状态
                allowIps 验证浏览器端的ip地址是否有效
     */
    /**
     * 编号
     */
    private String id;
    /**
     * 登录账号
     */
    private String loginAct;
    /**
     * 用户的真实姓名
     */
    private String name;
    /**
     * 登录密码
     */
    private String loginPwd;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 失效时间
     */
    private String expireTime;
    /**
     * 锁定状态
     * 0: 锁定
     * 1: 启用
     */
    private String lockState;
    /**
     * 部门编号
     */
    private String deptno;
    /**
     * 允许访问的ip地址
     */
    private String allowIps;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改时间
     */
    private String editTime;
    /**
     * 修改人
     */
    private String editBy;
}
