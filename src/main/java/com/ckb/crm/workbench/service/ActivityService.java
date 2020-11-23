package com.ckb.crm.workbench.service;

import com.ckb.crm.vo.PaginationVO;
import com.ckb.crm.workbench.domain.Activity;
import com.ckb.crm.workbench.domain.ActivityRemark;

import java.util.List;
import java.util.Map;

/**
 * @author ychen
 */
public interface ActivityService {
    /**
     * 是否插入/保存成功
     * @param a 活动对象
     * @return true/false
     */
    boolean save(Activity a);

    /**
     *
     * @param map
     * @return
     */
    PaginationVO<Activity> pageList(Map<String, Object> map);

    boolean delete(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    boolean update(Activity a);

    Activity detail(String id);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    boolean deleteRemark(String id);

    boolean saveRemark(ActivityRemark ar);

    boolean updateRemark(ActivityRemark ar);

    List<Activity> getActivityListByClueId(String clueId);

    List<Activity> getActivityListByNameAndNotByClueId(Map<String, String> map);
}
