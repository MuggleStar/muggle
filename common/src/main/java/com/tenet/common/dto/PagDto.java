package com.tenet.common.dto;

import com.tenet.common.entity.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 分页查询
 *
 * @author Madison
 * @since 2021/2/22
 */
@Data
public class PagDto<T> extends BaseEntity {

    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页数据
     */
    private List<T> items;

    public PagDto(){
        this.pageNo = 1;
        this.pageSize = 15;
    }

    public PagDto(PagDto param){
        this.pageNo = param.getPageNo();
        this.pageSize = param.getPageSize();
    }


}
