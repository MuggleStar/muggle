package com.tenet.goods.api.entity.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.tenet.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * spu表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("go_spu")
public class GoSpu extends BaseEntity {

    /**
     * spu id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String spuTitle;

    /**
     * 子标题
     */
    private String spuSubTitle;

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
     * 商品所属品牌id
     */
    private Long goBrandId;

    /**
     * 是否上架，0下架，1上架
     */
    private Boolean isSaleable;

    /**
     * 是否有效，0已删除，1有效
     */
    private Boolean isValid;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;


}
