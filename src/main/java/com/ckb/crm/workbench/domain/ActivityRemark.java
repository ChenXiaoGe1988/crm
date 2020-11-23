package com.ckb.crm.workbench.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ychen
 */
@Getter
@Setter
@ToString
public class ActivityRemark {
    private String id;
    private String noteContent;
    private String createTime;
    private String createBy;
    private String editTime;
    private String editBy;
    private String editFlag;
    private String activityId;
}
