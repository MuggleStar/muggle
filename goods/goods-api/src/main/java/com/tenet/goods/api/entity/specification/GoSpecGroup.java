package com.tenet.goods.api.entity.specification;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 规格参数的分组表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("go_spec_group")
public class GoSpecGroup implements Serializable {

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
     * 规格组的名称
     */
    private String specGroupName;


}
