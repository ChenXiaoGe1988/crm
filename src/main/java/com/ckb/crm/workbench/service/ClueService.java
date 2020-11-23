package com.ckb.crm.workbench.service;

import com.ckb.crm.workbench.domain.Clue;

/**
 * @author ychen
 */
public interface ClueService {

    boolean save(Clue clue);

    Clue detail(String id);

    boolean unbund(String id);

    boolean bund(String cid, String[] aids);
}
