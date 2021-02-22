package com.tenet.goods.api.entity.category;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.tenet.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品类目-品牌中间表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("go_category_brand")
public class GoCategoryBrand extends BaseEntity {

    /**
     * 商品类目id
     */
    private Long goCategoryId;

    /**
     * 品牌id
     */
    private Long goBrandId;


}
