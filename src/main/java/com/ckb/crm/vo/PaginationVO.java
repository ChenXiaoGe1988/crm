package com.ckb.crm.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


/**
 * @author ychen
 * @param <T>
 */
@Getter
@Setter
@ToString
public class PaginationVO<T> {
    /**
     * 查询的总条数
     */
    private int total;
    /**
     * 市场活动信息列表
     */
    private List<T> dataList;
}
