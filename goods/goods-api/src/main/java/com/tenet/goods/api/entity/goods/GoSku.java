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
 * sku表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("go_sku")
public class GoSku extends BaseEntity {

    /**
     * sku id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu id
     */
    private Long goSpuId;

    /**
     * 商品标题
     */
    private String skuTitle;

    /**
     * 商品的图片，多个图片以‘,’分割
     */
    private String skuImages;

    /**
     * 销售价格，单位为分
     */
    private Long skuPrice;

    /**
     * 特有规格属性在spu属性模板中的对应下标组合
     */
    private String ownSpecIndex;

    /**
     * sku的特有规格参数键值对，json格式，反序列化时请使用linkedHashMap，保证有序
     */
    private String ownSpec;

    /**
     * 是否有效，0无效，1有效
     */
    private Boolean isEnable;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;


}
