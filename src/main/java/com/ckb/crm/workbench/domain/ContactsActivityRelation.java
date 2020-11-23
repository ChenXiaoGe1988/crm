package com.ckb.crm.workbench.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ychen
 */
@Getter
@Setter
public class ContactsActivityRelation {
    private String id;
    private String contactsId;
    private String activityId;
}
