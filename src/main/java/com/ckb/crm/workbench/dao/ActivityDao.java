package com.ckb.crm.workbench.dao;

import com.ckb.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * @author ychen
 */
public interface ActivityDao {
    /**
     * 向活动表中保存数据
     * @param a
     * @return
     */
    int save(Activity a);

    /**
     * 取得市场活动信息列表
     * @param map
     * @return
     */
    List<Activity> getActivityListByCondition(Map<String, Object> map);

    /**
     * 取得查询总条数
     * @param map
     * @return
     */
    int getTotalByCondition(Map<String, Object> map);

    int delete(String[] ids);

    Activity getById(String id);

    int update(Activity a);

    Activity detail(String id);

    List<Activity> getActivityListByClueId(String clueId);

    List<Activity> getActivityListByNameAndNotByClueId(Map<String, String> map);
}
