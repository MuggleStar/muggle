package com.tenet.goods.api.entity.specification;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 规格参数名称表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("go_spec_param")
public class GoSpecParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品分类id
     */
    private Long goCategoryId;

    /**
     * 规格参数分组表id
     */
    private Long goSpecGroupId;

    /**
     * 参数名
     */
    private String specParamName;

    /**
     * 是否是数字类型参数，true或false
     */
    private Boolean isNumeric;

    /**
     * 数字类型参数的单位，非数字类型可以为空
     */
    private String numericUnit;

    /**
     * 是否是sku通用属性，true或false
     */
    private Boolean isGeneric;

    /**
     * 是否用于搜索过滤，true或false
     */
    private Boolean isSearching;

    /**
     * 数值类型参数，如果需要搜索，则添加分段间隔值，如CPU频率间隔：0.5-1.0
     */
    private String segments;


}
