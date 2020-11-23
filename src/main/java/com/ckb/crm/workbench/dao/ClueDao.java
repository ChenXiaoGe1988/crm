package com.ckb.crm.workbench.dao;

import com.ckb.crm.workbench.domain.Clue;

/**
 * @author ychen
 */
public interface ClueDao {
    int save(Clue clue);

    Clue detail(String id);
}
