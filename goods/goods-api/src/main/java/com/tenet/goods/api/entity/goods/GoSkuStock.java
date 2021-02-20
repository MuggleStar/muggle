package com.tenet.goods.api.entity.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 库存表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("go_sku_stock")
public class GoSkuStock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 库存对应的商品sku id
     */
    private Long goSkuId;

    /**
     * 可秒杀库存
     */
    private Integer seckillStock;

    /**
     * 秒杀总数量
     */
    private Integer seckillTotal;

    /**
     * 库存数量
     */
    private Integer stock;


}
