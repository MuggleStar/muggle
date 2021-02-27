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
public class PageDto<T> extends BaseEntity {

    /**
     * 页码
     */
    private Long pageNo;
    /**
     * 每页数量
     */
    private Long pageSize;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 当前页数据
     */
    private List<T> result;

    /**
     * 参数
     */
    private T param;



    public PageDto(){
        this.pageNo = 1L;
        this.pageSize = 15L;
    }

    public PageDto(PageDto param){
        this.pageNo = param.getPageNo();
        this.pageSize = param.getPageSize();
    }


}
