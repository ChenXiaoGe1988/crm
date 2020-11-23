package com.ckb.crm.workbench.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ychen
 * 客户实体类
 */
@Getter
@Setter
@ToString
public class Customer {
    /**主键id*/
    private String id;
    /**所有者*/
    private String owner;
    /**客户名字*/
    private String name;
    /**公司网站*/
    private String website;
    /**公司座机*/
    private String phone;
    /**创建人*/
    private String createBy;
    /**创建时间*/
    private String createTime;
    /**修改人*/
    private String editBy;
    /**修改时间*/
    private String editTime;
    /**联系纪要*/
    private String contactSummary;
    /**下次联系时间*/
    private String nextContactTime;
    /**描述*/
    private String description;
    /**详细地址*/
    private String address;
}
