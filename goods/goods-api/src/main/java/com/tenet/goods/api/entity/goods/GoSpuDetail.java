package com.tenet.goods.api.entity.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * spu扩展表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("go_spu_detail")
public class GoSpuDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long goSpuId;

    /**
     * 商品描述信息
     */
    private String spuDescription;

    /**
     * 通用规格参数数据
     */
    private String genericSpec;

    /**
     * 特有规格参数及可选值信息，json格式
     */
    private String specialSpec;

    /**
     * 包装清单
     */
    private String packingList;

    /**
     * 售后服务
     */
    private String afterService;


}
