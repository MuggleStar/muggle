package com.tenet.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Madison
 * @since 2021/3/12
 */
@Data
@Document(indexName = "goods_search_v1")
public class GoodsSearch {

    @Id
    private Long id;
    /**
     * 组合字段，用户搜索
     */
    private String all;
    /**
     * 标题
     */
    private String spuTitle;
    /**
     * 品牌id
     */
    private Long goBrandId;
    /**
     * 1级类目id
     */
    private Long goCategoryIdOne;

    /**
     * 2级类目id
     */
    private Long goCategoryIdTwo;

    /**
     * 3级类目id
     */
    private Long goCategoryIdThree;
    /**
     * 添加时间
     */
    private LocalDateTime createTime;
    /**
     * 价格
     */
    private List<Long> priceList;
    /**
     * 属性参数
     */
    private Map<String, Object> spec;





}
