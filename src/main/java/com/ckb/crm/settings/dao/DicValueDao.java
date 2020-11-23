package com.ckb.crm.settings.dao;

import com.ckb.crm.settings.domain.DicValue;

import java.util.List;

public interface DicValueDao {
    List<DicValue> getListByCode(String code);
}
