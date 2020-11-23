package com.ckb.crm.workbench.dao;

import com.ckb.crm.workbench.domain.ClueActivityRelation;

/**
 * @author ychen
 */
public interface ClueActivityRelationDao {
    int unbund(String id);

    int bund(ClueActivityRelation car);
}
