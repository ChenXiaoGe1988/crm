package com.ckb.crm.workbench.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ychen
 * 活动实体类
 */
@Getter
@Setter
@ToString
public class Activity {
    /**主键id*/
    private String id;
    /**所有者*/
    private String owner;
    /**活动名字*/
    private String name;
    /**活动开始时间*/
    private String startDate;
    /**活动结束时间*/
    private String endDate;
    /**活动成本*/
    private String cost;
    /**活动描述*/
    private String description;
    /**活动创建时间*/
    private String createTime;
    /**活动创建人*/
    private String createBy;
    /**活动修改时间*/
    private String editTime;
    /**活动修改人*/
    private String editBy;
}
