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
public class CustomerRemark {
    private String id;
    private String noteContent;
    private String createBy;
    private String createTime;
    private String editBy;
    private String editTime;
    private String editFlag;
    private String customerId;
}
